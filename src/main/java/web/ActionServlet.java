package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("action: "+action);
		if("/check".equals(action)) {
			String username=request.getParameter("username");
			System.out.println("username: "+username);
			if("DMETAL".equals(username)) {
				out.println("用户名已存在");
			}else {
				out.print("√");
			}
		}else if("/getNumber".equals(action)) {
			Random r=new Random();
			int number=r.nextInt(9999);
			System.out.println("number: "+number);
			out.print(number);
		}else if("/getUn".equals(action)) {
			String province=request.getParameter("province");
			System.out.println("province: "+province);
			if("bj".equals(province)) {
				out.println("bd:北大;qh:清华");
			}else if("sh".equals(province)) {
				out.println("fd:复旦;tj:同济;jt:交通");
			}else {
				out.println("sd:深大;xd:厦大");
			}
		}
		
		
	}

}
