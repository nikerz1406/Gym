/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jason
 */
public class SQLFitness {
    DAO dao = new DAO();
    
    public static Connection conn = null;
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String CONN = "jdbc:mysql://localhost:3306/gym";
    
    public void connectSQL() {
        try {
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //Get the Max ID of table
    public int getQueryMaxId(String tableName) {
        int result = -1;
        String select = "SELECT MAX(ID) FROM " + tableName;
        //Display Query
        System.out.println(select);
        try {
            resultSet = dao.queryGet(select);
            if (resultSet != null) {
                result = resultSet.getInt("MAX(ID)");
            }
        } catch (SQLException e) {
            System.err.println("SQLFitness :: queryMaxId\n" + e);
        }
        return result;
    }

    //Get the number of column in a table 
    public int getQueryCountAll(String tableName) {
        int result = -1;
        String select = "SELECT COUNT(*) FROM " + tableName + " ";
        String where = "WHERE Status = 1";
        String query = (select + where);
        //Display Query
        System.out.println(query);
        try {
            resultSet = dao.queryGet(query);
            if (resultSet != null) {
                while(resultSet.next()){
                    result = resultSet.getInt("COUNT(*)");
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLFitness :: getQueryCountAll\n" + e);
        }
        return result;
    }
    
    
    
    //Get id when Insert the row
    public int Insert(String table, HashMap<String, Object> data,String getID) throws SQLException {
        boolean result = false;
        int ID = -1;int max = 0;
        
        result = dao.Insert(table, data);
        // get id
        if(result){
            ArrayList<ArrayList<Object>> array = new ArrayList<>();
            ArrayList<String> field = new ArrayList<>();
            field.add("id");
            array = dao.select(field, table,data);
            for (ArrayList<Object> j : array) {
                        for (Object i : j) {
                            if((int)i>max){
                                max=(int) i;
                            }
                        }
                    }
        }//end check insert success
        
        ID = max;
        return ID;
    }
    
    //Get select all value of table
    public ArrayList<Object[]> getQuerySelectAll(String fieldName, String tableName, String columnName, String condition){
        ArrayList<Object[]> resultList = new ArrayList<>();
        String select = "SELECT " + fieldName + " FROM " + tableName + " ";
        String where = "WHERE " + columnName + " = " + condition;
        String query = select + where;
        System.out.print(query);
        try {
            resultSet = dao.queryGet(query);
            if(resultSet != null){
                while(resultSet.next()){
                    Object[] objects = new Object[]{
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getDouble("Price"),
                        resultSet.getInt("Members"),
                        resultSet.getInt("CourseLimit"),
                    };
                    resultList.add(objects);
                }
            }
        } catch(SQLException e) {
            System.err.println("SQLFitness :: getQuerySelectAll\n" + e);
        }
        return resultList;
    }
    
    
    
    public ArrayList<Object[]> getQueryInner(String[] fieldName, String[] tableName, HashMap<String, String> condition){
        ArrayList<Object[]> resultList = new ArrayList<>();
        Object[] conditions = condition.entrySet().toArray();
        String select = "SELECT " + fieldName[0] + " FROM " + tableName[0] + " ";
        String inner = "INNER JOIN " + tableName[1] + " ON " + conditions[0].toString() + " ";
        String where = "WHERE " + conditions[1].toString();
        String query = (select + inner + where);
        
        try {
            resultSet = dao.queryGet(query);
            if(resultSet != null){
                while(resultSet.next()){
                    Object[] objects = new Object[]{
                        resultSet.getObject(fieldName[0]),
                    };
                    resultList.add(objects);
                }
            }
        } catch(SQLException e) {
            System.err.println("SQLFitness :: getQueryInner\n" + e);
        }
        return resultList;
    }
    
    //Use for NutrientZone start
    public boolean getQueryDelete(String tableName, int condition){
        boolean result = false;
        
        String select = "UPDATE " + tableName + " SET Status = 0 ";
        String where = "WHERE ID = " + condition;
        String query = select + where;
        result = dao.queryExe(query);
        
        return result;
    }
    
    public ArrayList<Object[]> getQueryNutrient(String fieldName, String tableName, String columnName, String condition){
        ArrayList<Object[]> resultList = new ArrayList<>();
        String select = "SELECT " + fieldName + " FROM " + tableName + " ";
        String where = "WHERE " + columnName + " = " + condition;
        String query = select + where;
        System.out.print(query);
        try {
            resultSet = dao.queryGet(query);
            if(resultSet != null){
                while(resultSet.next()){
                    Object[] objects = new Object[]{
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Description"),
                    };
                    resultList.add(objects);
                }
            }
        } catch(SQLException e) {
            System.err.println("SQLFitness :: getQueryNutrient\n" + e);
        }
        return resultList;
    }
    //Use for NutrientZone end
    
    //Use for Branch start
    public ArrayList<Object[]> getQueryBranch(String fieldName, String tableName, String columnName, String condition){
        ArrayList<Object[]> resultList = new ArrayList<>();
        String select = "SELECT " + fieldName + " FROM " + tableName + " ";
        String where = "WHERE " + columnName + " = " + condition;
        String query = select + where;
        System.out.print(query);
        try {
            resultSet = dao.queryGet(query);
            if(resultSet != null){
                while(resultSet.next()){
                    Object[] objects = new Object[]{
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Address"),
                        resultSet.getString("Phone"),
                    };
                    resultList.add(objects);
                }
            }
        } catch(SQLException e) {
            System.err.println("SQLFitness :: getQueryNutrient\n" + e);
        }
        return resultList;
    }
    //Use for Branch end
    
    //Use for Candidate start
    public int getQueryValidate(String tableName, HashMap<String, Object> condition){
        int result = -1;
        Object[] conditions = condition.entrySet().toArray();
        String select = "SELECT COUNT(*) FROM " + tableName + " ";
        String where = "WHERE " + conditions[0].toString() + " AND " + conditions[1].toString();
        select += where;
        try {
            resultSet = dao.queryGet(select);
            if (resultSet != null) {
                while (resultSet.next()) {
                    result = resultSet.getInt("COUNT(*)");
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLFitness :: getQueryInner\n" + e);
        }
        return result;
    }
    
    public ArrayList<Object[]> getQueryCandidate(String fieldName, String tableName, String columnName, String condition){
        ArrayList<Object[]> resultList = new ArrayList<>();
        String select = "SELECT " + fieldName + " FROM " + tableName + " ";
        String where = "WHERE " + columnName + " = " + condition;
        String query = select + where;
        System.out.print(query);
        try {
            resultSet = dao.queryGet(query);
            if(resultSet != null){
                while(resultSet.next()){
                    Object[] objects = new Object[]{
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Gender"),
                        resultSet.getDate("Birthday"),
                        resultSet.getString("Branch")
                    };
                    resultList.add(objects);
                }
            }
        } catch(SQLException e) {
            System.err.println("SQLFitness :: getQueryNutrient\n" + e);
        }
        return resultList;
    }
    //Use for Candidate end
    
    private ResultSet resultSet;
}
