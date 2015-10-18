


import java.io.BufferedReader;

import org.json.simple.JSONObject;
import org.json.JSONException;
import org.json.*;
import org.w3c.dom.CharacterData;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Servlet implementation class Relocation
 */

public class Relocation extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
	    String to=(String)session.getAttribute("to");
	    String[] to_split=to.split(",");
	    String city=to_split[0];
	    String state=to_split[1];
		
			String url = "http://www.zillow.com/webservice/GetRegionChildren.htm?zws-id=X1-ZWz1ez3ugfroqz_aovt1&childtype=neighborhood&state="+state+"&city="+city;
		  	System.out.println(url);
		  	URL obj = new URL(url);
		  	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		  	con.setRequestMethod("GET");
		  	int responseCode = con.getResponseCode();
		  	BufferedReader in = new BufferedReader(
		  	new InputStreamReader(con.getInputStream()));
		  	String inputLine;
		  	StringBuffer outline = new StringBuffer();

		  	while ((inputLine = in.readLine()) != null) {
		  		outline.append(inputLine);
		  	}
		  	in.close();
		  	try {
				org.json.JSONObject outjson=XML.toJSONObject(outline.toString());
				org.json.JSONObject outjsonFinal=(org.json.JSONObject)outjson.get("RegionChildren:regionchildren");
				request.setAttribute("jsonObj", outjsonFinal);
				//System.out.println(outjsonFinal);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("realEstate.jsp");
			    dispatcher.forward(request, response);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	

