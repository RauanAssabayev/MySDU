package com.ce.sdu.mysdu.model;

import com.google.gson.annotations.SerializedName;


public class Student {
    @SerializedName("STUD_ID")
    private int mStudentID;
    @SerializedName("NAME")
    private String mName;
    @SerializedName("SURNAME")
    private String mSurname;
    @SerializedName("CLASS")
    private int mClass;
    @SerializedName("STATUS")
    private int mStatus;
    @SerializedName("PASSW")
    private String mPassword;
    @SerializedName("WEB_LAN")
    private String mWebLan;
    @SerializedName("LAST_PSW_SET_DATE")
    private String mLastPswSetDate;
    @SerializedName("EMP_ID")
    private int mEmpID;
    @SerializedName("DEP_ID_QEYD")
    private int mDEP_ID_QEYD;
    @SerializedName("TYPE")
    private String mType;
    @SerializedName("NAME_NATIVE")
    private String mNameNative;
    @SerializedName("SURNAME_NATIVE")
    private String mSurnameNative;
    @SerializedName("OLD_SDU_ID")
    private int mOld_SDU_ID;
    @SerializedName("PATRONYMIC")
    private String mPatronymic;


    public int getmStudentID() {
        return mStudentID;
    }

    public void setmStudentID(int mStudentID) {
        this.mStudentID = mStudentID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
    }

    public int getmClass() {
        return mClass;
    }

    public void setmClass(int mClass) {
        this.mClass = mClass;
    }

    public int getmStatus() {
        return mStatus;
    }

    public void setmStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmWebLan() {
        return mWebLan;
    }

    public void setmWebLan(String mWebLan) {
        this.mWebLan = mWebLan;
    }

    public String getmLastPswSetDate() {
        return mLastPswSetDate;
    }

    public void setmLastPswSetDate(String mLastPswSetDate) {
        this.mLastPswSetDate = mLastPswSetDate;
    }

    public int getmEmpID() {
        return mEmpID;
    }

    public void setmEmpID(int mEmpID) {
        this.mEmpID = mEmpID;
    }

    public int getmDEP_ID_QEYD() {
        return mDEP_ID_QEYD;
    }

    public void setmDEP_ID_QEYD(int mDEP_ID_QEYD) {
        this.mDEP_ID_QEYD = mDEP_ID_QEYD;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmNameNative() {
        return mNameNative;
    }

    public void setmNameNative(String mNameNative) {
        this.mNameNative = mNameNative;
    }

    public String getmSurnameNative() {
        return mSurnameNative;
    }

    public void setmSurnameNative(String mSurnameNative) {
        this.mSurnameNative = mSurnameNative;
    }

    public int getmOld_SDU_ID() {
        return mOld_SDU_ID;
    }

    public void setmOld_SDU_ID(int mOld_SDU_ID) {
        this.mOld_SDU_ID = mOld_SDU_ID;
    }

    public String getmPatronymic() {
        return mPatronymic;
    }

    public void setmPatronymic(String mPatronymic) {
        this.mPatronymic = mPatronymic;
    }

}
