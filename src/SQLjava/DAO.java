
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLjava;

//import demoqlsv.DAO;
import Entities.*;
import Main.MainInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class DAO {

    public static Connection conn = null;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN = "jdbc:mysql://localhost:3306/gym";

    public void connectSQL() {
        try {
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.connectSQL();
    }

    public void query(String query) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            System.out.println("connected");
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("Name");
                System.out.println(fullName);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ResultSet queryGet(String query) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            System.out.println("connected");
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
        
                return rs;
  
        } catch (SQLException e) {
            System.out.println("queryGet error " + e);
            return null;
        }

    }

    public boolean queryExe(String query) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            System.out.println("connected");
            PreparedStatement st = conn.prepareStatement(query);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("queryExe error " + e);
            return false;
        }

    }

    // create method track typeof value
    public Boolean isInt(Object o) {
        try {
            int i = Integer.parseInt((String) o);

            return true;
        } catch (Exception e) {
            //  Block of code to handle errors
            return false;
        }
    }

    public Boolean isDouble(Object o) {
        try {
            Double i = Double.parseDouble((String) o);

            return true;
        } catch (Exception e) {
            //  Block of code to handle errors
            return false;
        }
    }

    public Boolean isBoolean(Object o) {
        try {
            Boolean i = Boolean.parseBoolean((String) o);

            return true;
        } catch (Exception e) {
            //  Block of code to handle errors
            return false;
        }
    }

    public String typeOf(Object o) {
        String parameter = "";
        if (isInt(o) || isDouble(o)) {
            parameter = (String) o;
        } else {
            parameter = "'" + (String) o + "'";
        }
        return parameter;
    }//end create method track value

    public boolean Insert(String table, HashMap<String, Object> data) {
        boolean result = false;
        // validate data
        if (data != null) {
            // create sql
            String sql = "INSERT INTO " + table + " (";
            String subSql = " VALUES(";
            for (Entry<String, Object> entry : data.entrySet()) {
                String k = entry.getKey();
                //Nang ::
                //(String)entry.gatValue() bao loi phai doi entry.gatValue().toStrubg() moi chay duoc
                String v = entry.getValue().toString();

                //String v = (String)entry.getValue();
                sql += k + ",";
                subSql += typeOf(v) + ",";
            }

            sql = sql.substring(0, sql.length() - 1) + ") ";
            subSql = subSql.substring(0, subSql.length() - 1) + ")";
            sql = sql + subSql;// end create sql
            System.out.println("Insert method query = " + sql);

            result = queryExe(sql);// insert success
            result = true;
        }//end check data

        return result;
    }
    
    public int Insert(String table, HashMap<String, Object> data,String getID) throws SQLException {
        boolean result = false;
        int ID = -1;int max = 0;
        result= this.Insert(table, data);
        // get id
        if(result){
            ArrayList<ArrayList<Object>> array = new ArrayList<ArrayList<Object>>();
            ArrayList<String> field = new ArrayList<String>();
            field.add("id");
            array = this.select(field, table,data);
            
            for (ArrayList<Object> j : array) {
                        for (Object i : j) {
                            int temp = Integer.valueOf((String) i);
                            if(temp>max){
                                max = temp;
                            }
                        }
                    }
        }//end check insert success
        
        ID = max;
        return ID;
    }

    public boolean Update(String table, HashMap<String, Object> data, HashMap<String, Object> condition) {
        boolean result = false;
        // validate data
        //        UPDATE table_name
        //        SET column1=value, column2=value2,...
        //        WHERE some_column=some_value 
        if (data != null) {
            // create sql
            String sql = "UPDATE " + table + " SET ";
            String subSql = "";
            String where = " where ";

            for (Entry<String, Object> entry : data.entrySet()) {
                String k = entry.getKey();
                //(String)entry.gatValue() have to change to entry.gatValue().toStrubg()
                String v = entry.getValue().toString();

                subSql += k + " = " + typeOf(v) + ",";
            }
            subSql = subSql.substring(0, subSql.length() - 1) + " ";

            for (Entry<String, Object> entry : condition.entrySet()) {
                String k = entry.getKey();
                String v = (String) entry.getValue();

                where += k + " = " + typeOf(v) + " and ";
            }

            where = where.substring(0, where.length() - 4);

            sql = sql + subSql + where;// end create sql
            System.out.println("Update method query = " + sql);

            result = queryExe(sql);// insert success

        }//end check data

        return result;
    }

    //Nang ::
    public boolean Update(String table, HashMap<String, Object> data, int id) {
        boolean result = false;
        // validate data
        if (data != null) {
            // create sql
            String sql = "UPDATE " + table + " SET ";
            String subSql = "";
            String where = " WHERE ID = " + id;
            for (Entry<String, Object> entry : data.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue().toString();
                subSql += k + " = " + typeOf(v) + ",";
            }
            subSql = subSql.substring(0, subSql.length() - 1) + " ";
            sql = sql + subSql + where;// end create sql
            System.out.println("Update method query = " + sql);

            result = queryExe(sql);// insert success

        }//end check data

        return result;
    }

    public boolean Delete(String table, HashMap<String, Object> condition) {
        boolean result = false;
        // validate data
        //        UPDATE table_name
        //        SET status = 1, column2=value2,...
        //        WHERE some_column=some_value 
        // create sql
        String sql = "UPDATE " + table + " SET ";
        String subSql = " status = 0 ";
        String where = " where ";

        subSql = subSql.substring(0, subSql.length() - 1) + " ";

        for (Entry<String, Object> entry : condition.entrySet()) {
            String k = entry.getKey();
            String v = (String) entry.getValue();

            where += k + " = " + typeOf(v) + " and ";
        }

        where = where.substring(0, where.length() - 4);

        sql = sql + subSql + where;// end create sql
        System.out.println("Update method query = " + sql);

        result = queryExe(sql);// insert success      

        return result;
    }

    //Nang ::
    public boolean Delete(String table, int[] selectedArray) {
        boolean result = false;
        String sql = "UPDATE " + table + " SET Status = 1 WHERE ID IN (";
        String idArray = "";
        for (int id : selectedArray) {
            idArray += Integer.toString(id) + ", ";
        }
        idArray = idArray.substring(0, idArray.length() - 2);
        sql += idArray + ")";
        System.out.println("Update method query = " + sql);
        result = queryExe(sql);
        return result;
    }
    
