package com.billing.setu.config;

import com.billing.setu.document.Users;
import com.billing.setu.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            userRepository.save(new Users(1,"Pulkit Mital", "upGrad", 16));
            userRepository.save(new Users(2,"Prachi Agrawal", "MoonfrogLabs", 20));
        };
    }
}
