package lk.ijse.backendforpossystemusingspring.util;

import lk.ijse.backendforpossystemusingspring.dto.impl.CustomerDTO;
import lk.ijse.backendforpossystemusingspring.entity.impl.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;


    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return  modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public CustomerDTO toCustomerDto(CustomerEntity customerEntity){
        return  modelMapper.map(customerEntity, CustomerDTO.class);
    }

}
