import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

@SuppressWarnings("rawtypes")
public class PatronTest {


    @Test
    public void Patron_instanceCountTest(){
        Patron testPatron = new Patron();
        Class c = testPatron.getClass();
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
    public void Patron_instanceVariablesTest(){
        Patron testPatron = new Patron();
        instanceVariablePrivate("firstName",testPatron);
        instanceVariablePrivate("lastName",testPatron);
        instanceVariablePrivate("phone",testPatron);
        instanceVariablePrivate("email",testPatron);
        instanceVariablePrivate("pizzas",testPatron);

        instanceVariableStatic("firstName",testPatron);
        instanceVariableStatic("lastName",testPatron);
        instanceVariableStatic("phone",testPatron);
        instanceVariableStatic("email",testPatron);
        instanceVariableStatic("pizzas",testPatron);

        instanceVariableCorrectType("firstName",String.class,testPatron);
        instanceVariableCorrectType("lastName",String.class,testPatron);
        instanceVariableCorrectType("phone",String.class,testPatron);
        instanceVariableCorrectType("email",String.class,testPatron);
        instanceVariableCorrectType("pizzas",ArrayList.class,testPatron);
    }

    @Test
    public void Patron_defaultConstructorTest() {
        Patron testPatron = new Patron();

        testVariable("firstName",testPatron,"","When checking the value of firstName we");
        testVariable("lastName",testPatron,"","When checking the value of lastName we");
        testVariable("phone",testPatron,"","When checking the value of phone we");
        testVariable("email",testPatron,"","When checking the value of email we");
        testVariable("pizzas",testPatron,new ArrayList<>(),"When checking the value of pizzas we");

    }

    @Test
    public void Patron_parameterizedConstructorTest() {
        Patron testPatron = new Patron("Claire","Sparks","555-230-2212","csparks@vcu.edu");

        testVariable("firstName",testPatron,"Claire","When checking the value of firstName we");
        testVariable("lastName",testPatron,"Sparks","When checking the value of lastName we");
        testVariable("phone",testPatron,"555-230-2212","When checking the value of phone we");
        testVariable("email",testPatron,"csparks@vcu.edu","When checking the value of email we");
        testVariable("pizzas",testPatron,new ArrayList<>(),"When checking the value of pizzas we");

    }

    @Test
    public void Patron_getFirstNameTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        assertEquals("With a Patron object who's firstName instance variable is Claire, when calling getFirstName we","Claire",testPatron.getFirstName());
    }

