package sp.spring.io.shop.security.service;

import java.security.NoSuchAlgorithmException;

import sp.spring.io.shop.security.entity.UserInfo;

public interface AuthDataService {

	UserInfo findByUsername(String username);

	UserInfo findByEmail(String email);

	void deleteByUsernamePassword(String username, String password) throws NoSuchAlgorithmException;

	void createUserProfile(UserInfo userInfo) throws NoSuchAlgorithmException;
}
