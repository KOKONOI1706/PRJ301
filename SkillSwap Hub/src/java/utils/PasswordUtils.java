/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.UserDAO;
import dto.UserDTO;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;

/**
 *
 * @author GIGABYTE
 */
public class PasswordUtils {

    private static final int SALT_ROUNDS = 10;

    public static String hashString(String plainString) {
        String hashedPassword = plainString;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            
            byte[] messageDigest = md.digest(plainString.getBytes());
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }
    public static boolean checkPassword(String plainPassword, String hashedPassword){
        String newHasedPassword = hashString(plainPassword);
        return newHasedPassword != null && newHasedPassword.equals(hashedPassword);
    }
    public static void migratePasswords() {
        UserDAO udao = new UserDAO();
        List<UserDTO> users = udao.getAllUsers(); // Giả sử có phương thức để đọc tất cả người dùng

        for (UserDTO user : users) {
            // Lấy mật khẩu hiện tại (không mã hóa)
            String plainPassword = user.getPassword();

            // Mã hóa mật khẩu với MD5
            String hashedPassword = PasswordUtils.hashString(plainPassword);

            // Cập nhật mật khẩu mới
            user.setPassword(hashedPassword);

            // Lưu vào cơ sở dữ liệu
            udao.update(user); // Giả sử có phương thức update
        }

        System.out.println("Di chuyển mật khẩu sang MD5 hoàn tất");
    }
    public static void main(String[] args) {
        migratePasswords();
    }
}
