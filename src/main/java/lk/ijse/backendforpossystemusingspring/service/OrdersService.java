package lk.ijse.backendforpossystemusingspring.service;

import lk.ijse.backendforpossystemusingspring.dao.OrdersDao;
import lk.ijse.backendforpossystemusingspring.dto.impl.ItemOrderDTO;
import lk.ijse.backendforpossystemusingspring.dto.impl.OrdersDTO;
import lk.ijse.backendforpossystemusingspring.entity.impl.ItemOrderEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.OrdersEntity;
import lk.ijse.backendforpossystemusingspring.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface OrdersService {
    void saveOrderDetails(ItemOrderDTO itemOrderDTO);
}
