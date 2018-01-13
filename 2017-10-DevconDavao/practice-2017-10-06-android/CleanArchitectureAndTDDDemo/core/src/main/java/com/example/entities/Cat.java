package com.example.entities;

import java.util.UUID;

/**
 * Created by MyndDev on 06/10/2017.
 */

public class Cat {
    private UUID id;
    private String name;
    private String title;

    public Cat(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
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
}
