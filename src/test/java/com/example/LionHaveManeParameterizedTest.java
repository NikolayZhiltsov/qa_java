package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionHaveManeParameterizedTest {
    private final String sex;
    private final boolean expected;
    private Lion lion;
    private Feline feline;

    public LionHaveManeParameterizedTest(String sex, boolean expected) throws Exception {
        this.sex = sex;
        this.expected = expected;
        this.feline = new Feline();
        this.lion = new Lion(sex, feline);
    }

    @Parameterized.Parameters()
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void haveManeTest() {
        assertEquals(expected, lion.doesHaveMane());
    }
}