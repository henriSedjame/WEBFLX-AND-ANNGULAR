package io.github.hsedjame.webfluxandangular.resources;

import io.github.hsedjame.webfluxandangular.domain.Quote;
import io.github.hsedjame.webfluxandangular.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

/**
 * @Project webflux-and-angular
 * @Author Henri Joel SEDJAME
 * @Date 02/02/2019
 * @Class purposes : .......
 */
@Configuration
public class RouteDefs {

    @Autowired
    QuoteRepository repository;

    @Bean
    RouterFunction<?> routes(){
        return RouterFunctions.route(RequestPredicates.GET("/quotes"), this::handleGetQuotes);
    }

    Mono<ServerResponse> handleGetQuotes(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(fromPublisher(repository.findAll().delayElements(Duration.ofMillis(100)), Quote.class));
    }
}
