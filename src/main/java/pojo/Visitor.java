package pojo;

import java.util.Objects;

/**
 * @autor Mrk
 * @create 2022-04-24 21:19
 * @desc    用户表
 */
public class Visitor {
    Integer  visitorID;
    String  visitorName;
    String  gender;
    String  phoneNumber;
    String  password;
    Integer     isMaster;

    public Visitor() {
    }

    public Visitor(Integer visitorID, String visitorName, String gender, String phoneNumber, String password, Integer isMaster) {
        this.visitorID = visitorID;
        this.visitorName = visitorName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isMaster = isMaster;
    }

    public Integer getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(int isMaster) {
        this.isMaster = isMaster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return isMaster == visitor.isMaster &&
                Objects.equals(visitorID, visitor.visitorID) &&
                Objects.equals(visitorName, visitor.visitorName) &&
                Objects.equals(gender, visitor.gender) &&
                Objects.equals(phoneNumber, visitor.phoneNumber) &&
                Objects.equals(password, visitor.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorID, visitorName, gender, phoneNumber, password, isMaster);
    }

    @Override
    public String toString() {
        return "visitor{" +
                "visitorID='" + visitorID + '\'' +
                ", visitorName='" + visitorName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", isMaster=" + isMaster +
                '}';
    }
}
