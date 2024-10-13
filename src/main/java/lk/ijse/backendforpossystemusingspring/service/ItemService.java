package lk.ijse.backendforpossystemusingspring.service;

import lk.ijse.backendforpossystemusingspring.dto.CustomerStatus;
import lk.ijse.backendforpossystemusingspring.dto.ItemStatus;
import lk.ijse.backendforpossystemusingspring.dto.impl.CustomerDTO;
import lk.ijse.backendforpossystemusingspring.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void  saveItem(ItemDTO itemDTO);
    void  updateItem(String itemId, ItemDTO updateItemDTO);

    List<ItemDTO> getAllItems();
    ItemStatus getSelectedItem(String itemId);

    void deleteItem(String itemId);
}
