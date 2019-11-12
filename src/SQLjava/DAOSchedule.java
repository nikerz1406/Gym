/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Viet
 */
public class DAOSchedule {

    private Connection conn;

    public DAOSchedule() {
        try {
            final String USERNAME = "root";
            final String PASSWORD = "";
            final String CONN = "jdbc:mysql://localhost:3306/gym";
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQLMember - SQLMember: " + e);
        }
    }

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

    public ArrayList<ArrayList<Object>> select(ArrayList<String> columnNameS, String tableName, String condition) {
        try {
            ArrayList<ArrayList<Object>> data = new ArrayList<>();
            String query = "SELECT ";
            for (String i : columnNameS) {
                query += i + ", ";
            }
            query = query.substring(0, query.length() - 2) + " FROM " + tableName + " WHERE " + condition;
            System.out.println(query);
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

    public boolean update(HashMap<String, Object> data, String tableName, String condition) throws SQLException {
        try {
            String query = "UPDATE " + tableName + " SET ";
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                query += key + " = '" + value + "', ";
            }
            query = query.substring(0, query.length() - 2) + " WHERE " + condition;
            queryExe(query);
            return true;
        } catch (Exception e) {
            System.out.println("SQLMember: " + e);
        }
        return false;
    }

    public boolean insert(HashMap<String, Object> data, String tableName) {
        try {
            String query1 = "INSERT INTO " + tableName + " (";
            String query2 = " VALUES ('";
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                query1 += key + ", ";
                query2 += value + "', '";
            }
            query1 = query1.substring(0, query1.length() - 2) + ")";
            query2 = query2.substring(0, query2.length() - 3) + ")";
            System.out.println(query1 + query2);
            return queryExe(query1 + query2);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // for Events
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

    public boolean isEmpty(String table, String condition) {
        try {
            String query = "SELECT ID FROM " + table + " WHERE " + condition;
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
}
