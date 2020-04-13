package tutors.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import tutors.domain.model.User;
import tutors.domain.repository.UserRepository;


@Component
public class LoginUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
        User user = userRepository.findByMailAddress(username);
        if(user == null) {
        	throw new UsernameNotFoundException("ログインエラーです");
        }
        return new LoginUserDetails(user);
    }
}
