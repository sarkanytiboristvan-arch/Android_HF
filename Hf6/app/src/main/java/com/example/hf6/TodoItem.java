package com.example.hf6;

public class TodoItem {
    private String title;
    private String description;
    private String status;
    private String date;

    public TodoItem(String title, String description, String status, String date) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    // Getterek
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
}
