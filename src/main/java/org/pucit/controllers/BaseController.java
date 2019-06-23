package org.pucit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/")
public class BaseController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String alertInfo(ModelMap model) {
        model.addAttribute("message", "Welcome to Web Engineering Project...");
        return "index";
    }
}
