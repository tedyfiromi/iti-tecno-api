package br.com.itau.ititecnoapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {

    private String nameUser;
    private String passworld;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", nameUser='" + nameUser + '\'' +
                ", passworld='" + passworld + '\'' +
                '}';
    }
}
