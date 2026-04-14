package com.enterprise.regression.downstream.journey;

public record CustomerJourneyResponse(
        String customerId,
        String customerName,
        String city,
        String tier,
        int activeOrders,
        String lastOrderId,
        String recommendedAction,
        String journeyStatus
) {
}
