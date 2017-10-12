package org.seleniumng.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ManagementServer extends HttpServlet {

	public ManagementServer() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processPost(req, resp);
	}

	private String getParameter(HttpServletRequest httpReq, String parameter) {
		String value = "Expected parameter:" + parameter
				+ " was not found, please check the url for correct parameters";
		try {
			value = httpReq.getParameter(parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processBoth(req, resp);
	}

	protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameterMap();
		getParameter(req, "Question");
		processBoth(req, resp);
	}

	protected void processBoth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sPath = req.getPathInfo().toLowerCase();
		String responseStr = "";
		switch (sPath) {
		case "/test":
			responseStr = req.getParameterMap().toString();
			break;
		case "":
		case "/":
		default:
			responseStr = LibHtml.getTableEntryForm("PAGES");

		}
		writeResponse(resp, responseStr, null);

	}

	protected void writeResponse(HttpServletResponse response, String respStr, Exception e) throws IOException {
		if (e != null) {
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			e.printStackTrace(printWriter);
			printWriter.flush();
			respStr = writer.toString();

		}
		// TODO: write jsoup document
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(respStr);
		response.getWriter().close();
	}

}