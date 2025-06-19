package View.MaHoa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRegistrationService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/quanlykhachsan";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public void registerAccount(String accountNumber, String pin, String fullName, String email, String phoneNumber) {
        String hashedAccountNumber = hashAccountNumber(accountNumber);
        String hashedPin = hashPin(pin);

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "INSERT INTO accounts (account_number_hash, pin, fullname, email, phone_number, registration_date) "
                    + "VALUES (?, ?, ?, ?, ?, NOW())";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, hashedAccountNumber);
            stmt.setString(2, hashedPin);
            stmt.setString(3, fullName);
            stmt.setString(4, email);
            stmt.setString(5, phoneNumber);

            stmt.executeUpdate();
            System.out.println("Account registered successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String hashAccountNumber(String accountNumber) {
        return hashString(accountNumber);
    }

    private String hashPin(String pin) {
        return hashString(pin);
    }

    private String hashString(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(input.getBytes());
            return bytesToHex(hashedBytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
