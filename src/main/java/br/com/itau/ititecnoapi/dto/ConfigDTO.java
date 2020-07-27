package br.com.itau.ititecnoapi.dto;

import lombok.Data;

@Data
public class ConfigDTO {

    private int minLength = 1;
    private int maxLength = 1;
    private int upperCase = 0;
    private int lowerCase = 0;
    private int digit = 0;
    private int special = 0;

}
