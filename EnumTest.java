import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EnumTest {

    @Test
    public void SizeTest() {
        try {
            Size.valueOf("SMALL");
            Size.valueOf("MEDIUM");
            Size.valueOf("LARGE");
            Size.valueOf("PERSONAL");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Size enum, we",4,Size.values().length);
    }

    @Test
    public void CrustTest() {
        try {
            Crust.valueOf("HAND_TOSSED");
            Crust.valueOf("THIN");
            Crust.valueOf("THICK");
            Crust.valueOf("STUFFED");

        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Crust enum, we",4,Crust.values().length);
    }

    @Test
    public void SauceTest() {
        try {
            Sauce.valueOf("MARINARA");
            Sauce.valueOf("WHITE");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Sauce enum, we",2,Sauce.values().length);
    }

    @Test
    public void MeatToppingTest() {
        try {
            MeatTopping.valueOf("none");
            MeatTopping.valueOf("PEPPERONI");
            MeatTopping.valueOf("SAUSAGE");
            MeatTopping.valueOf("HAM");
            MeatTopping.valueOf("CHICKEN");
            MeatTopping.valueOf("BACON");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the MeatTopping enum, we",6,MeatTopping.values().length);
    }

    @Test
    public void VeggieToppingTest() {
        try {
            VeggieTopping.valueOf("none");
            VeggieTopping.valueOf("MUSHROOMS");
            VeggieTopping.valueOf("ONIONS");
            VeggieTopping.valueOf("GREEN_PEPPERS");
            VeggieTopping.valueOf("PINEAPPLE");
            VeggieTopping.valueOf("SPINACH");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the VeggieTopping enum, we",6,VeggieTopping.values().length);
    }

}