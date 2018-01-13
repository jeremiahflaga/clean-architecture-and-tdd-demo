package com.example.data;

import com.example.entities.Cat;
import com.example.repositories.CatsRepository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * Created by MyndDev on 06/10/2017.
 */

public class CatsRepositoryImpl implements CatsRepository {

    HashMap<UUID, Cat> cats = new LinkedHashMap<>();

    @Override
    public void save(Cat cat) {
        cats.put(cat.getId(), cat);
    }

    public Cat getCat(UUID id) {
        return cats.get(id);
    }
}
