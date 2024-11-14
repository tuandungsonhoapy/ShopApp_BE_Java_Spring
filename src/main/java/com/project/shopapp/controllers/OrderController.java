package com.project.shopapp.controllers;

import com.project.shopapp.dtos.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    @PostMapping("")
    public ResponseEntity<String> createOrder(@RequestBody @Valid OrderDTO orderDTO,
                                              BindingResult result) {
        try {
            if(result.hasErrors()){
                List<String> errorMessages = result.getFieldErrors().stream()
                        .map(error -> error.getField() + " " + error.getDefaultMessage())
                        .toList();

                return ResponseEntity.badRequest().body(errorMessages.toString());
            }

            return ResponseEntity.ok("Order of " + orderDTO.getUserId() + " created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{userId}")
    public ResponseEntity<String> getOrdersByUserId(@PathVariable("userId") Long userId) {
        try {
            return ResponseEntity.ok("Orders of user with id: " + userId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("id") Long orderId,
                                              @RequestBody @Valid OrderDTO orderDTO,
                                              BindingResult result) {
        try {
            if(result.hasErrors()){
                List<String> errorMessages = result.getFieldErrors().stream()
                        .map(error -> error.getField() + " " + error.getDefaultMessage())
                        .toList();

                return ResponseEntity.badRequest().body(errorMessages.toString());
            }

            return ResponseEntity.ok("Order with id: " + orderId + " updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId) {
        try {
            return ResponseEntity.ok("Order with id: " + orderId + " deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
