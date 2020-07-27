package br.com.itau.ititecnoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Account {

    private String nameUser;
    private String passworld;

}
