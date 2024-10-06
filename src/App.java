import java.io.Console;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        ShoppingCart userCart = new ShoppingCart();
        System.out.println("Welcome to your shopping cart");

        Console console = System.console(); 
        String keyboardInput = "";

        while (!keyboardInput.equals("quit")) {

            keyboardInput = console.readLine();

            // input: "list"
            if (keyboardInput.equals("list")) {
                userCart.list();
            } 
            
            // input: starts with "add"
            else if (keyboardInput.startsWith("add")) {
                keyboardInput = keyboardInput.replace(',', ' ');

                Scanner scan = new Scanner(keyboardInput.substring(4));
                String tempStorage = "";
                while (scan.hasNext()) {
                    tempStorage = scan.next();
                    userCart.add(tempStorage);
                }
                scan.close();
            } 
            
            // input starts with "delete"
            else if (keyboardInput.startsWith("delete")) {
                Scanner scan = new Scanner(keyboardInput.substring(6));
                String deleteIndex = scan.next(); 
                scan.close();

                userCart.delete(Integer.parseInt(deleteIndex));
                
            }

        }

    }

}
