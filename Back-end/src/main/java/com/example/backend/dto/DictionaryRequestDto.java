package com.example.backend.dto;


public class DictionaryRequestDto {
    private String englishText;
    private String turkishText;
    private String description;

    public DictionaryRequestDto(String englishText, String turkishText, String description) {
        this.englishText = englishText;
        this.turkishText = turkishText;
        this.description = description;
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
