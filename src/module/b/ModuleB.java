package module.b;

import adtInterface.LinkedList;
import entity.DeliveryMan;
import entity.Order;
import java.util.Scanner;
import adtInterface.LinkedListInterface;

public class ModuleB {

    private static int registrationNo = 109;

    public static int getNextRegNo() {

        return ++registrationNo;
    }

    public static int decreseRegNo() {//in case the user cancel add delivery man
        return --registrationNo;
    }

    public static void main(String[] args) {

        LinkedListInterface<DeliveryMan> deliveryManList = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        DeliveryMan worker1 = new DeliveryMan("W101", "Alex Chan", "970417-10-6124", "0123456789", "abc92@mail.com", "3,jalan aman,taman aman", "Employed", "Pending", true, 45, 8);
        DeliveryMan worker2 = new DeliveryMan("W102", "Benny Fan", "121221-33-1251", "0198765432", "fedc98@gmail.com", "22,prima setapak condo", "Employed", "Pending", true, 23.9, 9);
        DeliveryMan worker3 = new DeliveryMan("W103", "Polly Ng", "980530-09-1234", "0158749632", "quada99@mailcom", "99,jalan bunga wangi,taman wangi", "Employed", "Break", true, 7.8, 25);
        DeliveryMan worker4 = new DeliveryMan("W104", "See Kwee Heng", "870930-33-1233", "0123456787", "asdasda88@gmail.com", "32,jalan cempaka wangi,taman cempaka", "Employed", "Available", true, 55.31, 70);
        DeliveryMan worker5 = new DeliveryMan("W105", "Liaw Swee Tian", "120921-33-1224", "0198765432", "fedc98@gmail.com", "22,prima setapak condo", "Employed", "Delivering", true, 18, 5);
        DeliveryMan worker6 = new DeliveryMan("W106", "Jason Chong", "980430-09-1234", "0158749632", "quada99@mailcom", "99,jalan bunga wangi,taman wangi", "Resigned", "Break", false, 36, 23);
        DeliveryMan worker7 = new DeliveryMan("W107", "Ali Binti Shadin", "971217-10-5363", "0123456789", "abc92@mail.com", "3,jalan aman,taman aman", "Employed", "Pending", true, 40.8, 33);
        DeliveryMan worker8 = new DeliveryMan("W108", "Muthu", "121221-33-3251", "0198765432", "fedc98@gmail.com", "22,prima setapak condo", "Employed", "Available", false, 12.06, 10);
        DeliveryMan worker9 = new DeliveryMan("W109", "Chaw Rong Weng", "980730-09-1234", "0158749632", "quada99@mailcom", "99,jalan bunga wangi,taman wangi", "Resigned", "Available", false, 90, 100);
        deliveryManList.add(worker1);
        deliveryManList.add(worker2);
        deliveryManList.add(worker3);
        deliveryManList.add(worker4);
        deliveryManList.add(worker5);
        deliveryManList.add(worker6);
        deliveryManList.add(worker7);
        deliveryManList.add(worker8);
        deliveryManList.add(worker9);

        LinkedListInterface<Order> orderDetails = new LinkedList<>();
        Order order1 = new Order("W101", "O101", "Pizza", 2, "Taman Ehsan", "Chris", "012-9685969", 15.90);
        Order order2 = new Order("W102", "O102", "Pasta", 3, "Sungai Buluh", "Kelly", "011-7859962", 10.00);
        Order order3 = new Order("W107", "O103", "Mee Goreng", 1, "Petaling Jaya", "Merry", "012-8563223", 16.00);
        orderDetails.add(order1);
        orderDetails.add(order2);
        orderDetails.add(order3);
        int input;
        do {
            input = menu();
            if (input == 0) {
                break;
            }
            switch (input) {
                case 1://if the user choose to add new delivery man
                    DeliveryMan newWorker = addWorker();
                    System.out.print("\nRegister (Y/N): ");
                    String result = scan.nextLine();
                    switch (result) {
                        case "Y":
                        case "y": {
                            deliveryManList.add(newWorker);
                            System.out.println("****************************");
                            System.out.println("REGISTERED SUCCESSFULLY!!");
                            System.out.println("****************************\n");

                            System.out.println(newWorker.toString());
                        }
                        break;
                        default: {
                            System.out.println("Registration is cancelled.");
                            decreseRegNo();
                        }
                    }
                    break;
                case 2:
                    int selection = viewStatus(deliveryManList);
                    if (selection == 1) {
                        viewPendingDeli(deliveryManList, orderDetails);
                    }
                    break;
                case 3:
                    updateStatus(deliveryManList);
                    break;
                case 4:
                    updateInfo(deliveryManList);
                    break;
                case 5:
                    System.out.println("\tView Daily Report");
                    System.out.println("--------------------------\n");
                    System.out.println("1. Based on total distance(in descending order)\n2. Based on total delivery completed(in descending order)\n");
                    System.out.print("How do you view the report?(1 or 2): ");
                    int a = scan.nextInt();
                    if (a == 1) {
                        reportBasedOnDistance(deliveryManList);
                    } else if (a == 2) {
                        reportBasedOnTotDeli(deliveryManList);
                    }
                    break;

            }
        } while (!confirmExit());
        System.out.println("Thanks for using the system. Have a Nice Day :)");

    }

