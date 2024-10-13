package lk.ijse.backendforpossystemusingspring.dto.impl;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.backendforpossystemusingspring.entity.impl.ItemOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrdersDTO {

    private String o_id;
    private Date date;
    private String c_id;
    private String c_name;
    private String c_nic;
    private String c_email;
    private String c_address;
    private String c_tel;
    private String i_id;
    private String i_name;
    private String i_price;
    private String i_qty;
    private String i_selectedQty;
    private Double total;
    private Double balance;
    private Double cash;
    private Double discount;

}
