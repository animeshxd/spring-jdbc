package example.models;

public class Customer {

    final private Integer customerID;
    private String  customerName; 
    private String  contactName;
    private String  address;
    private String  city;
    private String  postalCode;
    private String  country;


    public Customer(
        Integer customerID, 
        String customerName, 
        String contactName, 
        String address, 
        String city,
        String postalCode, 
        String country) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Customer(String... l){
        
        this(Integer.parseInt(l[0]), l[1], l[2], l[3], l[4], l[5], l[6]);
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public Object[] toObjects(){
        return new Object[]{ customerID, customerName, contactName, address, city, postalCode, country};
    }
    @Override
    public String toString() {
        return "Customer [address=" + address + ", city=" + city + ", contactName=" + contactName + ", country="
                + country + ", customerID=" + customerID + ", customerName=" + customerName + ", postalCode="
                + postalCode + "]";
    }
}