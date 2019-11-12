/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLjava;

import Entities.Customer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author Viet
 */
public class DAOEmployee {

    private Connection conn;

    public DAOEmployee() {
        try {
            final String USERNAME = "root";
            final String PASSWORD = "";
            final String CONN = "jdbc:mysql://localhost:3306/gym";
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQLMember - SQLMember: " + e);
        }
    }

    // 
    public ResultSet queryGet(String query) {
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("DAOEmployee - queryGet:" + e);
        }
        return null;
    }

    public boolean queryExe(String query) {
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("DAOEmployee - queryExe:" + e);
        }
        return false;
    }
    //

    public int getMaxNum(String columnName, String tableName) {
        try {
            int maxNum = 0;
            String query = "SELECT MAX(" + columnName + ") AS 'Latest' FROM " + tableName;
            ResultSet rs = queryGet(query);
            while (rs.next()) {
                maxNum = rs.getInt("Latest");
            }
            return maxNum;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public String getProductName(int productId, String tableName) {
        try {
            String productName = "";
            ResultSet rs = queryGet("SELECT Name FROM " + tableName + " WHERE ID='" + productId + "'");
            while (rs.next()) {
                productName = rs.getString("Name");
            }
            return productName;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean checkExist(String column, String value) {
        try {
            String query = "SELECT ID FROM employee WHERE " + column + " ='" + value + "'";
            ResultSet rs = queryGet(query);
            while (rs.next()) {
                if (rs.getInt("ID") > 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    public int checkRole(String condition) {
        try {
            String query = "SELECT Role FROM employee WHERE " + condition + "';";
            ResultSet rs = queryGet(query);
            while (rs.next()) {
                if (rs.getInt("Role") > 0) {
                    return rs.getInt("Role");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public boolean insert(String tableName, HashMap<String, Object> data) {
        try {
            String query1 = "INSERT INTO " + tableName + " (";
            String query2 = " VALUES ('";
            for (Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                query1 += key + ", ";
                query2 += value + "', '";
            }
            query1 += "Status) ";
            query2 += "1');";
            System.out.println(query1 + query2);
            return queryExe(query1 + query2);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateEmployeeAvatar(String imagePath, int employeeId) {
        InputStream inputStream = null;
        try {
            String query = "UPDATE employee SET Avatar = ? WHERE ID = '" + employeeId + "';";
            PreparedStatement st = conn.prepareStatement(query);
            inputStream = new FileInputStream(imagePath);
            st.setBinaryStream(1, inputStream, (int) imagePath.length());
            return st.executeUpdate() > 0;
        } catch (FileNotFoundException | SQLException e) {
            System.out.println("DAOEmployee - updateCustomerAvatar: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("DAOEmployee - updateCustomerAvatar: " + e);
            }
        }
        return false;
    }

    public boolean update(HashMap<String, Object> data, String tableName, String condition) throws SQLException {
        try {
            String query = "UPDATE " + tableName + " SET ";
            for (Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                query += key + " = '" + value + "', ";
            }
            query = query.substring(0, query.length() - 2) + " WHERE " + condition;
            System.out.println(query);
            queryExe(query);
            return true;
        } catch (Exception e) {
            System.out.println("SQLMember: " + e);
        }
        return false;
    }

    public ArrayList<ArrayList<Object>> select(ArrayList<String> columnNameS, String tableName, String condition) throws SQLException {
        try {
            ArrayList<ArrayList<Object>> data = new ArrayList<>();
            String query = "SELECT ";
            for (String i : columnNameS) {
                query += i + ", ";
            }
            query = query.substring(0, query.length() - 2) + " FROM " + tableName + " WHERE " + condition;
            ResultSet rs = queryGet(query);
            while (rs.next()) {
                ArrayList<Object> dataRow = new ArrayList<>();
                for (int i = 0; i < columnNameS.size(); ++i) {
                    String columnName = columnNameS.get(i);
                    dataRow.add(rs.getString(columnName));
                }
                data.add(dataRow);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("SQLMember: " + e);
        }
        return null;
    }
}
