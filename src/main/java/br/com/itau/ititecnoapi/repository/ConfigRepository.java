package br.com.itau.ititecnoapi.repository;

import br.com.itau.ititecnoapi.model.Config;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigRepository extends MongoRepository<Config, String> {

    Config findFirstByOrderByDateTimeDesc();

}
