package ru.gb.OpenFeignService.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.OpenFeignService.model.Payment;
import ru.gb.OpenFeignService.proxy.PaymentProxy;

@RestController
@AllArgsConstructor
public class PaymentController {
    private final PaymentProxy paymentProxy;

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        String requestId = "1";
        return paymentProxy.createPayment(requestId, payment);
    }
}
