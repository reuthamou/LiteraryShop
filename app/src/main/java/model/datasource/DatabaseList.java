package model.datasource;

import entities.Book;
import entities.Customer;
import entities.Frequency;
import entities.Gender;
import entities.Genre;
import entities.Periodical;
import entities.Provider;
import entities.Purchase;
import entities.Series;
import entities.StandAlone;
import entities.WrittenWork;
import model.backend.Backend;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Rotem on 28/12/2015.
 */
public class DatabaseList implements Backend {

    ArrayList<Provider> Providers = new ArrayList<Provider>();
    ArrayList<WrittenWork> Products = new ArrayList<WrittenWork>();
    ArrayList<Customer> Customers = new ArrayList<Customer>();

    int ProductCounter = 0;
    int ProviderCounter = 0;
    int CustomerCounter = 0;

    @Override
    public void addBook(WrittenWork book) throws Exception {
        for (WrittenWork item:Products) {
            if (book.equals(item)) throw new Exception("This book already exists in the Database");
            }
        book.setId(ProductCounter++);
        Products.add(book);
        }

    @Override
    public void addCustomer(Customer customer) throws Exception {
        for (Customer item:Customers) {
            if (customer.equals(item)) throw new Exception("This customer already exists in the Database");
        }
        customer.setId(CustomerCounter++);
        Customers.add(customer);
    }

    @Override
    public void addProvider(Provider provider) throws Exception {
        for (Provider item:Providers) {
            if (provider.equals(item)) throw new Exception("This provider already exists in the Database");
        }
        provider.setId(ProviderCounter++);
        Providers.add(provider);
    }

    @Override
    public void deleteBook(int bookID) throws Exception {
        for (WrittenWork item:Products) {
            if (item.getId() == bookID) {
                // Remove the item from any seller in the app
                for (Provider seller:item.getSellers()) {
                    seller.removeProduct(bookID);
                }
                Products.remove(item);
                return;
            }
            throw new Exception("This product doesn't exist in the Database");
        }
    }

    @Override
    public void deleteCustomer(int customerID) throws Exception {
        for (Customer customer:Customers) {
            if (customer.getId() == customerID) {
                Customers.remove(customer);
                return;
            }
            throw new Exception("This customer doesn't exist in the Database");
        }

    }

    @Override
    public void deleteProvider(int providerID) throws Exception {
        for (Provider provider:Providers) {
            if (provider.getId() == providerID) {
                // Remove the seller from any item in the app
                for (WrittenWork item:provider.getProducts()) {
                    item.removeSeller(provider);
                }
                Providers.remove(provider);
                return;
            }
            throw new Exception("This provider doesn't exist in the Database");
        }
    }

    @Override
    public void updateShoppingCart() throws Exception {

    }

    @Override
    public void updateProduct(Purchase purchase) throws Exception {

    }

    public Customer findCustomerByUsername(String username) throws Exception {
        for (Customer customer:Customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        throw new Exception("wrong Username");
    }

    public boolean doesCustomerEmailExist(String email) {
        for (Customer customer:Customers) {
            if (customer.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void setLists() {
        try {
            this.addBook(new Series("JK Rowling", 1988, 1, "Harry Potter", 59.99, "A great novel for all ages", Genre.FANTASY, 7));
            this.addBook(new Series("JRR Tolkein", 1960, 1, "LOTR", 59.99, "Masterpiece", Genre.FANTASY, 3));
            this.addBook(new StandAlone("JRR Tolkein", 1973, 1, "The Hobbit", 20, "Better-suited for kids", Genre.FANTASY));
            this.addBook(new Periodical("Time", 12.99, "Classic", Genre.JOURNAL, Frequency.MONTHFY));

            this.addCustomer(new Customer("Rotem", "Nokdim", new Date(1993, 8, 21), "rotemfridman@gmail.com", Gender.FEMALE, "rotem", "rotem123"));
            this.addCustomer(new Customer("Reut", "beitar", new Date(1993, 1, 1), "reuthamou@gmail.com", Gender.FEMALE, "reut", "reut123"));

            this.addProvider(new Provider("Amazon", "US", "amazon@amazon.com", "amazon", "amazon123"));
            this.addProvider(new Provider("eBay", "US", "ebay@ebay.com", "ebay", "ebay123" ));
            this.addProvider(new Provider("Target", "US", "target@target.com", "target", "target123" ));
        }

        catch (Exception a) {

        }
    }
}
