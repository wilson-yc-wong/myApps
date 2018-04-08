package net.myapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chunwyc on 31/3/2018.
 */
@Controller
@RequestMapping("/app")
public class AppController {
    @RequestMapping("/test")
    public String test(ModelMap map) {
        return "html/test";
    }

    @RequestMapping("/ranking")
    public String rankingReport(ModelMap map) {
        return "html/app/ranking/report";
    }
}
