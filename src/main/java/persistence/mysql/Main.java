package persistence.mysql;

import services.CustomerService;

public class Main {
    public static void main (String[] args) {
        var service = new CustomerService();
        var customers = service.getAll();
    }
}
