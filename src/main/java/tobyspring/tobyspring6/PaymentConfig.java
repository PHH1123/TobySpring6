package tobyspring.tobyspring6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import tobyspring.tobyspring6.api.ApiTemplate;
import tobyspring.tobyspring6.api.ErApiExRateExtractor;
import tobyspring.tobyspring6.api.SimpleApiExecutor;
import tobyspring.tobyspring6.exrate.RestTemplateExRateProvider;
import tobyspring.tobyspring6.payment.ExRateProvider;
import tobyspring.tobyspring6.exrate.WebApiExRateProvider;
import tobyspring.tobyspring6.payment.PaymentService;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
