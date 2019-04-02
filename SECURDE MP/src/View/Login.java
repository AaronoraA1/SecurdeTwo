
package View;

import Controller.SQLite;
import Model.User;

import javax.swing.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Login extends javax.swing.JPanel {

    public Frame frame;
    public SQLite sql;

    private static final File FILENAME = new File("logs/logs.txt");

    private ArrayList<User> users;

    private int loginAttempts;
    private int secondsPassed;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtLogUsername = new javax.swing.JTextField();
        txtLogPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        txtLogUsername.setBackground(new java.awt.Color(240, 240, 240));
        txtLogUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLogUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLogUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        txtLogPassword.setBackground(new java.awt.Color(240, 240, 240));
        txtLogPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLogPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLogPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N


        btnRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        errorMessage.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtLogUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtLogPassword))
                                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(96, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtLogUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(95, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {

        users = this.frame.main.sqlite.getUsers();
        boolean userFound = false;
        User foundUser = null;
        String inputHashPassword = this.frame.main.hashPassword(txtLogPassword.getText());

        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(txtLogUsername.getText() ) &&
                    user.getPassword().equals(inputHashPassword)){
                userFound = true;
                foundUser = user;
                break;
            }
        }
        if(userFound){
            loginAttempts = 0;
            this.frame.main.writeLogs(newLog(txtLogUsername.getText(), inputHashPassword, userFound));
            clearFields();
            frame.setUser(foundUser);
            frame.mainNav();
        }
        else{
            this.frame.main.writeLogs(newLog(txtLogUsername.getText(), txtLogPassword.getText(), userFound));
            loginAttempts++;
            errorMessage.setText("Failed login attempts [" + loginAttempts + "/3]");

            if(loginAttempts == 3){
                loginAttempts = 0;
                JOptionPane.showMessageDialog(null, "Please try again after 30 seconds");
                clearFields();
                btnLogin.setEnabled(false);
                failedLogin();
            }
        }
    }

    private void failedLogin(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
                secondsPassed++;

                if(secondsPassed >= 30){
                    btnLogin.setEnabled(true);
                    timer.cancel();
                    secondsPassed = 0;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields();
        frame.registerNav();
    }

    public void clearFields(){
        txtLogUsername.setText("");
        txtLogPassword.setText("");
        errorMessage.setText("");
    }



    public String newLog(String username, String password, boolean isSuccessful){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();

        if(!isSuccessful){
            return df.format(dateobj) + " : " + "FAILED LOGIN ATTEMPT [" + username + ", " + password +"]";
        }else{
            return df.format(dateobj) + " :  LOGGED IN [" + username + "]";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtLogPassword;
    private javax.swing.JTextField txtLogUsername;
    // End of variables declaration//GEN-END:variables
}
