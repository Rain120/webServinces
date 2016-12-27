/**
     注意：这个文件是建立的Servlet
     Eclipse新建方法
     在control层上右击选择new->Servlet->class name(命名规则：类名首字母大写)->next
     ->URL mappings中的第一项，再在右边点击Edit，将首字母变成小写(编码规范，便于比较)->finish
*/

package com.servince.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servince.model.*;
import com.servince.service.UserService;
import com.servince.utils.TextUtils;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取报头名
		String useragent = request.getHeader("user-agent");
		System.out.println(useragent); 
		
		//一次性获得所有报头名的集合
		Enumeration<String> names = request.getHeaderNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = request.getHeader(name);
			System.out.println("name =  " + name + "\n" + "value = " + value);
		}
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取表单参数
		User user = new User();
		getParam(request, user);
		
		//进行服务器端校验
		String result = "";
		String errorMsg = validate(user);
		
		if (!"".equals(errorMsg)){
			result = errorMsg;
		}else{
			//判断用户名是否重复:根据当前用户名查询
			User tempUser = new User();
			tempUser.setUsername(user.getUsername());
			List<User> resultList = UserService.getInstance().selectUser(tempUser);
			if (resultList.size() > 0){
				result = "Username is repeat!\n";
			}else{
				UserService.getInstance().saveUser(tempUser);
				result = "Signup Successful!\n";
			}
			
		}
		
		//页面跳转
		//设置响应类型 text/plain 纯文本 text/html  html文档
		response.setContentType("text/html");
		//获取输出流对象respond.getWrite()方法
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println(result);
		writer.println("</body>");
		writer.println("</html>");
		//关闭流对象
		writer.close();
	}
	
	private void getParam(HttpServletRequest request,User user){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String comPassword = request.getParameter("comfirmPasswd");
		String realname = request.getParameter("realName");
		String sex = request.getParameter("sex");	
		String citys = request.getParameter("citys");
		String province = request.getParameter("province");
		String certtype = request.getParameter("certtype");
		String cert = request.getParameter("cert");
		String birthday = request.getParameter("birthday");
		String usertype = request.getParameter("usertype");
		String content = request.getParameter("remark");
		
		//数据封装
		user.setUsername(username);
		user.setPassword(password);
		user.setComPassword(comPassword);
		user.setRealname(realname);
		user.setSex(sex);
		
		City city = new City();
		Province pro = new Province();
		pro.setProvinceID(province + 1);
		city.setPro(pro);
		city.setCity(citys);
		city.setCityID(citys + 1);
		user.setCity(city);
		
		CertType ct = new CertType();
		ct.setId( Integer.parseInt(certtype) );//纯数字
		user.setCert_type(ct);
		
		user.setCert(cert);
		
		if ( "".equals(birthday)){
			user.setBirthday(null);
		}else{
			user.setBirthday(Date.valueOf(birthday));
		}
		
		UserType ut = new UserType();
		ut.setId( Integer.parseInt(usertype) );
		ut.setContent(usertype);
		user.setUser_type(ut);

		user.setRule("1");
		user.setContent(content);
		user.setStatus("1");
		user.setLogin_ip(request.getRemoteAddr());
		user.setImage_path("");
	}
	
	private String validate(User user){
		StringBuffer errorMsg = new StringBuffer();
		
		//Username
		if ( !TextUtils.isEmpty( user.getUsername() ) ) {
			errorMsg.append("Username can't be null!");
			errorMsg.append("<br />");
		}else {
			if(user.getUsername().length() < 6){
				errorMsg.append("Password can't more than 6.");
				errorMsg.append("<br />");
			}else if(user.getUsername().length() > 30){
				errorMsg.append("Password can't more than 30.");
				errorMsg.append("<br />");
			}else if(!user.getUsername().matches("/^[a-zA-Z]{1}\\w{2,29}$/") ){
				errorMsg.append("Username be illegal!");
				errorMsg.append("<br />");
			}
		}
		
		//Password
		if ( !TextUtils.isEmpty( user.getPassword() ) ){
			errorMsg.append("Password can't be null!");
			errorMsg.append("<br />");
		}else{
			if(user.getPassword().length() < 6){
				errorMsg.append("Password can't more than 6.");
				errorMsg.append("<br />");
			}else if(user.getPassword().length() > 30){
				errorMsg.append("Password can't more than 30.");
				errorMsg.append("<br />");
			}else if(!user.getPassword().equals(user.getComPassword()) ){
				errorMsg.append("Password not matches ComPassword!");
				errorMsg.append("<br />");
			}
		}
		
		//Realname
		if ( !TextUtils.isEmpty( user.getRealname() ) ){
			errorMsg.append("Realname can't be null!");
			errorMsg.append("<br />");
		}else{
			if(!user.getRealname().matches("/^[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*||[a-zA-Z]$/") ){
				errorMsg.append("Realname be illegal!");
				errorMsg.append("<br />");
			}
		}
		
		//City/Province
		if ( "1".equals( user.getCity().getPro().getProvinceID() ) ){
			errorMsg.append("Pronvince can't be null!");
			errorMsg.append("<br />");
		}
		//Cert
		String IDNumberReg = "/^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$/";
		String passportReg = "/^1[45][0-9]{7}|([P|p|S|s]\\d{7})|([S|s|G|g]\\d{8})|([Gg|Tt|Ss|Ll|Qq|Dd|Aa|Ff]\\d{8})|([H|h|M|m]\\d{8,10})$/";
		String HongKongMacauLaissezPasserReg = "/^[HMhm]{1}([0-9]{10}|[0-9]{8})$/";
		String TaiwanPassProcessReg = "/^T{1}([0-9]{10}|[0-9]{8})$/";
		if( !TextUtils.isEmpty(user.getCert()) ){
			errorMsg.append("Cert can't be null!");
			errorMsg.append("<br />");
		}else if(1 == user.getCert_type().getId()){
			if (!user.getCert().matches(IDNumberReg)){
				errorMsg.append("IDNumberReg be illegal!");
				errorMsg.append("<br />");
			}
		}else if(2 == user.getCert_type().getId()){
			if (!user.getCert().matches(passportReg)){
				errorMsg.append("PassportReg be illegal!");
				errorMsg.append("<br />");
			}
		}else if(3 == user.getCert_type().getId()){
			if (!user.getCert().matches(HongKongMacauLaissezPasserReg)){
				errorMsg.append("HongKongMacauLaissezPasserReg be illegal!");
				errorMsg.append("<br />");
			}
		}else if(4 == user.getCert_type().getId()){
			if (!user.getCert().matches(TaiwanPassProcessReg)){
				errorMsg.append("TaiwanPassProcessReg be illegal!");
				errorMsg.append("<br />");
			}
		}
		
		//Birthday
		if (user.getBirthday() == null){
			errorMsg.append("Birthday can't be null!");
			errorMsg.append("<br />");
		}
		return errorMsg.toString();
		
	}
}


