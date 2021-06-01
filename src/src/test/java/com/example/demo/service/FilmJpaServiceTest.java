package com.example.demo.service;

import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilmJpaServiceTest {

    @Mock
    FilmRepository filmRepository;

    @InjectMocks
    FilmJpaService service;

    @Test
    void findByBDDId() {
        Film mockfilm = mock(Film.class);
        given(filmRepository.findById(1)).willReturn(Optional.of(mockfilm));
        Film mockfilm2 = mock(Film.class);
        mockfilm2 = service.findById(1);
        assertEquals(mockfilm, mockfilm2);
    }

    @Test
    void findById() {
        //Film film = new Film();
        Film mockfilm = mock(Film.class);
        when(filmRepository.findById(1)).thenReturn(Optional.of(mockfilm));
        Film mockfilm2 = mock(Film.class);
        mockfilm2 = service.findById(1);
        //assertNotEquals(null, mockfilm2);
        assertEquals(mockfilm, mockfilm2);
        //verify(filmRepository).findById(1);
    }

    @Test
    void delete() {
        Film film = new Film();
        service.delete(film);
        verify(filmRepository).delete(any(Film.class));
    }

    @Test
    void deleteById() {
        service.deleteById(4);
        service.deleteById(5);
        verify(filmRepository, times(2)).deleteById(anyInt());
    }

    @Test
    void deleteByIdAtLeast() {
        service.deleteById(4);
        service.deleteById(4);
        service.deleteById(4);
        service.deleteById(4);
        verify(filmRepository, atLeast(2)).deleteById(4);
        verify(filmRepository, atMost(5)).deleteById(4);
        verify(filmRepository, never()).deleteById(7);
    }


}

