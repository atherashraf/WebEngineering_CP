package org.pucit.controllers;

import org.pucit.enumerators.ResponseType;
import org.pucit.enumerators.UserType;
import org.pucit.utils.DBConnection;
import org.pucit.template.ResponseTpl;
import org.pucit.utils.PasswordUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user_info")
public class UserInfo {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(ModelMap map) {
        map.addAttribute("message", "Welcome to User Module...");
        return "user_management";
    }

    @RequestMapping(value = "/create_user_table", method = RequestMethod.GET)
    public @ResponseBody
    String createUserTable(ModelMap map) {
        ResponseTpl res = new ResponseTpl();
        DBConnection dbConnection = new DBConnection();

        String ddl = "CREATE TABLE users (user_id int NOT NULL AUTO_INCREMENT, `user_name` varchar(255),  " +
                "email varchar(255), `password` varchar(255), `user_type` varchar(255), `salt` varchar(50),  PRIMARY KEY (user_id))";
        dbConnection.createTable(ddl);
        res.setResponseType(dbConnection.getResponseType());
        res.setMsg(dbConnection.getMsg());
        dbConnection.closeConnection();
        return res.toJSON();
    }

    @RequestMapping("/add_user_form")
    public ModelAndView addUser() {
        ModelAndView model = new ModelAndView("add_user");
        String message = "Add New User...";
        model.addObject("message", message);
        List<Map<String, String>> userTypes = new ArrayList();
        Map map = new HashMap();
//        map.put("User Type", null);
//        userTypes.add(map);
        for (UserType ut : UserType.values()) {
            map = new HashMap();
            map.put(ut.name, ut.value);
            userTypes.add(map);
        }

        model.addObject("userTypes", userTypes);
        return model;
    }

    @RequestMapping(value = "/insert_user", method = RequestMethod.POST)
    public @ResponseBody
    String inserUser(@RequestParam("user_name") String userName, @RequestParam("email") String email,
                     @RequestParam("pass") String pass, @RequestParam("user_type") String userType,
                     ModelMap modelMap) {
        ResponseTpl responseTpl = new ResponseTpl();
        DBConnection dbConn = new DBConnection();
        String insertStatement = "Insert into users(user_name, email, password, user_type, salt) values(?,?,?,?,?)";
        List values= new ArrayList<String>();
        String saltValue = PasswordUtils.getSalt(30);
        values.add(userName);
        values.add(email);
        values.add(PasswordUtils.generateSecurePassword(pass, saltValue));
        values.add(userType);
        values.add(saltValue);
        dbConn.preparedStatement(insertStatement, values);
        dbConn.executeDMLOperation();
        dbConn.closeConnection();
        responseTpl.setResponseType(dbConn.getResponseType());
        responseTpl.setMsg(dbConn.getMsg());
        return responseTpl.toJSON();
    }

}

