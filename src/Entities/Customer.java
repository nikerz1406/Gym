/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Viet
 */
public class Customer {

    private int id;
    private String fullName;
    private int phone;
    private byte gender;
    private int member;
    private Date birthday;
    private String idCard;
    private String email;
    private String address;
    private String note;
    private byte status;
    private String branch;
    private ImageIcon avatar;

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public Customer() {
    }

    public Customer(int id, String fullName, int phone, int member, byte gender, Date birthday, String idCard, String email, String address, String note, byte status, String branch) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.gender = gender;
        this.member = member;
        this.birthday = birthday;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.note = note;
        this.status = status;
        this.branch = branch;
    }

    public Customer(int id, String fullName, int phone, int member, byte status) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.member = member;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPhone() {
        return phone;
    }

    public byte getGender() {
        return gender;
    }

    public int getMember() {
        return member;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }

    public byte getStatus() {
        return status;
    }

    public String getBranch() {
        return branch;
    }

}
