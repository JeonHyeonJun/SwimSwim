package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Customer;
import service.CustomerServiceImpl;
import service.CustormerService;

@WebServlet("*.do")
public class DoServlet extends HttpServlet{
	private CustormerService service = new CustomerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String contextPath = req.getContextPath()+"/";
		if(req.getRequestURI().equals(contextPath + "insert.do")){
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			String tel = req.getParameter("tel");
			String addr = req.getParameter("addr");
			
			Customer customer = new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setAge(age);
			customer.setTel(tel);
			customer.setAddr(addr);
			
			boolean isSucc = service.join(customer);
			String result = "{ \"result\" : "+isSucc+ "}";
			PrintWriter pw = resp.getWriter();
			pw.println(result);
			return;
			
//			CustomerDao cd = CustomerDao.getInstance();
//			if(cd.selectOne(id) == null){
//				cd.insertCustomer(customer);
//				resp.sendRedirect("list.do");				
//			}
//			else{
//				resp.sendRedirect("list.do");
//			}
		}
		
		else if(req.getRequestURI().equals(contextPath + "check.do")){
			String id = req.getParameter("id");
			boolean isDuplicated = service.idCheck(id);
			String result = "{ \"result\" : "+isDuplicated+ "}";
			PrintWriter pw = resp.getWriter();
			pw.println(result);
			return;
			
//			CustomerDao cd = CustomerDao.getInstance();
//			if(cd.selectOne(id) == null){
//				String msg = "사용가능";
//				pw.println("[\""+msg+"\"]");
//			}
//			else{
//				String msg = "중복";
//				pw.println("[\""+msg+"\"]");
//			}
		}
		
		else if(req.getRequestURI().equals(contextPath + "list.do")){
			List<Customer> list = service.getAllCustomer();
			String result = new Gson().toJson(list);
			PrintWriter pw = resp.getWriter();
			pw.println(result);
			return;
			
//			CustomerDao cd = CustomerDao.getInstance();
//			List<Customer> list = cd.selectAll();
//			
//			PrintWriter pw = resp.getWriter();
//				pw.println("{");
////				pw.println("	\"list\" : {");
//				pw.println("		\"list1\" : \""+list.get(0).getNo()+"\"");
//				pw.println(",		\"list2\" : \""+list.get(0).getId()+"\"");
////				pw.println("		\"list2\" : \""+list.get(1)+"\"");
////				pw.println("	}");
//				pw.println("}");
		}
		
		else if(req.getRequestURI().equals(contextPath + "delete.do")){
			String id = req.getParameter("id");
			boolean isSucc = service.delete(id);
			String result = "{ \"result\" : "+isSucc+ "}";
			PrintWriter pw = resp.getWriter();
			pw.println(result);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		doGet(req, resp);
	}
	
}
