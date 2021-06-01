package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    @Test
    void groupedAssertions() {
        Film film = new Film("Druk", (short)115);
        assertAll("Test film props",
                () -> assertEquals("Drukx", film.getFilmName(), "fandt ikke druk"),
                () -> assertEquals((short)115, film.getLength(), "forkert længde"));
    }

}