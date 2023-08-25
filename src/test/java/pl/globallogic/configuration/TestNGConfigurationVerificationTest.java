package pl.globallogic.configuration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGConfigurationVerificationTest {

    @Test
    public void shouldAlwaysBeTrue() {
        int number = 1;
        int number2 = 2;
        Assert.assertEquals(number, 1);
        Assert.assertNotEquals(number2, number);
    }
}
