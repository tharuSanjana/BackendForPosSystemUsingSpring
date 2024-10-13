package lk.ijse.backendforpossystemusingspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private String i_id;
    private String name;
    private String  qty;
    private String price;
}