// Here is back up method simple inner join : select * from course inner join coursedetail on course.ID = coursedetail.courseID where coursedetail.courseID = 1
//    public ArrayList<ArrayList<Object>> select(HashMap<String, Object> field,ArrayList<String> table, HashMap<String, Object> on,String where) throws SQLException {
//        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
//        // select col1,col2 from table1 as t1 inner join table2 as t2 on t1.col = t2.col where
//        ArrayList<String> subfield = new ArrayList<String>();
//        
//        String subtable= "";
//        
//        for(String t : table){
//           subtable +=t+" inner join ";
//        }
//        subtable=subtable.substring(0, subtable.length() - 11) + " ";
//        subtable +=" on ";
//        
//        String subon ="";
//        
//         for (Entry<String, Object> entry : on.entrySet()) {
//            String k = entry.getKey();
//            String v = (String) entry.getValue();
//            subon += k +" = "+v+" ";
//        }
//        
//         for (Entry<String, Object> entry : field.entrySet()) {
//            String k = entry.getKey();
//            String v = (String) entry.getValue();
//            String col = k+"."+v;
//            subfield.add(col);
//
//        }
//         subtable = subtable + subon;
//         result = select(subfield,subtable,where);
//        return result;
//    }
//     End back up
    
    public ArrayList<ArrayList<Object>> select(Object[][] field,ArrayList<String> table, HashMap<String, Object> on,String where) throws SQLException {
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
//         select col1,col2,col3... from 
//            table1 as t1 inner join table2 
//                as t2 on t1.col = t2.col 
//                        inner join table3 as t3
//                                on t1.col = t3.col
//                                      where col3 =1
        ArrayList<String> subfield = new ArrayList<String>();
        
        String subtable= table.get(0);
        
        int i=0;
        
         for (Entry<String, Object> entry : on.entrySet()) {
            i++;
            subtable += " inner join "+table.get(i)+" ";
            String k = entry.getKey();
            String v = (String) entry.getValue();
            String subon = " on "+k +" = "+v+" ";
            subtable =subtable+subon;
            
        }
         int len = field.length;

          for (int j=0;j<len;j++) {
              String temp = field[j][0]+"."+field[j][1];
 
                subfield.add(temp);
           }
      
 
         result = select(subfield,subtable,where);
        return result;
    }
    public ArrayList<ArrayList<Object>> select1(ArrayList<String> field, String table, HashMap<String, Object> condition) throws SQLException {
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
        // prepare sql query
        // validate parameter
        // excute field
        // get name table :SELECT * FROM information_schema.COLUMNS WHERE `column_name`  = table;
        // if select field
        String fieldView = "";
        for (String i : field) {
            fieldView += i + ",";
        }
        fieldView = fieldView.substring(0, fieldView.length() - 1);
        String sql = "select " + fieldView + " from " + table + " where ";
        String where = "";

        for (Entry<String, Object> entry : condition.entrySet()) {
            String k = entry.getKey();
            String v = (String) entry.getValue();
            if ("1".equals(k) && "1".equals(v)) {
                where += "1=1 and ";
                break;
            }else{
                where += k + " = " + typeOf(v) + " and ";
            }

        }
        where = where.substring(0, where.length() - 4);
        sql += where;
        System.out.println("select query sql : " + sql);
        
        Object temp = queryGet(sql);
        if(temp != null){
            ResultSet rs = (ResultSet)temp;
        
        while (rs.next()) {
            ArrayList<Object> col = new ArrayList<Object>();
            for (int i = 0; i < field.size(); i++) {
                String nameCol = field.get(i);
                col.add(rs.getString(nameCol));
            }
            result.add(col);
            }
        }// end check rs case
        
        return result;
    }
    
 
    public ArrayList<ArrayList<Object>> select(String table, HashMap<String, Object> condition) throws SQLException {
        // prepare sql query
        // validate parameter
        // find field select of table
        // get name table :SELECT COLUMN_name FROM information_schema.COLUMNS where TABLE_NAME like "bookstore"
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
        if (condition != null) {
            // get field name table
            ArrayList<String> colName = new ArrayList<String>();
            String sql = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE `TABLE_NAME`  = '" + table + "'";
            ResultSet rs = queryGet(sql);
            // check success query
            if (rs != null) {
                while (rs.next()) {
                    String fullName = rs.getString("COLUMN_NAME");
                    colName.add(fullName);
                }

                result = select(colName, table, condition);

            } else {
                System.out.println("Don't have table name " + table);

            }// end get field name table

        }// end check condition

        return result;
    }

    public ArrayList<ArrayList<Object>> select(String table) throws SQLException {
        // prepare sql query
        // validate parameter
        // find field select of table
        // get name table :SELECT COLUMN_name FROM information_schema.COLUMNS where TABLE_NAME like "bookstore"
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();

        // get field name table
        ArrayList<String> colName = new ArrayList<String>();
        String sql = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE `TABLE_NAME`  = '" + table + "'";
        ResultSet rs = queryGet(sql);
        // check success query
        if (rs != null) {
            while (rs.next()) {
                String fullName = rs.getString("COLUMN_NAME");
                colName.add(fullName);
            }

            HashMap<String, Object> condition = new HashMap<String, Object>();
            condition.put("1", "1");
            result = select(colName, table, condition);

        } else {
            System.out.println("Don't have table name " + table);

        }// end get field name table

        return result;
    }
    public ArrayList<ArrayList<Object>> select(ArrayList<String> field, String table,String where) throws SQLException {
//        select col1,col2 ... from table where + String
        ArrayList<ArrayList<Object>> result = new  ArrayList<ArrayList<Object>>();
        String fieldView = "";
        for (String i : field) {
            fieldView += i + ",";
        }
        fieldView = fieldView.substring(0, fieldView.length() - 1);
        String sql = "select " + fieldView + " from " + table + " where ";

        sql += where;
        System.out.println("select query sql : " + sql);
        
        Object temp = queryGet(sql);
        if(temp != null){
            ResultSet rs = (ResultSet)temp;
        
        while (rs.next()) {
            ArrayList<Object> col = new ArrayList<Object>();
            for (int i = 0; i < field.size(); i++) {
                String nameCol = field.get(i);
                col.add(rs.getString(nameCol));
            }
            result.add(col);
            }
        }// end check rs case

        return result;
    }
    public int selectGetID(String table,String where) throws SQLException {
//        select col1,col2 ... from table where + String
        int ID =-1;
        ArrayList<ArrayList<Object>> result = new  ArrayList<ArrayList<Object>>();
        
        String sql = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE `TABLE_NAME`  = '" + table + "' AND ORDINAL_POSITION =1";
        ResultSet rs = queryGet(sql);
        String fieldView ="";
        while (rs.next()) {
            fieldView =  rs.getString("COLUMN_NAME");
        }
        
        System.out.println("fieldView "+ fieldView);
         sql = "select " + fieldView + " from " + table + " where ";

        sql += where;
        System.out.println("select query sql : " + sql);
        
        Object temp = queryGet(sql);
        if(temp != null){
            rs = (ResultSet) temp;
            String str="";
            while (rs.next()) {
            str = rs.getString(fieldView);
            }
            
            ID =Integer.parseInt(str);
            System.out.println("ID "+ID);
        }// end check rs case

        return ID;
    }
    public ArrayList<ArrayList<Object>> select(ArrayList<String> field, String table, HashMap<String, Object> condition) throws SQLException {
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
        // prepare sql query
        // validate parameter
        // excute field

        // get name table :SELECT * FROM information_schema.COLUMNS WHERE `column_name`  = table;
        // if select field
        String fieldView = "";
        for (String i : field) {
            fieldView += i + ",";
        }
        fieldView = fieldView.substring(0, fieldView.length() - 1);
        String sql = "select " + fieldView + " from " + table + " where ";
        String where = "";

        for (Entry<String, Object> entry : condition.entrySet()) {
            String k = entry.getKey();
            String v = (String) entry.getValue();
            if (k == "1" && v == "1") {
                where += "1=1 and ";
            } else {
                where += k + " = " + typeOf(v) + " and ";
            }

        }
        where = where.substring(0, where.length() - 4);
        sql += where;
        System.out.println("select query sql : " + sql);
        ResultSet rs = queryGet(sql);

        while (rs.next()) {
            ArrayList<Object> col = new ArrayList<Object>();
            for (int i = 0; i < field.size(); i++) {
                String nameCol = field.get(i);
                col.add(rs.getString(nameCol));
            }
            result.add(col);
        }

        return result;
    }
    
    public ArrayList<ArrayList<Object>> select(ArrayList<String> field, String table) throws SQLException {

        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();

        // check success query
        HashMap<String, Object> condition = new HashMap<String, Object>();
        condition.put("1", "1");
        result = select(field, table, condition);

        return result;
    }
    public boolean addTableView(ArrayList<ArrayList<Object>> result, JTable table){
        boolean check =false;
        try {
            int row = result.size();
            int col = result.get(1).size();
            int tableCol = table.getColumnCount();
         for(int i=0;i<row;i++){
             Object[] rowData = new Object[col];
              
             // connect col result to col table view UI
             for(int j=0;j<col;j++){
                 Object value = result.get(i).get(j);
                 rowData[j] =value;
            }
             // end connect
             
             DefaultTableModel model = (DefaultTableModel)table.getModel();
             model.addRow(rowData);
         }
         check =true;
        } catch (Exception e) {
            System.out.println("error addTableView"+e);
        }
         

        return check;
    }

      //custom-code @Hue
    public static MainInterface mainInterface;

    public static void testSelect() {
        
        try {
            
            // HUONG DAN DUNG
            // method 1 : select(table)
//            DAO test = new DAO();
//              ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
//              String table = "customers";
//            result = test.select(table);

            // method 2 : select(field, table);
//            DAO test = new DAO();
//                        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
//                        String table = "customers";
//                        ArrayList<String> field = new ArrayList<String>();
//                        field.add("id");field.add("name");
//                        result = test.select(field, table);

            //method 3 : select(field,table,condistion);
//            DAO test = new DAO();
//                     ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
//                        String table = "customers";
//                        ArrayList<String> field = new ArrayList<String>();
//                        field.add("id");field.add("name");field.add("duration");
//                        HashMap<String, Object> condistion = new HashMap<String, Object>();
//                        condistion.put("id", "1");condistion.put("month", "9");
//                        result = test.select(field, table,condistion);
                        
            //method 4 : select(table,condistion);
//            DAO test = new DAO();
//                     ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
//                        String table = "customers";
//                          HashMap<String, Object> condistion = new HashMap<String, Object>();
//                          condistion.put("id", "1");
//                          condistion.put("Duration", "6");
//                          result = test.select(table,condistion);
            //method 5 : select(field,table,where);
//            DAO test = new DAO();
//                     ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
//                        String table = "customers";
//                        ArrayList<String> field = new ArrayList<String>();
//                        field.add("id");field.add("name");field.add("duration");
//                        HashMap<String, Object> condistion = new HashMap<String, Object>();
//                        String where = "name like '%ha%' and age between 20 and 29";
//                        result = test.select(field, table,where);
                        
            //method 6 : select(field,table[],on,where);  
            DAO test = new DAO();
                        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
                        Object[][] field = new Object[2][2];
                        field[1][0] ="transaction"; field[0][1] ="id";
                        field[2][0] ="course"; field[0][1] ="name"; 
       
                        ArrayList<String> table = new ArrayList<String>();
                        table.add("transaction");
                        table.add("course");
                        
                        HashMap<String, Object> on = new HashMap<String, Object>();
                        on.put("transaction.id", "course.id");
                        
                        String where = "name like '%ha%' and age between 20 and 29";
                        
                        result = test.select(field, table,on,where);
                        
            // GOI KET QUA   
            if (result == null) {
                System.out.println(" result is null, check your exist table or table is null");
            } else {

                System.out.println("result " + result);
                for (ArrayList<Object> j : result) {
                    for (Object i : j) {
                        System.out.print(i + " ");
                    }
                    System.out.println("|");
                }
                            
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void testInsert() {
        DAO test = new DAO();
        try {
            String table = "excercise";
            HashMap<String, Object> data = new HashMap<String, Object>();

            data.put("Duration", "123");
            data.put("Name", "Excercise123");

            test.Insert(table, data);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void testUpdate() {
        DAO test = new DAO();
        try {
            String table = "excercise";
            HashMap<String, Object> data = new HashMap<String, Object>();

            data.put("Duration", "6000");
            data.put("Name", "Excercise10000");

            HashMap<String, Object> condition = new HashMap<String, Object>();
            condition.put("Duration", "60");
            condition.put("Name", "Excercise10");

            test.Update(table, data, condition);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    //end custom-code

}
