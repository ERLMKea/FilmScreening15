package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Film;
import com.example.demo.model.Screening;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin(value = "*")
public class FilmRestController {

    FilmRepository filmRepository;
    ScreeningRepository screeningRepository;

    public FilmRestController(FilmRepository filmRepository, ScreeningRepository screeningRepository) {
        this.filmRepository = filmRepository;
        this.screeningRepository = screeningRepository;
    }

    public void insertScreening(Film film1) {
        long millis = System.currentTimeMillis();
        java.sql.Date date1 = new java.sql.Date(millis);
        java.sql.Time time1 = new java.sql.Time(millis);
        Screening screen1 = new Screening(date1,time1,film1);
        film1.getScreenings().add(screen1);
        screeningRepository.save(screen1);
    }

    @GetMapping("/insert/{id}")
    public ResponseEntity<Film> insertScreenings(@PathVariable Integer id) {
        Optional<Film> film1 = filmRepository.findById(1);
        if (film1.isPresent()) {
            Film gotFilm = film1.get();
            for (int i = 0; i<id; i++) {
                insertScreening(gotFilm);
            }
            return new ResponseEntity<>(gotFilm, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Vi kunne ikke finde filmen film=" + id);
        }
    }



    @GetMapping("/films")
    public List<Film> findAllfilms() {
        return filmRepository.findAll();
    }

    @GetMapping("/filmsxx")
    public List<Film> findAllfilmsxx() {
        int i1 = 100;
        int i2 = 0;
        int i3 = i1/i2;
        return filmRepository.findAll();
    }

    @GetMapping("/filmsyy")
    @CrossOrigin(origins = "http://localhost:63342")
    public List<Film> findAllfilmsyy() {
        return filmRepository.findAll();
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Film> findFilmById(@PathVariable Integer id) {
        Film film = filmRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Vi kunne ikke finde din film med id= " + id)
        );
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    @PostMapping(value="/newfilm", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Film postFilm(@RequestBody Film film) {
        System.out.println(film);
        return filmRepository.save(film);
    }

    @GetMapping("/screening/{id}")
    public ResponseEntity<Screening> findScreeningById(@PathVariable Integer id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        if (screening.isPresent()) {
            Screening realscreen = screening.get();
            return new ResponseEntity<>(realscreen, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/newscreen", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Screening postScreening(@RequestBody Screening screening) {
        System.out.println(screening);
        return screeningRepository.save(screening);
    }

    @GetMapping("/filmz/{id}")
    public ResponseEntity<Film> findFilmByIdz(@PathVariable Integer id) {
        Film film = filmRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Vi kunne ikke finde film med id = " + id)
        );
        return new ResponseEntity<>(film, HttpStatus.OK);
    }


}




