package com.code.controller;

import com.code.model.BookDto;
import com.code.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v01/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<BookDto> save(@RequestBody Mono<BookDto> bookDto) {
        return bookService.save(bookDto);
    }

    @GetMapping(value = "/{id}")
    public Mono<BookDto> get(@PathVariable("id") String id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public Flux<BookDto> get() {
        return bookService.getAll();
    }

    @GetMapping("/range")
    public Flux<BookDto> getProductBetweenRange(@RequestParam("min") double min, @RequestParam("max")double max){
        return bookService.getBookInRange(min,max);
    }

    @PutMapping(value = "/{id}")
    public Mono<BookDto> update(@PathVariable("id") String id, @RequestBody Mono<BookDto> bookDto) {
        return bookService.update(bookDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return bookService.delete(id);
    }
}
