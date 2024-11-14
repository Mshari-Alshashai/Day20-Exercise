package com.example.bankmanagement.Controller;

import com.example.bankmanagement.ApiResponse.ApiResponse;
import com.example.bankmanagement.Module.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    ArrayList<Customers> customers=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customers customer){
        customers.add(customer);
        return new ApiResponse("Customer Added Successfully");
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateCustomer(@PathVariable int id,@RequestBody Customers customer){
        customers.set(id,customer);
        return new ApiResponse("Customer Updated Successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteCustomer(@PathVariable int id){
        customers.remove(id);
        return new ApiResponse("Customer Deleted Successfully");
    }

    @PutMapping("/deposit/{id}")
    public ApiResponse deposit(@PathVariable int id, @RequestParam double amount){
        customers.get(id).setBalance(customers.get(id).getBalance()+amount);
        return new ApiResponse("Customer Deposited Successfully");
    }

    @PutMapping("/withdrawal/{id}")
    public ApiResponse withdrawal(@PathVariable int id, @RequestParam double amount){
        customers.get(id).setBalance(customers.get(id).getBalance()-amount);
        return new ApiResponse("Customer Withdrawal Successfully");
    }
}
