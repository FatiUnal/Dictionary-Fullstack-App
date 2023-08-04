package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dictionary")

public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String englishText;
    private String turkishText;
    private String description;



    public Dictionary(){

    }
    public Dictionary(int id, String englishText, String turkishText, String description) {
        this.id = id;
        this.englishText = englishText;
        this.turkishText = turkishText;
        this.description = description;
    }
    public Dictionary(String englishText, String turkishText, String description) {
        this.englishText = englishText;
        this.turkishText = turkishText;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishText() {
        return englishText;
    }

    public void setEnglishText(String englishText) {
        this.englishText = englishText;
    }

    public String getTurkishText() {
        return turkishText;
    }

    public void setTurkishText(String turkishText) {
        this.turkishText = turkishText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
