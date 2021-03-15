//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: UserService

package com.example.illustris.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    public void deleteUser(Long userId) {
        boolean exists=userRepository.existsById(userId);
		if (!exists) {
			throw new IllegalStateException("user with id "+ userId + " does not exist");//TODO: use an error message
		}
		userRepository.deleteById(userId);
    }

    @Transactional
    public void uadateUser(Long userId, String lastName, String email) {
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
