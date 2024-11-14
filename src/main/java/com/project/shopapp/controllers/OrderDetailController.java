package com.project.shopapp.controllers;

import com.project.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/order-details")
public class OrderDetailController {
    @PostMapping("")
    public ResponseEntity<String> createOrderDetail(@RequestBody @Valid OrderDetailDTO orderDetailDTO,
                                                    BindingResult result) {
        try {
            if(result.hasErrors()){
                List<String> errorMessages = result.getFieldErrors().stream()
                        .map(error -> error.getField() + " " + error.getDefaultMessage())
                        .toList();

                return ResponseEntity.badRequest().body(errorMessages.toString());
            }

            return ResponseEntity.ok("Order detail created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getOrderDetail(@PathVariable("id") Long orderDetailId) {
        try {
            return ResponseEntity.ok("Order detail with id: " + orderDetailId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<String> getOrderDetailsByOrderId(@PathVariable("orderId") Long orderId) {
        try {
            return ResponseEntity.ok("Order details of order with id: " + orderId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateOrderDetail(@PathVariable("id") Long orderDetailId,
                                                    @RequestBody @Valid OrderDetailDTO orderDetailDTO,
                                                    BindingResult result) {
        try {
            if(result.hasErrors()){
                List<String> errorMessages = result.getFieldErrors().stream()
                        .map(error -> error.getField() + " " + error.getDefaultMessage())
                        .toList();

                return ResponseEntity.badRequest().body(errorMessages.toString());
            }

            return ResponseEntity.ok("Order detail with id: " + orderDetailId + " updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderDetail(@PathVariable("id") Long orderDetailId) {
        try {
            return ResponseEntity.ok("Order detail with id: " + orderDetailId + " deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
