package lk.ijse.backendforpossystemusingspring.service;

import lk.ijse.backendforpossystemusingspring.customStatusCode.SelectedCustomerErrorStatus;
import lk.ijse.backendforpossystemusingspring.customStatusCode.SelectedItemErrorStatus;
import lk.ijse.backendforpossystemusingspring.dao.ItemDao;
import lk.ijse.backendforpossystemusingspring.dto.ItemStatus;
import lk.ijse.backendforpossystemusingspring.dto.impl.ItemDTO;
import lk.ijse.backendforpossystemusingspring.entity.impl.CustomerEntity;
import lk.ijse.backendforpossystemusingspring.entity.impl.ItemEntity;
import lk.ijse.backendforpossystemusingspring.exception.CustomerNotFoundException;
import lk.ijse.backendforpossystemusingspring.exception.DataPersistException;
import lk.ijse.backendforpossystemusingspring.exception.ItemNotFoundException;
import lk.ijse.backendforpossystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    @Autowired
    private Mapping itemMappimg;

    @Autowired
    private ItemDao itemDao;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity savedItem = itemDao.save(itemMappimg.toItemEntity(itemDTO));
        if (savedItem == null) {
            throw new DataPersistException("Item not saved");

        }
    }

    @Override
    public void updateItem(String itemId, ItemDTO updateItemDTO) {
        Optional<ItemEntity> findItem = itemDao.findById(itemId);
        if (!findItem.isPresent()) {
            throw new ItemNotFoundException("Note not found");
        }else {
            findItem.get().setName(updateItemDTO.getName());
            findItem.get().setQty(updateItemDTO.getQty());
            findItem.get().setPrice(updateItemDTO.getPrice());

        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> getAllItems = itemDao.findAll();
        return itemMappimg.asItemDtoList(getAllItems);
    }

    @Override
    public ItemStatus getSelectedItem(String itemId) {
        if (itemDao.existsById(itemId)) {
            ItemEntity selectedItem = itemDao.getReferenceById(itemId);
            return (ItemStatus) itemMappimg.toItemDto(selectedItem);
        } else {
            return  new SelectedItemErrorStatus(2, "Item with id " + itemId + " not found");
        }

    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> foundNote = itemDao.findById(itemId);
        if (!foundNote.isPresent()) {
            throw new CustomerNotFoundException("Item not found");
        } else {
            itemDao.deleteById(itemId);
        }
    }
}
