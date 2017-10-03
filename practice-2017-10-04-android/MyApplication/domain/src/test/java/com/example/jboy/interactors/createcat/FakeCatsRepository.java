package com.example.jboy.interactors.createcat;

import com.example.jboy.entities.Cat;
import com.example.jboy.repositories.CatsRepository;

/**
 * Created by Dev on 04/10/2017.
 */

class FakeCatsRepository implements CatsRepository {

    public void save(Cat cat) {
        this.saveMethodCalled = true;
        this.catObjectPassedToSaveMethod = cat;
    }

    private boolean saveMethodCalled = false;
    private Cat catObjectPassedToSaveMethod;

    public boolean theSaveMethodWasCalled() {
        return this.saveMethodCalled;
    }

    public Cat theCatObjectThatWasPassedToTheSaveMethod() {
        return this.catObjectPassedToSaveMethod;
    }
}
