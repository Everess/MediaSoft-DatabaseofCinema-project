package com.example.TestMediaSoft.repos.productRepo;

import com.example.TestMediaSoft.entities.productEntities.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This class contains methods for implementing movie sorting and allows Film entities to interact with the database.
 */
public interface FilmRepo extends CrudRepository<Film, Long> {
    List<Film> findByTitle(String title);
    List<Film> findByDateProd(Integer dateProd);
    List<Film> findByGenre(String genre);

}
