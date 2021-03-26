//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: UserController

package com.example.illustris.user;

import java.util.List;

import com.example.illustris.registration.token.ConfirmationTokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/User")
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    public UserController(UserService userService, 
    BCryptPasswordEncoder bCryptPasswordEncoder, 
    ConfirmationTokenService confirmationTokenService) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
    
    @DeleteMapping(path= "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path ="{userId}")
    public void updateUser(
        @PathVariable("userId") Long userId,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String email
    ){
        userService.uadateUser(userId, lastName, email);
    }
    
}
