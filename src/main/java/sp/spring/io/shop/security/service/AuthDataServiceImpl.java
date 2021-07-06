package sp.spring.io.shop.security.service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sp.spring.io.shop.security.entity.UserInfo;
import sp.spring.io.shop.security.repository.UserInfoRepository;
import sp.spring.io.shop.security.util.Md5Util;

@Service
public class AuthDataServiceImpl implements AuthDataService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserInfo findByUsername(String username) {
		Optional<UserInfo> result = userInfoRepository.findByUserName(username);
		UserInfo userInfo = null;
		if (result.isPresent()) {
			userInfo = result.get();
		}
		return userInfo;

	}

	@Override
	public UserInfo findByEmail(String email) {
		Optional<UserInfo> result = userInfoRepository.findByEmail(email);
		UserInfo userInfo = null;
		if (result.isPresent()) {
			userInfo = result.get();
		}
		return userInfo;
	}

	@Override
	public void deleteByUsernamePassword(String username, String password) throws NoSuchAlgorithmException {
		userInfoRepository.deleteByUsernamePassword(username, Md5Util.getInstance().getMd5Hash(password));
	}

	@Override
	public void createUserProfile(UserInfo userInfo) throws NoSuchAlgorithmException {

		userInfoRepository.createUserProfile(userInfo.getUsername(), userInfo.getFirstName(), userInfo.getLastName(),
				userInfo.getEmail(), Md5Util.getInstance().getMd5Hash(userInfo.getPassword()));
	}

}
