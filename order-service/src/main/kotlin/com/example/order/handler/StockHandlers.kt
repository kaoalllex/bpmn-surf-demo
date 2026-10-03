package com.example.order.handler

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription
import org.camunda.bpm.client.task.ExternalTask
import org.camunda.bpm.client.task.ExternalTaskHandler
import org.camunda.bpm.client.task.ExternalTaskService
import org.springframework.stereotype.Component

/** The steps of the "Reserve stock" subprocess. */
@Component
@ExternalTaskSubscription("reserveItems")
class ReserveItemsHandler(
    private val warehouse: Warehouse
) : ExternalTaskHandler {

    override fun execute(task: ExternalTask, service: ExternalTaskService) {
        warehouse.reserve(task.getVariable("orderId"))
        service.complete(task)
    }
}

@Component
@ExternalTaskSubscription("confirmReservation")
class ConfirmReservationHandler(
    private val warehouse: Warehouse
) : ExternalTaskHandler {

    override fun execute(task: ExternalTask, service: ExternalTaskService) {
        warehouse.confirm(task.getVariable("orderId"))
        service.complete(task)
    }
}
