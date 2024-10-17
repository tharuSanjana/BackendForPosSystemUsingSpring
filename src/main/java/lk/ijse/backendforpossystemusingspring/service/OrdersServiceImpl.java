package lk.ijse.backendforpossystemusingspring.service;

import lk.ijse.backendforpossystemusingspring.dao.OrdersDao;
import lk.ijse.backendforpossystemusingspring.dto.impl.ItemOrderDTO;
import lk.ijse.backendforpossystemusingspring.dto.impl.OrdersDTO;
import lk.ijse.backendforpossystemusingspring.entity.impl.ItemOrderEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.OrdersEntity;
import lk.ijse.backendforpossystemusingspring.exception.DataPersistException;
import lk.ijse.backendforpossystemusingspring.util.AppUtil;
import lk.ijse.backendforpossystemusingspring.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersServiceImpl {
    @Autowired
    private OrdersDao orderDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private ItemOrderService itemOrderService;
    private static final Logger logger= LoggerFactory.getLogger(ItemOrderEntity.class);
    @Override
    public void saveOrder(OrdersDTO orderDTO) {
        logger.info("Attempting to save order with Id ",orderDTO.getO_id());
        OrdersEntity order = orderDao.save(mapping.toOrderentity(orderDTO));
        if (order==null){
            throw new DataPersistException("Order not saved");
        }else {
            logger.info("Saved Successfully !!!");
            for (ItemOrderDTO orderDetailsDTO:orderDTO.getOrderDetailsDTO()){
                orderDetailsDTO.setId(AppUtil.OrderDetailsId());
                orderDetailsDTO.setOrder(orderDTO);
                ItemOrderService.saveOrderDetails(new ItemOrderDTO(
                        orderDetailsDTO.getId(),
                        orderDetailsDTO.getDate(),
                        orderDetailsDTO.getCustomerId(),
                        orderDetailsDTO.getCustomerName(),
                        orderDetailsDTO.getCustomerCity(),
                        orderDetailsDTO.getCustomerTel(),
                        orderDetailsDTO.getItemName(),
                        orderDetailsDTO.getOrderQty(),
                        orderDetailsDTO.getUnitPrice(),
                        orderDetailsDTO.getItem(),
                        orderDetailsDTO.getOrder()
                ));
                logger.info("Order detail for order Id saved successfully ",orderDTO.getOrderId());
            }
        }
    }
}
