/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author GIGABYTE
 */
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Thư viện: https://mvnrepository.com/artifact/com.sun.mail/javax.mail Tao mật
 * khẩu ứng dụng: https://myaccount.google.com/apppasswords
 */
public class EmailUtils {

    // Thông tin tài khoản email dùng để gửi (thay đổi thông tin này)
    private static final String EMAIL_USERNAME = "nguyenduycongtm@gmail.com";
    private static final String EMAIL_PASSWORD = "nzxm hczx sdva uguz";

    // Cấu hình SMTP server
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";

    /**
     * Gửi email thông báo đăng ký thành công
     *
     * @param toEmail Địa chỉ email người nhận
     * @param fullName Tên đầy đủ của người dùng
     * @param userID ID người dùng
     * @return true nếu gửi email thành công, false nếu có lỗi
     */
    public static boolean sendRegistrationEmail(String toEmail, String fullName, String userID) {
        try {
            // Thiết lập các thuộc tính
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", SMTP_HOST);
            props.put("mail.smtp.port", SMTP_PORT);

            // Tạo phiên xác thực
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
                }
            });

            // Tạo message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Welcome to Our Website - Registration Successful");

            // Xây dựng nội dung HTML email
            String htmlContent = createRegistrationEmailContent(fullName, userID);
            message.setContent(htmlContent, "text/html; charset=utf-8");

            // Gửi email
            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Xây dựng nội dung HTML cho email đăng ký thành công
     *
     * @param fullName Tên đầy đủ người dùng
     * @param userID ID người dùng
     * @return Chuỗi HTML hoàn chỉnh cho nội dung email
     */
    private static String createRegistrationEmailContent(String fullName, String userID) {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Registration Successful</title>\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Arial, sans-serif;\n"
                + "            line-height: 1.6;\n"
                + "            color: #333;\n"
                + "            margin: 0;\n"
                + "            padding: 0;\n"
                + "        }\n"
                + "        .container {\n"
                + "            max-width: 600px;\n"
                + "            margin: 0 auto;\n"
                + "            padding: 20px;\n"
                + "            background-color: #f9f9f9;\n"
                + "        }\n"
                + "        .header {\n"
                + "            background-color: #4a90e2;\n"
                + "            color: white;\n"
                + "            padding: 20px;\n"
                + "            text-align: center;\n"
                + "        }\n"
                + "        .content {\n"
                + "            padding: 20px;\n"
                + "            background-color: white;\n"
                + "            border-radius: 5px;\n"
                + "        }\n"
                + "        .button {\n"
                + "            display: inline-block;\n"
                + "            padding: 10px 20px;\n"
                + "            background-color: #4a90e2;\n"
                + "            color: white;\n"
                + "            text-decoration: none;\n"
                + "            border-radius: 5px;\n"
                + "            margin: 20px 0;\n"
                + "        }\n"
                + "        .footer {\n"
                + "            text-align: center;\n"
                + "            margin-top: 20px;\n"
                + "            font-size: 12px;\n"
                + "            color: #666;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <div class=\"header\">\n"
                + "            <h1>Welcome to Our Website!</h1>\n"
                + "        </div>\n"
                + "        <div class=\"content\">\n"
                + "            <h2>Hello, " + fullName + "!</h2>\n"
                + "            <p>Thank you for registering with our website. Your account has been successfully created.</p>\n"
                + "            <p><strong>Your login information:</strong></p>\n"
                + "            <p>Username: <strong>" + userID + "</strong></p>\n"
                + "            <p>You can now login to your account and start exploring our services.</p>\n"
                + "            <a href=\"http://yourwebsite.com/login\" class=\"button\">Login to Your Account</a>\n"
                + "            <p>If you have any questions or need assistance, please don't hesitate to contact our support team.</p>\n"
                + "            <p>Best regards,<br>The Team</p>\n"
                + "        </div>\n"
                + "        <div class=\"footer\">\n"
                + "            <p>This is an automated message, please do not reply to this email.</p>\n"
                + "            <p>&copy; 2025 Your Company. All rights reserved.</p>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";
    }

    /**
     * Gửi email xác thực đăng ký với token xác thực
     *
     * @param toEmail Địa chỉ email người nhận
     * @param fullName Tên đầy đủ của người dùng
     * @param token Token xác thực
     * @return true nếu gửi email thành công, false nếu có lỗi
     */
    public static boolean sendVerificationEmail(String toEmail, String fullName, String token) {
        try {
            // Thiết lập các thuộc tính
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", SMTP_HOST);
            props.put("mail.smtp.port", SMTP_PORT);

            // Tạo phiên xác thực
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
                }
            });

            // Tạo message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Account Verification Required");

            // Xây dựng nội dung HTML email
            String verificationLink = "http://localhost:8080/SkillSwap_Hub/home.jsp";
            String htmlContent = createVerificationEmailContent(fullName, verificationLink);
            message.setContent(htmlContent, "text/html; charset=utf-8");

            // Gửi email
            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Xây dựng nội dung HTML cho email xác thực tài khoản
     *
     * @param fullName Tên đầy đủ người dùng
     * @param verificationLink Đường dẫn xác thực
     * @return Chuỗi HTML hoàn chỉnh cho nội dung email
     */
    private static String createVerificationEmailContent(String fullName, String verificationLink) {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Verify Your Account</title>\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Arial, sans-serif;\n"
                + "            line-height: 1.6;\n"
                + "            color: #333;\n"
                + "            margin: 0;\n"
                + "            padding: 0;\n"
                + "        }\n"
                + "        .container {\n"
                + "            max-width: 600px;\n"
                + "            margin: 0 auto;\n"
                + "            padding: 20px;\n"
                + "            background-color: #f9f9f9;\n"
                + "        }\n"
                + "        .header {\n"
                + "            background-color: #4a90e2;\n"
                + "            color: white;\n"
                + "            padding: 20px;\n"
                + "            text-align: center;\n"
                + "        }\n"
                + "        .content {\n"
                + "            padding: 20px;\n"
                + "            background-color: white;\n"
                + "            border-radius: 5px;\n"
                + "        }\n"
                + "        .button {\n"
                + "            display: inline-block;\n"
                + "            padding: 10px 20px;\n"
                + "            background-color: #4a90e2;\n"
                + "            color: white;\n"
                + "            text-decoration: none;\n"
                + "            border-radius: 5px;\n"
                + "            margin: 20px 0;\n"
                + "        }\n"
                + "        .footer {\n"
                + "            text-align: center;\n"
                + "            margin-top: 20px;\n"
                + "            font-size: 12px;\n"
                + "            color: #666;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <div class=\"header\">\n"
                + "            <h1>Verify Your Account</h1>\n"
                + "        </div>\n"
                + "        <div class=\"content\">\n"
                + "            <h2>Hello, " + fullName + "!</h2>\n"
                + "            <p>Thank you for registering with our website. To complete your registration, please verify your email address by clicking the button below:</p>\n"
                + "            <a href=\"" + verificationLink + "\" class=\"button\">Verify Your Account</a>\n"
                + "            <p>If the button doesn't work, you can also copy and paste the following link into your browser:</p>\n"
                + "            <p><a href=\"" + verificationLink + "\">" + verificationLink + "</a></p>\n"
                + "            <p>This verification link will expire in 24 hours.</p>\n"
                + "            <p>If you did not sign up for an account, please ignore this email.</p>\n"
                + "            <p>Best regards,<br>The Team</p>\n"
                + "        </div>\n"
                + "        <div class=\"footer\">\n"
                + "            <p>This is an automated message, please do not reply to this email.</p>\n"
                + "            <p>&copy; 2025 Your Company. All rights reserved.</p>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";
    }
    
     public static boolean sendWelcomeEmail(String toEmail, String fullName) {
        try {
            // Thiết lập các thuộc tính
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", SMTP_HOST);
            props.put("mail.smtp.port", SMTP_PORT);
            
            // Tạo phiên xác thực
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
                }
            });
            
            // Tạo message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Account Verification Required");
            
            // Xây dựng nội dung HTML email
            String verificationLink = "http://localhost:8080/SkillSwap_Hub/home.jsp";
            String htmlContent = getWelcomeEmail(fullName);
            message.setContent(htmlContent, "text/html; charset=utf-8");
            
            // Gửi email
            Transport.send(message);
            
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getWelcomeEmail(String fullName) {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Welcome to SkillSwap Hub!</title>\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Arial, sans-serif;\n"
                + "            background-color: #f4f4f4;\n"
                + "            color: #333;\n"
                + "            margin: 0;\n"
                + "            padding: 0;\n"
                + "        }\n"
                + "        .container {\n"
                + "            max-width: 600px;\n"
                + "            margin: 20px auto;\n"
                + "            padding: 20px;\n"
                + "            background-color: white;\n"
                + "            border-radius: 8px;\n"
                + "            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);\n"
                + "        }\n"
                + "        .header {\n"
                + "            background-color: #007bff;\n"
                + "            color: white;\n"
                + "            padding: 20px;\n"
                + "            text-align: center;\n"
                + "            border-top-left-radius: 8px;\n"
                + "            border-top-right-radius: 8px;\n"
                + "        }\n"
                + "        .content {\n"
                + "            padding: 20px;\n"
                + "            text-align: center;\n"
                + "        }\n"
                + "        .button {\n"
                + "            display: inline-block;\n"
                + "            padding: 12px 20px;\n"
                + "            background-color: #007bff;\n"
                + "            color: white;\n"
                + "            text-decoration: none;\n"
                + "            font-size: 16px;\n"
                + "            border-radius: 5px;\n"
                + "            margin: 20px 0;\n"
                + "        }\n"
                + "        .footer {\n"
                + "            text-align: center;\n"
                + "            font-size: 12px;\n"
                + "            color: #666;\n"
                + "            margin-top: 20px;\n"
                + "            padding: 10px;\n"
                + "            background-color: #f4f4f4;\n"
                + "            border-bottom-left-radius: 8px;\n"
                + "            border-bottom-right-radius: 8px;\n"
                + "        }\n"
                + "        .footer p {\n"
                + "            margin: 5px 0;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <div class=\"header\">\n"
                + "            <h1>Welcome to SkillSwap Hub!</h1>\n"
                + "        </div>\n"
                + "        <div class=\"content\">\n"
                + "            <h2>Hello, " + fullName + "!</h2>\n"
                + "            <p>We’re thrilled to have you join <strong>SkillSwap Hub</strong>, where you can swap and learn new skills from other users.</p>\n"
                + "            <p>Start exploring now by finding skills you want to learn or offer your expertise to others.</p>\n"
                + "            <a href=\"http://localhost:8080/SkillSwap_Hub/home.jsp\" class=\"button\">Get Started</a>\n"
                + "            <p>Need help? Visit our <a href=\"http://localhost:8080/SkillSwap_Hub/home.jsp\">Help Center</a>.</p>\n"
                + "            <p>Happy learning and sharing!</p>\n"
                + "            <p>Best regards,<br><strong>SkillSwap Hub Team</strong></p>\n"
                + "        </div>\n"
                + "        <div class=\"footer\">\n"
                + "            <p>This is an automated email, please do not reply.</p>\n"
                + "            <p>&copy; 2025 SkillSwap Hub. All rights reserved.</p>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";
    }

    public static void main(String[] args) {
        sendRegistrationEmail("myhauvuong8672@gmail.com", "Anh Cong", "1706");
    }
}
