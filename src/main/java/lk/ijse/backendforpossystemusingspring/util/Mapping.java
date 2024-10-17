package lk.ijse.backendforpossystemusingspring.util;

import lk.ijse.backendforpossystemusingspring.dto.impl.CustomerDTO;
import lk.ijse.backendforpossystemusingspring.dto.impl.ItemDTO;
import lk.ijse.backendforpossystemusingspring.dto.impl.ItemOrderDTO;
import lk.ijse.backendforpossystemusingspring.dto.impl.OrdersDTO;
import lk.ijse.backendforpossystemusingspring.entity.impl.CustomerEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.ItemEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.ItemOrderEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.OrdersEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<CustomerDTO> asCustomerDtoList(List<CustomerEntity>customerEntity){
        return modelMapper.map(customerEntity,new TypeToken<List<CustomerDTO>>(){}.getType());
    }
    ////////////////////////////////



    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return  modelMapper.map(itemDTO, ItemEntity.class);
    }


    public ItemDTO toItemDto(ItemEntity itemEntity){
        return  modelMapper.map(itemEntity, ItemDTO.class);
    }

    public List<ItemDTO> asItemDtoList(List<ItemEntity>itemEntity){
        return modelMapper.map(itemEntity,new TypeToken<List<ItemEntity>>(){}.getType());
    }
    /////////////////////////////////

    public OrdersEntity toOrderentity (OrdersDTO orderDTO){
        return modelMapper.map(orderDTO, OrdersEntity.class);
    }
    public OrdersDTO toOrderDTO(OrdersEntity orderEntity){
        return modelMapper.map(orderEntity, OrdersDTO.class);
    }
    public List<OrdersDTO>toOrderList(List<OrdersEntity>orderList){
        return modelMapper.map(orderList,new TypeToken<List<OrdersDTO>>(){}.getType());
    }

    public List<ItemOrderEntity> toOrderEntityDetailsList(List<ItemOrderDTO>orderList){
        return modelMapper.map(orderList,new TypeToken<List<ItemOrderEntity>>(){}.getType());
    }
    public ItemOrderEntity toOrderDetailsEntity(ItemOrderDTO itemOrderDTO){
        return modelMapper.map(itemOrderDTO, ItemOrderEntity.class);
    }


}
