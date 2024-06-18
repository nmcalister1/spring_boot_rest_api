package com.nmcalister.database_postgres;

import com.nmcalister.database_postgres.domain.dto.AuthorDto;
import com.nmcalister.database_postgres.domain.dto.BookDto;
import com.nmcalister.database_postgres.domain.entities.AuthorEntity;
import com.nmcalister.database_postgres.domain.entities.BookEntity;

public final class TestDataUtil {
    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("John Doe")
                .age(30)
                .build();
    }

//    public static AuthorEntity createTestAuthorDtoA() {
//        return AuthorDto.builder()
//                .id(5L)
//                .name("Marry Jane")
//                .age(23)
//                .build();
//    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Dally")
                .age(50)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Don")
                .age(22)
                .build();
    }

    public static BookEntity createTestBookEntityA(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("978-4324-5132-0")
                .title("The shadow of the wind")
                .author(author)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto author) {
        return BookDto.builder()
                .isbn("978-4324-5132-0")
                .title("The shadow of the wind")
                .author(author)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("978-4324-5932-1")
                .title("Beyond the horizon")
                .author(author)
                .build();
    }

    public static BookEntity createTestBookC(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("978-4324-5802-2")
                .title("The last ember")
                .author(author)
                .build();
    }
}
