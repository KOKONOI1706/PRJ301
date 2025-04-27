/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author GIGABYTE
 */
public class UserDTO {

    private int user_id;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String profilePictureUrl;
    private String location;
    private Date createdAt;
    private int rating;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDTO(int user_id, String username, String email, String password, String bio, String profilePictureUrl, String location, Date createdAt, int rating, String fullName, String role) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.profilePictureUrl = profilePictureUrl;
        this.location = location;
        this.createdAt = createdAt;
        this.rating = rating;
        this.fullName = fullName;
        this.role = role;
    }
    private String role;

    public UserDTO(int user_id, String username, String email, String password, String bio, String profilePictureUrl, String location, Date createdAt, int rating) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.profilePictureUrl = profilePictureUrl;
        this.location = location;
        this.createdAt = createdAt;
        this.rating = rating;
    }

    public UserDTO() {
    }

    public UserDTO(int user_id, String username, String email, String password, String bio, String profilePictureUrl, String location, Date createdAt) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.profilePictureUrl = profilePictureUrl;
        this.location = location;
        this.createdAt = createdAt;
    }

    public UserDTO(int user_id, String username, String email, int rating) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.rating = rating;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
