package com.gc.clients.controller;

import com.gc.clients.daoImpl.ClientDaoImpl;
import com.gc.clients.dto.Client;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author george
 */
@WebServlet("/cliente")
public class ClientController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    ClientDaoImpl clientDaoImpl;
    
    @Override
    public void init() {
        try {
            String jdbcURL = getServletContext().getInitParameter("jdbcURL");
            String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
            String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
            
            clientDaoImpl = new ClientDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ClientController() {
        super();
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "createForm":
                    createForm(request, response);
                    break;
                case "updateForm":
                    udpateForm(request, response);
                    break;
                case "create":
                    create(request, response);
                    break;
                case "show":
                    show(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                default:
                    break;
                }			
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        doGet(request, response);
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException 
     */
    private void index(HttpServletRequest request, HttpServletResponse response)
             throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException 
     */
    private void createForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher= request.getRequestDispatcher("/views/create.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException 
     */
    private void udpateForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Client client = clientDaoImpl.find(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("client", client);
        
        RequestDispatcher dispatcher= request.getRequestDispatcher("/views/update.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException 
     */
    private void create(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ServletException, IOException {
        Client client = new Client(
            0,
            request.getParameter("cedula"),
            request.getParameter("nombres"),
            request.getParameter("apellidos")
        );
        clientDaoImpl.create(client);
        this.index(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException 
     */
    private void show(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/show.jsp");
        List<Client> clientList = clientDaoImpl.list();
        request.setAttribute("lista", clientList);
        dispatcher.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException 
     */
    private void update(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ServletException, IOException {
        System.out.println("HOLA! UPDATE" + request.getParameter("id"));
        Client client = new Client(
            Integer.parseInt(request.getParameter("id")),
            request.getParameter("cedula"),
            request.getParameter("nombres"),
            request.getParameter("apellidos")
        );
        clientDaoImpl.update(client);
        this.show(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException 
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ServletException, IOException {
        clientDaoImpl.delete(Integer.parseInt(request.getParameter("id")));
        this.show(request, response);
    }
    
}