    @Test
    public void Patron_setFirstNameTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);

        testPatron.setFirstName("Samus");
        testVariable("firstName",testPatron,"Samus","After calling Patron's setFirstName method with an argument of Stefan, for the value of firstName we");
    }

    @Test
    public void Patron_getLastNameTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        assertEquals("With a Patron object who's lastName instance variable is Sparks, when calling getLastName we","Sparks",testPatron.getLastName());
    }

    @Test
    public void Patron_setLastNameTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        testPatron.setLastName("Aran");
        testVariable("lastName",testPatron,"Aran","After calling Patron's setLastName method with an argument of Aran, for the value of lastName we");
    }

    @Test
    public void Patron_getPhoneTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        assertEquals("With a Patron object who's phone instance variable is 555-230-2212, when calling getPhone we","555-230-2212",testPatron.getPhone());
    }

    @Test
    public void Patron_setPhoneTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        testPatron.setPhone("804-921-1017");
        testVariable("phone",testPatron,"804-921-1017","After calling Patron's setPhone method with an argument of 804-921-1017, for the value of phone we");
    }

    @Test
    public void Patron_getEmailTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        assertEquals("With a Patron object who's email instance variable is csparks@vcu.edu, when calling getEmail we","csparks@vcu.edu",testPatron.getEmail());
    }

    @Test
    public void Patron_setEmailTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        testPatron.setEmail("aran.samus@gfed.gov");
        testVariable("email",testPatron,"aran.samus@gfed.gov","After calling Patron's setEmail method with an argument of aran.samus@gfed.gov, for the value of email we");
    }

    @Test
    public void Patron_getPizzasTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        somePizzas.add(createPizza(Size.PERSONAL,Crust.THIN,Sauce.WHITE, MeatTopping.HAM, VeggieTopping.PINEAPPLE));
        somePizzas.add(createPizza(Size.MEDIUM,Crust.THICK,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.none));

        ArrayList<Pizza> expectedPizzas = new ArrayList<>();
        expectedPizzas.add(createPizza(Size.PERSONAL,Crust.THIN,Sauce.WHITE, MeatTopping.HAM, VeggieTopping.PINEAPPLE));
        expectedPizzas.add(createPizza(Size.MEDIUM,Crust.THICK,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.none));

        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        testPizzaArray("With a Patron object who's pizzas instance variable is has two elements, when calling getPizzas we",expectedPizzas,testPatron.getPizzas());
    }

    @Test
    public void Patron_getNumPizzasTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        somePizzas.add(createPizza(Size.PERSONAL,Crust.THIN,Sauce.WHITE, MeatTopping.HAM, VeggieTopping.PINEAPPLE));
        somePizzas.add(createPizza(Size.MEDIUM,Crust.THICK,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.none));
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        assertEquals("With a Patron object who's pizzas instance variable is has two elements, when calling getNumPizzas we",2,testPatron.getNumPizzas());
    }

    @Test
    public void Patron_addPizzaOnePizzaTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        ArrayList<Pizza> expectedPizza = new ArrayList<>();
        expectedPizza.add(createPizza(Size.PERSONAL,Crust.THIN,Sauce.WHITE, MeatTopping.HAM, VeggieTopping.PINEAPPLE));
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        testPatron.addPizza(createPizza(Size.PERSONAL,Crust.THIN,Sauce.WHITE, MeatTopping.HAM, VeggieTopping.PINEAPPLE));

        testVariable("pizzas",testPatron,expectedPizza,"With a Patron object who's pizzas instance variable had zero elements, then calling addPizza once, when checking the pizzas instance variable we");
    }


    @Test
    public void Patron_addPizzaFourPizzasTest() {
        ArrayList<Pizza> somePizzas = new ArrayList<>();
        ArrayList<Pizza> expectedPizza = new ArrayList<>();
        expectedPizza.add(createPizza(Size.LARGE,Crust.HAND_TOSSED,Sauce.MARINARA,MeatTopping.SAUSAGE,VeggieTopping.MUSHROOMS));
        expectedPizza.add(createPizza(Size.LARGE,Crust.STUFFED,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.ONIONS));
        expectedPizza.add(createPizza(Size.PERSONAL,Crust.HAND_TOSSED,Sauce.WHITE,MeatTopping.CHICKEN,VeggieTopping.SPINACH));
        expectedPizza.add(createPizza(Size.LARGE,Crust.THIN,Sauce.MARINARA,MeatTopping.BACON,VeggieTopping.none));


        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizzas);
        testPatron.addPizza(createPizza(Size.LARGE,Crust.HAND_TOSSED,Sauce.MARINARA,MeatTopping.SAUSAGE,VeggieTopping.MUSHROOMS));
        testPatron.addPizza(createPizza(Size.LARGE,Crust.STUFFED,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.ONIONS));
        testPatron.addPizza(createPizza(Size.PERSONAL,Crust.HAND_TOSSED,Sauce.WHITE,MeatTopping.CHICKEN,VeggieTopping.SPINACH));
        testPatron.addPizza(createPizza(Size.LARGE,Crust.THIN,Sauce.MARINARA,MeatTopping.BACON,VeggieTopping.none));


        testVariable("pizzas",testPatron,expectedPizza,"With a Patron object who's pizzas instance variable had zero elements, then calling addPizza four times, when checking the pizzas instance variable we");
    }

    @Test
    public void Customer_toStringTest() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        somePizza.add(createPizza(Size.LARGE,Crust.HAND_TOSSED,Sauce.MARINARA,MeatTopping.SAUSAGE,VeggieTopping.MUSHROOMS));
        Patron testPatron = createPatron("Claire","Sparks","555-230-2212","csparks@vcu.edu",somePizza);


        assertEquals(  "Claire\n" +
                "Sparks\n" +
                "555-230-2212\n" +
                "csparks@vcu.edu\n" +
                "Pizzas:\n" +
                "\n" +
                "\tLARGE\n" +
                "\tHAND_TOSSED\n" +
                "\tMARINARA\n" +
                "\tSAUSAGE\n" +
                "\tMUSHROOMS\n", testPatron.toString());


        somePizza = new ArrayList<>();

        somePizza.add(createPizza(Size.LARGE,Crust.HAND_TOSSED,Sauce.MARINARA,MeatTopping.SAUSAGE,VeggieTopping.MUSHROOMS));
        somePizza.add(createPizza(Size.LARGE,Crust.STUFFED,Sauce.MARINARA,MeatTopping.PEPPERONI,VeggieTopping.ONIONS));
        somePizza.add(createPizza(Size.PERSONAL,Crust.HAND_TOSSED,Sauce.WHITE,MeatTopping.CHICKEN,VeggieTopping.SPINACH));
        somePizza.add(createPizza(Size.LARGE,Crust.THIN,Sauce.MARINARA,MeatTopping.BACON,VeggieTopping.none));

        testPatron = createPatron("Claire","Sparks","804-230-2112","csparks@vcu.edu",somePizza);

        assertEquals(  "Claire\n" +
                "Sparks\n" +
                "804-230-2112\n" +
                "csparks@vcu.edu\n" +
                "Pizzas:\n" +
                "\n" +
                "\tLARGE\n" +
                "\tHAND_TOSSED\n" +
                "\tMARINARA\n" +
                "\tSAUSAGE\n" +
                "\tMUSHROOMS\n"+
                "\n" +
                "\tLARGE\n" +
                "\tSTUFFED\n" +
                "\tMARINARA\n" +
                "\tPEPPERONI\n" +
                "\tONIONS\n" +
                "\n" +
                "\tPERSONAL\n" +
                "\tHAND_TOSSED\n" +
                "\tWHITE\n" +
                "\tCHICKEN\n" +
                "\tSPINACH\n"+
                "\n" +
                "\tLARGE\n" +
                "\tTHIN\n" +
                "\tMARINARA\n" +
                "\tBACON\n" +
                "\tnone\n", testPatron.toString());
    }

    private Patron createPatron(String aFirstName, String aLastName, String aPhone, String anEmail, ArrayList anPizzas){
        Patron testPatron = new Patron();
        Class c = testPatron.getClass();

        try {
            Field firstName = c.getDeclaredField("firstName");
            firstName.setAccessible(true);
            firstName.set(testPatron, aFirstName);

            Field lastName = c.getDeclaredField("lastName");
            lastName.setAccessible(true);
            lastName.set(testPatron, aLastName);

            Field phone = c.getDeclaredField("phone");
            phone.setAccessible(true);
            phone.set(testPatron, aPhone);

            Field email = c.getDeclaredField("email");
            email.setAccessible(true);
            email.set(testPatron, anEmail);

            Field pizzas = c.getDeclaredField("pizzas");
            pizzas.setAccessible(true);
            pizzas.set(testPatron, anPizzas);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testPatron;
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
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertFalse("Your instance variables must NOT be static.", Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField, Class<?> aClass,  Object testObject) {
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
                //CUSTOM FOR PROJECT6TESTS!!!
                testPizzaArray(message,(ArrayList) expected, (ArrayList) fieldValue);
            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }

    private void testPizzaArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!PizzaIsEqual(expected.get(i), actual.get(i))) {
                assertEquals(message + " looked at index "+i+" and ", expected, actual);
            }
        }
    }

    private boolean PizzaIsEqual(Object o1, Object o2){
        Class c = o1.getClass();
        try {
            Field o1FieldOwner = c.getDeclaredField("size");
            o1FieldOwner.setAccessible(true);
            Object o1Owner = o1FieldOwner.get(o1);

            Field o2FieldOwner = c.getDeclaredField("size");
            o2FieldOwner.setAccessible(true);
            Object o2Owner = o2FieldOwner.get(o2);

            Field o1FieldSquareFootage = c.getDeclaredField("crust");
            o1FieldSquareFootage.setAccessible(true);
            Object o1squareFootage = o1FieldSquareFootage.get(o1);

            Field o2FieldSquareFootage = c.getDeclaredField("crust");
            o2FieldSquareFootage.setAccessible(true);
            Object o2squareFootage = o2FieldSquareFootage.get(o2);

            Field o1FieldLotNumber = c.getDeclaredField("sauce");
            o1FieldLotNumber.setAccessible(true);
            Object o1lotNumber = o1FieldLotNumber.get(o1);

            Field o2FieldLotNumber = c.getDeclaredField("sauce");
            o2FieldLotNumber.setAccessible(true);
            Object o2lotNumber = o2FieldLotNumber.get(o2);

            Field o1FieldBedrooms = c.getDeclaredField("meatTopping");
            o1FieldBedrooms.setAccessible(true);
            Object o1Bedrooms = o1FieldBedrooms.get(o1);

            Field o2FieldBedrooms = c.getDeclaredField("meatTopping");
            o2FieldBedrooms.setAccessible(true);
            Object o2Bedrooms = o2FieldBedrooms.get(o2);

            Field o1FieldBaths = c.getDeclaredField("veggieTopping");
            o1FieldBaths.setAccessible(true);
            Object o1Baths = o1FieldBaths.get(o1);

            Field o2FieldBaths = c.getDeclaredField("veggieTopping");
            o2FieldBaths.setAccessible(true);
            Object o2Baths = o2FieldBaths.get(o2);

            return  o1Owner.equals(o2Owner) &&
                    o1squareFootage.equals(o2squareFootage) &&
                    o1lotNumber.equals(o2lotNumber) &&
                    o1Bedrooms.equals(o2Bedrooms) &&
                    o1Baths.equals(o2Baths);


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
    }

}