package productManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class SecurityController {

    @RequestMapping(method = RequestMethod.GET)
    public String listAllUsers() {
        System.out.println("List all products");
        return "mainPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin")
    public String adminCrud() {
        System.out.println("List admin Crud operation");
        return "mainPage";
    }

}
