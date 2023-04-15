/**
 * Program Name: PizzaExperience
 * Program Description: Pizza store that sells pizza on patrons (customer) where a pizza can
 *                      have toppings, size, crust type, and sauce.
 * -------------------------------------------------------------
 * <YOUR NAME>
 * <DATE>
 * <COURSE NUMBER & SECTION>
 */

/**
 * Models a pizza sold in store
 * Instance variables: size, crust, sauce, meat topping, and veggie topping
 */
public class Pizza {
    private Size size;
    private Crust crust;
    private Sauce sauce;
    private MeatTopping meatTopping;
    private VeggieTopping veggieTopping;

    /**
     * Parameterized constructor
     * @param aSize
     * @param aCrust
     * @param aSauce
     * @param aMeatTopping
     * @param aveggieTopping
     */
    public Pizza(Size aSize, Crust aCrust, Sauce aSauce, MeatTopping aMeatTopping, VeggieTopping aveggieTopping) {
        size = aSize;
        crust = aCrust;
        sauce = aSauce;
        meatTopping = aMeatTopping;
        veggieTopping = aveggieTopping;
    }

    /**
     * Default constructor - initializes each fields with first value of enumeration
     */
    public Pizza() {
        size = Size.values()[0];
        crust = Crust.values()[0];
        sauce = Sauce.values()[0];
        meatTopping = MeatTopping.values()[0];
        veggieTopping = VeggieTopping.values()[0];
    }

    /**
     * Getter for size
     * @return
     */
    public Size getSize() {
        return size;
    }

    /**
     * Getter for crust
     * @return
     */
    public Crust getCrust() {
        return crust;
    }

    /**
     * Getter for sauce
     * @return
     */
    public Sauce getSauce() {
        return sauce;
    }

    /**
     * Getter for meatTopping
     * @return
     */
    public MeatTopping getMeatTopping() {
        return meatTopping;
    }

    /**
     * Getter for veggieTopping
     * @return
     */
    public VeggieTopping getVeggieTopping() {
        return veggieTopping;
    }

    /**
     * Setter for size
     * @param aSize
     */
    public void setSize(Size aSize) {
        size = aSize;
    }

    /**
     * Setter for crust
     * @param aCrust
     */
    public void setCrust(Crust aCrust) {
        crust = aCrust;
    }

    /**
     * Setter for sauce
     * @param aSauce
     */
    public void setSauce(Sauce aSauce) {
        sauce = aSauce;
    }

    /**
     * Setter for meatTopping
     * @param aMeatTopping
     */
    public void setMeatTopping(MeatTopping aMeatTopping) {
        meatTopping = aMeatTopping;
    }

    /**
     * Setter for veggieTopping
     * @param aVeggieTopping
     */
    public void setVeggieTopping(VeggieTopping aVeggieTopping) {
        veggieTopping = aVeggieTopping;
    }

    /**
     * Implementation of string representation
     * @return
     */
    public String toString() {
        String builder = "\n";
        builder += "\t" + size.name() + "\n";
        builder += "\t" + crust.name() + "\n";
        builder += "\t" + sauce.name() + "\n";
        builder += "\t" + meatTopping.name() + "\n";
        builder += "\t" + veggieTopping.name() + "\n";
        return builder;
    }
}
