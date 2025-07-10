package org.lessons.java.spring.spring_intro.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/greetings")
    public String getMethodName(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "greetings";
    }

    @GetMapping("/user")
    public String getMethodName(@RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            Model model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currentTime = LocalTime.now().format(formatter);

        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("date", currentTime);

        return "user";
    }

}
