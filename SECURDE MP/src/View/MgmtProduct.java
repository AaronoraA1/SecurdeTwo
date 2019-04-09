/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Main;
import Controller.SQLite;
import Model.Product;
import Model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author beepxD
 */
public class MgmtProduct extends javax.swing.JPanel {

    public Main main;
    public SQLite sqlite;
    public DefaultTableModel tableModel;

    private User user;
    private int roleID;


    public MgmtProduct(SQLite sqlite) {
        this.main = new Main();
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel) table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

//        UNCOMMENT TO DISABLE BUTTONS
//        btnPurchase.setVisible(false);
//        btnAdd.setVisible(false);
//        btnEdit.setVisible(false);
//        btnDelete.setVisible(false);
    }

    public void init(User user) {

        this.setUser(user);
        main.writeLogs(newLog(this.user.getUsername()) + " accessed Products");

        //      CLEAR TABLE
        for (int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--) {
            tableModel.removeRow(0);
        }

//      LOAD CONTENTS
        ArrayList<Product> products = sqlite.getProduct();

        for (int nCtr = 0; nCtr < products.size(); nCtr++) {
            tableModel.addRow(new Object[]{
                    products.get(nCtr).getName(),
                    products.get(nCtr).getStock(),
                    products.get(nCtr).getPrice()});
        }

        if (this.getRoleID() == 2) {
            btnAdd.setVisible(false);
            btnEdit.setVisible(false);
            btnDelete.setVisible(false);
        } else if (this.getRoleID() == 3) {
            btnAdd.setVisible(false);
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
        btnPurchase = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Name", "Stock", "Price"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        btnPurchase.setBackground(new java.awt.Color(255, 255, 255));
        btnPurchase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPurchase.setText("PURCHASE");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setToolTipText("");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)
                                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)
                                                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );


    }// </editor-fold>//GEN-END:initComponents

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed

        if (table.getSelectedRow() >= 0) {
            JTextField stockFld = new JTextField("0");
            designer(stockFld, "PRODUCT STOCK");

            String itemBought = tableModel.getValueAt(table.getSelectedRow(), 0).toString();

            Object[] message = {
                    "How many " + itemBought + " do you want to purchase?", stockFld
            };

            main.writeLogs(newLog(user.getUsername()) + " attempted to purchase " + itemBought);

            int result = JOptionPane.showConfirmDialog(null, message, "PURCHASE PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            int numStocks = Integer.parseInt(stockFld.getText());
            int stocksLeft = Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 1).toString());

            if (result == JOptionPane.OK_OPTION) {
                if(numStocks <= stocksLeft){
                    System.out.println(this.getUser().getUsername() + " purchased " +
                            itemBought + " Quantity: " + numStocks);
                    main.writeLogs(newLog(user.getUsername()) + " purchased " + stockFld.getText() + " " + itemBought + "/s");
                    sqlite.purchaseProduct(itemBought, stocksLeft - numStocks);
                    init(this.getUser());
                }else{
                    JOptionPane.showMessageDialog(null, "Insufficient stock!");
                }

            }
        }
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JTextField nameFld = new JTextField();
        JTextField stockFld = new JTextField();
        JTextField priceFld = new JTextField();

        designer(nameFld, "PRODUCT NAME");
        designer(stockFld, "PRODUCT STOCK");
        designer(priceFld, "PRODUCT PRICE");

        Object[] message = {
                "Insert New Product Details:", nameFld, stockFld, priceFld
        };

        JTextField confirmIdentity = new JPasswordField();
        designer(confirmIdentity, "PASSWORD");

        Object[] confirmMessage = {
                "Enter Password:", confirmIdentity
        };

        main.writeLogs(newLog(user.getUsername()) + " attempted to add an item");

        int result = JOptionPane.showConfirmDialog(null, message, "ADD PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
        String name = nameFld.getText();
        int stock = Integer.parseInt(stockFld.getText());
        float price = Float.valueOf(priceFld.getText());

        if (result == JOptionPane.OK_OPTION) {

            int confirm = JOptionPane.showConfirmDialog(null,
                    confirmMessage, "Confirm Identity", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null);

            if (confirm == JOptionPane.OK_OPTION) {
                if (main.hashPassword(confirmIdentity.getText()).equals(this.getUser().getPassword())) {
                    sqlite.addProduct(name, stock, price);
                    init(this.getUser());
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!");
                }
            }

        }

        main.writeLogs(newLog(user.getUsername()) + " added " + nameFld.getText() + " Stock: " + stockFld.getText() + " Price: " + priceFld.getText());
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (table.getSelectedRow() >= 0) {
            JTextField nameFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 0) + "");
            JTextField stockFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 1) + "");
            JTextField priceFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 2) + "");

            designer(nameFld, "PRODUCT NAME");
            designer(stockFld, "PRODUCT STOCK");
            designer(priceFld, "PRODUCT PRICE");

            Object[] message = {
                    "Edit Product Details:", nameFld, stockFld, priceFld
            };

            JTextField confirmIdentity = new JPasswordField();
            designer(confirmIdentity, "PASSWORD");

            Object[] confirmMessage = {
                    "Enter Password:", confirmIdentity
            };

            main.writeLogs(newLog(user.getUsername()) + " attempted to edit an item");

            int result = JOptionPane.showConfirmDialog(null, message, "EDIT PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            String oldName = String.valueOf(tableModel.getValueAt(table.getSelectedRow(), 0));
            String name = nameFld.getText();
            int stock = Integer.parseInt(stockFld.getText());
            float price = Float.valueOf(priceFld.getText());


            if (result == JOptionPane.OK_OPTION) {

                int confirm = JOptionPane.showConfirmDialog(null,
                        confirmMessage, "Confirm Identity", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null);

                if (confirm == JOptionPane.OK_OPTION) {
                    if (main.hashPassword(confirmIdentity.getText()).equals(this.getUser().getPassword())) {
                        sqlite.editProduct(oldName, name, stock, price);
                        init(this.getUser());
                        main.writeLogs(newLog(user.getUsername()) + " edited " + name);
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match!");
                    }
                }

            }

            main.writeLogs(newLog(user.getUsername()) + " edited " + nameFld.getText() + "Stock: " + stockFld.getText() + " Price: " + priceFld.getText());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        main.writeLogs(newLog(user.getUsername()) + " attempted to delete an item");

        String deletedItem = tableModel.getValueAt(table.getSelectedRow(), 0).toString();

        JTextField confirmIdentity = new JPasswordField();
        designer(confirmIdentity, "PASSWORD");

        Object[] confirmMessage = {
                "Enter Password:", confirmIdentity
        };

        if (table.getSelectedRow() >= 0) {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + deletedItem + "?", "DELETE PRODUCT", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {

                int confirm = JOptionPane.showConfirmDialog(null,
                        confirmMessage, "Confirm Identity", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null);

                if (confirm == JOptionPane.OK_OPTION) {
                    if (main.hashPassword(confirmIdentity.getText()).equals(this.getUser().getPassword())) {
                        sqlite.removeProduct(deletedItem);
                        init(this.getUser());
                        System.out.println("Deleted " + deletedItem);
                        main.writeLogs(newLog(user.getUsername()) + " deleted " + deletedItem);
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match!");
                    }
                }

            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    public String newLog(String user) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        return df.format(dateobj) + " : " + user;
    }


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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
