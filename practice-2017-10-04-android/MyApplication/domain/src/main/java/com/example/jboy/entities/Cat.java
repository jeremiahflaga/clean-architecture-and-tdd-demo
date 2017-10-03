package com.example.jboy.entities;

import java.util.UUID;

/**
 * Created by Dev on 04/10/2017.
 */

public class Cat {
    private String name;
    private String title;
    private UUID id;

    public Cat(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }
}
