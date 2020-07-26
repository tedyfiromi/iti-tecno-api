package br.com.itau.ititecnoapi.repository;

import br.com.itau.ititecnoapi.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

}
