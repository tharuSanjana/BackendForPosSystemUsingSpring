package lk.ijse.backendforpossystemusingspring.controller;

import lk.ijse.backendforpossystemusingspring.dto.impl.OrdersDTO;
import lk.ijse.backendforpossystemusingspring.exception.DataPersistException;
import lk.ijse.backendforpossystemusingspring.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {
    @Autowired
    private OrdersService orderService;
    static Logger logger= LoggerFactory.getLogger(OrdersController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrdersDTO orderDTO){
        orderDTO.setO_id(orderDTO.getO_id());
        try {
            orderService.saveOrder(orderDTO);
            logger.error("Saved Order !!");
            return new  ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.error("Bad Request !!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Internal Server Erro");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
