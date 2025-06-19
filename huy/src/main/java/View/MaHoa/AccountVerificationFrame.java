
package View.MaHoa;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountVerificationFrame extends JFrame {

    private JTextField accountNumberField;
    private JPasswordField pinField;
    private JLabel resultLabel;
    private AccountVerificationService verificationService;

    public AccountVerificationFrame(String accountNumber, String pin) {
        super("Account Verification");

        verificationService = new AccountVerificationService();

        // Thiết lập JFrame
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel chứa các thành phần
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Label và TextField cho số tài khoản
        JLabel accountLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField(accountNumber);
        accountNumberField.setEditable(false); // Chỉ hiển thị, không cho phép chỉnh sửa
        panel.add(accountLabel);
        panel.add(accountNumberField);

        // Label và TextField cho mã PIN
        JLabel pinLabel = new JLabel("PIN:");
        pinField = new JPasswordField(pin);
        pinField.setEditable(false); // Chỉ hiển thị, không cho phép chỉnh sửa
        panel.add(pinLabel);
        panel.add(pinField);

        // Button kiểm tra
        JButton checkButton = new JButton("Check Account");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                String pin = new String(pinField.getPassword());

                // Kiểm tra thông tin trong cơ sở dữ liệu
                if (verificationService.verifyAccount(accountNumber, pin)) {
                    resultLabel.setText("Account verified_ Đã đúng nhé!");
                } else {
                    resultLabel.setText("Invalid account or PIN.");
                }
            }
        });
        panel.add(checkButton);

        // Label kết quả
        resultLabel = new JLabel();
        panel.add(resultLabel);

        // Đặt panel vào JFrame
        add(panel);

        // Hiển thị JFrame
        setLocationRelativeTo(null); // Đặt cửa sổ JFrame vào giữa màn hình
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccountVerificationFrame("", "");
            }
        });
    }
}


//package View;   cũng tốt , nhưng do thiếu kêts hợp với frame trước
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class AccountVerificationFrame extends JFrame {
//
//    private JTextField accountNumberField;
//    private JPasswordField pinField;
//    private AccountVerificationService verificationService;
//
//    public AccountVerificationFrame() {
//        super("Account Verification");
//
//        verificationService = new AccountVerificationService();
//
//        // Thiết lập JFrame
//        setSize(300, 150);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Panel chứa các thành phần
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(3, 2));
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
//        // Button kiểm tra
//        JButton checkButton = new JButton("Check Account");
//        checkButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String accountNumber = accountNumberField.getText();
//                String pin = new String(pinField.getPassword());
//
//                // Kiểm tra thông tin trong cơ sở dữ liệu
//                if (verificationService.verifyAccount(accountNumber, pin)) {
//                    JOptionPane.showMessageDialog(AccountVerificationFrame.this, "Account verified!");
//                } else {
//                    JOptionPane.showMessageDialog(AccountVerificationFrame.this, "Invalid account or PIN.");
//                }
//            }
//        });
//        panel.add(checkButton);
//
//        // Đặt panel vào JFrame
//        add(panel);
//
//        // Hiển thị JFrame
//        setLocationRelativeTo(null); // Đặt cửa sổ JFrame vào giữa màn hình
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new AccountVerificationFrame();
//            }
//        });
//    }
//}
