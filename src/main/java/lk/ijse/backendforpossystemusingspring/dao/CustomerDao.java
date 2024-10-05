package lk.ijse.backendforpossystemusingspring.dao;

import lk.ijse.backendforpossystemusingspring.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
