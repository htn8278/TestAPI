package guru.springframework.services;

import guru.springframework.commands.UserForm;
import guru.springframework.domain.Product;
import guru.springframework.domain.User;
import guru.springframework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();


    @Autowired
    public UserServiceImpl (UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveNewUser(UserForm userForm) {
        User user = new User();
        Calendar cal = Calendar.getInstance();
        user.setUpdatedAt(cal.getTime());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setEmail(userForm.getEmail());
        user.setCreatedAt(cal.getTime());
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id, UserForm userForm) {
        User user = userRepository.findById(id).orElse(null);
        if (user==null)
        {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        user.setUpdatedAt(cal.getTime());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userRepository.save(user);
        return user;
    }
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
