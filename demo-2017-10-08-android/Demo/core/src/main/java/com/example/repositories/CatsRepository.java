package com.example.repositories;

import com.example.entities.Cat;

import java.util.UUID;

/**
 * Created by Dev on 09/10/2017.
 */

public interface CatsRepository {
    void save(Cat cat);

    Cat getCat(UUID newCatId);

    void remove(UUID newCatId);
}
