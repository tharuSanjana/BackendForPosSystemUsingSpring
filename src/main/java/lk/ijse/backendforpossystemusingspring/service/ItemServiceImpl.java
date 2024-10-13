package lk.ijse.backendforpossystemusingspring.service;

import lk.ijse.backendforpossystemusingspring.dao.ItemDao;
import lk.ijse.backendforpossystemusingspring.dto.impl.ItemDTO;
import lk.ijse.backendforpossystemusingspring.entity.impl.CustomerEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.ItemEntity;
import lk.ijse.backendforpossystemusingspring.exception.DataPersistException;
import lk.ijse.backendforpossystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    @Autowired
    private Mapping itemMappimg;

    @Autowired
    private ItemDao itemDao;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        /*ItemEntity savedItem = itemDao.save(itemMappimg.toItemEntity(itemDTO));
        if (savedItem == null) {
            throw new DataPersistException("Item not saved");

        }*/
    }
}
