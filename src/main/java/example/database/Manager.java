package example.database;

import java.util.List;

import javax.annotation.PostConstruct;

import example.models.Customer;

public interface Manager {
    public int insert(Customer customer);
    public int update(Customer customer);
    public int delete(int CustomerID);

    public Customer findOne(int CustomerID);
    public List<Customer> findAll();

    @PostConstruct
    public void afterInit();
}
