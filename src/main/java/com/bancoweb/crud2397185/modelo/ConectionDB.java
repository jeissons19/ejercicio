/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancoweb.crud2397185.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ander
 */
public class ConectionDB {
    
    private final String HOST_DB = "jdbc:mysql://localhost:3306/";
    private final String USER_DB = "root";
    private final String PASSWORD_DB = "admin";
    private final String NAME_DB = "usuarios_test_db";
    protected Connection coon;

    public ConectionDB() throws SQLException, ClassNotFoundException {
        if(coon == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coon = DriverManager.getConnection(HOST_DB + NAME_DB, USER_DB, PASSWORD_DB);
        }
    }
    
}
