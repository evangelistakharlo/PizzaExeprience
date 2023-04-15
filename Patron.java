/**
 * Program Name: PizzaExperience
 * Program Description: Pizza store that sells pizza on patrons (customer) where a pizza can
 *                      have toppings, size, crust type, and sauce.
 * -------------------------------------------------------------
 * <YOUR NAME>
 * <DATE>
 * <COURSE NUMBER & SECTION>
 */

import java.util.ArrayList;

/**
 * Models the customer of the store
 * Instance variables: first name, last name, phone, email
 */
public class Patron {
    private String firstName, lastName, phone, email;
    private ArrayList<Pizza> pizzas;

    /**
     * Parameterized constructor
     * @param aFirstName
     * @param aLastName
     * @param aPhone
     * @param anEmail
     */
    public Patron(String aFirstName, String aLastName, String aPhone, String anEmail) {
        firstName = aFirstName;
        lastName = aLastName;
        phone = aPhone;
        email = anEmail;
        pizzas = new ArrayList<>();
    }

    /**
     * Default constructor
     */
    public Patron() {
        firstName = "";
        lastName = "";
        phone = "";
        email = "";
        pizzas = new ArrayList<>();
    }

    /**
     * Getter for firstName
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for lastName
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for phone
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Getter for email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for firstName
     * @param aFirstName
     */
    public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    /**
     * Setter for lastName
     * @param aLastName
     */
    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    /**
     * Setter for phone
     * @param aPhone
     */
    public void setPhone(String aPhone) {
        phone = aPhone;
    }

    /**
     * Setter for email
     * @param anEmail
     */
    public void setEmail(String anEmail) {
        email = anEmail;
    }

    /**
     * Adds a Pizza object into the list of pizzas
     * @param aPizza
     */
    public void addPizza(Pizza aPizza) {
        pizzas.add(aPizza);
    }

    /**
     * Gets the number of pizzas in the list
     * @return
     */
    public int getNumPizzas() {
        return pizzas.size();
    }

    /**
     * Gets the list of pizzas
     * @return
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Returns information of a customer and list of pizzas
     * @return
     */
    public String toString() {
        String builder = firstName + "\n" + lastName + "\n";
        builder += phone + "\n";
        builder += email + "\n";
        builder += "Pizzas:\n";
        for(Pizza p: pizzas) {
            builder += p.toString();
        }

        return builder;
    }
}
