package entities; /**
 */

import java.util.*;

public class Provider {

    protected int id;
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String email;
    protected String username;
    protected String password;
    private double rating;
    private int experienceYears;

    private ArrayList<WrittenWork> products = new ArrayList<>();

    /**
     * Default constructor
     */
    public Provider() {
        super();
        rating = 0.0;
        experienceYears = 0;
    }

    /**
     * Constructor
     * @param name customer's name
     * @param address customer's address
     * @param birthDate customer's address to gather age
     * @param email customer's email
     * @param gender customer's gender
     */
    public Provider(String name, String address, Date birthDate, String email, Gender gender, String username, String password)
    {
        this.rating = 0.0;
        this.experienceYears = 0;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void addProduct(WrittenWork product) {
        products.add(product);
    }

    public void removeProduct(int productId) {

    }
    public ArrayList<WrittenWork> getProducts() { return products; }



}
