package com.crypto.dashboard.Service;

import com.crypto.dashboard.Entity.UserDetails;
import com.crypto.dashboard.Entity.UserLogin;
import com.crypto.dashboard.dto.LoginInfo;


public interface LoginSignupService {
	public String saveUserDetails(UserDetails ud, UserLogin ul);
	public UserDetails getUserDetails(String uname);
	public UserLogin CheckEmail(String username);
}
