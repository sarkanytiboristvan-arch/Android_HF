package com.example.hf5;

public class ListItem {
    public String text;
    public int color;

    public ListItem(String text, int color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return text;
    }
}
