package example.models;

public record Customer(
    Integer customerID, 
    String  customerName, 
    String  contactName, 
    String  address, 
    String  city,
    String  postalCode,
    String  country
){
    
    public Customer(String... l){
        
        this(Integer.parseInt(l[0]), l[1], l[2], l[3], l[4], l[5], l[6]);
    }

    public Object[] toObjects(){
        return new Object[]{ customerID(), customerName(), contactName(), address(), city(), postalCode(), country() };
    }
}