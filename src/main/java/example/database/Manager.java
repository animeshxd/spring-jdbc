package example.database;

import javax.annotation.PostConstruct;

import example.models.Customer;

public interface Manager {
    public int insert(Customer customer);
    public int update(Customer customer);
    public int delete(int CustomerID);

    @PostConstruct
    public void afterInit();
}
