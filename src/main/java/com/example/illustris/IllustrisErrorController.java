package com.example.illustris;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

public class IllustrisErrorController implements ErrorController {

    public IllustrisErrorController() {
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return null;
    }

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request) {
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
        
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return "/error/403";
            }
            else if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "/error/404";
            }
            
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "/error/500";
            }
        }
        return "error";
    }
    
}
