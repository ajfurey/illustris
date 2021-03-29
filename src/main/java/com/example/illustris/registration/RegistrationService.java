package com.example.illustris.registration;

import org.springframework.stereotype.Service;
/*mport com.example.illustris.user.User;
import com.example.illustris.user.UserService;
import com.example.illustris.user.UserRole;
import com.example.illustris.email.EmailSender;
import com.example.illustris.registration.token.ConfirmationToken;
import com.example.illustris.registration.token.ConfirmationTokenService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;*/

@Service
public class RegistrationService {
    
    /*private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public RegistrationService(UserService userService, EmailValidator emailValidator,
            ConfirmationTokenService confirmationTokenService, EmailSender emailSender) {
        this.userService = userService;
        this.emailValidator = emailValidator;
        this.confirmationTokenService = confirmationTokenService;
        this.emailSender = emailSender;
    }


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        String token = userService.signUpUser(
                new User(request.getFirstName(),request.getLastName(),request.getUsername(),
                    request.getEmail(),request.getPassword(),request.getPhone(),request.getDob(),
                    request.getUserRole(),request.getPosition(),request.getHireDate()
                )
        );

        String link = "http://localhost:8080/api/v1/Registration/confirm?token=" + token;
        /*emailSender.send(
                request.getEmail(),
                buildEmail(request.getFirstName(), link));*/

        //return token;
    //}

    /*@Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }

    /*private String buildEmail(String name, String link) {
        return 
        "<!DOCTYPE HTML>\n"+
        "<head>\n"+
            "<title>Getting Started: Serving Web Content</title>\n"+
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"+
        "</head>\n"+
        "<body>\n"+
            "<p>Hi there</p>\n"+
           "<p>Here's the link  "+link+"</p>\n"+
        "</body>\n"+
        "</html>";
    }*/


}
