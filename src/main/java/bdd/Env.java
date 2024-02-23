package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Env {
    private static final String[] bdd = {"jdbc:mysql://localhost:3306/StockA", "root", ""};
    private static final String encryptionKey = "adupngrx3GXZThd7";

    public static Connection getBdd() {
        try {
            return DriverManager.getConnection(bdd[0], bdd[1], bdd[2]);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getEncryptionKey(){
        return encryptionKey;
    }
}
