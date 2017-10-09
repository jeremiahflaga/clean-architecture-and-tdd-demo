package com.example.data;

import com.example.entities.Cat;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by MyndDev on 06/10/2017.
 */

public class CatsRepositoryImplTests_SavingCat {

    @Test
    public void shouldSaveCatToTheDatabase() {
        CatsRepositoryImpl repository = new CatsRepositoryImpl();
        Cat newCat = new Cat(UUID.randomUUID());

        repository.save(newCat);

        Cat theNewCat = repository.getCat(newCat.getId());

        Assert.assertEquals(newCat.getId(), theNewCat.getId());
    }
}
