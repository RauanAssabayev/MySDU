package com.ce.sdu.mysdu.model;
import com.google.gson.annotations.SerializedName;
public class Message {
    @SerializedName("SM_ID")
    private int smId;
    @SerializedName("MSG_ID")
    private int msgId;
    @SerializedName("MSG_FROM")
    private String msgFrom;
    @SerializedName("SUBJECT")
    private String subject;
    @SerializedName("TEACHER")
    private String teacher;

    public int getSmId() {
        return smId;
    }

    public void setSmId(int smId) {
        this.smId = smId;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(String msgFrom) {
        this.msgFrom = msgFrom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
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

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    @SerializedName("SENT_DATE")
    private String sentDate;
    @SerializedName("READ_DATE")
    private String readDate;
    @SerializedName("IS_READ")
    private String isRead;


}