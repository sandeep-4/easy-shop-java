package sp.spring.io.shop.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sp.spring.io.shop.security.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	@Query(value = "SELECT user_id,username,first_name,last_name,email,password FROM user_info WHERE username=:USERNAME", nativeQuery = true)
	Optional<UserInfo> findByUserName(@Param("USERNAME") String USERNAME);

	@Query(value = "SELECT user_id,username,first_name,last_name,email,password FROM user_info WHERE email=:EMAIL", nativeQuery = true)
	Optional<UserInfo> findByEmail(@Param("EMAIL") String email);

	@Query(value = "DELETE FROM user_info WHERE username=:USERNAME AND password=:PASSWORD",nativeQuery=true)
	void deleteByUsernamePassword(@Param("USERNAME") String USERNAME, @Param("PASSWORD") String PASSWORD);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user_info (username, first_name, last_name, email, password) "
			+ " VALUES (:USERNAME, :FIRSTNAME, :LASTNAME, :EMAIL, :PASSWORD)", nativeQuery = true)
	void createUserProfile(@Param("USERNAME") String USERNAME, @Param("FIRSTNAME") String FIRSTNAME,
			@Param("LASTNAME") String LASTNAME, @Param("EMAIL") String EMAIL, @Param("PASSWORD") String PASSWORD);

}
