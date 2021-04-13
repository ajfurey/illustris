package com.example.illustris;


import com.example.illustris.order.Modality;
import com.example.illustris.patient.Allergy;
import com.example.illustris.user.Title;

import com.example.illustris.user.UserRole;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    
    
    @GetMapping("/")
    public String index(Model model) {

        // add `message` attribute
        model.addAttribute("message", "Thank you for visiting.");
        
        // return view name
        return "index";
    }

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

    

    @GetMapping("medical/newOrder")
    public String orderPage(Model model) {
        Modality modalities[]= Modality.values();
        model.addAttribute("modality", modalities);
        // return view name
        return "newOrder";
    }

    @GetMapping("medical/newPatient")
    public String newPatientPage(Model model) {
        Allergy allergies[]= Allergy.values();
        model.addAttribute("allergy", allergies);
        // return view name
        return "newPatient";
    }

    /*@GetMapping("medical/imaging")
    public String image() {

        // return view name
        return "imaging";
    }*/

    @GetMapping("medical/diagnosis")
    public String diagnostic() {

        // return view name
        return "diagnosis";
    }

    @GetMapping("admin/newUser")
    public String newUserPage(Model model) {
        Title titles[]= Title.values();
        UserRole roles[]= UserRole.values();
        model.addAttribute("jobTitle", titles);
        model.addAttribute("userRole", roles);
        return "newUser";
    }

    @GetMapping("user/appts")
    public String apptsPage() {
        return "appts";
    }
}
