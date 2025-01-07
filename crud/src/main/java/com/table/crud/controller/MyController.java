package com.table.crud.controller;

import com.table.crud.model.MyModel;
import com.table.crud.repository.MyRepository;
import com.table.crud.service.MyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class MyController {

    private final MyService myService;

    public MyController(MyService myService, MyRepository myRepository) {
        this.myService = myService;
        this.myRepository = myRepository;
    }

    private final MyRepository myRepository;


    @GetMapping
    public List<MyModel> getting(){
        return myService.getAllUsers();
    }

    @GetMapping("/{id}")
    public MyModel gettingById(@PathVariable String id){
        return myService.getUserById(id);
    }

    @PostMapping
    public MyModel creating(@RequestBody MyModel myModel){
        return myService.createUser(myModel);
    }

    @PutMapping("/{id}")
        public MyModel updating(@PathVariable String id, @RequestBody MyModel updatedUser) {
        return myService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleting(@PathVariable String id){
        myRepository.deleteById(id);
    }
}