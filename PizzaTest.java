import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PizzaTest {

    @Test
    public void Pizza_instanceCountTest(){
        Pizza testPizza = new Pizza();
        @SuppressWarnings("rawtypes")
        Class c = testPizza.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    5, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void Pizza_instanceVariablesTest(){
        Pizza testPizza = new Pizza();
        instanceVariablePrivate("size",testPizza);
        instanceVariablePrivate("crust",testPizza);
        instanceVariablePrivate("sauce",testPizza);
        instanceVariablePrivate("meatTopping",testPizza);
        instanceVariablePrivate("veggieTopping",testPizza);

        instanceVariableStatic("size",testPizza);
        instanceVariableStatic("crust",testPizza);
        instanceVariableStatic("sauce",testPizza);
        instanceVariableStatic("meatTopping",testPizza);
        instanceVariableStatic("veggieTopping",testPizza);

        instanceVariableCorrectType("size", Size.class,testPizza);
        instanceVariableCorrectType("crust", Crust.class,testPizza);
        instanceVariableCorrectType("sauce", Sauce.class,testPizza);
        instanceVariableCorrectType("meatTopping", MeatTopping.class,testPizza);
        instanceVariableCorrectType("veggieTopping", VeggieTopping.class,testPizza);
    }

    @Test
    public void Pizza_defaultConstructorTest() {
        Pizza testPizza = new Pizza();

        testVariable("size",testPizza,Size.SMALL,"When checking the value of size we");
        testVariable("crust",testPizza,Crust.HAND_TOSSED,"When checking the value of crust we");
        testVariable("sauce",testPizza,Sauce.MARINARA,"When checking the value of sauce we");
        testVariable("meatTopping",testPizza,MeatTopping.none,"When checking the value of meatTopping we");
        testVariable("veggieTopping",testPizza,VeggieTopping.none,"When checking the value of veggieTopping we");
    }

    @Test
    public void Pizza_parameterizedConstructorTest() {
        Pizza testPizza = new Pizza(Size.LARGE,Crust.STUFFED,Sauce.MARINARA,MeatTopping.SAUSAGE,VeggieTopping.MUSHROOMS);

        testVariable("size",testPizza,Size.LARGE,"When checking the value of size we");
        testVariable("crust",testPizza,Crust.STUFFED,"When checking the value of crust we");
        testVariable("sauce",testPizza,Sauce.MARINARA,"When checking the value of sauce we");
        testVariable("meatTopping",testPizza,MeatTopping.SAUSAGE,"When checking the value of meatTopping we");
        testVariable("veggieTopping",testPizza,VeggieTopping.MUSHROOMS,"When checking the value of veggieTopping we");
    }

    @Test
    public void Pizza_getSizeTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        assertEquals("With an Pizza object who's size instance variable is PERSONAL, when calling getSize we",Size.PERSONAL,testPizza.getSize());
    }

    @Test
    public void Pizza_setSizeTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        testPizza.setSize(Size.MEDIUM);
        testVariable("size",testPizza,Size.MEDIUM,"After calling Pizza's setSize method with an argument of Size.MEDIUM, for the value of size we");
    }

    @Test
    public void Pizza_getSauceTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        assertEquals("With an Pizza object who's sauce instance variable is Sauce.MARINARA, when calling getSauce we",Sauce.MARINARA,testPizza.getSauce());
    }

    @Test
    public void Pizza_setSauceTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        testPizza.setSauce(Sauce.WHITE);
        testVariable("sauce",testPizza,Sauce.WHITE,"After calling Pizza's setSauce method with an argument of Sauce.WHITE, for the value of sauce we");
    }

    @Test
    public void Pizza_getCrustTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        assertEquals("With an Pizza object who's crust instance variable is Crust.THIN, when calling getCrust we",Crust.THIN,testPizza.getCrust());
    }

    @Test
    public void Pizza_setCrustTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        testPizza.setCrust(Crust.HAND_TOSSED);
        testVariable("crust",testPizza,Crust.HAND_TOSSED,"After calling Pizza's setCrust method with an argument of Crust.HAND_TOSSED, for the value of crust we");
    }

    @Test
    public void Pizza_getMeatToppingTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        assertEquals("With an Pizza object who's meatTopping instance variable is MeatTopping.PEPPERONI, when calling getMeatTopping we",MeatTopping.PEPPERONI,testPizza.getMeatTopping());
    }

    @Test
    public void Pizza_setMeatToppingTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        testPizza.setMeatTopping(MeatTopping.CHICKEN);
        testVariable("meatTopping",testPizza,MeatTopping.CHICKEN,"After calling Pizza's setMeatTopping method with an argument of MeatTopping.CHICKEN, for the value of meatTopping we");
    }

    @Test
    public void Pizza_getVeggieToppingTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        assertEquals("With an Pizza object who's veggieTopping instance variable is veggieTopping.GREEN_PEPPERS, when calling getVeggieTopping we",VeggieTopping.GREEN_PEPPERS,testPizza.getVeggieTopping());
    }

    @Test
    public void Pizza_setVeggieToppingTest() {
        Pizza testPizza = createPizza(Size.PERSONAL,Crust.THIN,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.GREEN_PEPPERS);
        testPizza.setVeggieTopping(VeggieTopping.SPINACH);
        testVariable("veggieTopping",testPizza,VeggieTopping.SPINACH,"After calling Pizza's setVeggieTopping method with an argument of VeggieTopping.SPINACH, for the value of veggieTopping we");
    }


    @Test
    public void Pizza_toStringTest() {
        Pizza testPizza = createPizza(Size.LARGE,Crust.STUFFED,Sauce.MARINARA,MeatTopping.SAUSAGE,VeggieTopping.MUSHROOMS);
        assertEquals(  "\n\tLARGE\n" +
                        "\tSTUFFED\n" +
                        "\tMARINARA\n" +
                        "\tSAUSAGE\n" +
                        "\tMUSHROOMS\n"
                , testPizza.toString());

        testPizza = createPizza(Size.MEDIUM,Crust.THIN,Sauce.WHITE,MeatTopping.HAM,VeggieTopping.PINEAPPLE);
        assertEquals(  "\n" +
                "\tMEDIUM\n" +
                "\tTHIN\n" +
                "\tWHITE\n" +
                "\tHAM\n" +
                "\tPINEAPPLE\n", testPizza.toString());
    }


    private Pizza createPizza(Size aSize, Crust aCrust, Sauce aSauce, MeatTopping aMeatTopping, VeggieTopping aVeggieTopping){
        Pizza testPizza = new Pizza();
        @SuppressWarnings("rawtypes")
        Class c = testPizza.getClass();

        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            size.set(testPizza, aSize);

            Field crust = c.getDeclaredField("crust");
            crust.setAccessible(true);
            crust.set(testPizza, aCrust);

            Field sauce = c.getDeclaredField("sauce");
            sauce.setAccessible(true);
            sauce.set(testPizza, aSauce);

            Field meatTopping = c.getDeclaredField("meatTopping");
            meatTopping.setAccessible(true);
            meatTopping.set(testPizza, aMeatTopping);

            Field veggieTopping = c.getDeclaredField("veggieTopping");
            veggieTopping.setAccessible(true);
            veggieTopping.set(testPizza, aVeggieTopping);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testPizza;
    }

    private void instanceVariablePrivate(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertTrue("You must make your instance variables private.", Modifier.isPrivate(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableStatic(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("Your instance variables must NOT be static.", false,
                    Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField, Class<?> aClass,  Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("You must make the speed instance variable of type"+ aClass.toString() +".", aClass, c.getDeclaredField(aField).getType());

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void testVariable(String aField, Object testObject, Object expected, String message){
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            Field field = c.getDeclaredField(aField);
            field.setAccessible(true);
            Object fieldValue = field.get(testObject);

            if(expected == null){
                assertNull(message,fieldValue);
            }
            //If class is a double we have a special Junit assert to run
            else if(expected.getClass().equals(Double.class)){
                double doubleFieldValue = (double) fieldValue;
                double doubleExpected = (double) expected;
                assertEquals(message, doubleExpected, doubleFieldValue, .01);
            }
            //Array of some kind yay
            else if(expected.getClass().isArray()){

            }
            else if(expected.getClass().equals(ArrayList.class)){

            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }
}