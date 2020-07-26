package br.com.itau.ititecnoapi.controller;

import br.com.itau.ititecnoapi.dto.AccountDTO;
import br.com.itau.ititecnoapi.model.Account;
import br.com.itau.ititecnoapi.response.Response;
import br.com.itau.ititecnoapi.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<Response<Account>> saveAccount(@RequestBody AccountDTO accountDTO){

        Response<Account> accountResponse = new Response<>();
        Account account = new Account();

        BeanUtils.copyProperties(accountDTO, account);
        Account accountObject = service.save(account);

        if (accountObject!=null) {
            accountResponse.setObject(accountObject);
            return ResponseEntity.ok(accountResponse);
        }

        return ResponseEntity.badRequest().build();
    }

}
