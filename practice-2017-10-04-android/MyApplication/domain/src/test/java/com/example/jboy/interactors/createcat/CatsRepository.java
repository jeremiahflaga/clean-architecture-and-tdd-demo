package com.example.jboy.interactors.createcat;

/**
 * Created by Dev on 04/10/2017.
 */

class CatsRepository {

    private boolean saveMethodCalled = false;
    private Cat catObjectPassedToSaveMethod;

    public boolean theSaveMethodWasCalled() {
        return this.saveMethodCalled;
    }

    public void save(Cat cat) {
        this.saveMethodCalled = true;
        this.catObjectPassedToSaveMethod = cat;
    }

    public Cat theCatObjectThatWasPassedToTheSaveMethod() {
        return this.catObjectPassedToSaveMethod;
    }
}
