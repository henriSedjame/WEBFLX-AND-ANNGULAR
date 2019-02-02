package io.github.hsedjame.webfluxandangular;

import io.github.hsedjame.webfluxandangular.domain.Quote;
import io.github.hsedjame.webfluxandangular.repositories.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class WebfluxAndAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxAndAngularApplication.class, args);
    }

    @Bean
    CommandLineRunner cmd(QuoteRepository repository){
        return args -> {
            repository.deleteAll()
                    .subscribe(null, null,
                            () ->
                                    Stream.of(
                                    new Quote(null, "Au nom de la Rose", "content1"),
                                    new Quote(null, "Le sieur Dieu", "content2"),
                                    new Quote(null, "Champignos hallucinogènes", "content3"),
                                    new Quote(null, "Archi pas chère", "content4"),
                                    new Quote(null, "Atlas mondial", "content5"),
                                    new Quote(null, "Les fleurs du mal", "content6"),
                                    new Quote(null, "Une virée vers le nord", "content7"),
                                    new Quote(null, "Spring for beginners", "content8"),
                                    new Quote(null, "Decouvrons Java", "content9"),
                                    new Quote(null, "Algo pour les totos", "content10"),
                                    new Quote(null, "Image: photographie et pixels", "content11"),
                                    new Quote(null, "Baudelaire, un si grand poète", "content12e")
                            ).forEach(quote -> repository.save(quote).subscribe()));
        };
    }

}

