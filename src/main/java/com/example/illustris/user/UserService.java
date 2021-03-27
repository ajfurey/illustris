//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: UserService

package com.example.illustris.user;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.illustris.registration.token.ConfirmationToken;
import com.example.illustris.registration.token.ConfirmationTokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    
	private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
	

    
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			ConfirmationTokenService confirmationTokenService) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.confirmationTokenService = confirmationTokenService;
	}

	/*@Autowired
		public UserService(UserRepository userRepository) {
			this.userRepository = userRepository;
		}*/
		
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		

		return userRepository.findByEmail(email).
		orElseThrow(()-> new UsernameNotFoundException(
			String.format("User with email %s not found",email)));
	}

	public String signUpUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

		user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
				token,LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

		//TODO: SEND EMAIL
        return token;
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }


    
}
