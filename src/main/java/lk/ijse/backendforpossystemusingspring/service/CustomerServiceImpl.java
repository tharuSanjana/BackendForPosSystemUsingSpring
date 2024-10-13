package lk.ijse.backendforpossystemusingspring.service;

import lk.ijse.backendforpossystemusingspring.customStatusCode.SelectedCustomerErrorStatus;
import lk.ijse.backendforpossystemusingspring.dao.CustomerDao;
import lk.ijse.backendforpossystemusingspring.dto.CustomerStatus;
import lk.ijse.backendforpossystemusingspring.dto.SuperDTO;
import lk.ijse.backendforpossystemusingspring.dto.impl.CustomerDTO;
import lk.ijse.backendforpossystemusingspring.entity.impl.CustomerEntity;
import lk.ijse.backendforpossystemusingspring.exception.DataPersistException;
import lk.ijse.backendforpossystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping customerMapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity savedCustomer = customerDao.save(customerMapping.toCustomerEntity(customerDTO));
        if (savedCustomer == null) {
            throw new DataPersistException("Customer not saved");

        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        customerDao.save(customerMapping.toCustomerEntity(customerDTO));
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> foundNote = customerDao.findById(customerId);
        if (!foundNote.isPresent()) {
            /* throw new NoteNotFoundException("Note not found");*/
        } else {
            customerDao.deleteById(customerId);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> getAllUser = customerDao.findAll();
        return customerMapping.asCustomerDtoList(getAllUser);
    }

    @Override
    public CustomerStatus getSelectedCustomer(String customerId) {
        if (customerDao.existsById(customerId)) {
            CustomerEntity selectedCustomer = customerDao.getReferenceById(customerId);
            return customerMapping.toCustomerDto(selectedCustomer);
        } else {
            return  new SelectedCustomerErrorStatus(2, "Customer with id " + customerId + " not found");
        }

    }
}
