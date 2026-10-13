# bpmn-surf demo

A small Camunda 7 order service, used to showcase
[bpmn-surf](https://github.com/kaoalllex/bpmn-surf) — a Chrome extension that
renders and diffs BPMN and DMN diagrams right in GitLab and GitHub. The same
project on GitLab: [kao.alllex/bpmn-surf-demo](https://gitlab.com/kao.alllex/bpmn-surf-demo).

- `order-service/src/main/resources/bpmn/OrderMain.bpmn` — the order process:
  a collapsed "Reserve stock" subprocess, a call activity into `Payment.bpmn`,
  and a receive task waiting for the `OrderPaid` message.
- `Payment.bpmn` assesses the risk with `PaymentRisk.dmn` and sends risky payments
  to `ManualReview.bpmn`. `SubscriptionRenewal.bpmn` calls the same payment process
  every month.
- `order-service/src/main/kotlin/` — external task handlers
  (`@ExternalTaskSubscription`) and the Kafka listener that reports the payment back to
  the waiting process.

With the extension installed, open the open pull request → **Files changed** and press
**Schema diff** on `OrderMain.bpmn`, or open any `.bpmn` file and press
**View schema**.

The project is a frozen showcase: its pull request stays open on purpose.
