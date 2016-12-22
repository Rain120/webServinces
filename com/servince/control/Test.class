package com.servince.control;

import java.util.List;

import com.servince.model.CertType;
import com.servince.model.City;
import com.servince.model.User;
import com.servince.model.UserType;
import com.servince.service.UserService;

public class Test {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("Tom");
		user.setPassword("123456");
		user.setRule("2");
		user.setRealname("小明");
		user.setSex("男");

		City city = new City();
		city.setCityID("3");
		city.setCity("吉安");
		user.setCity(city);

		CertType certType = new CertType();
		certType.setId(1);
		certType.setContent("护照");
		user.setCert_type(certType);

		user.setCert("36242619860101020x");

		java.util.Date curDate = new java.util.Date();
		java.sql.Date birthDate = new java.sql.Date(curDate.getTime());
		user.setBirthday(birthDate);

		UserType userType = new UserType();
		userType.setId(1);
		userType.setContent("学生");
		user.setUser_type(userType);

		user.setContent(null);
		user.setStatus("1");
		user.setLogin_ip(null);
		user.setImage_path(null);

		UserService.getInstance().saveUser(user);
/*Login*/		
		User loginUser = UserService.getInstance().Login("Grande", "123456");
		if (loginUser == null){
			System.out.println("Login failure!");
		}
		else{
			System.out.println("Login Successful!\n"
					+ "" + "Username:" + loginUser.getUsername() 
					+ "\nPassword:" + loginUser.getPassword()
					+ "\nRule:" + loginUser.getRule()
					+ "\nRealname:" + loginUser.getRealname()
					+ "\nSex:" + loginUser.getSex()
					+ "\nCity:" + loginUser.getCity().getCity()
					+ "\nCert_Type:" + loginUser.getCert_type().getContent()
					+ "\nCert:" + loginUser.getCert()
					+ "\nBirthday:" + loginUser.getBirthday()
					+ "\nUser_Type:" + loginUser.getUser_type().getContent()
					+ "\nContent:" + loginUser.getContent()
					+ "\nStatus:" + loginUser.getStatus()
					+ "\nlogin_ip:" + loginUser.getLogin_ip()
					+ "\nimage_path:" + loginUser.getImage_path());
		}
		 UserService.getInstance().deleteUserDate("Grade");
		
		User seleteUser = new User();
		seleteUser.setRealname("护照");
		List<User> userDate = UserService.getInstance().selectUser(seleteUser);
		for (User userdate : userDate){
			System.out.println("username:" + userdate.getUsername()
											+ "\nRealname:" + userdate.getRealname()
											+ "\nSex:" + userdate.getSex()
											+ "\nCert_type:" + userdate.getCert_type().getContent()
											+ "\nCert:" + userdate.getCert()
											+ "\nUser_type:" + userdate.getUser_type().getContent()
											);
		}
	}

}
