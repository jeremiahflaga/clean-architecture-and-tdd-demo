package com.example.jboy.interactors.createcat;

import com.example.jboy.entities.Cat;
import com.example.jboy.repositories.CatsRepository;

/**
 * Created by Dev on 30/09/2017.
 */

class FakeCatsRepository implements CatsRepository {
    private boolean saveMethodCalled = false;
    private Cat catEntityReceivedBySaveMethod;

    @Override
    public void save(Cat cat) {
        this.saveMethodCalled = true;
        this.catEntityReceivedBySaveMethod = cat;
    }

    public boolean theSaveMethodWasCalled() {
        return saveMethodCalled;
    }

    public Cat theCatEntityThatWasReceivedByTheSaveMethod() {
        return catEntityReceivedBySaveMethod;
    }
}
