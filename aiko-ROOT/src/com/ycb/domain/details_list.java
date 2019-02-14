package com.ycb.domain;

import java.util.Date;

public class details_list {
    private Integer elId;

    private String elBadtype;

    private String elBadnum;

    private String elBoard;

    private String elImgpath;

    private String elPath;

    private String elChipnum;

    private String elNumber;

    private Date elBadtypetime;

    private Date elDatatime;

    private String elBath;

    private String elExtend;

    private String elExtend1;

    private String elExtend2;

    public Integer getElId() {
        return elId;
    }

    public void setElId(Integer elId) {
        this.elId = elId;
    }

    public String getElBadtype() {
        return elBadtype;
    }

    public void setElBadtype(String elBadtype) {
        this.elBadtype = elBadtype == null ? null : elBadtype.trim();
    }

    public String getElBadnum() {
        return elBadnum;
    }

    public void setElBadnum(String elBadnum) {
        this.elBadnum = elBadnum == null ? null : elBadnum.trim();
    }

    public String getElBoard() {
        return elBoard;
    }

    public void setElBoard(String elBoard) {
        this.elBoard = elBoard == null ? null : elBoard.trim();
    }

    public String getElImgpath() {
        return elImgpath;
    }

    public void setElImgpath(String elImgpath) {
        this.elImgpath = elImgpath == null ? null : elImgpath.trim();
    }

    public String getElPath() {
        return elPath;
    }

    public void setElPath(String elPath) {
        this.elPath = elPath == null ? null : elPath.trim();
    }

    public String getElChipnum() {
        return elChipnum;
    }

    public void setElChipnum(String elChipnum) {
        this.elChipnum = elChipnum == null ? null : elChipnum.trim();
    }

    public String getElNumber() {
        return elNumber;
    }

    public void setElNumber(String elNumber) {
        this.elNumber = elNumber == null ? null : elNumber.trim();
    }

    public Date getElBadtypetime() {
        return elBadtypetime;
    }

    public void setElBadtypetime(Date elBadtypetime) {
        this.elBadtypetime = elBadtypetime;
    }

    public Date getElDatatime() {
        return elDatatime;
    }

    public void setElDatatime(Date elDatatime) {
        this.elDatatime = elDatatime;
    }

    public String getElBath() {
        return elBath;
    }

    public void setElBath(String elBath) {
        this.elBath = elBath == null ? null : elBath.trim();
    }

    public String getElExtend() {
        return elExtend;
    }

    public void setElExtend(String elExtend) {
        this.elExtend = elExtend == null ? null : elExtend.trim();
    }

    public String getElExtend1() {
        return elExtend1;
    }

    public void setElExtend1(String elExtend1) {
        this.elExtend1 = elExtend1 == null ? null : elExtend1.trim();
    }

    public String getElExtend2() {
        return elExtend2;
    }

    public void setElExtend2(String elExtend2) {
        this.elExtend2 = elExtend2 == null ? null : elExtend2.trim();
    }
}