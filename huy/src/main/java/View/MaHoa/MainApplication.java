


package View.MaHoa;


import View.MaHoa.*;
public class MainApplication {

    public static void main(String[] args) {
        // Bước 1: Mở frame đăng ký tài khoản và lấy thông tin từ frame
        String[] accountInfo = openRegistrationFrame();

        if (accountInfo != null && accountInfo.length == 5) {
            // Bước 2: Thực hiện đăng ký thông tin tài khoản vào cơ sở dữ liệu
            boolean registered = registerAccount(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3], accountInfo[4]);

            if (registered) {
                // Bước 3: Kiểm tra thông tin tài khoản
                verifyAccount(accountInfo[0], accountInfo[1]);
            } else {
                System.out.println("Đăng ký tài khoản không thành công.");
            }
        } else {
            System.out.println("Thông tin tài khoản không hợp lệ từ frame đăng ký.");
        }
    }

    private static String[] openRegistrationFrame() {
        // Mở frame đăng ký tài khoản và lấy thông tin từ frame
        AccountRegistrationFrame registrationFrame = new AccountRegistrationFrame();
        registrationFrame.setVisible(true);

        // Lấy thông tin từ frame đăng ký
        return registrationFrame.getAccountInfo();
    }

    private static boolean registerAccount(String accountNumber, String pin, String fullName, String email, String phoneNumber) {
        try {
            AccountRegistrationService registrationService = new AccountRegistrationService();
            registrationService.registerAccount(accountNumber, pin, fullName, email, phoneNumber);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi khi đăng ký tài khoản: " + e.getMessage());
            return false;
        }
    }

    private static void verifyAccount(String accountNumber, String pin) {
        try {
            AccountVerificationService verificationService = new AccountVerificationService();
            boolean isValid = verificationService.verifyAccount(accountNumber, pin);

            if (isValid) {
                System.out.println("Thông tin tài khoản hợp lệ.");
            } else {
                System.out.println("Thông tin tài khoản không hợp lệ.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi kiểm tra tài khoản: " + e.getMessage());
        }
    }
}



//
//public class MainApplication {
//
//    public static void main(String[] args) {
//        // Bước 1: Mở frame đăng ký tài khoản và lấy thông tin từ frame
//        String[] accountInfo = openRegistrationFrame();
//
//        if (accountInfo != null && accountInfo.length == 5) {
//            // Bước 2: Thực hiện đăng ký thông tin tài khoản vào cơ sở dữ liệu
//            registerAccount(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3], accountInfo[4]);
//
//            // Bước 3: Kiểm tra thông tin tài khoản
//            verifyAccount(accountInfo[0], accountInfo[1]);
//        } else {
//            System.out.println("Thông tin tài khoản không hợp lệ từ frame đăng ký.");
//        }
//    }
//
//    private static String[] openRegistrationFrame() {
//        // Mở frame đăng ký tài khoản và lấy thông tin từ frame
//        AccountRegistrationFrame registrationFrame = new AccountRegistrationFrame();
//        registrationFrame.setVisible(true);
//
//        // Lấy thông tin từ frame đăng ký
//        return registrationFrame.getAccountInfo();
//    }
//
//    private static void registerAccount(String accountNumber, String pin, String fullName, String email, String phoneNumber) {
//        AccountRegistrationService registrationService = new AccountRegistrationService();
//        registrationService.registerAccount(accountNumber, pin, fullName, email, phoneNumber);
//    }
//
//    private static void verifyAccount(String accountNumber, String pin) {
//        AccountVerificationService verificationService = new AccountVerificationService();
//        boolean isValid = verificationService.verifyAccount(accountNumber, pin);
//
//        if (isValid) {
//            System.out.println("Thông tin tài khoản hợp lệ.");
//        } else {
//            System.out.println("Thông tin tài khoản không hợp lệ.");
//        }
//    }
//}





//package Controller;    cũng chưa test nhưng do ở hàm nhập là tự ý  không tận dụng frame //
//
//import View.AccountRegistrationService;
//import View.AccountVerificationService;
//
//public class MainApplication {
//
//    public static void main(String[] args) {
//        // Bước 1: Đăng ký thông tin tài khoản
//        registerAccount();
//
//        // Bước 2: Kiểm tra thông tin tài khoản
//        verifyAccount();
//    }
//
//    private static void registerAccount() {
//        AccountRegistrationService registrationService = new AccountRegistrationService();
//
//        // Thực hiện đăng ký tài khoản
//        String accountNumber = "123456789";
//        String pin = "9876";
//        String fullName = "John Doe";
//        String email = "john.doe@example.com";
//        String phoneNumber = "123456789";
//
//        registrationService.registerAccount(accountNumber, pin, fullName, email, phoneNumber);
//    }
//
//    private static void verifyAccount() {
//        AccountVerificationService verificationService = new AccountVerificationService();
//
//        // Thực hiện kiểm tra thông tin tài khoản
//        String accountNumber = "123456789"; // Số tài khoản cần kiểm tra
//        String pin = "9876"; // Mã PIN tương ứng
//
//        boolean isValid = verificationService.verifyAccount(accountNumber, pin);
//
//        if (isValid) {
//            System.out.println("Thông tin tài khoản hợp lệ.");
//        } else {
//            System.out.println("Thông tin tài khoản không hợp lệ.");
//        }
//    }
//}
//
//
//




//package Controller;    chưa test 
//
//import View.AccountRegistrationService;
//import View.AccountVerificationService;
//
//public class MainApplication {
//
//    public static void main(String[] args) {
//        // Bước 1: Đăng ký thông tin tài khoản
//        registerAccount();
//
//        // Bước 2: Kiểm tra thông tin tài khoản
//        verifyAccount();
//    }
//
//    private static void registerAccount() {
//        AccountRegistrationService registrationService = new AccountRegistrationService();
//
//        // Thực hiện đăng ký tài khoản
//        String accountNumber = "123456789";
//        String pin = "9876";
//        String fullName = "John Doe";
//        String email = "john.doe@example.com";
//        String phoneNumber = "123456789";
//
//        registrationService.registerAccount(accountNumber, pin, fullName, email, phoneNumber);
//    }
//
//    private static void verifyAccount() {
//        AccountVerificationService verificationService = new AccountVerificationService();
//
//        // Thực hiện kiểm tra thông tin tài khoản
//        String accountNumber = "123456789"; // Số tài khoản cần kiểm tra
//        String pin = "9876"; // Mã PIN tương ứng
//
//        boolean isValid = verificationService.verifyAccount(accountNumber, pin);
//
//        if (isValid) {
//            System.out.println("Thông tin tài khoản hợp lệ.");
//        } else {
//            System.out.println("Thông tin tài khoản không hợp lệ.");
//        }
//    }
//}
