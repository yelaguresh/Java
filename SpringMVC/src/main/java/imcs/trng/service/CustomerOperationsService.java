package imcs.trng.service;

import imcs.trng.pojo.Customers;

public interface CustomerOperationsService {
boolean login(String Username,String Password);
boolean checkCreateCustomer(Customers customers);
Customers read(int id);
boolean checkUpdateCustomer(int id, String phone);
boolean checkDeleteCustomer(int id);
}
