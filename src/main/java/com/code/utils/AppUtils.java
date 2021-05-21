package com.code.utils;

import com.code.entity.Book;
import com.code.model.BookDto;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static BookDto entityToDto(Book book) {
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);
        return bookDto;
    }

    public static Book dtoToEntity(BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return book;
    }
}
