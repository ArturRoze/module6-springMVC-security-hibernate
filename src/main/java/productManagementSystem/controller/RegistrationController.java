package productManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import productManagementSystem.model.Roles;
import productManagementSystem.model.User;
import productManagementSystem.service.UserService;

import java.io.IOException;

@Controller
@RequestMapping(method = RequestMethod.POST, value = "/register")
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") User user) throws IOException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Roles.USER);
        try{
            userService.create(user);
        }
        catch (Exception e){
            throw new IOException("Exception during saving user to database");
        }
        return "redirect:/login";
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException ex) {
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).build();
    }
}
