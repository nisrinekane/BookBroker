package com.nisrinekane.bookbroker.services;


import com.nisrinekane.bookbroker.models.LoginUser;
import com.nisrinekane.bookbroker.models.User;
import com.nisrinekane.bookbroker.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        //find if email exists
        Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());

        //reject values or register if no errors:
        if (potentialUser.isPresent()) {
            result.rejectValue("email", "Matches", "Email is taken");
        }
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        // return null if result has errors
        if(result.hasErrors()) {
            return null;
        }
        // hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        userRepository.save(newUser);
        return newUser;
    }

    //USER LOGIN SERVICE SIDE
    public User login(LoginUser newLogin, BindingResult result) {

        Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());

        // Find user in the DB by email
        // Reject if NOT present
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Matches", "User not found!");
            return null;
        }

        // User exists, retrieve user from DB
        User user = potentialUser.get();

        // Reject if BCrypt password match fails
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }

        // Return null if result has errors
        if(result.hasErrors()) {
            return null;
        }

        // Otherwise, return the user object
        return user;
    }

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create a user
    public User createUser(User d) {
        return userRepository.save(d);
    }

    //retrieve a user
    public User findUser(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    //return all users
    public List<User> allUsers() {
        return (List<User>) userRepository.findAll();
    }

    //update a user
    public void updateUser(User user) {
        userRepository.save(user);
    }

    // delete all users
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
