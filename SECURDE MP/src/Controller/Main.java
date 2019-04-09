package Controller;


import Model.History;
import Model.Logs;
import Model.Product;
import Model.User;
import View.Frame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import static javax.script.ScriptEngine.FILENAME;


public class Main {

    public SQLite sqlite;
    private static final File FILENAME_1 = new File("logs/secret/dont touch this log.txt");
    private static final File FILENAME_2 = new File("logs/logs.txt");
    private static final File DATABASE_HISTORIES = new File("database/database_histories.txt");
    private static final File DATABASE_LOGS = new File("database/database_logs.txt");
    private static final File DATABASE_PRODUCTS = new File("database/database_products.txt");
    private static final File DATABASE_USERS = new File("database/database_users.txt");

    public static void main(String[] args) {
        new Main().init();
    }

    public void init() {
        // Initialize a driver object
        sqlite = new SQLite();


        // Create a database
        sqlite.createNewDatabase();

        // Drop users table if needed
        sqlite.dropHistoryTable();
        sqlite.dropLogsTable();
        sqlite.dropProductTable();
        sqlite.dropUserTable();

        // Create users table if not exist
        sqlite.createHistoryTable();
        sqlite.createLogsTable();
        sqlite.createProductTable();
        sqlite.createUserTable();

        // Add sample history
        sqlite.addHistory("admin", "Antivirus", 1, "2019-04-03 14:30:00.000");
        sqlite.addHistory("manager", "Firewall", 1, "2019-04-03 14:30:01.000");
        sqlite.addHistory("staff", "Scanner", 1, "2019-04-03 14:30:02.000");

        // Add sample logs
        sqlite.addLogs("NOTICE", "admin", "User creation successful", new Timestamp(new Date().getTime()).toString());
        sqlite.addLogs("NOTICE", "manager", "User creation successful", new Timestamp(new Date().getTime()).toString());
        sqlite.addLogs("NOTICE", "admin", "User creation successful", new Timestamp(new Date().getTime()).toString());

        // Add sample product
        sqlite.addProduct("Antivirus", 5, 500.0);
        sqlite.addProduct("Firewall", 3, 1000.0);
        sqlite.addProduct("Scanner", 10, 100.0);

        // Add sample users
        sqlite.addUser("admin", hashPassword("qwerty1234"), 5);
        sqlite.addUser("manager", hashPassword("qwerty1234"), 4);
        sqlite.addUser("staff", hashPassword("qwerty1234"), 3);
        sqlite.addUser("client1", hashPassword("qwerty1234"), 2);
        sqlite.addUser("client2", hashPassword("qwerty1234"), 2);


        // Get users
        ArrayList<History> histories = sqlite.getHistory();
        for (int nCtr = 0; nCtr < histories.size(); nCtr++) {
            System.out.println("===== History " + histories.get(nCtr).getId() + " =====");
            System.out.println(" Username: " + histories.get(nCtr).getUsername());
            System.out.println(" Name: " + histories.get(nCtr).getName());
            System.out.println(" Stock: " + histories.get(nCtr).getStock());
            System.out.println(" Timestamp: " + histories.get(nCtr).getTimestamp());
        }

        // Get users
        ArrayList<Logs> logs = sqlite.getLogs();
        for (int nCtr = 0; nCtr < logs.size(); nCtr++) {
            System.out.println("===== Logs " + logs.get(nCtr).getId() + " =====");
            System.out.println(" Username: " + logs.get(nCtr).getEvent());
            System.out.println(" Password: " + logs.get(nCtr).getUsername());
            System.out.println(" Role: " + logs.get(nCtr).getDesc());
            System.out.println(" Timestamp: " + logs.get(nCtr).getTimestamp());
        }

        // Get users
        ArrayList<Product> products = sqlite.getProduct();
        for (int nCtr = 0; nCtr < products.size(); nCtr++) {
            System.out.println("===== Product " + products.get(nCtr).getId() + " =====");
            System.out.println(" Name: " + products.get(nCtr).getName());
            System.out.println(" Stock: " + products.get(nCtr).getStock());
            System.out.println(" Price: " + products.get(nCtr).getPrice());
        }
        // Get users
        ArrayList<User> users = sqlite.getUsers();
        for (int nCtr = 0; nCtr < users.size(); nCtr++) {
            System.out.println("===== User " + users.get(nCtr).getId() + " =====");
            System.out.println(" Username: " + users.get(nCtr).getUsername());
            System.out.println(" Password: " + users.get(nCtr).getPassword());
            System.out.println(" Role: " + users.get(nCtr).getRole());
            System.out.println(" Locked: " + users.get(nCtr).getLocked());
        }

        BufferedWriter bwH = null;
        BufferedWriter bwL = null;
        BufferedWriter bwP = null;
        BufferedWriter bwU = null;
        FileWriter fwH = null;
        FileWriter fwL = null;
        FileWriter fwP = null;
        FileWriter fwU = null;

        try {
            fwH = new FileWriter(DATABASE_HISTORIES, false);
            fwL = new FileWriter(DATABASE_LOGS, false);
            fwP = new FileWriter(DATABASE_PRODUCTS, false);
            fwU = new FileWriter(DATABASE_USERS, false);
            bwH = new BufferedWriter(fwH);
            bwL = new BufferedWriter(fwL);
            bwP = new BufferedWriter(fwP);
            bwU = new BufferedWriter(fwU);

            for (int nCtr = 0; nCtr < histories.size(); nCtr++) {
                bwH.write(histories.get(nCtr).getId() + "," +
                        histories.get(nCtr).getUsername() + "," +
                        histories.get(nCtr).getName() + "," +
                        histories.get(nCtr).getStock() + "," +
                        histories.get(nCtr).getTimestamp() + "\n");
            }

            for (int nCtr = 0; nCtr < logs.size(); nCtr++) {
                bwL.write(logs.get(nCtr).getId() + "," +
                        logs.get(nCtr).getEvent() + "," +
                        logs.get(nCtr).getUsername() + "," +
                        logs.get(nCtr).getDesc() + "," +
                        logs.get(nCtr).getTimestamp() + "\n");
            }

            for (int nCtr = 0; nCtr < products.size(); nCtr++) {
                bwP.write(products.get(nCtr).getId() + "," +
                        products.get(nCtr).getName() + "," +
                        products.get(nCtr).getStock() + "," +
                        products.get(nCtr).getPrice() + "\n");
            }

            for (int nCtr = 0; nCtr < users.size(); nCtr++) {
                bwU.write(users.get(nCtr).getId() + "," +
                        users.get(nCtr).getUsername() + "," +
                        users.get(nCtr).getPassword() + "," +
                        users.get(nCtr).getRole() + "," +
                        users.get(nCtr).getLocked() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bwH != null)
                    bwH.close();
                if (fwH != null)
                    fwH.close();

                if (bwL != null)
                    bwL.close();
                if (fwL != null)
                    fwL.close();

                if (bwP != null)
                    bwP.close();
                if (fwP != null)
                    fwP.close();

                if (bwU != null)
                    bwU.close();
                if (fwU != null)
                    fwU.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        //databaseCSV(histories, logs, products, users);

        // Initialize User Interface
        Frame frame = new Frame();
        frame.init(this);
    }

    public void writeLogs(String newEntry) {

        BufferedWriter bw1 = null;
        BufferedWriter bw2 = null;
        FileWriter fw1 = null;
        FileWriter fw2 = null;

        try {
            fw1 = new FileWriter(FILENAME_1, false);
            fw2 = new FileWriter(FILENAME_2, true);
            bw1 = new BufferedWriter(fw1);
            bw2 = new BufferedWriter(fw2);
            bw1.write(newEntry + "\n");
            bw2.write(newEntry + "\n");

            System.out.println("Log added!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw1 != null)
                    bw1.close();
                if (fw1 != null)
                    fw1.close();

                if (bw2 != null)
                    bw2.close();
                if (fw2 != null)
                    fw2.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public String hashPassword(String password) {
        try {
            MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            String salt = "randomSalt";
            String passWithSalt = password + salt;
            byte[] passBytes = passWithSalt.getBytes();
            byte[] passHash = sha512.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < passHash.length; i++) {
                sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16).substring(1));
            }
            String generatedPassword = sb.toString();
            System.out.println("HASHED PASSWORD >>> " + generatedPassword);
            return generatedPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


}
