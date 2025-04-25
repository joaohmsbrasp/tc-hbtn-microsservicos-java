package com.example.demo.controller;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if (id > 0 && id < 100) {
            return "You have entered valid ID";
        }
        throw new UserIdException(String.valueOf(id));
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if (userName.length() > 3 && userName.length() < 15) {
            return "You have entered valid USERNAME";
        }
        throw new UserNameException(userName);
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        if (isCPF(cpf)) {
            return "You have entered valid CPF";
        }
        throw new CPFException(cpf);
    }

    private boolean isCPF(String cpf) {
        // Validação simplificada de CPF
        return cpf != null && cpf.matches("\\d{11}");
    }
}
