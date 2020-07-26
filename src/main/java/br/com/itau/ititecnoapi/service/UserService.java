package br.com.itau.ititecnoapi.service;

import br.com.itau.ititecnoapi.model.User;

public interface UserService {

    boolean isValid(String passworld);

    User save(User user);

}
