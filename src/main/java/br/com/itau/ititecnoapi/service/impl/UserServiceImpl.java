package br.com.itau.ititecnoapi.service.impl;

import br.com.itau.ititecnoapi.model.User;
import br.com.itau.ititecnoapi.repository.UserRepository;
import br.com.itau.ititecnoapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public boolean isValid(String passworld) {
        return true;
    }

    @Override
    public User save(User user) {
        if (isValid(user.getAccount().getPassworld())) {
            return repository.save(user);
        }
        return null;
    }
}
