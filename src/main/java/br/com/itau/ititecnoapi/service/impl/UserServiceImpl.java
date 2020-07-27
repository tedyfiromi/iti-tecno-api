package br.com.itau.ititecnoapi.service.impl;

import br.com.itau.ititecnoapi.model.Config;
import br.com.itau.ititecnoapi.model.User;
import br.com.itau.ititecnoapi.repository.ConfigRepository;
import br.com.itau.ititecnoapi.repository.UserRepository;
import br.com.itau.ititecnoapi.service.UserService;
import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ConfigRepository configRepository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public RuleResult valid(String password) {

        Config lastConfig = configRepository.findFirstByOrderByDateTimeDesc();

        List<Rule> rules = new ArrayList<>();

        rules.add(new LengthRule(lastConfig.getMinLength(), lastConfig.getMaxLength()));
        rules.add(new WhitespaceRule());
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, lastConfig.getUpperCase()));
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, lastConfig.getLowerCase()));
        rules.add(new CharacterRule(EnglishCharacterData.Digit, lastConfig.getDigit()));
        rules.add(new CharacterRule(EnglishCharacterData.Special, lastConfig.getSpecial()));

        PasswordValidator validator = new PasswordValidator(rules);
        PasswordData passData = new PasswordData(password);
        return validator.validate(passData);
    }
}
