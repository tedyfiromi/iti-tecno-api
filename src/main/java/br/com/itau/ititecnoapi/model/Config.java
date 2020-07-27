package br.com.itau.ititecnoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@AllArgsConstructor
public class Config {

    private int minLength = 1;
    private int maxLength = 1;
    private int upperCase = 0;
    private int lowerCase = 0;
    private int digit = 0;
    private int special = 0;
    @Indexed(direction = IndexDirection.DESCENDING)
    private LocalDateTime dateTime;

    public Config() {
    }

}
