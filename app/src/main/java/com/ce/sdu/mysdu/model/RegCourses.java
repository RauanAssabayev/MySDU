package com.ce.sdu.mysdu.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rauan on 08.06.2017.
 */


public class RegCourses {
    @SerializedName("DERS_AL_ID")
    private String dersAlId;
    @SerializedName("DERS_KOD")
    private String dersKod;
    @SerializedName("SECTION")
    private int section;
    @SerializedName("PRACTICE")
    private int practice;
    @SerializedName("LAB_SECTION")
    private String labSection;
    @SerializedName("LAB_SOBE_ID")
    private String labSobeId;
    @SerializedName("DERS_TITLE")
    private String dersTitle;
    @SerializedName("K_TEOR")
    private  int kTeor;
    @SerializedName("K_PRAT")
    private int kPrat;
    @SerializedName("K_LAB")
    private int kLab;
    @SerializedName("K_QU")
    private int kQu;
    @SerializedName("K_ECTS")
    private int kEcts;
    @SerializedName("TYPE")
    private String type;
    @SerializedName("LANG_CODE")
    private String langCode;
    @SerializedName("N_EMP_TITLE")
    private String nEmpTitle ;
    @SerializedName("P_EMP_TITLE")
    private String pEmpTitle;
    @SerializedName("L_EMP_TITLE")
    private String lEmpTitle;

    public String getDersAlId() {
        return dersAlId;
    }

    public void setDersAlId(String dersAlId) {
        this.dersAlId = dersAlId;
    }

    public String getDersKod() {
        return dersKod;
    }

    public void setDersKod(String dersKod) {
        this.dersKod = dersKod;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getPractice() {
        return practice;
    }

    public void setPractice(int practice) {
        this.practice = practice;
    }

    public String getLabSection() {
        return labSection;
    }

    public void setLabSection(String labSection) {
        this.labSection = labSection;
    }

    public String getLabSobeId() {
        return labSobeId;
    }

    public void setLabSobeId(String labSobeId) {
        this.labSobeId = labSobeId;
    }

    public String getDersTitle() {
        return dersTitle;
    }

    public void setDersTitle(String dersTitle) {
        this.dersTitle = dersTitle;
    }

    public int getkTeor() {
        return kTeor;
    }

    public void setkTeor(int kTeor) {
        this.kTeor = kTeor;
    }

    public int getkPrat() {
        return kPrat;
    }

    public void setkPrat(int kPrat) {
        this.kPrat = kPrat;
    }

    public int getkLab() {
        return kLab;
    }

    public void setkLab(int kLab) {
        this.kLab = kLab;
    }

    public int getkQu() {
        return kQu;
    }

    public void setkQu(int kQu) {
        this.kQu = kQu;
    }

    public int getkEcts() {
        return kEcts;
    }

    public void setkEcts(int kEcts) {
        this.kEcts = kEcts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getnEmpTitle() {
        return nEmpTitle;
    }

    public void setnEmpTitle(String nEmpTitle) {
        this.nEmpTitle = nEmpTitle;
    }

    public String getpEmpTitle() {
        return pEmpTitle;
    }

    public void setpEmpTitle(String pEmpTitle) {
        this.pEmpTitle = pEmpTitle;
    }

    public String getlEmpTitle() {
        return lEmpTitle;
    }

    public void setlEmpTitle(String lEmpTitle) {
        this.lEmpTitle = lEmpTitle;
    }

    public int getPainSection() {
        return painSection;
    }

    public void setPainSection(int painSection) {
        this.painSection = painSection;
    }

    @SerializedName("PAID_SECTION")
    private int painSection;
}