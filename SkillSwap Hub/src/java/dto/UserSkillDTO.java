/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author GIGABYTE
 */
public class UserSkillDTO {
    private int user_skill_id;
    private int user_id;
    private int skill_id;
    private String type;
    private String proficiency_level;

    public UserSkillDTO() {
    }

    public UserSkillDTO(int user_skill_id, int user_id, int skill_id, String type, String proficiency_level) {
        this.user_skill_id = user_skill_id;
        this.user_id = user_id;
        this.skill_id = skill_id;
        this.type = type;
        this.proficiency_level = proficiency_level;
    }

    public int getUser_skill_id() {
        return user_skill_id;
    }

    public void setUser_skill_id(int user_skill_id) {
        this.user_skill_id = user_skill_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProficiency_level() {
        return proficiency_level;
    }

    public void setProficiency_level(String proficiency_level) {
        this.proficiency_level = proficiency_level;
    }
    
}
