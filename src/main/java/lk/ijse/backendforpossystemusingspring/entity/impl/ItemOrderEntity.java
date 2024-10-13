package lk.ijse.backendforpossystemusingspring.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemOrderEntity {
   /* private String o_id;
    private String i_id;*/

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private String id;

 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "i_id", nullable = false)
    private ItemEntity item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "o_id", nullable = false)
    private OrdersEntity order;
}
