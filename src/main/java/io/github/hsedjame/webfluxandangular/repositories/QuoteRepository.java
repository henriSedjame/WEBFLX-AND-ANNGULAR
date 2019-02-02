package io.github.hsedjame.webfluxandangular.repositories;

import io.github.hsedjame.webfluxandangular.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @Project webflux-and-angular
 * @Author Henri Joel SEDJAME
 * @Date 02/02/2019
 * @Class purposes : .......
 */
public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {
}
