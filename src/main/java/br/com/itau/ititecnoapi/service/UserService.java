package br.com.itau.ititecnoapi.service;

import br.com.itau.ititecnoapi.model.User;
import org.passay.RuleResult;

public interface UserService {

    User save(User user);

    RuleResult valid(String password);

}
