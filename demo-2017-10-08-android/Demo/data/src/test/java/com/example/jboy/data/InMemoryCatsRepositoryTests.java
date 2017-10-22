package com.example.jboy.data;

import com.example.entities.Cat;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Dev on 10/10/2017.
 */

public class InMemoryCatsRepositoryTests {

    InMemoryCatsRepository repository = new InMemoryCatsRepository();

    @Before
    public void setup() {
        // arrange
        repository = new InMemoryCatsRepository(new ArrayList<Cat>());
    }

    @Test
    public void shouldGetCorrectCatFromDatabase() {
        // arrange
        UUID newCatId_1 = UUID.randomUUID();
        Cat newCat_1 = new Cat(newCatId_1, "Kang Kang");
        repository.save(newCat_1);

        UUID newCatId_2 = UUID.randomUUID();
        Cat newCat_2 = new Cat(newCatId_2, "Angel");
        repository.save(newCat_2);

        // act
        Cat firstCat = repository.getCat(newCatId_1);

        // assert
        assertEquals(newCatId_1, firstCat.getId());
        assertEquals("Kang Kang", firstCat.getName());
    }

    @Test
    public void shouldRemoveCorrectCatFromDatabase() {
        // arrange
        UUID newCatId_1 = UUID.randomUUID();
        Cat newCat_1 = new Cat(newCatId_1, "Kang Kang");
        repository.save(newCat_1);

        UUID newCatId_2 = UUID.randomUUID();
        Cat newCat_2 = new Cat(newCatId_2, "Angel");
        repository.save(newCat_2);

        // act
        repository.remove(newCatId_1);

        // assert
        Cat cat = repository.getCat(newCatId_1);
        assertNull(cat);
    }
}
