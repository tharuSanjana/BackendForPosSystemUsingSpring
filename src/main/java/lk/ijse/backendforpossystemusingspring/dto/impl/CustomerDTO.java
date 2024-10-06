package lk.ijse.backendforpossystemusingspring.dto.impl;

import lk.ijse.backendforpossystemusingspring.dto.CustomerStatus;
import lk.ijse.backendforpossystemusingspring.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String c_id;
    private String name;
    private String nic;
    private String email;
    private String address;
    private String tel;
}
