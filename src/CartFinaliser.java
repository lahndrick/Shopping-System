/*
* this class is used to finalise the shopping cart, it includes: 
* a password check, "checkPassword()", 
* a pickup/deliver check which also returns the total, "checkPickup()"
* a method to add the finalised purchase to a transaction log, "addTransaction()"
 */
import java.util.Scanner;

/**
 *
 * @author Lahndrick Hendricks
 */
public class CartFinaliser extends ShoppingCart {

    private User user;
    private String password;
    private FileManager fileMan;
    private int size;
    private double total;
    private boolean clear;

    public CartFinaliser(User user, ShoppingCart cart) {
        this.user = user;
        this.password = user.getPassword();
        fileMan = new FileManager();
        this.size = super.getCart().size();
        this.total = cart.getTotal();
        this.clear = true;
    }

    public boolean checkPassword() {

        System.out.println("Before proceeding to checkout, please enter your password.");

        Scanner scan = new Scanner(System.in);
        String input;

        for (int x = 4; x > 0; x--) {
            input = scan.nextLine();

            if (input.equals(password)) {
                //if correct, the user passes the password check and method ends
                System.out.println("Password correct.");
                return true;
            } else {
                //if fail, the user has 3 attempts remaining after initial attempt
                System.out.println("Incorrect password, tries remaining: " + (x - 1));
            }
        }

        //if user fails password 3 times, the method will return false indicating user does not know the password
        System.out.println("Number of tries exceeded");
        return false;
    }

    //this method is the final step in transaction, once transaction is completed it will be added to a txt file
    public void addTransaction() {

        //boolean checked for each while loop
        boolean breakCheck = true;
        Scanner scan = new Scanner(System.in);

        OUTER:
        while (breakCheck) {
            System.out.println("Would you like to complete this transaction?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int input = 0;

            try {
                while (true) {
                    String inputString = scan.nextLine();
                    inputString = inputString.replaceAll("[^a-zA-Z0-9]", "");

                    try {
                        if (inputString.trim().isEmpty()) {
                            throw new Exception();
                        } else {
                            input = Integer.valueOf(inputString);
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Input error.");
                    }
                }

                switch (input) {
                    case 1:
                        //writes the transaction to a file named "transactionlog.txt"
                        fileMan.writeToTransactionLog(this);
                        clear = true;
                        System.out.println("Transaction completed.");
                        //end while loop
                        breakCheck = false;
                        break;
                    case 2:
                        System.out.println("Cancelling transaction.");
                        clear = false;
                        //end while loop
                        breakCheck = false;
                        break;
                    default:
                        System.out.println("Input error.");
                        continue OUTER;
                }
                //handles all errors
            } catch (Exception e) {
                System.out.println("Input error.");
                continue OUTER;
            }
        }
    }

    //this method checks pickup option and reveals total cost
    public void checkPickup() {
        Scanner scan = new Scanner(System.in);

        //while loop continues until break is determined after total cost calculated
        OUTER:
        while(true) {
            System.out.println("Please choose method of shipping");
            System.out.println("1. pickup ($0 charge)");
            System.out.println("2. deliver ($10 charge)");
            int input = 0;

            while(true) {
                String inputString = scan.nextLine();
                inputString = inputString.replaceAll("[^a-zA-Z0-9]", "");
                
                try {
                    if(inputString.trim().isEmpty()){
                        throw new Exception();
                    } else {
                        input = Integer.valueOf(inputString);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Input error.");
                }
            }

            switch (input) {
                case 1:
                    System.out.println("Pickup selected.");
                    total -= 10;
                    System.out.println("Your total comes to: $" + total + "\n");
                    break OUTER;
                case 2:
                    System.out.println("Delivery selected.");
                    System.out.println("Your total comes to: $" + total + "\n");
                    break OUTER;
                default:
                    System.out.println("Input error.");
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public double getTotal() {
        return total;
    }
    
    public boolean getClear(){
        return clear;
    }
}
