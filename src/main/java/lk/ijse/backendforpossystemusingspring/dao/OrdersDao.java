package lk.ijse.backendforpossystemusingspring.dao;

import lk.ijse.backendforpossystemusingspring.entity.impl.ItemEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDao extends JpaRepository<OrdersEntity,String> {
}
