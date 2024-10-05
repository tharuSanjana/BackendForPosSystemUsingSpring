package lk.ijse.backendforpossystemusingspring.entity.impl;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "item")
public class ItemEntity {
    @Id
    private String i_id;
    private String name;
    private String  qty;
    private String price;
    @OneToOne
    private CustomerEntity customer;
    @OneToMany(mappedBy = "item")
    private List<ItemOrderEntity> orderDetailsList = new ArrayList<>();
}
