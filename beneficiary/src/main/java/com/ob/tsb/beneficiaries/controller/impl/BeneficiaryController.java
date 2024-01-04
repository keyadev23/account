package com.ob.tsb.beneficiaries.controller.impl;

import com.ob.tsb.beneficiaries.controller.BeneficiaryApiVersion;
import com.ob.tsb.beneficiaries.model.response.beneficiary.BeneficiaryRespoonse;
import com.ob.tsb.beneficiaries.service.BeneficiaryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.processing.Generated;

@RestController
public class BeneficiaryController implements BeneficiaryApiVersion {

    private static final Logger logger = LogManager.getLogger(BeneficiaryController.class);

    private final BeneficiaryService beneficiaryService;

    @Autowired
    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @GetMapping("/accounts/{AccountId}/beneficiaries")
    public Mono<BeneficiaryRespoonse> getBeneficiaries(@RequestHeader("AuthDate") String authDate,
                                                     @RequestHeader("CustomerIpAddress") String customerIpAddress,
                                                     @RequestHeader("InteractionId") String interactionId,
                                                     @RequestHeader("Accept") String accept,
                                                     @PathVariable("AccountId") String accountId) {

        logger.info("Request for get beneficiaries for the account Id: {}",accountId);

        Mono<BeneficiaryRespoonse> _resp = beneficiaryService
                .getBeneficiariesById(authDate,customerIpAddress,interactionId,accept,accountId);

        logger.info("The Response: {}", _resp);
        return _resp;
    }
}
