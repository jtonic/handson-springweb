package ro.jtonic.handson.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.jtonic.handson.springweb.entities.Customer;
import ro.jtonic.handson.springweb.repositories.JpaCustomerRepository;

/**
 * Created by antonelpazargic on 06/09/16.
 */
@Service
public class CustomerService {

    private JpaCustomerRepository customerRepository;

    @Autowired
    public void config(JpaCustomerRepository jpaCustomerRepository) {
        this.customerRepository = jpaCustomerRepository;
    }

    public Long getCustomerId(String customerName) {
        Customer customer = customerRepository.findByName(customerName);
        if (customer != null) {
            return customer.getId();
        }
        return -1L;
    }

}
