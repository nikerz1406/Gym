/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Main.MainInterface;
import SQLjava.DAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LH
 */
public class OrderView extends javax.swing.JPanel {

    /**
     * Creates new form OrderView
     */
    public OrderView() {
        initComponents();
        setTimeDefault();
        viewVoucherCreated(this.voucherno);
        if (MainInterface.userType == 1) {
            btnEdit.setEnabled(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        labDateFrom = new javax.swing.JLabel();
        labDateTo = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabOrder = new javax.swing.JTable();
        inputDateForm = new com.toedter.calendar.JDateChooser();
        inputDateTo = new com.toedter.calendar.JDateChooser();
        btnEdit = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabOrderdetail = new javax.swing.JTable();

        jLabel7.setText("ORDER TRANSACTIONS VIEWS");

        labDateFrom.setText("Date From");

        labDateTo.setText("Date To");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tabOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VoucherNo", "VoucherDate", "Description", "Customer", "Payment", "Creater", "Total", "Liabilities"
            }
        ));
        tabOrder.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabOrderFocusGained(evt);
            }
        });
        tabOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabOrderMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabOrder);

        inputDateForm.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                inputDateFormAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(labDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputDateForm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(labDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(inputDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        headerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inputDateForm, inputDateTo});

        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(inputDateForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labDateFrom)
                        .addComponent(labDateTo)
                        .addComponent(inputDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEdit))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        headerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inputDateForm, labDateFrom, labDateTo});

        jLabel16.setText("ORDER TRANSACTIONS DETAIL");

        tabOrderdetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Course", "Service Name", "Description", "Price"
            }
        ));
        jScrollPane5.setViewportView(tabOrderdetail);

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(396, 396, 396))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputDateFormAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_inputDateFormAncestorAdded
//        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy 'at' hh:mm:ss a");
//        Date date = inputDateForm.getDate();
//        String str =ft.format(date);
//
//        System.out.println("input data form "+str);
    }//GEN-LAST:event_inputDateFormAncestorAdded

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int row = tabOrder.getSelectedRow();
        
        System.out.println(" voucher no orderview " + voucherno);
        if (row != -1) {
            String voucherno = (String) tabOrder.getValueAt(row, 0);
            if (tabOrder.getValueAt(row, 0) != null) {                
                
                center.removeAll();
                OrderEdit oe = null;
                try {
                    oe = new OrderEdit();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("voucher no send to order eidt in orderview.java(240)");
                
                
                center.add(oe);
                oe.takeVoucherNo(voucherno);
                try {
                    oe.addDataEdit();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
                }
                center.repaint();
                center.revalidate();
            }
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:2019-09-30 23:12:25
        DateFormat df = new SimpleDateFormat("yyyy-M-dd");
        String dateForm = df.format(inputDateForm.getDate());
        String dateTo = df.format(inputDateTo.getDate());
        
        DAO test = new DAO();
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
        Object[][] field = new Object[8][2];
        field[0][0] = "transaction";
        field[0][1] = "voucherNo";
        field[1][0] = "transaction";
        field[1][1] = "DateCreated";        
        field[2][0] = "transaction";
        field[2][1] = "Description";
        field[3][0] = "customer";
        field[3][1] = "name";        
        field[4][0] = "transaction";
        field[4][1] = "Payment";
        field[5][0] = "transaction";
        field[5][1] = "creater";        
        field[6][0] = "transaction";
        field[6][1] = "Amount";
        field[7][0] = "transaction";
        field[7][1] = "Liabilities";        
        
        ArrayList<String> table = new ArrayList<String>();
        table.add("transaction");
        table.add("customer");
        
        HashMap<String, Object> on = new HashMap<String, Object>();
        on.put("transaction.CustomerID", "customer.id");
        
        String where = " DATE_FORMAT(transaction.DateCreated,'%Y-%m-%d') between '" + dateForm + "' and '" + dateTo + "' and transaction.status =1";
        
        try {
            result = test.select(field, table, on, where);
        } catch (SQLException ex) {
            Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        addTableOder(result, tabOrder);
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tabOrderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabOrderFocusGained
        // TODO add your handling code here:
        //changeValueTable();
    }//GEN-LAST:event_tabOrderFocusGained

    private void tabOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabOrderMouseClicked
        // TODO add your handling code here:
        changeValueTable();
    }//GEN-LAST:event_tabOrderMouseClicked
    // change value table when you change select row taborder
    public void changeValueTable() {
        int row = tabOrder.getSelectedRow();
        
        if (row != -1) {
            String voucherno = (String) tabOrder.getValueAt(row, 0);
            
            DAO test = new DAO();
            ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
            Object[][] field = new Object[4][2];
            
            field[0][0] = "orderdetail";
            field[0][1] = "Course";
            field[1][0] = "orderdetail";
            field[1][1] = "ProductName";            
            field[2][0] = "orderdetail";
            field[2][1] = "Description";
            field[3][0] = "orderdetail";
            field[3][1] = "Price";
            
            ArrayList<String> table = new ArrayList<String>();
            table.add("transaction");
            table.add("orderdetail");
            
            HashMap<String, Object> on = new HashMap<String, Object>();
            on.put("transaction.id", "orderdetail.BatchID");
            
            String where = "transaction.voucherno ='" + voucherno + "'";
            
            try {
                result = test.select(field, table, on, where);
            } catch (SQLException ex) {
                Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
            }

            // remove value curent
            DefaultTableModel model = (DefaultTableModel) tabOrderdetail.getModel();
            int lenRow = model.getRowCount();
            for (int i = lenRow - 1; i > -1; i--) {
                model.removeRow(i);
            }
            
            addTableOrderDetail(result, tabOrderdetail);
        }// end check value exist
        
    }

    public void addTableOrderDetail(ArrayList<ArrayList<Object>> result, JTable table) {
        
        try {
            int row = result.size();
            int col = result.get(1).size();
            int tableCol = table.getColumnCount();
            int tableRow = table.getRowCount();
            int num = tableRow > 1 ? (int) table.getValueAt(tableRow - 2, 0) + 1 : 0;
            
            for (int i = 0; i < row; i++) {
                Object[] rowData = new Object[5];

//             for(int j=0;j<col;j++){
//                 Object value = result.get(i).get(j);
//                 rowData[j] =value;
//            }
                rowData[0] = i + 1 + num;
                rowData[1] = result.get(i).get(0); // course   
                rowData[2] = (String) result.get(i).get(1);// service name
                rowData[3] = result.get(i).get(2);// Description
                rowData[4] = result.get(i).get(3); // price
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(rowData);
                System.out.println(" row " + i);
            }
            
        } catch (Exception e) {
            System.out.println("error addTableOderDetail " + e);
        }
        
    }

    public void addTableOder(ArrayList<ArrayList<Object>> result, JTable table) {
        
        try {
            int row = result.size();
            
            for (int i = 0; i < row; i++) {
                Object[] rowData = new Object[8];

//             for(int j=0;j<col;j++){
//                 Object value = result.get(i).get(j);
//                 rowData[j] =value;
//            }
                rowData[0] = result.get(i).get(0); // voucherno
                
                rowData[1] = (String) result.get(i).get(1);// voucherdate
                rowData[2] = result.get(i).get(2);// Description
                rowData[3] = result.get(i).get(3); // customer
                rowData[4] = result.get(i).get(4);// payment
                rowData[5] = result.get(i).get(5);// creater
                rowData[6] = result.get(i).get(6);// total
                rowData[7] = result.get(i).get(7);// status
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(rowData);
                
            }
            
        } catch (Exception e) {
            System.out.println("error addTableOderDetail " + e);
        }
        
    }

    public void delete() {
        int row = tabOrder.getSelectedRow();
        if (row != -1) {
            String voucherno = (String) tabOrder.getValueAt(row, 0);
            DAO conn = new DAO();
            boolean check = false;
            String table = "transaction";
            HashMap<String, Object> condistion = new HashMap<String, Object>();
            condistion.put("voucherno", voucherno);
            check = conn.Delete(table, condistion);
            if (check) {
                DefaultTableModel model = (DefaultTableModel) tabOrder.getModel();                
                model.removeRow(row);
                
                
                DefaultTableModel modelDetail = (DefaultTableModel) tabOrderdetail.getModel(); 
                int rowO = tabOrderdetail.getRowCount();
                for (int j =rowO-1; j >-1; j--) {
                    modelDetail.removeRow(j);
                }
                JOptionPane.showMessageDialog(center, " Delete success !");
            }
        }
    }

    public void viewVoucherCreated(String voucherno) {
        System.out.println(" voucher is null ");
        System.out.println((this.voucherno == null));
        if (this.voucherno != null) {
            // view voucherno               
            DAO test = new DAO();
            ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
            Object[][] field = new Object[8][2];
            field[0][0] = "transaction";
            field[0][1] = "voucherNo";
            field[1][0] = "transaction";
            field[1][1] = "DateCreated";            
            field[2][0] = "transaction";
            field[2][1] = "Description";
            field[3][0] = "customer";
            field[3][1] = "name";            
            field[4][0] = "transaction";
            field[4][1] = "Payment";
            field[5][0] = "transaction";
            field[5][1] = "creater";            
            field[6][0] = "transaction";
            field[6][1] = "Amount";
            field[7][0] = "transaction";
            field[7][1] = "Liabilities";            
            
            ArrayList<String> table = new ArrayList<String>();
            table.add("transaction");
            table.add("customer");
            
            HashMap<String, Object> on = new HashMap<String, Object>();
            on.put("transaction.CustomerID", "customer.id");
            
            String where = " transaction.voucherno = '" + voucherno + "' and transaction.status =1";
            
            try {
                result = test.select(field, table, on, where);
            } catch (SQLException ex) {
                Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            addTableOder(result, tabOrder);
            //end view
        }
        
    }

    public void addVoucherCreated(String voucherno) {
        voucherno = this.voucherno;
        System.out.println("set voucher no ");
        System.out.println("this voucherno");
        System.out.println(this.voucherno);
        System.out.println("voucherno");
        System.out.println(voucherno);
    }

    public void setTimeDefault() {
        Date dateobj = new Date();
        
        inputDateForm.setDate(dateobj);
        inputDateTo.setDate(dateobj);
    }

    public void orderCenter(javax.swing.JPanel c) {
        center = c;
    }
    private String voucherno;
    private javax.swing.JPanel center;
    //private Search search;
    private static final String NOT_SELECTABLE_OPTION = " - Select an Option - ";
    private javax.swing.JComboBox<String> comboCustomSearch;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel header;
    private com.toedter.calendar.JDateChooser inputDateForm;
    private com.toedter.calendar.JDateChooser inputDateTo;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labDateFrom;
    private javax.swing.JLabel labDateTo;
    private javax.swing.JTable tabOrder;
    private javax.swing.JTable tabOrderdetail;
    // End of variables declaration//GEN-END:variables
}
