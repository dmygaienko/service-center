package com.mygaienko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by enda1n on 03.12.2016.
 */
@Controller
public class LoginRedirectController {

    @RequestMapping(value = "/api/login", method = RequestMethod.GET)
    public ModelAndView redirectWithPrefix(ModelMap model) {
        //model.addAttribute("attribute", "redirectWithRedirectAttributes");
        return new ModelAndView("redirect:/", model);
    }

    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
}
