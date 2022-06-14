package guru.springframework.services;

import guru.springframework.commands.UserForm;
import guru.springframework.domain.Product;
import guru.springframework.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getById(Long id);
    User saveNewUser( UserForm userForm);
    User updateUser(Long id,UserForm userForm);
    void delete(Long id);
    User findByEmail(String email);

    List<User> listAll();


}
