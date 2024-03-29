/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nutrient;
import SQLjava.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jason
 */
public class NutrientMainPanel extends javax.swing.JPanel {
    SQLFitness sql = new SQLFitness();
    /**
     * Creates new form NutrientAddPanel
     */
    public NutrientMainPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        btView = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 716));

        pnMain.setPreferredSize(new java.awt.Dimension(980, 640));
        pnMain.setLayout(null);

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTitle.setText("Nutrient Zone");
        lbTitle.setPreferredSize(new java.awt.Dimension(300, 35));

        btView.setText("View");
        btView.setPreferredSize(new java.awt.Dimension(70, 25));
        btView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btViewMouseClicked(evt);
            }
        });

        btNew.setText("New");
        btNew.setPreferredSize(new java.awt.Dimension(70, 25));
        btNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNewMouseClicked(evt);
            }
        });

        btEdit.setText("Edit");
        btEdit.setPreferredSize(new java.awt.Dimension(70, 25));
        btEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditMouseClicked(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.setPreferredSize(new java.awt.Dimension(70, 25));
        btDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btViewMouseClicked
        showViewPanel();
    }//GEN-LAST:event_btViewMouseClicked
    
    public void showViewPanel() {
        selectId = -1;
        setEnable();
        pnMain.removeAll();
        pnMain.updateUI();
        NutrientViewPanel viewPanel = new NutrientViewPanel();
        viewPanel.setVisible(true);
        viewPanel.setBounds(0, 0, 980, 640);
        pnMain.add(viewPanel);
    }
    
    private void btNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNewMouseClicked
        showNewPanel();
    }//GEN-LAST:event_btNewMouseClicked

    public void showNewPanel(){
        try {
            selectId = -1;
            setEnable();
            pnMain.removeAll();
            pnMain.updateUI();
            NutrientNewPanel newPanel = new NutrientNewPanel();
            newPanel.setVisible(true);
            newPanel.setBounds(0, 0, 980, 640);
            pnMain.add(newPanel);
            newPanel.nutrientForm();
        } catch (Exception e) {
            System.out.println("NutrientMainPanel :: btNewMouseClicked\n" + e);
        }
    }
    
    private void btEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditMouseClicked
        try {
            if (btEdit.isEnabled() == true) {
                if(selectId != -1){
                    pnMain.removeAll();
                    pnMain.updateUI();
                    NutrientEditPanel editPanel = new NutrientEditPanel();
                    editPanel.setVisible(true);
                    editPanel.setBounds(0, 0, 980, 640);
                    pnMain.add(editPanel);
                }
            }
        } catch (Exception e) {
            System.out.println("NutrientMainPanel :: btEditMouseClicked\n" + e);
        }
    }//GEN-LAST:event_btEditMouseClicked

    private void btDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteMouseClicked
        if (btDelete.isEnabled() == true) {
            if (selectId != -1) {
                String sqlTableName = "";
                switch (selectType) {
                    case "Nutrient":
                        sqlTableName = "nutrient";
                        break;
                    case "Diet":
                        sqlTableName = "diet";
                        break;
                    case "Recipe":
                        sqlTableName = "recipe";
                        break;
                }
                if (sql.getQueryDelete(sqlTableName, selectId)) {
                    JOptionPane.showMessageDialog(null, "Delete Successful");
                    showViewPanel();
                }
            }
        }
    }//GEN-LAST:event_btDeleteMouseClicked
    
    public void getArrayList(){
        ArrayList<Object[]> tempList;
        tempList = sql.getQueryNutrient("*", "nutrient", "Status", "1");
        nutrientList = new ArrayList<>();
        loadData(tempList, "Nutrient");
        
        tempList = sql.getQueryNutrient("*", "diet", "Status", "1");
        dietList = new ArrayList<>();
        loadData(tempList, "Diet");
        
        tempList = sql.getQueryNutrient("*", "recipe", "Status", "1");
        recipeList = new ArrayList<>();
        loadData(tempList, "Recipe");
    }
    
    public void loadData(ArrayList<Object[]> arrayList, String string) {
        for (Object[] arrays : arrayList) {
            Object[] row = new Object[arrays.length + 1];
            for (int i = 0; i < row.length; i++) {
                if (i == 0) {
                    row[i] = string;
                } else {
                    row[i] = arrays[i - 1];
                }
            }
            if ("Nutrient".equals(string)) {
                nutrientList.add(row);
            } else if ("Diet".equals(string)) {
                dietList.add(row);
            } else if ("Recipe".equals(string)) {
                recipeList.add(row);
            }
        }
    }
    
    //Button Edit and Delete will disable if row in the View Panel hasn't been select
    public void setEnable() {
        if(selectId == -1) {
            btEdit.setEnabled(false);
            btDelete.setEnabled(false);
        }
        else {
            btEdit.setEnabled(true);
            btDelete.setEnabled(true);
        }
    }
    
    //Variables Zone
    public static ArrayList<Object[]> nutrientList;
    public static ArrayList<Object[]> dietList;
    public static ArrayList<Object[]> recipeList;
    public static int selectNo = -1;
    public static int selectId = -1;
    public static String selectType = "";
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btDelete;
    public static javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btView;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables
}
