package com.table.crud.service;

import com.table.crud.model.MyModel;
import com.table.crud.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    private final MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<MyModel> getAllUsers(){
        return myRepository.findAll();
    }

    public MyModel getUserById(String id){
        return myRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public MyModel createUser(MyModel myModel){
        return myRepository.save(myModel);
    }

    public MyModel updateUser(String id, MyModel updatedUser){
        MyModel existUser = myRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        // Updating the user detail
        existUser.setName(updatedUser.getName());
        existUser.setEmail(updatedUser.getEmail());
        existUser.setPassword(updatedUser.getPassword());
        return myRepository.save(existUser);
    }

//    public void deleteUser(String id){
//        MyModel existUser = myRepository.findById(Long.valueOf(id))
//        myRepository.delete(existUser);
//    }

}
