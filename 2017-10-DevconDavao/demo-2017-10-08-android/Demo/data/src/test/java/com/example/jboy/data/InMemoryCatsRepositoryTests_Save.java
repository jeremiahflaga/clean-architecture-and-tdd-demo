package com.example.jboy.data;

import com.example.entities.Cat;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Dev on 10/10/2017.
 */

public class InMemoryCatsRepositoryTests_Save {

    InMemoryCatsRepository repository = new InMemoryCatsRepository();

    @Before
    public void setup() {
        // arrange
        repository = new InMemoryCatsRepository(new ArrayList<Cat>());
    }

    @Test
    public void shouldSaveNewCatToDatabase() {
        // arrange
        UUID newCatId = UUID.randomUUID();
        Cat newCat = new Cat(newCatId, "Kang Kang");

        // act
        repository.save(newCat);

        // assert
        assertEquals(1, repository.getAllCats().size());

        Cat cat = repository.getCat(newCatId);
        assertEquals(newCatId, cat.getId());
        assertEquals("Kang Kang", cat.getName());
    }

    @Test
    public void shouldSaveTwoNewCatsToDatabase() {
        // arrange
        UUID newCatId_1 = UUID.randomUUID();
        Cat newCat_1 = new Cat(newCatId_1, "Kang Kang");

        UUID newCatId_2 = UUID.randomUUID();
        Cat newCat_2 = new Cat(newCatId_2, "Angel");

        // act
        repository.save(newCat_1);
        repository.save(newCat_2);

        // assert
        assertEquals(2, repository.getAllCats().size());
    }
}
