package com.example.order.handler

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription
import org.camunda.bpm.client.task.ExternalTask
import org.camunda.bpm.client.task.ExternalTaskHandler
import org.camunda.bpm.client.task.ExternalTaskService
import org.springframework.stereotype.Component

@Component
@ExternalTaskSubscription("chargeCustomer")
class ChargeCustomerHandler(
    private val payments: PaymentGateway
) : ExternalTaskHandler {

    override fun execute(task: ExternalTask, service: ExternalTaskService) {
        payments.charge(task.getVariable("orderId"), task.getVariable("amount"))
        service.complete(task)
    }
}
