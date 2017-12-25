package entity;

/**
 *
 * @author ng
 */
public class DeliveryMan {

    private String regNo;
    private String deliveryManName, ic, phoneNo, email, address;
    private String workingStatus, deliveryStatus;
    private boolean attendance;
    private double totalDistance;
    private int totalDelivery ;

    public int getTotalDelivery() {
        return totalDelivery;
    }

    public void setTotalDelivery(int totalDelivery) {
        this.totalDelivery = totalDelivery;
    }

    public DeliveryMan(String regNo, String deliveryManName, String ic, String phoneNo, String email, String address, String workingStatus, String deliveryStatus, boolean attendance, double totalDistance, int totalDelivery) {
        this.regNo = regNo;
        this.deliveryManName = deliveryManName;
        this.ic = ic;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.workingStatus = workingStatus;
        this.deliveryStatus = deliveryStatus;
        this.attendance = attendance;
        this.totalDistance = totalDistance;
        this.totalDelivery = totalDelivery;
    }

   

    public DeliveryMan(String regNo, String deliveryManName, String ic, String phoneNo, String email, String address) {
        this.regNo = regNo;
        this.deliveryManName = deliveryManName;
        this.ic = ic;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.workingStatus = "Employed";
        this.deliveryStatus = "Available";
        this.attendance = false;
        this.totalDistance = 0;
        this.totalDelivery = 0;
    }

    public DeliveryMan() {
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getDeliveryManName() {
        return deliveryManName;
    }

    public void setDeliveryManName(String deliveryManName) {
        this.deliveryManName = deliveryManName;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    @Override
    public String toString() {
       return     "Reg No\t\t\t: "+regNo
               +"\nName\t\t\t: "+deliveryManName
               +"\nIC\t\t\t: "+ic
               +"\nPhone No.\t\t: "+phoneNo
               +"\nEmail\t\t\t: "+email
               +"\nHome address\t\t: "+address
               +"\nWorking status\t\t: "+workingStatus
               +"\nDelivery status\t\t: "+deliveryStatus
               +"\nAttendance\t\t: "+attendance
               +"\nTotal distance(km)\t: "+totalDistance
               +"\nTotal delivery completed: " +totalDelivery+"\n\n";
    }

}
