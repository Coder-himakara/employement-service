package coder.himakara.employee_management_service.config;

import coder.himakara.employee_management_service.client.SetGoalsClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ServiceClientsConfig {

    private static final Logger logger = LoggerFactory.getLogger(ServiceClientsConfig.class);

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Bean
    public WebClient.Builder webClientBuilder(ObjectMapper objectMapper) {
        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> {
                    configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper));
                    configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper));
                    configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024);
                })
                .build();

        return WebClient.builder().exchangeStrategies(strategies);
    }

    @Bean
    public SetGoalsClient getSetGoalsClient(@Value("${set-goals-service.url}") String baseUrl, WebClient.Builder webClientBuilder) {
        logger.info("Creating SetGoalsClient with base url: {}", baseUrl);
        WebClient webClient = webClientBuilder
                .baseUrl(baseUrl)
                .build();
        return new SetGoalsClient(webClient);
    }
}
