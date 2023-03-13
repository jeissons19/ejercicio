/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bancoweb.crud2397185.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bancoweb.crud2397185.modelo.User;
import java.sql.SQLException;

/**
 *
 * @author ander
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User userModel = new User();
            userModel.setName(req.getParameter("name"));
            userModel.setPassword(req.getParameter("password"));
            if(userModel.login()) {
                resp.sendRedirect("UserServlet");
            } else {
                req.setAttribute("message", "Usuario o contraseña incorrecto!");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
}
