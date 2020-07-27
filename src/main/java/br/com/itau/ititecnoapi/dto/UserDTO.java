package br.com.itau.ititecnoapi.dto;

import br.com.itau.ititecnoapi.model.Account;
import lombok.Data;

@Data
public class UserDTO {

    private String id;
    private String name;
    private Account account;

}
