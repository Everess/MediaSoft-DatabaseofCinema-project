package com.example.TestMediaSoft.entities.productEntities;

import javax.persistence.*;

/**
 * Serial entity.
 *
 * TODO: Add this entity to the project work. At now entity not used.
 */
@Entity
@Table(name = "srl")
public class Serial extends Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    /**
     * Title of the serial.
     */
    public String title;

    /**
     * Genre of the serial.
     */
    public String genre;

    /**
     * Count seasons of the serial.
     */
    public int Seasons;

    /**
     * Count episodes of the serial.
     */
    public int Episodes;

    public Serial() {
    }

    /**
     * Declaration serial constructor.
     * @param title
     * @param genre
     * @param seasons
     * @param episodes
     */
    public Serial(String title, String genre, int seasons, int episodes) {
        this.title = title;
        this.genre = genre;
        Seasons = seasons;
        Episodes = episodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method allows get title of the serial.
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method allows set title of the serial.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method allwos get genre of the serial.
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Method allows set genre of the serial.
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Method allows get seasons of the serial.
     * @return seasons
     */
    public int getSeasons() {
        return Seasons;
    }

    /**
     * Method allows set seasons of the serial.
     * @param seasons
     */
    public void setSeasons(int seasons) {
        Seasons = seasons;
    }

    /**
     * Method allows get episodes of the serial.
     * @return episodes
     */
    public int getEpisodes() {
        return Episodes;
    }

    /**
     * Method allows set episodes of the serial.
     * @param episodes
     */
    public void setEpisodes(int episodes) {
        Episodes = episodes;
    }
}
