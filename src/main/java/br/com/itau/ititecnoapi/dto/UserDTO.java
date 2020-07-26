package br.com.itau.ititecnoapi.dto;

import br.com.itau.ititecnoapi.model.Account;

public class UserDTO {

    private String id;
    private String name;
    private Account account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
