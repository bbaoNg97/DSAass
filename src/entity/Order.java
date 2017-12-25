
package entity;

/**
 *
 * @author ng
 */
public class Order {
     private final String regNo;
    private final String orderID;
    private final String foodItem;
    private final int foodQty;
    private final String location;
    private final String customer;
    private final String cust_contact;
    private final double price;

    public Order(String regNo, String orderID, String foodItem, int foodQty, String location, String customer, String cust_contact, double price) {
        this.regNo = regNo;
        this.orderID = orderID;
        this.foodItem = foodItem;
        this.foodQty = foodQty;
        this.location = location;
        this.customer = customer;
        this.cust_contact = cust_contact;
        this.price = price;
    }
   

   

    public String getOrderID() {
        return orderID;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public int getFoodQty() {
        return foodQty;
    }

    public String getLocation() {
        return location;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCust_contact() {
        return cust_contact;
    }

    public double getPrice() {
        return price;
    }

    public String getRegNo() {
        return regNo;
    }

    @Override
    public String toString() {
       return  String.format("%-11s %-14s %-11d %-20s %-15s %-20s %.2f", orderID,foodItem,foodQty,location,customer,cust_contact,price) ;
    }

   

    
}
