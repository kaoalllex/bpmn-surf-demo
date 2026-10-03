# bpmn-surf demo

A small Camunda 7 order service, used to showcase
[bpmn-surf](https://github.com/kaoalllex/bpmn-surf) — a Chrome extension that
renders and diffs BPMN and DMN diagrams right in GitLab.

- `order-service/src/main/resources/bpmn/OrderMain.bpmn` — the order process:
  a collapsed "Reserve stock" subprocess, a call activity into `Payment.bpmn`,
  and a receive task waiting for the `OrderPaid` message.
- `order-service/src/main/resources/dmn/PaymentRisk.dmn` — the risk decision
  `Payment.bpmn` calls.
- `order-service/src/main/kotlin/` — external task handlers
  (`@ExternalTaskSubscription`) and the Kafka listener that reports the payment back to
  the waiting process.

With the extension installed, open the open merge request → **Changes** and press
**Schema diff** on `OrderMain.bpmn`, or open any `.bpmn` file and press
**View schema**.

The project is a frozen showcase: its merge request stays open on purpose.
