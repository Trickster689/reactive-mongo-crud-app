package com.code.service;

import com.code.model.BookDto;
import com.code.repository.BookRepository;
import com.code.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class BookService {
    @Autowired
    private BookRepository repository;


    public Flux<BookDto> getAll() {
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<BookDto> getBookById(String id) {
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Flux<BookDto> getBookInRange(double min, double max) {
        return repository.findByPriceBetween(Range.closed(min, max)).map(AppUtils::entityToDto);
    }

    public Mono<BookDto> save(Mono<BookDto> bookDtoMono) {
        log.info("service method called ... "+bookDtoMono);
        return bookDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<BookDto> update(Mono<BookDto> bookDtoMono, String id) {
        return repository.findById(id)
                .flatMap(p -> bookDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);

    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
