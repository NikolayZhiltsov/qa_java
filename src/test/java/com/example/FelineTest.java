package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private List<String> expectedFood;

    @Before
    public void setupAnimal() throws Exception {
        Animal animal = new Animal();
        expectedFood = animal.getFood("Хищник");
    }

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> result = feline.eatMeat();
        assertEquals(expectedFood, result);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }

    @Test
    public void getKittensDefaultTest() {
        Feline feline = new Feline();
        int result = feline.getKittens();
        assertEquals(1, result);
    }

    @Test
    public void getKittensCountTest() {
        Feline feline = new Feline();
        int result = feline.getKittens(13);
        assertEquals(13, result);
    }
}
