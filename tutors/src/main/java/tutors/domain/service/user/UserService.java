package tutors.domain.service.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tutors.domain.model.*;
import tutors.domain.repository.*;


@Service
@Transactional
public class UserService {
		
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User searchSameEmail(String mailAddress) {
		return userRepository.findByMailAddress(mailAddress);
	}
	
	public User create(User user, String rawPassword) {
		String encodedPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}

}
