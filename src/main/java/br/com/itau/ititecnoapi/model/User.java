package br.com.itau.ititecnoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private Account account;

}
