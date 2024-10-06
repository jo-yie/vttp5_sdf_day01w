import java.util.*;

public class ShoppingCart {

    private List<String> cart = new ArrayList<>();
    
    public ShoppingCart() {
    }

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

    public void add(String item) {
        if (this.cart.contains(item)) {
            System.out.println("You have " + item + " in your cart");
        } else {
            this.cart.add(item);
            System.out.println(item + " added to cart");
        }
        
    }

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

    
}
