package com.ce.sdu.mysdu.model;
import com.google.gson.annotations.SerializedName;
public class Message {
    @SerializedName("SM_ID")
    private int smId;
    @SerializedName("TEACHER")
    private String teacher;
    @SerializedName("SUBJECT")
    private String subject;
    @SerializedName("SENT_DATE")
    private String sentDate;
    @SerializedName("READ_DATE")
    private String readDate;
    @SerializedName("MSG_FROM")
    private String msgFrom;
    @SerializedName("IS_READ")
    private String isRead;

    public Message(String msgFrom, String subject, String readDate) {
    }


    public int getSmId() {
        return smId;
    }

    public void setSmId(int smId) {
        this.smId = smId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    public String getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(String msgFrom) {
        this.msgFrom = msgFrom;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }
}