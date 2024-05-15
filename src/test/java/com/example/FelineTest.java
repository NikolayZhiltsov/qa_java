package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private List<String> expectedFood;

    @Spy
    private Feline feline;

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

    @Test
    public void getKittensDefaultSpyTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void eatMeatSpyTest() throws Exception {
        feline.eatMeat();
        ArgumentCaptor<Feline> argumentCaptor = ArgumentCaptor.forClass(Feline.class);
        Mockito.verify(feline).getFood(String.valueOf(argumentCaptor.capture()));
        String capturedArgument = String.valueOf((argumentCaptor.getValue()));
        assertEquals("Хищник", capturedArgument);
    }
}