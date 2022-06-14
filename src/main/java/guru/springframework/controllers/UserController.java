package guru.springframework.controllers;

import guru.springframework.commands.ProductForm;
import guru.springframework.commands.UserForm;
import guru.springframework.domain.Product;
import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/user/list", "/user"})
    public ResponseEntity<List<User>> listUser(){
        List<User> userList =userService.listAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/show/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseEntity<User> createNewUser (@RequestBody UserForm userForm)
    {
        System.out.println(userForm.toString());
        User user = userService.saveNewUser(userForm);
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("user/update/{id}")
    public ResponseEntity<User> updateEmployee( @PathVariable Long id, @RequestBody UserForm userForm) {
        User updateUser = userService.updateUser(id, userForm);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }


}
