package com.code.repository;

import com.code.entity.Book;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findByPriceBetween(Range<Double> priceRange);
}
