/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLjava;

import Entities.Customer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Viet
 */
public class DAOMember {

    private Connection conn;

    public DAOMember() {
        try {
            final String USERNAME = "root";
            final String PASSWORD = "";
            final String CONN = "jdbc:mysql://localhost:3306/gym";
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("DAOMember - DAOMember: " + e);
        }
    }

    public static int getMaxNum(String columnName, String tableName) {
        try {
            int maxNum = 0;
            String query = "SELECT MAX(" + columnName + ") AS 'Latest' FROM " + tableName;
            DAO dao = new DAO();
            ResultSet rs = dao.queryGet(query);
            while (rs.next()) {
                maxNum = rs.getInt("Latest");
            }
            return maxNum;
        } catch (SQLException e) {
            System.out.println("DAOMember - getMaxNum: " + e);
        }
        return -1;
    }

    public static boolean checkExist(String column, String value) {
        try {
            String query = "SELECT ID FROM customer WHERE " + column + "='" + value + "'";
            DAO dao = new DAO();
            ResultSet rs = dao.queryGet(query);
            while (rs.next()) {
                if (rs.getInt("ID") > 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("DAOMember - checkExist: " + e);
        }
        return true;
    }

    public boolean insertCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customer(Name,Phone,Membership,Gender,Birthday,IdCard,Email,Address,Note,Status,Branch)" + "VALUES(?,?,?,?,?,?,?,?,?,1,?)";
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, customer.getFullName());
            st.setInt(2, customer.getPhone());
            st.setInt(3, customer.getMember());
            st.setInt(4, customer.getGender());
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            st.setString(5, ft.format(customer.getBirthday()));
            st.setString(6, customer.getIdCard());
            st.setString(7, customer.getEmail());
            st.setString(8, customer.getAddress());
            st.setString(9, customer.getNote());
            st.setString(10, customer.getBranch());

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("DAOMember - insertCustomerInfo: " + e);
        }
        return false;
    }

    public boolean updateCustomerAvatar(String imagePath, int customerId) {
        InputStream inputStream = null;
        try {
            String query = "UPDATE customer SET Avatar = ? WHERE ID = '" + customerId + "';";
            PreparedStatement st = conn.prepareStatement(query);
            inputStream = new FileInputStream(imagePath);
            st.setBinaryStream(1, inputStream, (int) imagePath.length());
            return st.executeUpdate() > 0;
        } catch (FileNotFoundException | SQLException e) {
            System.out.println("DAOMember - updateCustomerAvatar: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("DAOMember - updateCustomerAvatar: " + e);
            }
        }
        return false;
    }

    public boolean insertCustomerDetail(int customerId, int productId, String productType) {
        try {
            String query = "UPDATE customerdetail SET CustomerID = '?', ProductID = '?', ProductType = '?';";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, customerId);
            st.setInt(2, productId);
            st.setString(3, productType);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("insertCustomerProduct: " + e);
        }
        return false;
    }

    public Customer selectCustomer(int customerId) {
        String query = "SELECT * FROM customer "
                + "WHERE customer.ID='" + customerId + "'";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("ID");
                String fullName = rs.getString("Name");
                int phone = rs.getInt("Phone");
                int member = rs.getInt("Membership");
                byte gender = (byte) rs.getInt("Gender");
                Date sqlBirthday = rs.getDate("Birthday");
                java.util.Date birthday = new java.util.Date(sqlBirthday.getTime());
                String idCard = rs.getString("IdCard");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                String note = rs.getString("Note");
                byte status = rs.getByte("Status");
                String branch = rs.getString("Branch");
//                Blob blob = rs.getBlob("Avatar");
//                InputStream in = blob.getBinaryStream();
//                BufferedImage image = ImageIO.read(in);
//                ImageIcon avatar = new ImageIcon(image);
                Customer customer = new Customer(Id, fullName, phone, member, gender, birthday, idCard, email, address, note, status, branch);
//                customer.setAvatar(avatar);
                return customer;
            }
        } catch (SQLException e) {
            System.out.println("DAOMember - selectCustomer: " + e);
//        } catch (IOException e) {
//            System.out.println("DAOMEmber - selectCustomer: " + e);
        }
        return null;
    }

    public ArrayList<Customer> select(ArrayList<String> columnNameS, String tableName, String condition) {
        try {
            ArrayList<Customer> data = new ArrayList<>();
            String query = "SELECT ";
            for (String i : columnNameS) {
                query += i + ", ";
            }
            query = query.substring(0, query.length() - 2) + " FROM " + tableName + " WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(columnNameS.get(0));
                String fullName = rs.getString(columnNameS.get(1));
                int phone = rs.getInt(columnNameS.get(2));
                int member = rs.getInt(columnNameS.get(3));
                byte status = rs.getByte(columnNameS.get(4));
                Customer customer = new Customer(Id, fullName, phone, member, status);
                data.add(customer);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("SQLMember: " + e);
        }
        return null;
    }
}
