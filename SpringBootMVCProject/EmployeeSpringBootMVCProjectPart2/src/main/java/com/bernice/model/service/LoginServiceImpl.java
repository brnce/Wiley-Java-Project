package com.bernice.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernice.entity.User;
import com.bernice.model.persistence.UserDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean loginCheck(User user) {
		try {
			User usr=userDao.findByUserNameAndPassword(user.getUserName(), user.getPassword());
			if(usr!=null)
				return true;
			return false;
		}
		catch(Exception ex) {
			return false;
		}
	
	}

}