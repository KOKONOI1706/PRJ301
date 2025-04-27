/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.UserDAO;
import dto.UserDTO;

/**
 *
 * @author GIGABYTE
 */
public class AuthUtils {

    public static final String ADMIN_ROLE = "admin";
    public static final String GUEST_ROLE = "guest";
    public static final String MEMBER_ROLE = "member";
    public static final String VIP_ROLE = "vip";

    public static UserDTO getUser(String username) {
        UserDAO udao = new UserDAO();
        UserDTO user = udao.getUserByUsername(username);
        return user;
    }

    public static boolean isValidLogin(String username, String password) {
        UserDTO user = getUser(username);
        return user != null && user.getPassword().equals(password);
    }

    public static boolean isAdmin(UserDTO user){
        return user.getRole().equals(ADMIN_ROLE);
    }
    public static boolean isVip(UserDTO user){
        return user.getRole().equals(VIP_ROLE);
    }
    
}
