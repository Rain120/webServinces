/**
     注意：这个文件是建立的Servlet
     Eclipse新建方法
     在control层上右击选择new->Servlet->class name(命名规则：类名首字母大写)->next
     ->URL mappings中的第一项，再在右边点击Edit，将首字母变成小写(编码规范，便于比较)->finish
*/

package com.servince.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String username = request.getParameter("username");
		System.out.println("username:" + username);
		
		String password = request.getParameter("password");
		System.out.println("password:" + password);
	}

}
