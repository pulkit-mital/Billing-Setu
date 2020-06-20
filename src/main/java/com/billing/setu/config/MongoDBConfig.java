package com.billing.setu.config;

import com.billing.setu.document.PaymentDetails;
import com.billing.setu.document.Users;
import com.billing.setu.repository.PaymentDetailRepository;
import com.billing.setu.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableMongoRepositories(basePackageClasses = {UserRepository.class, PaymentDetailRepository.class})
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PaymentDetailRepository paymentDetailRepository){
        return args -> {
            List<String> refids = new ArrayList<>();
            refids.add("1");
            userRepository.save(new Users("1","Pulkit Mital", "9900977703", refids));
            paymentDetailRepository.save(new PaymentDetails("","1", "", 200, new Date(), false));
        };
    }
}
