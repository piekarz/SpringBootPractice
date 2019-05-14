package com.ericsson.myproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EventController {

    @GetMapping("/event-register")
    public String eventGet() {
        return "eventFormView";
    }

    @PostMapping("/event-register")
    public String eventPost(
            @RequestParam String name,
            @RequestParam String surname,
            RedirectAttributes redirectAttributes
    ) {
        if(name.length() <= 0 || surname.length() <= 0)
            return "redirect:/register-error";
        else {
            redirectAttributes.addFlashAttribute("name",name);
            redirectAttributes.addFlashAttribute("surname",surname);
            return "redirect:/success-page";
        }
    }

    @GetMapping("/register-error")
    public String errorViewPage(){
        return "errorView";
    }

    @GetMapping("/success-page")
    public String successViewPage(@ModelAttribute("name") String name, @ModelAttribute("surname") String surname){
        System.out.println(name);
        System.out.println(surname);
        return"successView";
    }
}
