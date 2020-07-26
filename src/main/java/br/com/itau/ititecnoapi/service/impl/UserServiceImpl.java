package br.com.itau.ititecnoapi.service.impl;

import br.com.itau.ititecnoapi.model.User;
import br.com.itau.ititecnoapi.repository.UserRepository;
import br.com.itau.ititecnoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean isValid(String passworld) {

        StringBuilder patternRegex = new StringBuilder("((?=.*[a-z])");
        patternRegex.append("(?=.*[?@#$%^&+=])");
        patternRegex.append("(?=.*[A-Z])");
        patternRegex.append("(?=.*\\d)");
        patternRegex.append(".{8,12})");

        Pattern pattern = Pattern.compile(patternRegex.toString());
        Matcher matcher = pattern.matcher(passworld);

        return matcher.matches();
    }

    @Override
    public User save(User user) {
        if (isValid(user.getAccount().getPassworld())) {
            return repository.save(user);
        }
        return null;
    }
}
