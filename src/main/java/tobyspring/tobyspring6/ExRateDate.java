package tobyspring.tobyspring6;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

// Jackson 3.0 부터는 ignore 설정을 해주지 않아도 알아서 무시됨
//@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRateDate(String result, Map<String, BigDecimal> rates) {
}
