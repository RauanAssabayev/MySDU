package com.ce.sdu.mysdu.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rauan on 03.06.2017.
 */

public class Courses {
    @SerializedName("STUD_ID")
    private int studId;
    @SerializedName("DERS_KOD")
    private String dersKod;
    @SerializedName("YEAR")
    private int year;
    @SerializedName("TERM")
    private String term;
    @SerializedName("SECTION")
    private String section;
    @SerializedName("PRACTISE")
    private String practise;
    @SerializedName("LABSOBE")
    private String labSobe;
    @SerializedName("TITLE")
    private String title;
    @SerializedName("TEOR")
    private int teor;
    @SerializedName("PRAT")
    private int prat;
    @SerializedName("LAB")
    private String lab;
    @SerializedName("ECTS")
    private int ects;
    @SerializedName("CR")
    private String cr;
    @SerializedName("QIYMET_HERF")
    private String qiymetHerf;
    @SerializedName("ORT")
    private int ort;
    @SerializedName("MT1")
    private int mt1;
    @SerializedName("MT2")
    private int mt2;
    @SerializedName("FIN")
    private int fin;
    @SerializedName("QAIB_SAY")
    private String qaibSay;
    @SerializedName("GRADING_TYPE")
    private String gradinType;
    @SerializedName("KECDI")
    private String kecdi;
    @SerializedName("DERS_AL_REPID")
    private String dersAlRepid;
    @SerializedName("SON")
    private String son;
    @SerializedName("BLOCKED")
    private String blocked;

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getDersKod() {
        return dersKod;
    }

    public void setDersKod(String dersKod) {
        this.dersKod = dersKod;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPractise() {
        return practise;
    }

    public void setPractise(String practise) {
        this.practise = practise;
    }

    public String getLabSobe() {
        return labSobe;
    }

    public void setLabSobe(String labSobe) {
        this.labSobe = labSobe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTeor() {
        return teor;
    }

    public void setTeor(int teor) {
        this.teor = teor;
    }

    public int getPrat() {
        return prat;
    }

    public void setPrat(int prat) {
        this.prat = prat;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getQiymetHerf() {
        return qiymetHerf;
    }

    public void setQiymetHerf(String qiymetHerf) {
        this.qiymetHerf = qiymetHerf;
    }

    public int getOrt() {
        return ort;
    }

    public void setOrt(int ort) {
        this.ort = ort;
    }

    public int getMt1() {
        return mt1;
    }

    public void setMt1(int mt1) {
        this.mt1 = mt1;
    }

    public int getMt2() {
        return mt2;
    }

    public void setMt2(int mt2) {
        this.mt2 = mt2;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public String getQaibSay() {
        return qaibSay;
    }

    public void setQaibSay(String qaibSay) {
        this.qaibSay = qaibSay;
    }

    public String getGradinType() {
        return gradinType;
    }

    public void setGradinType(String gradinType) {
        this.gradinType = gradinType;
    }

    public String getKecdi() {
        return kecdi;
    }

    public void setKecdi(String kecdi) {
        this.kecdi = kecdi;
    }

    public String getDersAlRepid() {
        return dersAlRepid;
    }

    public void setDersAlRepid(String dersAlRepid) {
        this.dersAlRepid = dersAlRepid;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }
}