package View.MaHoa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountVerificationService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/quanlykhachsan";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public boolean verifyAccount(String accountNumber, String pin) {
        String hashedAccountNumber = hashAccountNumber(accountNumber);
        String hashedPin = hashPin(pin);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "SELECT * FROM accounts WHERE account_number_hash = ? AND pin = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, hashedAccountNumber);
            stmt.setString(2, hashedPin);
            rs = stmt.executeQuery();

            return rs.next(); // true nếu có dòng dữ liệu trả về, ngược lại false
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
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
