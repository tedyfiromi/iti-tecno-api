package br.com.itau.ititecnoapi.repository;

import br.com.itau.ititecnoapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
