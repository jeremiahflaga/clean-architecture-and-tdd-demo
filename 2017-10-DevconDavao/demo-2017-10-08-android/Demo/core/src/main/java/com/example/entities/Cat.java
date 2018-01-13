package com.example.entities;

import java.util.UUID;

/**
 * Created by Dev on 09/10/2017.
 */

public class Cat {
    private UUID id;
    private String name;
    private String title;

    public Cat(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String grandioseName() {
        if (title != null && !title.trim().equals(""))
            return name + " '" + title + "'";

        return name;
    }

    public boolean isImportant() {
        return grandioseName().length() < 10;
    }
}
