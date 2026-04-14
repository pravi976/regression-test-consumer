package com.enterprise.regression.downstream.journey;

import java.math.BigDecimal;

public record OrderInsight(
        String customerId,
        int activeOrders,
        String lastOrderId,
        BigDecimal totalOrderValue
) {
}
