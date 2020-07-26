package br.com.itau.ititecnoapi.service;

import br.com.itau.ititecnoapi.dto.AccountDTO;
import br.com.itau.ititecnoapi.model.Account;

public interface AccountService {

    boolean isValid(String passworld);

    Account save(Account accountDTO);

}
