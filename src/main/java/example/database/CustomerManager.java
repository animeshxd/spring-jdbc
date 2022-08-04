package example.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import example.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import org.springframework.jdbc.core.RowMapper;

@Component
public class CustomerManager implements Manager {

    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public CustomerManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void afterInit() {
        String statement = """
                CREATE TABLE IF NOT EXISTS Customers (
                    CustomerID INTEGER PRIMARY KEY AUTOINCREMENT,
                    CustomerName TEXT,
                    ContactName TEXT,
                    Address TEXT,
                    City TEXT,
                    PostalCode TEXT,
                    Country TEXT
                    )
                """.strip();
        jdbcTemplate.update(statement);
    }
    @Override
    public int insert(Customer customer) {
        var statement = "INSERT INTO Customers(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country) VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(statement, customer.toObjects());
    }

    @Override
    public int update(Customer customer) {
       var statement = "UPDATE Customers SET CustomerName = ?, ContactName = ?, Address = ?, City = ?, PostalCode = ?, Country = ? WHERE CustomerID = ?";
        return jdbcTemplate.update(statement, customer.getCustomerName(), customer.getContactName(), customer.getAddress(), customer.getCity(), customer.getPostalCode(), customer.getCountry(), customer.getCustomerID());
    }
    @Override
    public int delete(int CustomerID) {
        var sql = "DELETE FROM Customers where CustomerID = ?";
        return jdbcTemplate.update(sql, CustomerID);
    }

    @Override
    public Customer findOne(int CustomerID) {
        var sql = "SELECT * FROM Customers WHERE CustomerID = ?";
        var mapper = new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                
                var customer = new Customer(rs.getInt(1));
                
                customer.setCustomerName(rs.getString(2));
                customer.setContactName(rs.getString(3));
                customer.setAddress(rs.getString(4));
                customer.setCity(rs.getString(5));
                customer.setPostalCode(rs.getString(6));
                customer.setCountry(rs.getString(7));
                return customer;
            }
            
        };
        return jdbcTemplate.queryForObject(sql, mapper, CustomerID);
    }
}
