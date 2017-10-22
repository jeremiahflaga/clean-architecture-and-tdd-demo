package com.example.jboy.data;

import com.example.entities.Cat;
import com.example.repositories.CatsRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dev on 10/10/2017.
 */

public class InMemoryCatsRepository implements CatsRepository {

    private static Map<UUID, Cat> cats = new HashMap();

    public InMemoryCatsRepository() {
    }

    public InMemoryCatsRepository(List<Cat> catsList) {
        cats.clear();
        for (Cat cat : catsList) {
            cats.put(cat.getId(), cat);
        }
    }

    @Override
    public void save(Cat cat) {
        cats.put(cat.getId(), cat);
    }

    @Override
    public Cat getCat(UUID catId) {
        return cats.get(catId);
    }

    @Override
    public void remove(UUID catId) {
        cats.remove(catId);
    }

    public Collection<Cat> getAllCats() {
        return cats.values();
    }
}
