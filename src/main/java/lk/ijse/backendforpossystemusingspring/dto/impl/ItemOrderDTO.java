package lk.ijse.backendforpossystemusingspring.dto.impl;

import jakarta.persistence.*;
import lk.ijse.backendforpossystemusingspring.entity.impl.ItemEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.OrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemOrderDTO {

    private String id;
    private ItemEntity item;
    private OrdersEntity order;
}
