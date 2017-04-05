package by.pvt.heldyieu.servlet;

import by.pvt.heldyieu.command.CommandManager;
import by.pvt.heldyieu.command.ServletCommand;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(urlPatterns ={"/Index", 
		"/act", 
		"/showMagazines", 
		"/editMagazine", 
		"/usersList",
		"/editSubscriptionType",
		"/subscription_types"})
public class IndexServ extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(IndexServ.class);
	private static final long serialVersionUID = 1L;
	private CommandManager manager = CommandManager.getInstance();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServ() {
		super();
	}
	@Override
	public void init() throws ServletException {
		super.init();
		LOGGER.info("Initializing Servlet");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		LOGGER.info("Processing " + request.getMethod() + " request");
		// определение команды, пришедшей из JSP
		ServletCommand command = manager.getCommand(request);
		/*
		 * вызов реализованного метода execute() и передача параметров
		 * классу-обработчику конкретной команды
		 */
		page = command.execute(request, response);
		if(page == null) {
            page = "/index";
        }
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
	}
}
