package com.example.entities;

import org.junit.Test;

import java.util.UUID;

import sun.security.x509.CertAttrSet;

import static org.junit.Assert.*;

/**
 * Created by Dev on 09/10/2017.
 */
public class CatTest {

    @Test
    public void shouldReturnCorrectGrandioseName() {
        Cat cat = new Cat(UUID.randomUUID(), "Kang Kang");
        cat.setTitle("The Great");

        assertEquals("Kang Kang 'The Great'", cat.grandioseName());
    }

    @Test
    public void shouldReturnCorrectGrandioseNameIfTitleIsNull() {
        Cat cat = new Cat(UUID.randomUUID(), "Kang Kang");
        cat.setTitle(null);

        assertEquals("Kang Kang", cat.grandioseName());
    }

    @Test
    public void shouldReturnCorrectGrandioseNameIfTitleIsBlank() {
        Cat cat = new Cat(UUID.randomUUID(), "Kang Kang");
        cat.setTitle("");

        assertEquals("Kang Kang", cat.grandioseName());
    }

    @Test
    public void shouldReturnCorrectGrandioseNameIfTitleIsAllSpaces() {
        Cat cat = new Cat(UUID.randomUUID(), "Kang Kang");
        cat.setTitle("       ");

        assertEquals("Kang Kang", cat.grandioseName());
    }

    @Test
    public void shouldReturnCorrectId() {
        UUID catId = UUID.randomUUID();
        Cat cat = new Cat(catId, "Cat Name");

        assertEquals(catId, cat.getId());
    }

    @Test
    public void shouldReturnCorrectName() {
        UUID catId = UUID.randomUUID();
        Cat cat = new Cat(catId, "Cat Name");

        assertEquals("Cat Name", cat.getName());
    }

    @Test
    public void shouldReturnCorrectTitle() {
        Cat cat = new Cat(UUID.randomUUID(), "Cat Name");
        cat.setTitle("Cat Title");

        assertEquals("Cat Title", cat.getTitle());
    }

    @Test
    public void catIsImportantIfItsGrandioseNameIsLessThanTen() {
        Cat cat = new Cat(UUID.randomUUID(), "1");
        cat.setTitle("2");

        assertTrue(cat.isImportant());
    }

    @Test
    public void catIsNotImportantIfItsGrandioseNameIsEqualToTen() {
        Cat cat = new Cat(UUID.randomUUID(), "1234567890");

        assertFalse(cat.isImportant());
    }

    @Test
    public void catIsNotImportantIfItsGrandioseNameIsGreaterThanTen() {
        Cat cat = new Cat(UUID.randomUUID(), "123456789AB");

        assertFalse(cat.isImportant());
    }
}