package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class LionSexNegativeTest {
    private final String sex;
    private final Feline feline;

    public LionSexNegativeTest(String sex) {
        this.sex = sex;
        this.feline = new Feline();
    }

    @Parameterized.Parameters()
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Unknown"},
                {"Абракадабра"},
                {""}
        };
    }

    @Test(expected = Exception.class)
    public void exceptionTest() throws Exception {
        new Lion(sex, feline);
    }

    @Test
    public void exceptionTextTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex, feline));
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}