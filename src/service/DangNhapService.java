package service;

import model.Customer;

public interface DangNhapService {
    public Customer loginCustomer(String username, String password);
    public Boolean writeFile(String username);
}
