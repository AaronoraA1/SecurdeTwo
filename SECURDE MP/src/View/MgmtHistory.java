/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Main;
import Controller.SQLite;
import Model.History;
import Model.Product;
import Model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author beepxD
 */
public class MgmtHistory extends javax.swing.JPanel {

    private static final File DATABASE_HISTORIES = new File("database/database_histories.txt");
    private static final File DATABASE_PRODUCTS = new File("database/database_products.txt");

    public Main main;
    public SQLite sqlite;
    public DefaultTableModel tableModel;

    private int roleID;
    private User user;

    public MgmtHistory(SQLite sqlite) {
        this.main = new Main();
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel) table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        javax.swing.table.DefaultTableCellRenderer rightAlign = new javax.swing.table.DefaultTableCellRenderer();
        rightAlign.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        table.getColumnModel().getColumn(2).setCellRenderer(rightAlign);
        table.getColumnModel().getColumn(3).setCellRenderer(rightAlign);
        table.getColumnModel().getColumn(4).setCellRenderer(rightAlign);
        table.getColumnModel().getColumn(5).setCellRenderer(rightAlign);

//        UNCOMMENT TO DISABLE BUTTONS
//        btnSearch.setVisible(false);
//        reportBtn.setVisible(false);
    }

    public void init(User user) {

        this.setUser(user);
        main.writeLogs(newLog(this.user.getUsername()) + " accessed History");
//      CLEAR TABLE
        for (int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--) {
            tableModel.removeRow(0);
        }

//      LOAD CONTENT
//        loaded data from csv to avoid NullPointerException when deleting a product which is used in populating history

        List<History> history = new ArrayList<>();
        List<Product> product = new ArrayList<>();
        try {
            String line = null;

            // wrap a BufferedReader around FileReader
            BufferedReader bufferedReader1;
            bufferedReader1 = new BufferedReader(new FileReader(DATABASE_HISTORIES));
            BufferedReader bufferedReader2;
            bufferedReader2 = new BufferedReader(new FileReader(DATABASE_PRODUCTS));

            // use the readLine method of the BufferedReader to read one line at a time.
            // the readLine method returns null when there is nothing else to read.
            while ((line = bufferedReader1.readLine()) != null) {
                String[] data = line.split(",");
                history.add(new History(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), data[4]));
            }

            while ((line = bufferedReader2.readLine()) != null) {
                String[] data = line.split(",");
                product.add(new Product(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Float.valueOf(data[3])));
            }

            // close the BufferedReader when we're done
            bufferedReader1.close();
            bufferedReader2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (this.getRoleID() == 5) {
            Product tempProduct = null;

            for (int nCtr = 0; nCtr < history.size(); nCtr++) {
                for (int i = 0; i < product.size(); i++) {
                    if (product.get(i).getName().equals(history.get(nCtr).getName())) {
                        tempProduct = product.get(i);
                        break;
                    }
                }
                tableModel.addRow(new Object[]{
                        history.get(nCtr).getUsername(),
                        history.get(nCtr).getName(),
                        history.get(nCtr).getStock(),
                        tempProduct.getPrice(),
                        tempProduct.getPrice() * history.get(nCtr).getStock(),
                        history.get(nCtr).getTimestamp()
                });
            }
        } else {
            Product tempProduct = null;
            for (int nCtr = 0; nCtr < history.size(); nCtr++) {
                if (!history.get(nCtr).getUsername().equalsIgnoreCase("admin")) {

                    for (int i = 0; i < product.size(); i++) {
                        if (product.get(i).getName().equals(history.get(nCtr).getName())) {
                            tempProduct = product.get(i);
                            break;
                        }
                    }

                    tableModel.addRow(new Object[]{
                            history.get(nCtr).getUsername(),
                            history.get(nCtr).getName(),
                            history.get(nCtr).getStock(),
                            tempProduct.getPrice(),
                            tempProduct.getPrice() * history.get(nCtr).getStock(),
                            history.get(nCtr).getTimestamp()
                    });
                }


            }
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
        btnSearch = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Username", "Name", "Stock", "Price", "Total", "Timestamp"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
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
            table.getColumnModel().getColumn(1).setPreferredWidth(160);
            table.getColumnModel().getColumn(2).setMinWidth(80);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(240);
        }

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setText("SEARCH USERNAME OR PRODUCT");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReload.setBackground(new java.awt.Color(255, 255, 255));
        btnReload.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReload.setText("RELOAD");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
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
                                                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)
                                                .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        main.writeLogs(newLog(user.getUsername()) + " attempted to search history");

        JTextField searchFld = new JTextField("0");
        designer(searchFld, "SEARCH USERNAME OR PRODUCT");

        Object[] message = {
                searchFld
        };

        int result = JOptionPane.showConfirmDialog(null, message, "SEARCH HISTORY", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

        if (result == JOptionPane.OK_OPTION) {

            main.writeLogs(newLog(user.getUsername()) + " searched " + searchFld.getText() + " in history");

//          CLEAR TABLE
            for (int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--) {
                tableModel.removeRow(0);
            }

//          LOAD CONTENTS
            ArrayList<History> history = sqlite.getHistory();
            for (int nCtr = 0; nCtr < history.size(); nCtr++) {
                if (searchFld.getText().equalsIgnoreCase(history.get(nCtr).getUsername()) ||
                        history.get(nCtr).getUsername().equalsIgnoreCase(searchFld.getText()) ||
                        searchFld.getText().equalsIgnoreCase(history.get(nCtr).getName()) ||
                        history.get(nCtr).getName().equalsIgnoreCase(searchFld.getText())) {

                    Product product = sqlite.getProduct(history.get(nCtr).getName());
                    tableModel.addRow(new Object[]{
                            history.get(nCtr).getUsername(),
                            history.get(nCtr).getName(),
                            history.get(nCtr).getStock(),
                            product.getPrice(),
                            product.getPrice() * history.get(nCtr).getStock(),
                            history.get(nCtr).getTimestamp()
                    });
                    // if manager searched for admin-related history, dont show
                    if (user.getRole() == 4 && searchFld.getText().equalsIgnoreCase("admin")) {
                        tableModel.removeRow(tableModel.getRowCount() - 1);
                    }

                }
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        main.writeLogs(newLog(user.getUsername()) + " reloaded history");
        init(this.getUser());
    }//GEN-LAST:event_btnReloadActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
