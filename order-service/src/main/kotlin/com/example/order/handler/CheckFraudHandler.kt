package com.example.order.handler

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription
import org.camunda.bpm.client.task.ExternalTask
import org.camunda.bpm.client.task.ExternalTaskHandler
import org.camunda.bpm.client.task.ExternalTaskService
import org.springframework.stereotype.Component

@Component
@ExternalTaskSubscription("checkFraud")
class CheckFraudHandler(
    private val fraudScoring: FraudScoring
) : ExternalTaskHandler {

    override fun execute(task: ExternalTask, service: ExternalTaskService) {
        fraudScoring.check(task.getVariable("orderId"))
        service.complete(task)
    }
}
