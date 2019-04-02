package com.example.TestMediaSoft.entities.productEntities;

import javax.persistence.*;

/**
 *  This class describes the essence of the movie.
 */

@Entity
@Table(name = "flm")
public class Film extends Product {

    /**
     * Movie identifier
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    /**
     * Movie title.
     */
    public String title;

    /**
     * Movie premiere date.
     */
    public Integer dateProd;

    /**
     * Movie genre
     */
    public String genre;

    /**
     * Movie description
     */
    public String description;

    public Film() {
    }

    /**
     * This is a movie class constructor.
     * @param title
     * @param dateProd
     * @param genre
     * @param description
     */
    public Film(String title, Integer dateProd, String genre, String description) {
        this.title = title;
        this.dateProd = dateProd;
        this.genre = genre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method allows get title of the movie.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method allows you to change the name of the movie.
     * @param title title of the movie.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method allows get date premier of the movie.
     * @return dateProd
     */
    public int getDateProd() {
        return dateProd;
    }

    /**
     * Method allows set date premier of the movie.
     * @param dateProd
     */
    public void setDateProd(int dateProd) {
        this.dateProd = dateProd;
    }

    /**
     * Method allows get genre of the movie.
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Method allows set genre of the movie.
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Method allows get description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method allows set description.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
