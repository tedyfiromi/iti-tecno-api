package br.com.itau.ititecnoapi.controller;

import br.com.itau.ititecnoapi.dto.UserDTO;
import br.com.itau.ititecnoapi.model.User;
import br.com.itau.ititecnoapi.response.Response;
import br.com.itau.ititecnoapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.passay.RuleResult;
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

    @ApiOperation(value = "Save user data")
    @PostMapping
    public ResponseEntity<Response<User>> saveUser(@RequestBody UserDTO userDTO) {

        Response<User> userResponse = new Response<>();
        User user = new User();

        BeanUtils.copyProperties(userDTO, user);

        RuleResult status = service.valid(user.getAccount().getPassworld());
        if (!status.isValid()) {
            userResponse.setStatus(status.getDetails().toString());
            return ResponseEntity.badRequest().body(userResponse);
        }

        User userObject = service.save(user);
        userResponse.setObject(userObject);

        return ResponseEntity.ok(userResponse);

    }
}
