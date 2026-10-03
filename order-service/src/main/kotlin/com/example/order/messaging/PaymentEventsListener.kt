package com.example.order.messaging

import org.camunda.bpm.engine.RuntimeService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class PaymentEventsListener(
    private val runtimeService: RuntimeService
) {

    @KafkaListener(topics = ["order.payments"])
    fun onPaymentReceived(event: PaymentEvent) {
        runtimeService.createMessageCorrelation("OrderPaid")
            .processInstanceBusinessKey(event.orderId)
            .setVariable("paid", event.status == "CAPTURED")
            .setVariable("amount", event.amount)
            .correlateWithResult()
    }
}
