package com.example.TestMediaSoft.entities.personEntities;

import javax.persistence.*;

/**
 * Actor entity.
 *
 * TODO: Add this entity to the project work. At now entity not used.
 */
@Entity
@Table(name = "actr")
public class Actor extends Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    /**
     * Name of actor.
     */
    public String name;

    /**
     * Surname of actor.
     */
    public String surname;

    /**
     * Works in which the actor took part (films, series).
     */
    public String works;

    public Actor() {

    }

    /**
     * Declaration constructor of actor.
     * @param name Name of actor.
     * @param surname Surname of actor.
     * @param works Actor works.
     */
    public Actor(String name, String surname, String works) {
        this.name = name;
        this.surname = surname;
        this.works = works;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method allows get user name.
     * @return name Name of user.
     */
    public String getName() {
        return name;
    }

    /**
     * Method allows set user name.
     * @param name Name of user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method allows get surname of user.
     * @return surname Surname of user.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Method allows set surname of user.
     * @param surname Surname of user.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Method allows get actor works from database.
     * @return works Actor works from database.
     */
    public String getWorks() {
        return works;
    }

    /**
     * Method allows set actor works.
     * @param works Actor works from database.
     */
    public void setWorks(String works) {
        this.works = works;
    }
}
