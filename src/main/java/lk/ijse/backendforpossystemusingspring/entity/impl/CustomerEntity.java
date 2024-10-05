package lk.ijse.backendforpossystemusingspring.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String c_id;
    private String name;
    private String nic;
    private String email;
    private String address;
    private String tel;
}
