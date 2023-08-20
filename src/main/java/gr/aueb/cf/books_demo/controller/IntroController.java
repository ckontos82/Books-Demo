package gr.aueb.cf.books_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroController {
    @RequestMapping("/")
    public String mainPage() {
        return "index.html";
    }
}
