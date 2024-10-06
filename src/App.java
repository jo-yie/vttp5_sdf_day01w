import java.io.Console;
import java.util.Scanner;

import java.io.File;

public class App {
    
    public static void main(String[] args) {
        String directoryName = "db"; // default directory 

        // check if a directory was provided 
        if (args.length > 0) {
            directoryName = args[0];
        }

        // create the directory if it does not exist 
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdirs(); 
            System.out.println("Directory " + directoryName + " created");
        } else {
            System.out.println("Using directory " + directoryName);
        }


        ShoppingCart userCart = new ShoppingCart(directoryName);
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

            // input starts with "login"

            else if (keyboardInput.startsWith("login")) {
                // ShoppingCart userCart = new ShoppingCart(directoryName);

                Scanner scan = new Scanner(keyboardInput.substring(6));
                String inputName = scan.next();
                scan.close();

                userCart.login(inputName);
            }

            // input: "save"
            else if (keyboardInput.equals("save")) {
                userCart.save();
            }

            // input: "users"
            else if (keyboardInput.equals("users")) {
                userCart.userList();
            }

        }

    }

}
