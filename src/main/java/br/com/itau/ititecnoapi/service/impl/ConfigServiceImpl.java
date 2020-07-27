package br.com.itau.ititecnoapi.service.impl;

import br.com.itau.ititecnoapi.model.Config;
import br.com.itau.ititecnoapi.repository.ConfigRepository;
import br.com.itau.ititecnoapi.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigRepository repository;

    @Override
    public Config configure(Config config) {

        LocalDateTime today = LocalDateTime.now();
        config.setDateTime(today);
        return repository.save(config);
    }

    @Override
    public Config findLastConfiguration() {
        return repository.findFirstByOrderByDateTimeDesc();

    }
}
