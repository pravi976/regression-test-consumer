package com.enterprise.regression.downstream.client;

import java.math.BigDecimal;

public record UpstreamCustomerResponse(
        String customerId,
        String customerName,
        String city,
        String tier,
        String status,
        BigDecimal creditLimit,
        String currency
) {
}
