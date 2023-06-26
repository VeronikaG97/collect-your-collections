package com.cyc.collectyourcollections.restController;

import com.cyc.collectyourcollections.data.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class endpointBookTest {
    public static Stream<Arguments> provideNewBooks() {
        return Stream.of(
               Arguments.of(new Book("Der Hobbit", "J. R. R. Tolkien", new HashSet<>(Integer.parseInt(BookGenres.FANTASY.name())))),
               Arguments.of(new Book("Wintermond", "Tanja Heitmann", new HashSet<>(Integer.parseInt(BookGenres.FANTASY.name()))))
        );
    }

    @ParameterizedTest
    @MethodSource("provideNewBooks")
    void addABook() {
    }

    @Test
    void getAllBooks() {

    }

}