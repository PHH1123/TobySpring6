package tobyspring.tobyspring6.api;

import tools.jackson.core.exc.JacksonIOException;

import java.math.BigDecimal;

public interface ExRateExtractor {
    BigDecimal extract(String response) throws JacksonIOException;
}
