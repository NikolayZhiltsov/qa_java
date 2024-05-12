package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class LionSexNegativeTest {
    private final String sex;
    private Feline feline;

    public LionSexNegativeTest(String sex) throws Exception {
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

}