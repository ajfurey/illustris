package com.example.illustris;



import com.example.illustris.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    
    
    //adds template as an index
    @GetMapping("/main")
    public String mainPage(Model model) {

        // add `message` attribute
        model.addAttribute("message", "Thank you for visiting.");
        
        // return view name
        return "main";
    }

    @GetMapping("/admin")
    public String adminPage() {
        
        // return view name
        return "admin";
    }

    

    @GetMapping("medical/order")
    public String orderPage() {
        
        // return view name
        return "order";
    }

    @GetMapping("user/addUser")
    public String add() {
        // add `message` attribute
        return "addUser";
    }

}
