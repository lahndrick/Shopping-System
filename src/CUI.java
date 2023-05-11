//this class is for the users use, utilising all other classes

import java.util.Scanner;

/**
 *
 * @author Lahndrick Hendricks
 */
public class CUI {

    public User user;

    public static void main(String[] args) {
        
        new CreateFiles();
        Scanner scan = new Scanner(System.in);
        Inventory inv = new Inventory();
//        FileManager fm = new FileManager();
        User user = new User("", "");
        String lineClear = "";
        int purchaseChoice;
        ShoppingCart cart = new ShoppingCart();
        int itemChoice;

        while (true) {

            //update inventory using txt file
//            fm.readFromInventory(inv);
            int loginRegister = 0;

            System.out.println("1. Log in");
            System.out.println("2. Admin log in");
            System.out.println("3. Register");
            System.out.println("4. Delete user");
            System.out.println("5. Exit program");

            String loginRegisterString = scan.nextLine();
            loginRegisterString = loginRegisterString.replaceAll("[^a-zA-Z0-9]", "");
            try {
                if (loginRegisterString.trim().isEmpty()) {
                    throw new Exception();
                } else {
                    loginRegister = Integer.valueOf(loginRegisterString);
                }
            } catch (Exception e) {
                System.out.println("Input error.");
                continue;
            }

            switch (loginRegister) {
                //case 1 checks whether username and password combo exists
                case 1:
                    System.out.println();

                    String nameLogin;
                    System.out.println("Username:");

                    while (true) {
                        nameLogin = scan.nextLine();
                        if (!nameLogin.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Input error.");
                    }

                    String passLogin;
                    System.out.println("Password:");

                    while (true) {
                        passLogin = scan.nextLine();
                        if (!passLogin.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Input error.");
                    }

                    //if user does exist
                    if (new LoginUser(nameLogin, passLogin, user).getProceed() == true) {
                        System.out.println();

                        OUTER:
                        while (true) {
                            try {
                                while (true) {
                                    System.out.println("1. Add item to cart");
                                    System.out.println("2. Remove item from cart");
                                    System.out.println("3. Finalise cart");
                                    System.out.println("4. View previous orders");
                                    System.out.println("5. Sign out");
                                    System.out.println("6. Exit program");

                                    String purchaseChoiceString = scan.nextLine();
                                    purchaseChoiceString = purchaseChoiceString.replaceAll("[^a-zA-Z0-9]", "");

                                    try {
                                        if (purchaseChoiceString.trim().isEmpty()) {
                                            throw new Exception();
                                        } else {
                                            purchaseChoice = Integer.valueOf(purchaseChoiceString);
                                            break;
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Input error.");
                                    }
                                }

                                System.out.println();

                                switch (purchaseChoice) {
                                    //add item
                                    case 1:
                                        System.out.println("Item list:");
                                        System.out.println(inv.toString());
                                        System.out.println("\nWhich item would you like to add?");

                                        while (true) {
                                            String itemChoiceString = scan.nextLine();
                                            itemChoiceString = itemChoiceString.replaceAll("[^a-zA-Z0-9]", "");

                                            try {
                                                if (itemChoiceString.trim().isEmpty()) {
                                                    throw new Exception();
                                                } else {
                                                    itemChoice = Integer.valueOf(itemChoiceString);

                                                    if (itemChoice > 0 && itemChoice <= inv.getSize()) {
                                                        break;
                                                    } else {
                                                        throw new Exception();
                                                    }

                                                }
                                            } catch (Exception e) {
                                                System.out.println("Input error.");
                                            }
                                        }

                                        cart.addItem(inv.getItem(itemChoice - 1));
                                        System.out.println("Items currently in cart");
                                        System.out.println(cart.toString());
                                        break;

                                    //remove item
                                    case 2:
                                        RemoveItemFromCart remItem = new RemoveItemFromCart(cart);
                                        int cartSize = cart.getSize();

                                        if (cartSize > 0) {
                                            System.out.println(remItem.greetMessage());

                                            while (true) {
                                                String itemChoiceString = scan.nextLine();
                                                itemChoiceString = itemChoiceString.replaceAll("[^a-zA-Z0-9]", "");
                                                try {
                                                    if (itemChoiceString.trim().isEmpty()) {
                                                        throw new Exception();
                                                    } else {
                                                        itemChoice = Integer.valueOf(itemChoiceString);
                                                        if (remItem.remove(itemChoice)) {
                                                            System.out.println(cart.toString());
                                                            break;
                                                        }
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Input error.");
                                                }
                                            }
                                        } else {
                                            System.out.println("Cart is empty.");
                                            break;
                                        }
                                        break;

                                    //finalise cart    
                                    case 3:
                                        if (cart.getSize() > 0) {
                                            CartFinaliser finalCart = new CartFinaliser(user, cart);

                                            if (finalCart.checkPassword()) {
                                                finalCart.checkPickup();
                                                finalCart.addTransaction();

                                                //if internal cart check is cleared, wipe existing shopping cart
                                                if (finalCart.getClear() == true) {
                                                    cart = new ShoppingCart();
                                                }
                                            }
                                        } else {
                                            System.out.println("Cart is empty.");
                                        }

                                        break;

                                    //previous orders    
                                    case 4:
                                        System.out.println("Previous orders:");
//                                        String prevOrders = fm.readFromTransactionLog(user.getUsername());

//                                        if (prevOrders == null) {
//                                            System.out.println("No previous orders");
//                                        } else {
//                                            System.out.println(prevOrders);
//                                        }
                                        break;

                                    //sign out
                                    case 5:
                                        //wipes the existing shopping cart
                                        cart = new ShoppingCart();
                                        break OUTER;

                                    case 6:
                                        System.exit(0);

                                    default:
                                        System.out.println("Input error.");
                                        continue OUTER;
                                }

                            } catch (Exception e) {
                                System.out.println("Input error.");
                                break;
                            }
                        }
                    }
                    break;

                //admin log in
                case 2:
                    System.out.println();
                    System.out.println("Username:");

                    while (true) {
                        nameLogin = scan.nextLine();
                        if (!nameLogin.trim().isEmpty()) {
                            break;
                        }

                        System.out.println("Input error.");
                    }

                    System.out.println("Password:");

                    while (true) {
                        passLogin = scan.nextLine();
                        if (!passLogin.trim().isEmpty()) {
                            break;
                        }

                        System.out.println("Input error.");
                    }

                    //if user does exist and the username is "admin"
                    if (new LoginUser(nameLogin, passLogin, user).getProceed() == true && nameLogin.equalsIgnoreCase("admin")) {
                        System.out.println();
                        inv.retrieveStock();

                        OUTER:
                        while (true) {
                            System.out.println("1. Add item to inventory");
                            System.out.println("2. Remove item from inventory");
                            System.out.println("3. Remove user");
                            System.out.println("4. Sign out");
                            System.out.println("5. Exit program");
                            int adminChoice = 0;

                            while (true) {
                                String adminChoiceString = scan.nextLine();
                                adminChoiceString = adminChoiceString.replaceAll("[^a-zA-Z0-9]", "");

                                try {
                                    if (adminChoiceString.trim().isEmpty()) {
                                        throw new Exception();
                                    } else {
                                        adminChoice = Integer.valueOf(adminChoiceString);
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Input error.");
                                }
                            }

                            ADMINLOOP:
                            switch (adminChoice) {
                                //add item to inventory
                                case 1:
                                    while (true) {
                                        System.out.println("Current items in inventory:");
                                        System.out.println(inv.toString());
                                        String itemName;
                                        System.out.println("Item name:");
                                        while (true) {
                                            itemName = scan.nextLine();

                                            if (!itemName.trim().isEmpty() && !itemName.replaceAll("[^a-zA-Z]", "").isEmpty()) {
                                                break;
                                            }

                                            System.out.println("Input error.");
                                        }

                                        System.out.println("Item cost (enter 0 to change item name):");
                                        Double itemCost = 0.0;

                                        while (true) {
                                            String itemCostString = scan.nextLine();
                                            itemCostString = itemCostString.replaceAll("[^0-9]", "");

                                            try {
                                                if (itemCostString.trim().isEmpty()) {
                                                    throw new Exception();
                                                } else {
                                                    itemCost = Double.valueOf(itemCostString);
                                                    break;
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Input error.");
                                            }
                                        }

                                        if (itemCost > 0) {
                                            inv.addItem(new Item(itemName, itemCost));
                                            inv.writeStock();
                                            break;
                                        } else {
                                            System.out.println("Input error.");
                                        }
                                    }
                                    break;

                                //remove item from inventory
                                case 2:
                                    System.out.println("Item list:");
//                                    fm.readFromInventory(inv);
                                    System.out.println(inv.toString());
                                    System.out.println("\nWhich item would you like to remove? (enter 0 to cancel)");
                                    adminChoice = 0;

                                    try {
                                        while (true) {
                                            String adminChoiceString = scan.nextLine();
                                            adminChoiceString = adminChoiceString.replaceAll("[^0-9]", "");

                                            try {
                                                if (adminChoiceString.trim().isEmpty()) {
                                                    throw new Exception();
                                                } else {
                                                    adminChoice = Integer.valueOf(adminChoiceString);

                                                    if (adminChoice > 0 && adminChoice <= inv.getSize()) {
                                                        break;
                                                    } else if (adminChoice == 0) {
                                                        break ADMINLOOP;
                                                    } else {
                                                        throw new Exception();
                                                    }
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Input error.");
                                                continue;
                                            }
                                        }

                                        inv.removeItem(inv.getItem(adminChoice - 1));
                                        inv.writeStock();
                                        inv.retrieveStock();
                                        System.out.println("New item list:");
                                        System.out.println(inv.toString());
                                    } catch (Exception e) {
                                        System.out.println("Input error.");
                                    }
                                    break;

                                //remove user from list
                                case 3:
                                    String removeUsername;
                                    System.out.println("Username to remove: ");
                                    while (true) {
                                        removeUsername = scan.nextLine();

                                        if (!removeUsername.trim().isEmpty()) {
                                            break;
                                        }
                                        System.out.println("Input error.");
                                    }

                                    System.out.println();
                                    new RemoveUser("admin", removeUsername);
                                    continue;

                                //sign out of admin
                                case 4:
                                    break OUTER;
                                //exit program
                                case 5:
                                    System.exit(0);
                                default:
                                    System.out.println("Input error.");
                                    break;
                            }
                        }
                    }
                    break;

                //create new user
                case 3:
                    System.out.println();
                    System.out.println("Please choose a username:");
                    String username = scan.nextLine();
                    System.out.println("Please choose a password:");
                    String password = scan.nextLine();

                    new CreateUser(username, password);
                    break;

                case 4:
                    new RemoveUser();
                    continue;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Input error.");
            }
        }
    }
}
