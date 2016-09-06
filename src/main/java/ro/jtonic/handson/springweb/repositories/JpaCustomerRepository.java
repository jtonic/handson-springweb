package ro.jtonic.handson.springweb.repositories;

import org.springframework.data.repository.Repository;
import ro.jtonic.handson.springweb.entities.Customer;

/**
 * Created by antonelpazargic on 06/09/16.
 */
public interface JpaCustomerRepository extends Repository<Customer, Long> {

    Customer findByName(String name);

}
