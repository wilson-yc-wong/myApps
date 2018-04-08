package net.myapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chunwyc on 31/3/2018.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        return "html/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "html/security/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "html/security/logout";
    }
}
