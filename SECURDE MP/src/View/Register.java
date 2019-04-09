
package View;

import Model.User;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Register extends javax.swing.JPanel {

    public Frame frame;

    private ArrayList<User> users;

    List<String> lower = new ArrayList<>();
    List<String> upper = new ArrayList<>();
    List<String> numbers = new ArrayList<>();
    List<String> symbols = new ArrayList<>();


    public Register() {
        initComponents();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String symbol = "!@#$%^&*()";

        for (int i = 0; i < 26; i++) {
            lower.add(String.valueOf(alphabet.charAt(i)));
        }

        for (int i = 0; i < 26; i++) {
            upper.add(String.valueOf(alphabet.charAt(i)).toUpperCase());
        }

        for (int i = 0; i < 10; i++) {
            numbers.add(String.valueOf(number.charAt(i)));
        }

        for (int i = 0; i < 10; i++) {
            symbols.add(String.valueOf(symbol.charAt(i)));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        btnRegister = new javax.swing.JButton();
        txtRegPassword = new javax.swing.JPasswordField();
        txtRegUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtRegConfirm = new javax.swing.JPasswordField();
        btnBackToLogin = new javax.swing.JButton();

        btnRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        txtRegPassword.setBackground(new java.awt.Color(240, 240, 240));
        txtRegPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRegPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        txtRegUsername.setBackground(new java.awt.Color(240, 240, 240));
        txtRegUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRegUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        txtRegConfirm.setBackground(new java.awt.Color(240, 240, 240));
        txtRegConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRegConfirm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegConfirm.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btnBackToLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnBackToLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBackToLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnBackToLogin.setText("<Back");
        btnBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(200, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtRegUsername)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtRegPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRegConfirm, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(200, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBackToLogin)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBackToLogin)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(txtRegUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRegPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRegConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {

        boolean small = false;
        boolean big = false;
        boolean number = false;
        boolean symbol = false;

        users = frame.main.sqlite.getUsers();
        boolean userFound = false;
        String hashedPassword = this.frame.main.hashPassword(txtRegPassword.getText());

        // checks for nulll input
        if (!txtRegUsername.getText().isEmpty() && !txtRegPassword.getText().isEmpty() && !txtRegConfirm.getText().isEmpty()) {
            // checks for password meets the character limit range
            if (txtRegPassword.getText().length() < 33 && txtRegPassword.getText().length() > 7) {
                for (int i = 0; i < txtRegPassword.getText().length(); i++) {
                    if (upper.contains(String.valueOf(txtRegPassword.getText().charAt(i)))) {
                        big = true;
                    }
                    if (lower.contains(String.valueOf(txtRegPassword.getText().charAt(i)))) {
                        small = true;
                    }
                    if (numbers.contains(String.valueOf(txtRegPassword.getText().charAt(i)))) {
                        number = true;
                    }
                    if (symbols.contains(String.valueOf(txtRegPassword.getText().charAt(i)))) {
                        symbol = true;
                    }

                    // checks for password has 12-32 characters with 1 small, capital, number, and symbol
                    if (big && small && number && symbol) {
                        break;
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Password should contain 12 to 32 characters");
                txtRegUsername.setText("");
                txtRegPassword.setText("");
                txtRegConfirm.setText("");
            }

            if (big && small && number && symbol) {
                if (txtRegPassword.getText().equals(txtRegConfirm.getText())) {

                    for (User user : users) {
                        if (user.getUsername().equalsIgnoreCase(txtRegUsername.getText())) {
                            userFound = true;
                            break;
                        }
                    }

                    if (userFound) {
                        JOptionPane.showMessageDialog(null, "User already exists!");
                        this.frame.main.writeLogs(newLog(txtRegUsername.getText(), txtRegPassword.getText(), userFound));
                        txtRegPassword.setText("");
                        txtRegConfirm.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Registered successfully!");
                        this.frame.main.writeLogs(newLog(txtRegUsername.getText(), hashedPassword, userFound));
                        frame.main.sqlite.addUser(txtRegUsername.getText(), hashedPassword, 2);
                        frame.main.sqlite.getUser(txtRegUsername.getText(), hashedPassword);
                        User newlyRegistered = new User(users.size() + 1, txtRegUsername.getText(), hashedPassword, 2, 0);
                        System.out.println(newlyRegistered.toString());
                        this.getUsers().add(newlyRegistered);
                        txtRegUsername.setText("");
                        txtRegPassword.setText("");
                        txtRegConfirm.setText("");
                        frame.loginNav();

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Passwords don't match!");
                    txtRegPassword.setText("");
                    txtRegConfirm.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Input. Should contain atleast 1 small, capital, number, and symbol.");
                txtRegUsername.setText("");
                txtRegPassword.setText("");
                txtRegConfirm.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Null input detected! ");
        }

    }

    private void btnBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {
        txtRegUsername.setText("");
        txtRegPassword.setText("");
        txtRegConfirm.setText("");

        frame.loginNav();
    }

    public String newLog(String username, String password, boolean isSuccessful) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();

        if (isSuccessful) {
            return df.format(dateobj) + " : " + "FAILED REGISTER ATTEMPT (User :" + username + " already exists)";
        } else {
            return df.format(dateobj) + " : REGISTERED (" + username + ")";
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtRegConfirm;
    private javax.swing.JTextField txtRegPassword;
    private javax.swing.JTextField txtRegUsername;
    // End of variables declaration//GEN-END:variables
}
