package com.example.data;

import com.example.entities.Cat;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by MyndDev on 06/10/2017.
 */

public class CatsRepositoryImplTests_GettingCat {

    @Test
    public void shouldGetCorrectCatFromTheDatabase() {
        CatsRepositoryImpl repository = new CatsRepositoryImpl();

        Cat fistCat = new Cat(UUID.randomUUID());
        fistCat.setName("Kang Kang");
        fistCat.setTitle("The Great");
        repository.save(fistCat);

        Cat secondCat = new Cat(UUID.randomUUID());
        fistCat.setName("Pepper");
        fistCat.setTitle("The First");
        repository.save(secondCat);

        Cat theSecondCatFromDb = repository.getCat(secondCat.getId());

        assertEquals(secondCat.getId(), theSecondCatFromDb.getId());
        assertEquals(secondCat.getName(), theSecondCatFromDb.getName());
        assertEquals(secondCat.getTitle(), theSecondCatFromDb.getTitle());
    }
}
