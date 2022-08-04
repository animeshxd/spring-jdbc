package example.database;

import javax.annotation.PostConstruct;

import example.models.Customer;

public interface Manager {
    public int insert(Customer customer);

    @PostConstruct
    public void afterInit();
}
