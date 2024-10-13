package lk.ijse.backendforpossystemusingspring.controller;

import lk.ijse.backendforpossystemusingspring.customStatusCode.SelectedCustomerErrorStatus;
import lk.ijse.backendforpossystemusingspring.customStatusCode.SelectedItemErrorStatus;
import lk.ijse.backendforpossystemusingspring.dto.ItemStatus;
import lk.ijse.backendforpossystemusingspring.dto.impl.ItemDTO;
import lk.ijse.backendforpossystemusingspring.exception.CustomerNotFoundException;
import lk.ijse.backendforpossystemusingspring.exception.DataPersistException;
import lk.ijse.backendforpossystemusingspring.exception.ItemNotFoundException;
import lk.ijse.backendforpossystemusingspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO) {

        try {
            itemService.saveItem(itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{itemId}")
    public ResponseEntity<Void> updateItem(@PathVariable("itemId")String itemId,@RequestBody ItemDTO updateItemDto){
        String regexForItemID = "^C\\d{3}$\n";
        Pattern regexPattern = Pattern.compile(regexForItemID);
        var regexMatcher = regexPattern.matcher(itemId);
        try {
            if(!regexMatcher.matches() || updateItemDto == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemId,updateItemDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getSelectedItem(@PathVariable("itemId") String itemId){
        String regexForCustomerId = "^I\\d{3}$";
        Pattern regexPattern = Pattern.compile(regexForCustomerId);
        var regexMatcher = regexPattern.matcher(itemId);
        if (!regexMatcher.matches()) {
            return  new SelectedItemErrorStatus(1," Item ID is not valid");
        }
        return itemService.getSelectedItem(itemId);

    }

    @DeleteMapping(value = "/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemId") String itemId){
        String regexForItemID = "^I\\d{3}$\n";
        Pattern regexPattern = Pattern.compile(regexForItemID);
        var regexMatcher = regexPattern.matcher(itemId);
        itemService.deleteItem(itemId);
        try {
            if (!regexMatcher.matches()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