    public static void title() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\t\tFASTEST DELIEVRYMAN SDN.BHD.");
        System.out.println("---------------------------------------------------------------------\n");
    }

    public static int menu() {
        title();
        int input = -1;
        System.out.println("1. Add new delivery man");
        System.out.println("2. View Delivery Man's Status");
        System.out.println("3. Update Delivery Man's Working status");
        System.out.println("4. Update Delivery Man Information");
        System.out.println("5. View Report");
        System.out.println("0. Exit");
        do {
            Scanner scan = new Scanner(System.in);

            System.out.print("\nPlease select your option: ");
            input = scan.nextInt();
            if (input < 0 || input > 5) {                                    //if not between 1 to 5
                System.out.println("The option selected is out of range! ");
            }

        } while (input < 0 || input > 5);
        return input;
    }

    public static DeliveryMan addWorker() {
        String deliveryManName, ic, phoneNo, email, address;  //create temporery variables to store the input from the user
        //after that only add in to list
        Scanner scan = new Scanner(System.in);

        String regNo = "W";
        System.out.println("\n\n");
        title();
        System.out.println("Delivery Man Registration ");
        System.out.println("----------------------------------\n");
        regNo += getNextRegNo();
        System.out.print("Registration Number: " + regNo + "");
        System.out.print("\nName: ");
        deliveryManName = scan.nextLine();
        System.out.print("IC: ");
        ic = scan.nextLine();
        System.out.print("Phone Number: ");
        phoneNo = scan.nextLine();
        System.out.print("Email: ");
        email = scan.nextLine();
        System.out.print("Home address: ");
        address = scan.nextLine();

        return new DeliveryMan(regNo, deliveryManName, ic, phoneNo, email, address);

    }

    public static void updateInfo(LinkedListInterface<DeliveryMan> deliManList) {
        boolean ans = false;                              //to find the correct regNo
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n");
        title();

        System.out.print("Please enter registration number of delivery man:");
        String regNo = scan.nextLine();
        System.out.println("\n\tDelivery Man Contact Information");
        System.out.println("---------------------------------------------------------------------\n");

        for (int i = 1; i <= deliManList.getTotal(); ++i) {                 //find the delivery Man by regNo
            if (deliManList.getEntry(i).getRegNo().equals(regNo)) {
                ans = true;                                 //to check wether want to show error message or not
                System.out.println(deliManList.getEntry(i).toString());
                //working status either is resigned or retired can not update delivery man's information
                if (deliManList.getEntry(i).getWorkingStatus().equals("Employed")) {
                    boolean valid = true;                                           //to check whether the number of menu is valid
                    do {
                        System.out.println("\n\nWhich informaton you want to update?\n");
                        System.out.println("1. Name");
                        System.out.println("2. IC");
                        System.out.println("3. Phone No");
                        System.out.println("4. Email");
                        System.out.println("5. Home Address");

                        System.out.print("\nPlease select a number from the menu: ");
                        String input = scan.nextLine();

                        switch (input) {
                            case "1": {
                                System.out.print("Name: ");
                                deliManList.getEntry(i).setDeliveryManName(scan.nextLine());

                            }
                            break;
                            case "2": {
                                System.out.print("IC: ");
                                deliManList.getEntry(i).setIc(scan.nextLine());

                            }
                            break;
                            case "3": {
                                System.out.print("Phone No: ");
                                deliManList.getEntry(i).setPhoneNo(scan.nextLine());

                            }
                            break;
                            case "4": {
                                System.out.print("Email: ");
                                deliManList.getEntry(i).setEmail(scan.nextLine());

                            }

                            break;
                            case "5": {
                                System.out.print("Home Address: ");
                                deliManList.getEntry(i).setAddress(scan.nextLine());

                            }
                            break;
                            default:
                                System.out.println("The option selected is out of range! Please select from 1 to 5");
                                valid = false;

                        }
                    } while (valid == false);
                    System.out.println("\n\nThe information is updated Successfully!\nUpdated Information:");
                    System.out.println("---------------------------------------------------------------------\n");
                    System.out.println(deliManList.getEntry(i).toString());
                }
                //display error message
                System.out.println("The working status of " + deliManList.getEntry(i).getRegNo() + " is " + deliManList.getEntry(i).getWorkingStatus() + ". The contact information can not be change.");

            }

        }
        if (ans == false) {
            System.out.println("Sorry, the ID does not exist in the list. Please try again.");
        }

    }

    public static void updateStatus(LinkedListInterface<DeliveryMan> deliManList) {
        System.out.println("\n\n");
        boolean ans = true;
        title();
        System.out.println("\tUpdate Delivery Man Status");
        System.out.println("---------------------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the registration number of the delivery man: ");
        String regNo = scan.nextLine();
        int input;
        for (int i = 1; i <= deliManList.getTotal(); ++i) {
            if (deliManList.getEntry(i).getRegNo().equals(regNo)) {
                String currentStatus = deliManList.getEntry(i).getWorkingStatus();
                System.out.println("The current status is: " + currentStatus);
                System.out.println("Please select an option for the latest working status: ");

                if (currentStatus.equals("Retired") || currentStatus.equals("Resigned")) {
                    System.out.println("1. Employed\t2. Exit");
                    System.out.print("Please select 1 or 2: ");
                    input = scan.nextInt();
                    if (input == 1) {
                        deliManList.getEntry(i).setWorkingStatus("Employed");
                        System.out.println("The status is updated.");
                    }
                } else {
                    System.out.println("1. Retired\t2. Resigned\t3. Exit");
                    System.out.print("Please select 1 or 2 or 3: ");
                    input = scan.nextInt();
                    if (input == 1) {
                        deliManList.getEntry(i).setWorkingStatus("Retired");
                        System.out.println("The status is updated.");
                    } else if (input == 2) {
                        deliManList.getEntry(i).setWorkingStatus("Resigned");
                        System.out.println("The status is updated.");
                    }
                }

            } 
            else 
                ans=false;          
        }
        if(ans==false){
             System.out.println("Sorry, the ID does not exist in the list. Please try again.");
        }
    }

    public static int viewStatus(LinkedListInterface<DeliveryMan> deliManList) {
        System.out.println("\n\n");
        Scanner scan = new Scanner(System.in);
        title();
        int input, selection;
        selection = 1; //to determines whether want to ask the user to view pending delivery or not 
        System.out.println("Do you want to view all delivery man's status or search by ID?");
        System.out.println("1. View All");
        System.out.println("2. Search by ID");
        System.out.print("Please enter your selection: ");
        input = scan.nextInt();
        //if is 1 then show all,if 2 can search by ID
        switch (input) {
            case 1:
                viewStatus();
                for (int i = 1; i <= deliManList.getTotal(); ++i) {
                    System.out.println(String.format("%-10s", deliManList.getEntry(i).getRegNo()) + String.format("%-28s", deliManList.getEntry(i).getDeliveryManName()) + String.format("%-20s", deliManList.getEntry(i).getWorkingStatus()) + String.format("%-20s", deliManList.getEntry(i).getDeliveryStatus()));
                }
                //if input is 2,search by ID
                break;
            case 2:
                System.out.print("Please enter the ID of the delivery man: ");
                String regNo = scan.next();
                int a = 1;//to determines whether want to show error message or not
                for (int i = 1; i <= deliManList.getTotal(); ++i) {
                    if (regNo.equals(deliManList.getEntry(i).getRegNo())) {
                        viewStatus();
                        String deliStatus = deliManList.getEntry(i).getDeliveryStatus();
                        System.out.println(String.format("%-10s", deliManList.getEntry(i).getRegNo()) + String.format("%-28s", deliManList.getEntry(i).getDeliveryManName()) + String.format("%-20s", deliManList.getEntry(i).getWorkingStatus()) + String.format("%-20s", deliStatus));
                        a = 0;
                        if (!deliStatus.equals("Pending")) {
                            selection = 2;                      //if the delivery status is not pending, 
                            //don't ask the user want to view pending deliveries or not

                        }
                    } else {
                        selection = 2;
                    }
                }
                if (a == 1) {
                    System.out.println("Sorry, the ID does not exist in the list. Please try again.");
                }
                break;
            default:
                System.out.println("The number is out of range! Plese enter a valid number.");
        }
        return selection;
    }

    public static void reportBasedOnDistance(LinkedListInterface<DeliveryMan> deliManList) {
        System.out.println("\n\n");
        title();
        LinkedListInterface<DeliveryMan> tempList = new LinkedList<>();//store the current list to temporery list in order 
        LinkedListInterface<DeliveryMan> viewList = new LinkedList<>();   // to arrange the list based on total delivery completed
        //add all details to tempList first
        for (int i = 1; i <= deliManList.getTotal(); ++i) {
            tempList.add(deliManList.getEntry(i));
        }

        //check the highest distance ,add in the list until the tempList is empty
        while (!(tempList.isEmpty())) {
            double a = -1.11;           //to store the highest distance
            int position = 0;          //to store the position of that delivery man with the highest distance travelled
            //in this for loop, get the highest first
            for (int i = 1; i <= tempList.getTotal(); ++i) {
                if (tempList.getEntry(i).getTotalDistance() > a) {
                    a = tempList.getEntry(i).getTotalDistance();
                    position = i;
                }
            }
            viewList.add(tempList.remove(position));
        }
        // retrieve all deliveryManContactInfo from the list
        reportDetails(viewList);
    }

    public static void reportBasedOnTotDeli(LinkedListInterface<DeliveryMan> deliManList) {
        System.out.println("\n\n");
        title();
        LinkedListInterface<DeliveryMan> tempList = new LinkedList<>();//store the current list to temporery list 
        LinkedListInterface<DeliveryMan> viewList = new LinkedList<>(); //in order to arrange the list based on total delivery completed

        //add all details to tempList first
        for (int i = 1; i <= deliManList.getTotal(); ++i) {
            tempList.add(deliManList.getEntry(i));
        }

        //check the highest of total number of delivery completed ,add in the list,then for loop again to remove until the tempList is empty
        while (!(tempList.isEmpty())) {
            double a = -1.11;
            int position = 0;
            //in this for loop, get the highest first
            for (int i = 1; i <= tempList.getTotal(); ++i) {
                if (tempList.getEntry(i).getTotalDelivery() > a) {
                    a = tempList.getEntry(i).getTotalDelivery();
                    position = i;
                }
            }
            viewList.add(tempList.remove(position));

        }
        reportDetails(viewList);
    }

    public static boolean confirmExit() {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nDo you want to continue(Y/N)?(Y=Redirect to the menu, N=end the system) ");
        String con = scan.next();

        char con1 = con.charAt(0);

        return !(con1 == 'Y' || con1 == 'y');

    }

    //view Status format
    public static void viewStatus() {
        System.out.println("\n\n");
        title();

        System.out.println("                     Delivery Man's Status ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("ID          Name                  Working Status        Delivery Status");
        System.out.println("------------------------------------------------------------------------");

    }

    public static void reportDetails(LinkedListInterface<DeliveryMan> deliManList) {
        System.out.println(String.format("%-10s %-20s %-15s %-15s %-30s %-35s %-20s %-22s %-18s %-15s %-20s ", "Reg No", "Name", "IC", "Phone No.", "Email", "Home address", "Working status", "Delivery status", "Attendence", "Total distance(km)", "Total delivery"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 1; i <= deliManList.getTotal(); ++i) {

            System.out.print(String.format("%-10s", deliManList.getEntry(i).getRegNo()));
            System.out.print(String.format("%-20s", deliManList.getEntry(i).getDeliveryManName()));
            System.out.print(String.format("%-18s", deliManList.getEntry(i).getIc()));
            System.out.print(String.format("%-15s", deliManList.getEntry(i).getPhoneNo()));
            System.out.print(String.format("%-30s", deliManList.getEntry(i).getEmail()));
            System.out.print(String.format("%-40s", deliManList.getEntry(i).getAddress()));
            System.out.print(String.format("%-20s", deliManList.getEntry(i).getWorkingStatus()));
            System.out.print(String.format("%-25s", deliManList.getEntry(i).getDeliveryStatus()));
            System.out.print(String.format("%-20s", deliManList.getEntry(i).isAttendance()));
            System.out.print(String.format("%.2f", deliManList.getEntry(i).getTotalDistance()));
            System.out.println(String.format("%18d", deliManList.getEntry(i).getTotalDelivery()));

        }
    }

    public static void viewPendingDeli(LinkedListInterface<DeliveryMan> deliManList, LinkedListInterface<Order> orderList) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to view pending deliveries for the delivery man?(Y/N) ");
        String input = scan.nextLine();
        String pendingRegNo;
        int a = 1;
        if ("Y".equals(input) || "y".equals(input)) {
            System.out.print("Please enter the delivery man's registration number: ");
            pendingRegNo = scan.nextLine();
            //FIND THE POSITION FOR DELIMANLIST
            int deliManPosition = 1;
            for (int i = 1; i <= deliManList.getTotal(); ++i) {
                if (pendingRegNo.equals(deliManList.getEntry(i).getRegNo())) {
                    deliManPosition = i;
                }
            }
            for (int i = 1; i <= orderList.getTotal(); ++i) {
                if (pendingRegNo.equals(deliManList.getEntry(deliManPosition).getRegNo()) && pendingRegNo.equals(orderList.getEntry(i).getRegNo())) {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\tOrder Details\n");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(String.format("%-8s", "Reg No") + String.format("%-12s", "Order ID") + String.format("%-15s", "Food Item") + String.format("%-15s", "Quantity") + String.format("%-20s", "Location") + String.format("%-18s", "Customer") + String.format("%-20s", "Phone No") + String.format("%-5s", "Price"));
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(String.format("%-10s", orderList.getEntry(i).getRegNo()) + orderList.getEntry(i).toString());
                    a = 0;
                }
            }
            if (a == 1) {
                System.out.println("Sorry, the ID does not exist in the list or there is no pending deliveries for " + pendingRegNo + ". Please try again.");
            }
        }
    }
}
