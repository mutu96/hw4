package com.hussain.hw4.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
//Table is being called from mysql workbanch
@Table(name ="movie")

public class Movie {
    //id and column is being called so information can get POST in it
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "Title")
    private String Title;




    public Movie()
    {

    }
    public Movie(String Title, String id) {

        this.id = id;
        this.Title = Title;

    }


    //using get and set function for column information
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
}
