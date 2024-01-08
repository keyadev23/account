package com.ob.tsb.beneficiaries.service;

import com.ob.tsb.beneficiaries.model.response.beneficiary.BeneficiaryRespoonse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeneficiaryService {
    Mono<BeneficiaryRespoonse> getBeneficiariesById(String authDate,
                                                    String customerIpAddress,
                                                    String interactionId,
                                                    String accept, String accountId);
}
