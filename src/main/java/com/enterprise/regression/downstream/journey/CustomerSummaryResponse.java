package com.enterprise.regression.downstream.journey;

import java.math.BigDecimal;

public record CustomerSummaryResponse(
        String customerId,
        String customerName,
        String tier,
        int activeOrders,
        String lastOrderId,
        BigDecimal totalOrderValue,
        String currency,
        String upstreamStatus
) {
}
