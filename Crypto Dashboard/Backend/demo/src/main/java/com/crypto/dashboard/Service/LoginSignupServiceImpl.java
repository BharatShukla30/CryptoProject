package com.crypto.dashboard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crypto.dashboard.Entity.UserDetails;
import com.crypto.dashboard.Entity.UserLogin;
import com.crypto.dashboard.Repository.UserDetailsRepository;
import com.crypto.dashboard.Repository.UserLoginRepository;

@Component
@Service
public class LoginSignupServiceImpl implements LoginSignupService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepo;
	
	@Autowired
	private UserLoginRepository userLoginRepo;

	@Override
	public String saveUserDetails(UserDetails ud, UserLogin ul) {
		try{
			userDetailsRepo.save(ud);
			userLoginRepo.save(ul);
			return "User details saved successfully!";
		}
		catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@Override
	public UserDetails getUserDetails(String userName) {
		return userDetailsRepo.findByUsername(userName);
	}
	
	
}
