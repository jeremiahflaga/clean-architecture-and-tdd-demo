package com.example.interactors.createcat;

import com.example.entities.Cat;
import com.example.repositories.CatsRepository;

/**
 * Created by MyndDev on 06/10/2017.
 */

class FakeCatsRepository implements CatsRepository {

    private boolean saveMethodCalled = false;
    private Cat theCatEntityReceivedBySaveMethod;

    public void save(Cat cat) {
        this.saveMethodCalled = true;
        this.theCatEntityReceivedBySaveMethod = cat;
    }

    public boolean theSaveMethodWasCalled() {
        return this.saveMethodCalled;
    }

    public Cat theCatEntityReceivedByTheSaveMethod() {
        return theCatEntityReceivedBySaveMethod;
    }
}
