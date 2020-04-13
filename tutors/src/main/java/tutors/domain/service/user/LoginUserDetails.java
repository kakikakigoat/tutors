package tutors.domain.service.user;


import tutors.domain.model.User;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;


public class LoginUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private final User user;
	private Collection<GrantedAuthority> authorities;
	
	
	public LoginUserDetails(User user) {
		this.user = user;
	}
	
	
	public User getUser() {
		return user;
	}
	
	
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    @Override
    public String getUsername() {
        return user.getMailAddress();
    }
    @Override
    public String getPassword() {
    	return user.getPassword();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}
