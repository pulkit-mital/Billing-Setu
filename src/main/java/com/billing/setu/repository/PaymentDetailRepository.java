package com.billing.setu.repository;

import com.billing.setu.document.PaymentDetails;
import com.billing.setu.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PaymentDetailRepository extends MongoRepository<PaymentDetails, Integer> {
    @Query("{'refId': ?0}")
    PaymentDetails findPaymentByRefId(String refId);

    @Query("{_id: { $in: ?0 } })")
    List<PaymentDetails> findPaymentsByIds(List<String> refIds);
}
