import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ShoppingCart {

    private List<String> cart = new ArrayList<>();
    private String directoryName;
    private String user;
    
    public ShoppingCart(String directoryName) {
        this.directoryName = directoryName;
    }

    // returns formatted list of items in cart
    public void list() {
        if (this.cart.size() > 0) {
            int i = 1;
            for (String item : this.cart) {
                System.out.printf("%d. %s \r\n", i, item);
                i++;
            }
        } else {
            System.out.println("Your cart is empty");
        } 
    }

    // adds items to cart
    public void add(String item) {
        if (this.cart.contains(item)) {
            System.out.println("You have " + item + " in your cart");
        } else {
            this.cart.add(item);
            System.out.println(item + " added to cart");
        }
        
    }

    // deletes items from cart 
    public void delete(int num) {
        if (num <= getCart().size() && num > 0) {
            int indexToDelete = num - 1; 
            System.out.println(this.cart.get(indexToDelete) + " removed from cart");
            this.cart.remove(indexToDelete);
        } else {
            System.out.println("Incorrect item index");
        }
    }

    public List<String> getCart() {
        return cart;
    }

    public void setCart(List<String> cart) {
        this.cart = cart;
    }

    
    // loads user database file from shopping cart directory
    // if database file does not exist, file is created
    public void login(String userName) {
        File userFile = new File(this.directoryName + "/" + userName + ".db");

        if (userFile.exists()) {
            if (this.cart.size() > 0) {
                System.out.println(userName + ", your cart contains the following items");
                ((ShoppingCart) cart).list();
            } else {
                System.out.println(userName + ", your cart is empty");
            }
        } else {
            try {
                userFile.createNewFile(); 
                System.out.println(userName + ", your cart is empty");
            } catch (IOException e) {
                System.out.println("Error creating user file");
            }
        }
        this.user = userName;

    }

    // saves users cart to file 
    // prompts login if not logged in
    public void save() {
        if (user.equals("")) {
            System.out.println("Please login to save");
        } else {
            File userFile = new File(directoryName + "/" + user + ".db");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            for (String item : cart) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("Your cart has been saved");
        } catch (IOException e) {
            System.out.println("Error saving cart");
            }
        }

    }

    // lists all filenames under shopping cart directory
    public void userList() {
        File directory = new File(directoryName);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".db"));
        
        if (files != null && files.length > 0) {
            System.out.println("The following users are registered");
            int num = 1;
            for (File f : files) {
                String user = f.getName().replace(".db", "");
                System.out.printf("%d. %s \r\n", num, user);
                num ++;
            } 
        } else {
            System.out.println("No users found");
        }
    }

    
}
