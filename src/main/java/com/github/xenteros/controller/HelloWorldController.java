package com.github.xenteros.controller;

import com.github.xenteros.model.User;
import com.github.xenteros.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by agurgul on 20.09.2017.
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
//    @Qualifier(value = "cap")
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String helloWorld() {
        return helloWorldService.hello();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String helloName(@PathVariable(value = "name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {

            final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            final Object principal = auth.getPrincipal();
            if (principal != null && principal instanceof User) {
                User user = (User) principal;
                return "Hello " + user.getAuthority().toString() + " " +
                        user.getUsername();
            }
        return "Hello " + auth.getName();
    }
}
