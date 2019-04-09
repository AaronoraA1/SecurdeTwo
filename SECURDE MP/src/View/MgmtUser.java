/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Main;
import Controller.SQLite;
import Model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author beepxD
 */
public class MgmtUser extends javax.swing.JPanel {

    public Main main;
    public SQLite sqlite;
    public DefaultTableModel tableModel;


    private User user;
    private int roleID;

    public MgmtUser(SQLite sqlite) {
        this.main = new Main();
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel) table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

//        UNCOMMENT TO DISABLE BUTTONS
//        editBtn.setVisible(false);
//        btnDelete.setVisible(false);
//        btnLock.setVisible(false);
//        btnChangePass.setVisible(false);
    }

    public void init(User user) {
        this.setUser(user);
        main.writeLogs(newLog(this.user.getUsername()) + " accessed Users");
        //      CLEAR TABLE
        for (int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--) {
            tableModel.removeRow(0);
        }

//      LOAD CONTENTS
        ArrayList<User> users = sqlite.getUsers();

        if (this.getRoleID() == 5) {
            for (int nCtr = 0; nCtr < users.size(); nCtr++) {
                tableModel.addRow(new Object[]{
                        users.get(nCtr).getUsername(),
                        users.get(nCtr).getPassword(),
                        users.get(nCtr).getRole(),
                        users.get(nCtr).getLocked()});
            }
        } else if (this.getRoleID() == 4) {
            for (int nCtr = 0; nCtr < users.size(); nCtr++) {
                if (users.get(nCtr).getRole() == 3 || users.get(nCtr).getRole() == 2)
                    tableModel.addRow(new Object[]{
                            users.get(nCtr).getUsername(),
                            users.get(nCtr).getPassword(),
                            users.get(nCtr).getRole(),
                            users.get(nCtr).getLocked()});
            }

            btnChangePass.setVisible(false);

        } else if (this.getRoleID() == 3) {
            for (int nCtr = 0; nCtr < users.size(); nCtr++) {
                if (users.get(nCtr).getRole() == 2)
                    tableModel.addRow(new Object[]{
                            users.get(nCtr).getUsername(),
                            users.get(nCtr).getPassword(),
                            users.get(nCtr).getRole(),
                            users.get(nCtr).getLocked()});
            }

            btnChangePass.setVisible(false);
            btnEditRole.setVisible(false);
            btnDelete.setVisible(false);
        }
    }

    public void designer(JTextField component, String text) {
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnEditRole = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLock = new javax.swing.JButton();
        btnChangePass = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Username", "Password", "Role", "Locked"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(160);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnEditRole.setBackground(new java.awt.Color(255, 255, 255));
        btnEditRole.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditRole.setText("EDIT ROLE");
        btnEditRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRoleActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnLock.setBackground(new java.awt.Color(255, 255, 255));
        btnLock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLock.setText("LOCK/UNLOCK");
        btnLock.setToolTipText("");
        btnLock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLockActionPerformed(evt);
            }
        });

        btnChangePass.setBackground(new java.awt.Color(255, 255, 255));
        btnChangePass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChangePass.setText("CHANGE PASS");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnEditRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)
                                                .addComponent(btnLock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)
                                                .addComponent(btnChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditRole, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLock, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRoleActionPerformed
        if (table.getSelectedRow() >= 0) {
            String[] options = {"1-DISABLED", "2-CLIENT", "3-STAFF", "4-MANAGER", "5-ADMIN"};
            JComboBox optionList = new JComboBox(options);

            String selectedUser = tableModel.getValueAt(table.getSelectedRow(), 0).toString();

            main.writeLogs(newLog(user.getUsername()) + " attempted to edit the role of " + selectedUser);

            optionList.setSelectedIndex((int) tableModel.getValueAt(table.getSelectedRow(), 2) - 1);

            String result = (String) JOptionPane.showInputDialog(null, "USER: " + selectedUser,
                    "EDIT USER ROLE", JOptionPane.QUESTION_MESSAGE, null, options, options[(int) tableModel.getValueAt(table.getSelectedRow(), 2) - 1]);

            if (result != null) {
                System.out.println(selectedUser);
                System.out.println(result.charAt(0));

                main.writeLogs(newLog(user.getUsername()) + " edited the role of " + selectedUser + " to " + options[result.charAt(0)]);

            }
        }
    }//GEN-LAST:event_btnEditRoleActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        String selectedUser = tableModel.getValueAt(table.getSelectedRow(), 0).toString();

        if (table.getSelectedRow() >= 0) {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + selectedUser +
                    "?", "DELETE USER", JOptionPane.YES_NO_OPTION);

            main.writeLogs(newLog(user.getUsername()) + " attempted to delete " + selectedUser);

            if (result == JOptionPane.YES_OPTION) {

                sqlite.removeUser(selectedUser);
                init(this.getUser());
                System.out.println(selectedUser);
                main.writeLogs(newLog(user.getUsername()) + " deleted " + selectedUser);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLockActionPerformed
        if (table.getSelectedRow() >= 0) {
            String state = "lock";
            if ("1".equals(tableModel.getValueAt(table.getSelectedRow(), 3) + "")) {
                state = "unlock";
            }

            String selectedUser = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
            main.writeLogs(newLog(user.getUsername()) + " attempted to lock/unlock " + selectedUser);


            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + state + " " + selectedUser
                    + "?", "DELETE USER", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                System.out.println(selectedUser);
                main.writeLogs(newLog(user.getUsername()) + " locked/unlocked " + selectedUser);
            }
        }
    }//GEN-LAST:event_btnLockActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        if (table.getSelectedRow() >= 0) {


            String selectedUser = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
            main.writeLogs(newLog(user.getUsername()) + " attempted to change password of " + selectedUser);

            JTextField password = new JPasswordField();
            JTextField confpass = new JPasswordField();
            designer(password, "PASSWORD");
            designer(confpass, "CONFIRM PASSWORD");

            Object[] message = {
                    "Enter New Password:", password, confpass
            };

            int result = JOptionPane.showConfirmDialog(null, message, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            if (result == JOptionPane.OK_OPTION) {
                System.out.println(password.getText());
                System.out.println(confpass.getText());
                main.writeLogs(newLog(user.getUsername()) + " change password to " + password.getText()); // hash it later
            }
        }
    }//GEN-LAST:event_btnChangePassActionPerformed

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String newLog(String user) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        return df.format(dateobj) + " : " + user;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditRole;
    private javax.swing.JButton btnLock;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
