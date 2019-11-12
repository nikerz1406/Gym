/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Customer.CustomerNewPanel;
import Customer.CustomerListPanel;
import Customer.CustomerMainPanel;
import Employee.*;
import Event.*;
import Fitness.*;
import Nutrient.NutrientMainPanel;
import Order.*;
import Branch.*;
import SQLjava.*;
import Schedule.*;
import Store.*;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Viet
 */
public class MainInterface extends javax.swing.JFrame {

    /**
     * Creates new form MainInterface
     */
    public MainInterface() {
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

        MainDesktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mnStore = new javax.swing.JMenu();
        mnOrder = new javax.swing.JMenu();
        miNewOrder = new javax.swing.JMenuItem();
        miViewOrder = new javax.swing.JMenuItem();
        mnMember = new javax.swing.JMenu();
        miNewMember = new javax.swing.JMenuItem();
        miViewMember = new javax.swing.JMenuItem();
        mnFitness = new javax.swing.JMenu();
        miNewFitness = new javax.swing.JMenuItem();
        miView = new javax.swing.JMenuItem();
        mnNutrition = new javax.swing.JMenu();
        miNewNutrition = new javax.swing.JMenuItem();
        miViewNutrition = new javax.swing.JMenuItem();
        mnNews = new javax.swing.JMenu();
        mnBranch = new javax.swing.JMenu();
        mnStory = new javax.swing.JMenu();
        mnAccount = new javax.swing.JMenu();
        miSchdule = new javax.swing.JMenuItem();
        miEmployee = new javax.swing.JMenuItem();
        mnLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gym Managerment");
        setName("Gym Managerment"); // NOI18N
        setResizable(false);

        javax.swing.GroupLayout MainDesktopPaneLayout = new javax.swing.GroupLayout(MainDesktopPane);
        MainDesktopPane.setLayout(MainDesktopPaneLayout);
        MainDesktopPaneLayout.setHorizontalGroup(
            MainDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        MainDesktopPaneLayout.setVerticalGroup(
            MainDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        mnStore.setText("Store");
        mnStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnStoreMouseClicked(evt);
            }
        });
        menuBar.add(mnStore);

        mnOrder.setText("Order");

