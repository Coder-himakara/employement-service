package coder.himakara.employee_management_service.config;

import coder.himakara.employee_management_service.client.SetGoalsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ServiceClientsConfig {

    private static final Logger logger = LoggerFactory.getLogger(ServiceClientsConfig.class);

    @Bean
    public SetGoalsClient getSetGoalsClient(@Value("${set-goals-service.url}") String baseUrl) {
        return new SetGoalsClient(createWebClient(baseUrl));
    }

    private WebClient createWebClient(String baseUrl) {
        logger.info("base url: {}", baseUrl);
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
}
