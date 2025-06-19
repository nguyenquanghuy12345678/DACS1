
package View.MaHoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountRegistrationFrame extends JFrame {

    private JTextField accountNumberField;
    private JPasswordField pinField;
    private JTextField fullNameField;
    private JTextField emailField;
    private JTextField phoneNumberField;

    public AccountRegistrationFrame() {
        super("Account Registration");

        // Thiết lập JFrame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel chứa các thành phần
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Label và TextField cho số tài khoản
        JLabel accountLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField();
        panel.add(accountLabel);
        panel.add(accountNumberField);

        // Label và TextField cho mã PIN
        JLabel pinLabel = new JLabel("PIN:");
        pinField = new JPasswordField();
        panel.add(pinLabel);
        panel.add(pinField);

        // Label và TextField cho họ và tên
        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameField = new JTextField();
        panel.add(fullNameLabel);
        panel.add(fullNameField);

        // Label và TextField cho email
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailField);

        // Label và TextField cho số điện thoại
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);

        // Button đăng ký
        JButton registerButton = new JButton("Register Account");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                String pin = new String(pinField.getPassword());
                String fullName = fullNameField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();

                // Gọi phương thức từ service để đăng ký tài khoản
                AccountRegistrationService registrationService = new AccountRegistrationService();
                registrationService.registerAccount(accountNumber, pin, fullName, email, phoneNumber);
            }
        });
        panel.add(registerButton);

        // Button kiểm tra tài khoản
        JButton checkAccountButton = new JButton("Check Account");
        checkAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                String pin = new String(pinField.getPassword());
                String fullName = fullNameField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();

                // Chuyển sang frame kiểm tra tài khoản
                new AccountVerificationFrame(accountNumber, pin).setVisible(true);
            }
        });
        panel.add(checkAccountButton);

        // Đặt panel vào JFrame
        add(panel);

        // Hiển thị JFrame
        setLocationRelativeTo(null); // Đặt cửa sổ JFrame vào giữa màn hình
        setVisible(true);
    }

    public String[] getAccountInfo() {
        String accountNumber = accountNumberField.getText();
        String pin = new String(pinField.getPassword());
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();

        return new String[]{accountNumber, pin, fullName, email, phoneNumber};
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccountRegistrationFrame();
            }
        });
    }
}

//package View;
//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class AccountRegistrationFrame extends JFrame {
//
//    private JTextField accountNumberField;
//    private JPasswordField pinField;
//    private JTextField fullNameField;
//    private JTextField emailField;
//    private JTextField phoneNumberField;
//
//    public AccountRegistrationFrame() {
//        super("Account Registration");
//
//        // Thiết lập JFrame
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Panel chứa các thành phần
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(6, 2, 10, 10));
//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
//        // Label và TextField cho số tài khoản
//        JLabel accountLabel = new JLabel("Account Number:");
//        accountNumberField = new JTextField();
//        panel.add(accountLabel);
//        panel.add(accountNumberField);
//
//        // Label và TextField cho mã PIN
//        JLabel pinLabel = new JLabel("PIN:");
//        pinField = new JPasswordField();
//        panel.add(pinLabel);
//        panel.add(pinField);
//
//        // Label và TextField cho họ và tên
//        JLabel fullNameLabel = new JLabel("Full Name:");
//        fullNameField = new JTextField();
//        panel.add(fullNameLabel);
//        panel.add(fullNameField);
//
//        // Label và TextField cho email
//        JLabel emailLabel = new JLabel("Email:");
//        emailField = new JTextField();
//        panel.add(emailLabel);
//        panel.add(emailField);
//
//        // Label và TextField cho số điện thoại
//        JLabel phoneNumberLabel = new JLabel("Phone Number:");
//        phoneNumberField = new JTextField();
//        panel.add(phoneNumberLabel);
//        panel.add(phoneNumberField);
//
//        // Button đăng ký
//        JButton registerButton = new JButton("Register Account");
//        registerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String accountNumber = accountNumberField.getText();
//                String pin = new String(pinField.getPassword());
//                String fullName = fullNameField.getText();
//                String email = emailField.getText();
//                String phoneNumber = phoneNumberField.getText();
//
//                // Gọi phương thức từ service để đăng ký tài khoản
//                AccountRegistrationService registrationService = new AccountRegistrationService();
//                registrationService.registerAccount(accountNumber, pin, fullName, email, phoneNumber);
//            }
//        });
//        panel.add(registerButton);
//
//        // Đặt panel vào JFrame
//        add(panel);
//
//        // Hiển thị JFrame
//        setLocationRelativeTo(null); // Đặt cửa sổ JFrame vào giữa màn hình
//        setVisible(true);
//    }
//
//    public String[] getAccountInfo() {
//        String accountNumber = accountNumberField.getText();
//        String pin = new String(pinField.getPassword());
//        String fullName = fullNameField.getText();
//        String email = emailField.getText();
//        String phoneNumber = phoneNumberField.getText();
//
//        return new String[]{accountNumber, pin, fullName, email, phoneNumber};
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new AccountRegistrationFrame();
//            }
//        });
//    }
//}
