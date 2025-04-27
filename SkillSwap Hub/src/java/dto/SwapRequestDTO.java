/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author GIGABYTE
 */
public class SwapRequestDTO {   
    private int request_id;
    private int sender_id;
    private int receiver_id;
    private int skill_requested_id;
    private int skill_offered_id;
    private String status;
     private Timestamp requestDate;

    public SwapRequestDTO() {
    }

    public SwapRequestDTO(int request_id, int sender_id, int receiver_id, int skill_requested_id, int skill_offered_id, String status, Timestamp requestDate) {
        this.request_id = request_id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.skill_requested_id = skill_requested_id;
        this.skill_offered_id = skill_offered_id;
        this.status = status;
        this.requestDate = requestDate;
    }

    public SwapRequestDTO(int sender_id, int receiver_id, int skill_requested_id, int skill_offered_id, String status) {
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.skill_requested_id = skill_requested_id;
        this.skill_offered_id = skill_offered_id;
        this.status = status;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public int getSkill_requested_id() {
        return skill_requested_id;
    }

    public void setSkill_requested_id(int skill_requested_id) {
        this.skill_requested_id = skill_requested_id;
    }

    public int getSkill_offered_id() {
        return skill_offered_id;
    }

    public void setSkill_offered_id(int skill_offered_id) {
        this.skill_offered_id = skill_offered_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

   

}
