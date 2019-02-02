package io.github.hsedjame.webfluxandangular.controllers;

import io.github.hsedjame.webfluxandangular.domain.Quote;
import io.github.hsedjame.webfluxandangular.repositories.QuoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @Project webflux-and-angular
 * @Author Henri Joel SEDJAME
 * @Date 02/02/2019
 * @Class purposes : .......
 */
@RestController
public class QuoteController {
    private final QuoteRepository quoteRepository;


    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping(value = "/quotes")
    Flux<Quote> getQuotes(){
        return this.quoteRepository.findAll()
                .delayElements(Duration.ofMillis(1500));
    }
}
