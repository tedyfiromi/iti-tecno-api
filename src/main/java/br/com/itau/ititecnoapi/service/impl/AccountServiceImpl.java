package br.com.itau.ititecnoapi.service.impl;

import br.com.itau.ititecnoapi.model.Account;
import br.com.itau.ititecnoapi.repository.AccountRepository;
import br.com.itau.ititecnoapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public boolean isValid(String passworld) {
        return true;
    }

    @Override
    public Account save(Account account) {

        if (isValid(account.getPassworld())) {
            return repository.save(account);
        }
        return null;
    }
}
