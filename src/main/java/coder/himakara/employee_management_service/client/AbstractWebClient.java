package coder.himakara.employee_management_service.client;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

abstract class AbstractWebClient {

    protected WebClient createWebClient() {;
        return createWebClient(b ->{});
    }


    protected WebClient createWebClient(Consumer<WebClient.Builder> builderConsumer) {
        var builder = WebClient.builder()
                .baseUrl("http://localhost:8093");
        builderConsumer.accept(builder);
        return builder.build();
    }

}
