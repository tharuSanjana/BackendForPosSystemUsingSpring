package lk.ijse.backendforpossystemusingspring.service;

import lk.ijse.backendforpossystemusingspring.dao.CustomerDao;
import lk.ijse.backendforpossystemusingspring.dto.impl.CustomerDTO;
import lk.ijse.backendforpossystemusingspring.entity.impl.CustomerEntity;
import lk.ijse.backendforpossystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping customerMapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity savedCustomer = customerDao.save(customerMapping.toCustomerEntity(customerDTO));
        if( savedCustomer== null){
            //throw new DataPersistException("Note not saved");
            System.out.println("Customer not saved");
        }
    }

    @Override
    public void updateCustomer(String customerId,CustomerDTO customerDTO) {
        customerDao.save(customerMapping.toCustomerEntity(customerDTO));
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> foundNote = customerDao.findById(customerId);
        if (!foundNote.isPresent()) {
           /* throw new NoteNotFoundException("Note not found");*/
        }else {
            customerDao.deleteById(customerId);
        }
    }
}
