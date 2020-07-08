package com.billing.setu.controller;

import com.billing.setu.document.PaymentDetails;
import com.billing.setu.document.Users;
import com.billing.setu.model.fetchdetail.Data;
import com.billing.setu.model.ErrorResponse;
import com.billing.setu.model.fetchdetail.FetchDetailResponse;
import com.billing.setu.model.fetchdetail.FetchRequest;
import com.billing.setu.model.updatepayment.PaymentUpdateRequest;
import com.billing.setu.model.updatepayment.UpdatePaymentResponse;
import com.billing.setu.repository.PaymentDetailRepository;
import com.billing.setu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentDetailRepository paymentDetailRepository;

    @PostMapping("/fetch-bill")
    public Object fetchBill(@RequestBody FetchRequest request){
        if(request == null || request.getMobileNumber() == null || request.getMobileNumber().isEmpty() || "null".equalsIgnoreCase(request.getMobileNumber())){
            ErrorResponse errorResponse = new ErrorResponse("ERROR", "invalid-api-parameters");
            return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        Users users = userRepository.findByMobileNumber(request.getMobileNumber());
        if(users == null){
            ErrorResponse errorResponse = new ErrorResponse("ERROR", "customer-not-found");
            return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
        }
        List<PaymentDetails> paymentDetails = paymentDetailRepository.findPaymentsByIds(users.getRefIds());
        FetchDetailResponse response = new FetchDetailResponse();
        response.setStatus("SUCCESS");
        List<Data> datas = paymentDetails.stream().map(paymentDetail -> new Data(users.getCustomerName(), paymentDetail.getDueAmount(), paymentDetail.getDueDate(), paymentDetail.getRefId())).collect(Collectors.toList());
        response.setData(datas);
        return response;
    }

    @PostMapping("payment-update")
    public Object updatePayment(@RequestBody PaymentUpdateRequest paymentUpdateRequest){
        PaymentDetails paymentDetails = paymentDetailRepository.findPaymentByRefId(paymentUpdateRequest.getRefID());
        if(paymentDetails.isPaymentDone()){
            //TODO send the response as it is
        }else if (paymentUpdateRequest.getTransaction().getId().equalsIgnoreCase(paymentDetails.getId())){
            //TODO send the response as it is

        }else {

        }
        paymentDetails.setAckId("1");
        paymentDetails.setPaymentDone(true);
        paymentDetails.setId(paymentDetails.getId());
        paymentDetailRepository.save(paymentDetails);
        UpdatePaymentResponse response = new UpdatePaymentResponse();
        response.setStatus("SUCCESS");
        com.billing.setu.model.updatepayment.Data data = new com.billing.setu.model.updatepayment.Data();
        data.setAckId(paymentDetails.getAckId());
        response.setData(data);
        return response;
    }


}
