	import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;



	public class MainForm extends HttpServlet { 
		
	  public void doGet(HttpServletRequest request, 
	      HttpServletResponse response) throws ServletException, IOException 
	  {
	    // reading the user input
		  HttpSession session = request.getSession(true);
	    String from= (String) session.getAttribute("from"); 
	    String to=(String)session.getAttribute("to");
	    System.out.println(to);
	  YelpAPI yelpApi =new YelpAPI("pLuu3p_SZe7lzdKZVcUpzA","kWpC58_c7qbPje6seSBsXQxvroI","Z-waXeUkJrKgNgBugALL5ZlZfHTY8XZe","zlEZ795sVm2-iTMnm9Il1HBIQcI");
	//	System.out.println("created object");
	  JSONArray businesses= yelpApi.searchForBusinessesByLocationNew("hotel",to);
	//System.out.println(output);
	 // Demo demo= new Demo();
	 // demo.getHotels(to);
	  request.setAttribute("jsonArray", businesses);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("criuses.jsp");
	    dispatcher.forward(request, response);
	  
	  }  
	}

