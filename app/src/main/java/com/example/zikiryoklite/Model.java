package com.example.zikiryoklite;

public class Model {
    private String title, sentence;

    public Model(String title, String sentence) {
        this.title = title;
        this.sentence = sentence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
