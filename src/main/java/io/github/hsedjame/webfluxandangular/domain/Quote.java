package io.github.hsedjame.webfluxandangular.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Project webflux-and-angular
 * @Author Henri Joel SEDJAME
 * @Date 02/02/2019
 * @Class purposes : .......
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    @Id
    private String id;
    private String book;
    private String content;
}
