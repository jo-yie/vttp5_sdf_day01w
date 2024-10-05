import java.io.Console;
import java.util.*;

public class shoppingCart {

    public void list(List l) {
        if (cart.size() > 0) {
            for (int i = 0; i< cart.size(); i++) {
                System.out.printf("%d. %s \r\n", i + 1, cart.get(i));
            } 
        } else {
            System.out.println("Your cart is empty");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your shopping cart");
        shoppingCart newCart = new shoppingCart();

        Console console = System.console();
        List<String> cart = new ArrayList<String>();
        String keyboardInput = "";
        keyboardInput = console.readLine();
        Scanner scan = new Scanner(keyboardInput); 

        if (keyboardInput.equals("list")) {
            list();
        } else if (keyboardInput.startsWith("add ")) {
            while (scan.hasNext()) {
                String item = scan.next();
                cart.add(item);
                System.out.println(item + " added to cart");
            }
        }

        scan.close();

    }
}