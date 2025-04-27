/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Timestamp;

/**
 *
 * @author GIGABYTE
 */
public class RatingDTO {

    private int ratingId;
    private int userId;
    private int skillId;
    private int ratingValue;
    private Timestamp ratingDate;

    public RatingDTO(int ratingId, int userId, int skillId, int ratingValue, Timestamp ratingDate) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.skillId = skillId;
        this.ratingValue = ratingValue;
        this.ratingDate = ratingDate;
    }

    public int getRatingId() {
        return ratingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getSkillId() {
        return skillId;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public Timestamp getRatingDate() {
        return ratingDate;
    }
    
}
