package com.example.repositories;

import com.example.entities.Cat;

import java.util.UUID;

/**
 * Created by Dev on 09/10/2017.
 */

public class FakeCatsRepository implements CatsRepository {
    private boolean saveMethodWasCalled = false;
    private Cat catEntityReceivedByTheSaveMethod;

    @Override
    public void save(Cat cat) {
        this.saveMethodWasCalled = true;
        this.catEntityReceivedByTheSaveMethod = cat;
    }

    @Override
    public Cat getCat(UUID newCatId) {
        return null;
    }

    @Override
    public void remove(UUID newCatId) {

    }

    public boolean theSaveMethodWasCalled() {
        return this.saveMethodWasCalled;
    }

    public Cat theCatEntityReceivedByTheSaveMethod() {
        return catEntityReceivedByTheSaveMethod;
    }
}
