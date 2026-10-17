package tobyspring.tobyspring6;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.tobyspring6.payment.Payment;
import tobyspring.tobyspring6.payment.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    static void main() throws IOException, InterruptedException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(PaymentConfig.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);

        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("Payment: " + payment);
    }
}
