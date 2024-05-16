package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private List<String> expectedFood;

    @Mock
    Feline feline;
    Lion lion;

    @Before
    public void setLion() throws Exception {
        lion = new Lion("Самец", feline);
        expectedFood = List.of("Животные", "Птицы", "Рыба");
    }

    @Test
    public void foodLionTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> foodLion = lion.getFood();
        assertEquals(expectedFood, foodLion);
    }

    @Test
    public void getKittensTest () {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int result = lion.getKittens();
        assertEquals(1, result);
    }
}
