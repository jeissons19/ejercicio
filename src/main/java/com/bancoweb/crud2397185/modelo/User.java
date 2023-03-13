/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancoweb.crud2397185.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ander
 */
public class User extends ConectionDB {

    private int idusers;
    private String name;
    private String noCuenta;
    private String password;
    private int saldo;

    public User() throws SQLException, ClassNotFoundException {
        super();
    }

    public boolean login() throws SQLException {
        PreparedStatement ps = super.coon.prepareStatement("SELECT * FROM users WHERE no_cuenta = ? OR name = ? AND password = ?");
        ps.setString(1, name);
        ps.setString(2, name);
        ps.setString(3, password);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public void update() throws SQLException {
        PreparedStatement ps = super.coon.prepareStatement("UPDATE users SET name = ?, no_cuenta = ?, password = ?, saldo = ? WHERE idusers = ?");
        ps.setString(1, name);
        ps.setString(2, noCuenta);
        ps.setString(3, password);
        ps.setInt(4, saldo);
        ps.setInt(5, idusers);
        ps.executeUpdate();
    }

    public User findById() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.coon.prepareStatement("SELECT * FROM users WHERE idusers = ?");
        ps.setInt(1, idusers);
        ResultSet rs = ps.executeQuery();
        if (rs.next() == false) {
            return null;
        }
        User userData = new User();
        userData.setIdusers(rs.getInt("idusers"));
        userData.setName(rs.getString("name"));
        userData.setNoCuenta(rs.getString("no_cuenta"));
        userData.setPassword(rs.getString("password"));
        userData.setSaldo(rs.getInt("saldo"));
        return userData;
    }

    public void delete() throws SQLException {
        PreparedStatement ps = super.coon.prepareStatement("DELETE FROM users WHERE idusers = ?");
        ps.setInt(1, idusers);
        ps.executeUpdate();
    }

    public void create() throws SQLException {
        PreparedStatement ps = super.coon.prepareStatement("INSERT INTO users VALUES (null, ?, ?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, noCuenta);
        ps.setString(3, password);
        ps.setInt(4, saldo);
        ps.executeUpdate();
    }

    public List<User> findAll() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.coon.prepareStatement("SELECT * FROM users");
        ResultSet rs = ps.executeQuery();
        List<User> usuarios = new ArrayList();
        while (rs.next()) {
            User userData = new User();
            userData.setIdusers(rs.getInt("idusers"));
            userData.setName(rs.getString("name"));
            userData.setNoCuenta(rs.getString("no_cuenta"));
            userData.setPassword(rs.getString("password"));
            userData.setSaldo(rs.getInt("saldo"));
            usuarios.add(userData);
        }
        return usuarios;
    }

    /**
     * @return the idusers
     */
    public int getIdusers() {
        return idusers;
    }

    /**
     * @param idusers the idusers to set
     */
    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the noCuenta
     */
    public String getNoCuenta() {
        return noCuenta;
    }

    /**
     * @param noCuenta the noCuenta to set
     */
    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
