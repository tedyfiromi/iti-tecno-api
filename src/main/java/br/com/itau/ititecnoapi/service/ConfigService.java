package br.com.itau.ititecnoapi.service;

import br.com.itau.ititecnoapi.model.Config;

public interface ConfigService {

    Config configure(Config config);

    Config findLastConfiguration();

}
