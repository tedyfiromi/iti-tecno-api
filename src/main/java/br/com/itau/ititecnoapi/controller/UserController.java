package br.com.itau.ititecnoapi.controller;

import br.com.itau.ititecnoapi.dto.AccountDTO;
import br.com.itau.ititecnoapi.dto.UserDTO;
import br.com.itau.ititecnoapi.model.Account;
import br.com.itau.ititecnoapi.model.User;
import br.com.itau.ititecnoapi.response.Response;
import br.com.itau.ititecnoapi.service.AccountService;
import br.com.itau.ititecnoapi.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Response<User>> saveUser(@RequestBody UserDTO userDTO){

        Response<User> userResponse = new Response<>();
        User user = new User();

        BeanUtils.copyProperties(userDTO, user);
        User userObject = service.save(user);

        if (userObject!=null) {
            userResponse.setObject(userObject);
            return ResponseEntity.ok(userResponse);
        }

        return ResponseEntity.badRequest().build();
    }
}
