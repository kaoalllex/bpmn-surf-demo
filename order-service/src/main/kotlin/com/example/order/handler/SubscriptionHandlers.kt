package com.example.order.handler

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription
import org.camunda.bpm.client.task.ExternalTask
import org.camunda.bpm.client.task.ExternalTaskHandler
import org.camunda.bpm.client.task.ExternalTaskService
import org.springframework.stereotype.Component

@Component
@ExternalTaskSubscription("prepareInvoice")
class PrepareInvoiceHandler(
    private val billing: Billing
) : ExternalTaskHandler {

    override fun execute(task: ExternalTask, service: ExternalTaskService) {
        billing.prepareInvoice(task.getVariable("subscriptionId"))
        service.complete(task)
    }
}
