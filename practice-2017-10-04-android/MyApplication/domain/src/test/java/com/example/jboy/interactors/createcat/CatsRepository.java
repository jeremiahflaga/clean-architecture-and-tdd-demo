package com.example.jboy.interactors.createcat;

/**
 * Created by Dev on 04/10/2017.
 */

class CatsRepository {

    private boolean saveMethodCalled = false;

    public boolean theSaveMethodWasCalled() {
        return this.saveMethodCalled;
    }

    public void save() {
        this.saveMethodCalled = true;
    }
}
