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
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User userModel = new User();
            req.setAttribute("usuarios", userModel.findAll());
            req.getRequestDispatcher("inicio.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            User userModel = new User();
            switch (action) {
                case "guardar":
                    String userIdUpdate = req.getParameter("userId");
                    userModel.setName(req.getParameter("nombre"));
                    userModel.setNoCuenta(req.getParameter("noCuenta"));
                    userModel.setPassword(req.getParameter("password"));
                    userModel.setSaldo(Integer.parseInt(req.getParameter("saldo")));
                    if (userIdUpdate != null) {
                        userModel.setIdusers(Integer.parseInt(userIdUpdate));
                        userModel.update();
                    } else {
                        userModel.create();
                    }
                    break;
                case "eliminar":
                    int userId = Integer.parseInt(req.getParameter("userId"));
                    userModel.setIdusers(userId);
                    userModel.delete();
                    break;
                case "actualizar":
                    int userSelect = Integer.parseInt(req.getParameter("userId"));
                    userModel.setIdusers(userSelect);
                    req.setAttribute("userData", userModel.findById());
                    break;
            }
            req.setAttribute("usuarios", userModel.findAll());
            req.getRequestDispatcher("inicio.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
