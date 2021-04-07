package com.example.illustris.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
    
    /*@GetMapping("/")
    public String home() {
        return "("<h1>Welcome</h1>")";
    }*/

    /*@GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/user/addUser")
    public String sendForm() {

        return "addUser";
    }*/

    @PostMapping()
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
    
    @DeleteMapping(path= "{userId}")
    public void deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path ="{userId}")
    public void updateUser(
        @PathVariable("userId") int userId,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String email
    ){
        userService.uadateUser(userId, lastName, email);
    }
    

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

    
}