        miNewOrder.setText("New");
        miNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewOrderActionPerformed(evt);
            }
        });
        mnOrder.add(miNewOrder);

        miViewOrder.setText("View");
        miViewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewOrderActionPerformed(evt);
            }
        });
        mnOrder.add(miViewOrder);

        menuBar.add(mnOrder);

        mnMember.setText("Member");

        miNewMember.setText("New");
        miNewMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewMemberActionPerformed(evt);
            }
        });
        mnMember.add(miNewMember);

        miViewMember.setMnemonic('o');
        miViewMember.setText("View");
        miViewMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewMemberActionPerformed(evt);
            }
        });
        mnMember.add(miViewMember);

        menuBar.add(mnMember);

        mnFitness.setMnemonic('f');
        mnFitness.setText("Fitness Programs");

        miNewFitness.setText("New");
        miNewFitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewFitnessActionPerformed(evt);
            }
        });
        mnFitness.add(miNewFitness);

        miView.setMnemonic('s');
        miView.setText("View");
        miView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewActionPerformed(evt);
            }
        });
        mnFitness.add(miView);

        menuBar.add(mnFitness);

        mnNutrition.setText("Nutrition Zone");

        miNewNutrition.setText("New");
        miNewNutrition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewNutritionActionPerformed(evt);
            }
        });
        mnNutrition.add(miNewNutrition);

        miViewNutrition.setText("View");
        miViewNutrition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewNutritionActionPerformed(evt);
            }
        });
        mnNutrition.add(miViewNutrition);

        menuBar.add(mnNutrition);

        mnNews.setText("News and Events");
        mnNews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnNewsMouseClicked(evt);
            }
        });
        menuBar.add(mnNews);

        mnBranch.setText("Branches");
        mnBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnBranchMouseClicked(evt);
            }
        });
        menuBar.add(mnBranch);

        mnStory.setText("Success Stories");
        menuBar.add(mnStory);

        mnAccount.setText("Management");

        miSchdule.setText("Schedule");
        miSchdule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSchduleActionPerformed(evt);
            }
        });
        mnAccount.add(miSchdule);

        miEmployee.setText("Employees");
        miEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEmployeeActionPerformed(evt);
            }
        });
        mnAccount.add(miEmployee);

        menuBar.add(mnAccount);

        mnLogout.setText("Exit");
        mnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnLogoutMouseClicked(evt);
            }
        });
        menuBar.add(mnLogout);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainDesktopPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainDesktopPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miNewMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewMemberActionPerformed
        try {
            MainDesktopPane.removeAll();
            CustomerMainPanel member = new CustomerMainPanel();
            member.setVisible(true);
            member.setBounds(0, 0, 1000, 716);
            member.containPanel.removeAll();
            CustomerNewPanel memberNew = new CustomerNewPanel();
            memberNew.setBounds(0, 0, 976, 628);
            memberNew.setVisible(true);
            member.containPanel.add(memberNew);
            MainDesktopPane.add(member);
            MainDesktopPane.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FrameMain :: btFitnessMouseClicked Error\n" + e);
        }
    }//GEN-LAST:event_miNewMemberActionPerformed

    private void miViewMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewMemberActionPerformed
        try {
            MainDesktopPane.removeAll();
            CustomerMainPanel member = new CustomerMainPanel();
            member.setVisible(true);
            member.setBounds(0, 0, 1000, 716);
            member.containPanel.removeAll();
            CustomerListPanel memberList = new CustomerListPanel();
            memberList.setBounds(0, 0, 976, 628);
            memberList.setVisible(true);
            member.containPanel.add(memberList);
            MainDesktopPane.add(member);
            MainDesktopPane.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FrameMain :: btFitnessMouseClicked Error\n" + e);
        }
    }//GEN-LAST:event_miViewMemberActionPerformed

    private void miNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewOrderActionPerformed
        try {
            
            MainDesktopPane.removeAll();
            Orders order = new Orders();
            order.clickAdd();
            order.setVisible(true);
            order.setBounds(0, 0, 1000, 616);
            MainDesktopPane.add(order);
            order.center.add(new OrderAdd());
            order.btnEdit.setEnabled(false);
            order.btnDel.setEnabled(false);
            order.center.repaint();
            order.center.revalidate();
            MainDesktopPane.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FrameMain :: btFitnessMouseClicked Error\n" + e);
        }
    }//GEN-LAST:event_miNewOrderActionPerformed

    private void miEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEmployeeActionPerformed
        try {
            MainDesktopPane.removeAll();
            EmployeeMainPanel employee = new EmployeeMainPanel();
            if (userType == 1) {
                employee.btnEdit.setEnabled(false);
            }
            employee.setVisible(true);
            employee.setBounds(0, 0, 1000, 716);
            employee.containPanel.removeAll();
            EmployeeListPanel employeeList = new EmployeeListPanel();
            employeeList.setBounds(0, 0, 976, 628);
            employeeList.setVisible(true);
            employee.containPanel.add(employeeList);
            MainDesktopPane.add(employee);
            MainDesktopPane.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FrameMain :: btFitnessMouseClicked Error\n" + e);
        }
    }//GEN-LAST:event_miEmployeeActionPerformed

    private void mnNewsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnNewsMouseClicked
        try {
            MainDesktopPane.removeAll();
            EventMainPanel event = new EventMainPanel();
            event.setVisible(true);
            event.setBounds(0, 0, 1000, 716);
            if (userType == 1) {
                event.btnEdit.setEnabled(false);
            }
            event.containPanel.removeAll();
            EventListPanel eventtList = new EventListPanel();
            eventtList.setBounds(0, 0, 976, 626);
            eventtList.setVisible(true);
            event.containPanel.add(eventtList);
            MainDesktopPane.add(event);
            MainDesktopPane.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FrameMain :: btFitnessMouseClicked Error\n" + e);
        }
    }//GEN-LAST:event_mnNewsMouseClicked

    private void miViewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewOrderActionPerformed

        MainDesktopPane.removeAll();
        Orders order = new Orders();
        order.setVisible(true);
        order.setBounds(0, 0, 1000, 616);
        MainDesktopPane.add(order);
        OrderView ov = new OrderView();
        ov.orderCenter(order.center);
        order.ov = ov;
        order.addOrderView(ov);
        order.center.add(ov);
        order.center.repaint();
        order.center.revalidate();
        MainDesktopPane.updateUI();
    }//GEN-LAST:event_miViewOrderActionPerformed

    private void miNewFitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewFitnessActionPerformed
        MainDesktopPane.removeAll();
        FitnessMainPanel fitnessPanel = new FitnessMainPanel();
        fitnessPanel.setVisible(true);
        fitnessPanel.setBounds(0, 0, MainDesktopPane.getWidth(), MainDesktopPane.getHeight());
        MainDesktopPane.add(fitnessPanel);
        fitnessPanel.showNewPanel();
    }//GEN-LAST:event_miNewFitnessActionPerformed

    private void mnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnLogoutMouseClicked
        this.dispose();
    }//GEN-LAST:event_mnLogoutMouseClicked

    private void miSchduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSchduleActionPerformed
        MainDesktopPane.removeAll();
        ScheduleMainPanel schedule = new ScheduleMainPanel();
        schedule.setVisible(true);
        schedule.setBounds(0, 0, 1000, 716);
        schedule.containPanel.removeAll();
        ScheduleListPanel scheduleList = new ScheduleListPanel();
        scheduleList.setBounds(0, 0, 976, 654);
        scheduleList.setVisible(true);
        schedule.containPanel.add(scheduleList);
        MainDesktopPane.add(schedule);
        MainDesktopPane.updateUI();
    }//GEN-LAST:event_miSchduleActionPerformed

    private void miNewNutritionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewNutritionActionPerformed
        MainDesktopPane.removeAll();
        NutrientMainPanel mainPanel = new NutrientMainPanel();
        mainPanel.setVisible(true);
        mainPanel.setBounds(0, 0, 1000, 716);
        MainDesktopPane.add(mainPanel);
        mainPanel.showNewPanel();
    }//GEN-LAST:event_miNewNutritionActionPerformed

    private void miViewNutritionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewNutritionActionPerformed
        MainDesktopPane.removeAll();
        NutrientMainPanel mainPanel = new NutrientMainPanel();
        mainPanel.setVisible(true);
        mainPanel.setBounds(0, 0, 1000, 716);
        MainDesktopPane.add(mainPanel);
        mainPanel.showViewPanel();
    }//GEN-LAST:event_miViewNutritionActionPerformed

    private void miViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewActionPerformed
        MainDesktopPane.removeAll();
        FitnessMainPanel fitnessPanel = new FitnessMainPanel();
        fitnessPanel.setVisible(true);
        fitnessPanel.setBounds(0, 0, 1000, 716);
        MainDesktopPane.add(fitnessPanel);
        fitnessPanel.showViewPanel();
    }//GEN-LAST:event_miViewActionPerformed

    private void mnBranchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnBranchMouseClicked
        MainDesktopPane.removeAll();
        BranchMainPanel branchMain = new BranchMainPanel();
        branchMain.setVisible(true);
        branchMain.setBounds(0, 0, 1000, 716);
        MainDesktopPane.add(branchMain);
        branchMain.showViewPanel();
    }//GEN-LAST:event_mnBranchMouseClicked

    private void mnStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStoreMouseClicked
        MainDesktopPane.removeAll();
        StoreMainInterface storeMain = new StoreMainInterface();
        storeMain.setVisible(true);
        storeMain.setBounds(0, 0, 1000, 716);
        MainDesktopPane.add(storeMain);
    }//GEN-LAST:event_mnStoreMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        while (userType != 1 && userType != 2) {
