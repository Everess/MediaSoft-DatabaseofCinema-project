package com.example.TestMediaSoft.controller;

import com.example.TestMediaSoft.entities.productEntities.Film;
import com.example.TestMediaSoft.repos.productRepo.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * This controller processes data for movies.
 */
@Controller
@PreAuthorize("hasAuthority('USER')")
public class FilmController {
    /**
     * Connect the repository for movies to work with the database.
     */
    @Autowired
    private FilmRepo filmRepo;

    /**
     * Mapping to indicate the main page.
     * @param model Store the received object.
     * @return test Movie list page.
     */
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "redirect:/test";
    }

    /**
     * Mapping that handles a movie search form.
     * @param sTitle Title of the movie from form.
     * @param sDateProd Date premier of the movie.
     * @param sGenre Movie genre.
     * @param model Store the received object.
     * @return test Updated movie list page.
     */
    @GetMapping("/test")
    public String searchFilm(
            @RequestParam(required = false, defaultValue = "") String sTitle,
            @RequestParam(required = false, defaultValue = "2019") Integer sDateProd,
            @RequestParam(required = false, defaultValue = "") String sGenre,
            Model model) {

        Iterable<Film> films = filmRepo.findAll();

        /**
         * TODO: Validation to be redone.
         */
        if (sTitle != null && !sTitle.isEmpty()) {
            films = filmRepo.findByTitle(sTitle);
        }
        if (sGenre != null && !sGenre.isEmpty()) {
            films = filmRepo.findByGenre(sGenre);
        }

        model.addAttribute("films", films);
        model.addAttribute("sTitle", sTitle);
        model.addAttribute("sDateProd", sDateProd);
        model.addAttribute("sGenre", sGenre);

        return "test";
    }

    /**
     * Mapping that handles the form to add a movie to the database.
     * @param title Title of the movie from form.
     * @param dateProd Date premier of the movie.
     * @param genre Genre of the movie.
     * @param description Description of the movie.
     * @param model Store the received object.
     * @return test Redirect from movie list page.
     */
    @PostMapping("/test")
    public String addFilm(
            @RequestParam String title,
            @RequestParam Integer dateProd,
            @RequestParam String genre,
            @RequestParam String description,
            Map<String, Object> model
            ) {
        Film product = new Film(title, dateProd, genre, description);

        filmRepo.save(product);
        Iterable<Film> films = filmRepo.findAll();

        model.put("films", films);

        return "redirect:/test";
    }
}
