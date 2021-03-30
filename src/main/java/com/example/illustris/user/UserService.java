package com.example.illustris.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(IllustrisUserDetails::new).get();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.
        findUserByEmail(user.getEmail());
		if (userOptional.isPresent()) {
			throw new IllegalStateException("email taken");//TODO: use an error message
		}
		userRepository.save(user);
    }

    public void deleteUser(int userId) {
        boolean exists=userRepository.existsById(userId);
		if (!exists) {
			throw new IllegalStateException("user with id "+ userId + " does not exist");//TODO: use an error message
		}
		userRepository.deleteById(userId);
    }

    public void uadateUser(int userId, String lastName, String email) {
        User user = userRepository.findById(userId)
		.orElseThrow(() ->new IllegalStateException(
			"user with id "+ userId + " does not exist"));//TODO: use an error message

		if (lastName != null && lastName.length() >0 && 
		!Objects.equals(user.getLastName(), lastName)) {
			user.setLastName(lastName);
		}
		if (email != null && email.length() >0 && 
		!Objects.equals(user.getEmail(), email)) {
			Optional<User> studentOptional = userRepository
			.findUserByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");//TODO: use an error message
			}
			user.setEmail(email);
		}
    }

    
    
}
