package productManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SecurityController {

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public void listAllUsers() {
        System.out.println("List all users");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public void adminCrud() {
        System.out.println("List admin Crud operation");
    }

}
