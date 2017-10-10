package org.seleniumng.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ManagementServer  extends HttpServlet{

	
	public ManagementServer(){
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processGet (req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processPost(req, resp);
	}

	private String getParameter (HttpServletRequest httpReq, String parameter){
		String value = "Expected parameter:" + parameter +   " was not found, please check the url for correct parameters";
		try {
			value = httpReq.getParameter(parameter);
		} catch (Exception e){
			e.printStackTrace();
		}
		return value ;
	}
	
	protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		String sPath = req.getPathInfo();
		processBoth (req, resp);
	}
	protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		String sPath = req.getPathInfo();	
		req.getParameterMap();
		getParameter (req, "Question");
		}
	protected void processBoth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		String sPath = req.getPathInfo().toLowerCase();
		
		switch (sPath){
		case "":
		case "/":
			
		default:
			writeResponse (resp,LibHtml.getDocumentStr(),null);
			
		}
	}
	
	protected void writeResponse (HttpServletResponse response, String respStr, Exception e) throws  IOException {
		if (e != null){
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			respStr = writer.toString();
			
			}

		response.setContentType("text/html;charset=UTF-8");	
		response.getWriter().println(respStr);
		response.getWriter().close();
	}
	
}