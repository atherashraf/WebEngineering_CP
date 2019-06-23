package org.pucit.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping("/")
public class BaseController {
    @RequestMapping(method = RequestMethod.GET, value = "/alert_info")
    public String alertInfo(ModelMap model) {
        return "alert_info";
    }
}