//            login();
//        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainInterface().setVisible(true);

            // test method DAO
            // DAO conn = new DAO();
            //conn.testInsert();
            //conn.testUpdate();
            //conn.testSelect();
            //conn.testDelete();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane MainDesktopPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miEmployee;
    private javax.swing.JMenuItem miNewFitness;
    private javax.swing.JMenuItem miNewMember;
    private javax.swing.JMenuItem miNewNutrition;
    private javax.swing.JMenuItem miNewOrder;
    private javax.swing.JMenuItem miSchdule;
    private javax.swing.JMenuItem miView;
    private javax.swing.JMenuItem miViewMember;
    private javax.swing.JMenuItem miViewNutrition;
    private javax.swing.JMenuItem miViewOrder;
    private javax.swing.JMenu mnAccount;
    private javax.swing.JMenu mnBranch;
    private javax.swing.JMenu mnFitness;
    private javax.swing.JMenu mnLogout;
    private javax.swing.JMenu mnMember;
    private javax.swing.JMenu mnNews;
    private javax.swing.JMenu mnNutrition;
    private javax.swing.JMenu mnOrder;
    private javax.swing.JMenu mnStore;
    private javax.swing.JMenu mnStory;
    // End of variables declaration//GEN-END:variables

    //custom-code
    public static MainInterface mainInterface;
    public static int userType;

    //@viet
    private static boolean login() {
        try {
            JDialog dlgLogin = new JDialog(mainInterface, "Login", true);
            LoginPanel pnLogin = new LoginPanel();
            JButton btnLogin = new JButton("Login");
            btnLogin.setBounds(92, 99, 90, 30);
            JButton btnExit = new JButton("Exit");
            btnExit.setBounds(182, 99, 90, 30);
            btnLogin.addActionListener((ActionEvent e) -> {
                int type = Login.authenticate(pnLogin.getTxtUsername(), pnLogin.getTxtPassword());
                switch (type) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "You have successfully logged in as user!");
                        userType = 1;
                        dlgLogin.dispose();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "You have successfully logged in as admin.!");
                        userType = 2;
                        dlgLogin.dispose();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Wrong username or password!");
                        break;
                }
            });
            btnExit.addActionListener((ActionEvent e) -> {
                System.exit(0);
            });
            pnLogin.pnMain.add(btnLogin);
            pnLogin.pnMain.add(btnExit);
            pnLogin.repaint();
            pnLogin.revalidate();
            dlgLogin.add(pnLogin);
            dlgLogin.pack();
            final Toolkit toolkit = Toolkit.getDefaultToolkit();
            final Dimension screenSize = toolkit.getScreenSize();
            final int x = (screenSize.width - dlgLogin.getWidth()) / 2;
            final int y = (screenSize.height - dlgLogin.getHeight()) / 2;
            dlgLogin.setLocation(x, y);
            dlgLogin.setVisible(true);
        } catch (HeadlessException e) {
            System.out.println("MainInterface - login: " + e);
        }
        return false;
    }
    //end custom-code
}