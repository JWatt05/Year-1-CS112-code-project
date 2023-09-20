//wlb22171

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private HashMap<String, Component> catalogue;
    private int currentSerialNumber;
    private String productID;

    public Main() {
        catalogue = new HashMap<>();
        currentSerialNumber = 1;
    }

    // Initial startup Catalogue menu
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the OCP catalogue system:");
        int choices;

        do {
            System.out.println("Enter an option:");
            System.out.println("1. Add a new component product to the catalogue");
            System.out.println("2. Quit");
            System.out.print(">>> ");
            choices = scanner.nextInt();
            scanner.nextLine();

            switch (choices) {
                case 1:
                    addComponentProduct(scanner);
                    break;
                case 2:
                    System.out.println("Shutting down");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choices != 2);

        scanner.close();
    }

    // Menu system process to add details of component
    private void addComponentProduct(Scanner scanner) {
        System.out.println("Select the component type to be added: \n 1. CPU  2. GPU  3. Memory  4. Storage  5. PSU");
        System.out.print(">>> ");
        int componentType = scanner.nextInt();
        scanner.nextLine();

        String selectedComps;
        switch (componentType) {
            case 1:
                System.out.println("1. CPU");
                selectedComps = "CPU";
                break;
            case 2:
                System.out.println("2. GPU");
                selectedComps = "GPU";
                break;
            case 3:
                System.out.println("3. Memory");
                selectedComps = "Memory";
                break;
            case 4:
                System.out.println("4. Storage");
                selectedComps = "Storage";
                break;
            case 5:
                System.out.println("5. PSU");
                selectedComps = "PSU";
                break;
            default:
                System.out.println("Wrong Input, Try Again.");
                selectedComps = "Wrong Input, Try Again.";
                return;
        }

        System.out.println("Select the interface type \n 1. SocketAM  2. LGA  3. PCIe  4. DDR3  5. DDR4 \n 6. DDR5  7. NVME  8. SATA  9. ATX  10. ITX");
        System.out.print(">>> ");
        int interfaceType = scanner.nextInt();
        scanner.nextLine();

        String selectedType;

        switch (interfaceType) {
            case 1:
                System.out.println("1. SocketAM");
                selectedType = "SocketAM";
                break;
            case 2:
                System.out.println("2. LGA");
                selectedType = "LGA";
                break;
            case 3:
                System.out.println("3. PCIe");
                selectedType = "PCIe";
                break;
            case 4:
                System.out.println("4. DDR3");
                selectedType = "DDR3";
                break;
            case 5:
                System.out.println("5. DDR4");
                selectedType = "DDR4";
                break;
            case 6:
                System.out.println("6. DDR5");
                selectedType = "DDR5";
                break;
            case 7:
                System.out.println("7. NVME");
                selectedType = "NVME";
                break;
            case 8:
                System.out.println("8. SATA");
                selectedType = "SATA";
                break;
            case 9:
                System.out.println("9. ATX");
                selectedType = "ATX";
                break;
            case 10:
                System.out.println("10. ITX");
                selectedType = "ITX";
                break;
            default:
                System.out.println("Wrong Input, Try Again.");
                selectedType = "Wrong Input, Try Again.";
                return;
        }

        System.out.println("Enter the details for the component:");

        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        productID = generateProductID(manufacturer);

        System.out.println("Product is '" + selectedComps + " " + description + " with interface " + selectedType + " manufactured by\n" + manufacturer + " at price £" + price + "'. Is this correct? (Y/N)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            Component componentProduct = new Component(price, productID);
            catalogue.put(productID, componentProduct);
            System.out.println("Product ID " + productID + " added to the catalogue.");
        } else if (choice.equalsIgnoreCase("N")) {
            System.out.println("Please add information in the catalogue menu again.");
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println("\nPress any key to return to the main menu...");
        scanner.nextLine();
    }

    // Generation of the productID's after being entered via the menu
    private String generateProductID(String manufacturerName) {
        String prefix = manufacturerName.substring(0, Math.min(4, manufacturerName.length())).toUpperCase();
        String serialNumber = String.format("%04d", currentSerialNumber++);
        return prefix + "xxxx".substring(prefix.length()) + serialNumber;
    }


    public static void main(String[] args) {
        Main system = new Main();
        system.start();
    }
}