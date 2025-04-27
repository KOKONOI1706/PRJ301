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
public class SkillDTO {

    private int skill_id;
    private String skill_name;
    private String category;
    private int userCount;

    public SkillDTO(int skill_id, String skill_name, String category, int userCount) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.category = category;
        this.userCount = userCount;
    }

    public SkillDTO() {
    }

    public SkillDTO(int skill_id, String skill_name, String category) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.category = category;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

}
