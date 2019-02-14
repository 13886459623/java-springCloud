package com.ycb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class details_listExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public details_listExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andElIdIsNull() {
            addCriterion("el_id is null");
            return (Criteria) this;
        }

        public Criteria andElIdIsNotNull() {
            addCriterion("el_id is not null");
            return (Criteria) this;
        }

        public Criteria andElIdEqualTo(Integer value) {
            addCriterion("el_id =", value, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdNotEqualTo(Integer value) {
            addCriterion("el_id <>", value, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdGreaterThan(Integer value) {
            addCriterion("el_id >", value, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("el_id >=", value, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdLessThan(Integer value) {
            addCriterion("el_id <", value, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdLessThanOrEqualTo(Integer value) {
            addCriterion("el_id <=", value, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdIn(List<Integer> values) {
            addCriterion("el_id in", values, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdNotIn(List<Integer> values) {
            addCriterion("el_id not in", values, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdBetween(Integer value1, Integer value2) {
            addCriterion("el_id between", value1, value2, "elId");
            return (Criteria) this;
        }

        public Criteria andElIdNotBetween(Integer value1, Integer value2) {
            addCriterion("el_id not between", value1, value2, "elId");
            return (Criteria) this;
        }

        public Criteria andElBadtypeIsNull() {
            addCriterion("el_badtype is null");
            return (Criteria) this;
        }

        public Criteria andElBadtypeIsNotNull() {
            addCriterion("el_badtype is not null");
            return (Criteria) this;
        }

        public Criteria andElBadtypeEqualTo(String value) {
            addCriterion("el_badtype =", value, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeNotEqualTo(String value) {
            addCriterion("el_badtype <>", value, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeGreaterThan(String value) {
            addCriterion("el_badtype >", value, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeGreaterThanOrEqualTo(String value) {
            addCriterion("el_badtype >=", value, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeLessThan(String value) {
            addCriterion("el_badtype <", value, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeLessThanOrEqualTo(String value) {
            addCriterion("el_badtype <=", value, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeLike(String value) {
            addCriterion("el_badtype like", value, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeNotLike(String value) {
            addCriterion("el_badtype not like", value, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeIn(List<String> values) {
            addCriterion("el_badtype in", values, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeNotIn(List<String> values) {
            addCriterion("el_badtype not in", values, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeBetween(String value1, String value2) {
            addCriterion("el_badtype between", value1, value2, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadtypeNotBetween(String value1, String value2) {
            addCriterion("el_badtype not between", value1, value2, "elBadtype");
            return (Criteria) this;
        }

        public Criteria andElBadnumIsNull() {
            addCriterion("el_badnum is null");
            return (Criteria) this;
        }

        public Criteria andElBadnumIsNotNull() {
            addCriterion("el_badnum is not null");
            return (Criteria) this;
        }

        public Criteria andElBadnumEqualTo(String value) {
            addCriterion("el_badnum =", value, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumNotEqualTo(String value) {
            addCriterion("el_badnum <>", value, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumGreaterThan(String value) {
            addCriterion("el_badnum >", value, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumGreaterThanOrEqualTo(String value) {
            addCriterion("el_badnum >=", value, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumLessThan(String value) {
            addCriterion("el_badnum <", value, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumLessThanOrEqualTo(String value) {
            addCriterion("el_badnum <=", value, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumLike(String value) {
            addCriterion("el_badnum like", value, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumNotLike(String value) {
            addCriterion("el_badnum not like", value, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumIn(List<String> values) {
            addCriterion("el_badnum in", values, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumNotIn(List<String> values) {
            addCriterion("el_badnum not in", values, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumBetween(String value1, String value2) {
            addCriterion("el_badnum between", value1, value2, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBadnumNotBetween(String value1, String value2) {
            addCriterion("el_badnum not between", value1, value2, "elBadnum");
            return (Criteria) this;
        }

        public Criteria andElBoardIsNull() {
            addCriterion("el_board is null");
            return (Criteria) this;
        }

        public Criteria andElBoardIsNotNull() {
            addCriterion("el_board is not null");
            return (Criteria) this;
        }

        public Criteria andElBoardEqualTo(String value) {
            addCriterion("el_board =", value, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardNotEqualTo(String value) {
            addCriterion("el_board <>", value, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardGreaterThan(String value) {
            addCriterion("el_board >", value, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardGreaterThanOrEqualTo(String value) {
            addCriterion("el_board >=", value, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardLessThan(String value) {
            addCriterion("el_board <", value, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardLessThanOrEqualTo(String value) {
            addCriterion("el_board <=", value, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardLike(String value) {
            addCriterion("el_board like", value, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardNotLike(String value) {
            addCriterion("el_board not like", value, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardIn(List<String> values) {
            addCriterion("el_board in", values, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardNotIn(List<String> values) {
            addCriterion("el_board not in", values, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardBetween(String value1, String value2) {
            addCriterion("el_board between", value1, value2, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElBoardNotBetween(String value1, String value2) {
            addCriterion("el_board not between", value1, value2, "elBoard");
            return (Criteria) this;
        }

        public Criteria andElImgpathIsNull() {
            addCriterion("el_imgpath is null");
            return (Criteria) this;
        }

        public Criteria andElImgpathIsNotNull() {
            addCriterion("el_imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andElImgpathEqualTo(String value) {
            addCriterion("el_imgpath =", value, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathNotEqualTo(String value) {
            addCriterion("el_imgpath <>", value, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathGreaterThan(String value) {
            addCriterion("el_imgpath >", value, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("el_imgpath >=", value, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathLessThan(String value) {
            addCriterion("el_imgpath <", value, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathLessThanOrEqualTo(String value) {
            addCriterion("el_imgpath <=", value, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathLike(String value) {
            addCriterion("el_imgpath like", value, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathNotLike(String value) {
            addCriterion("el_imgpath not like", value, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathIn(List<String> values) {
            addCriterion("el_imgpath in", values, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathNotIn(List<String> values) {
            addCriterion("el_imgpath not in", values, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathBetween(String value1, String value2) {
            addCriterion("el_imgpath between", value1, value2, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElImgpathNotBetween(String value1, String value2) {
            addCriterion("el_imgpath not between", value1, value2, "elImgpath");
            return (Criteria) this;
        }

        public Criteria andElPathIsNull() {
            addCriterion("el_path is null");
            return (Criteria) this;
        }

        public Criteria andElPathIsNotNull() {
            addCriterion("el_path is not null");
            return (Criteria) this;
        }

        public Criteria andElPathEqualTo(String value) {
            addCriterion("el_path =", value, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathNotEqualTo(String value) {
            addCriterion("el_path <>", value, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathGreaterThan(String value) {
            addCriterion("el_path >", value, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathGreaterThanOrEqualTo(String value) {
            addCriterion("el_path >=", value, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathLessThan(String value) {
            addCriterion("el_path <", value, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathLessThanOrEqualTo(String value) {
            addCriterion("el_path <=", value, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathLike(String value) {
            addCriterion("el_path like", value, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathNotLike(String value) {
            addCriterion("el_path not like", value, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathIn(List<String> values) {
            addCriterion("el_path in", values, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathNotIn(List<String> values) {
            addCriterion("el_path not in", values, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathBetween(String value1, String value2) {
            addCriterion("el_path between", value1, value2, "elPath");
            return (Criteria) this;
        }

        public Criteria andElPathNotBetween(String value1, String value2) {
            addCriterion("el_path not between", value1, value2, "elPath");
            return (Criteria) this;
        }

        public Criteria andElChipnumIsNull() {
            addCriterion("el_chipnum is null");
            return (Criteria) this;
        }

        public Criteria andElChipnumIsNotNull() {
            addCriterion("el_chipnum is not null");
            return (Criteria) this;
        }

        public Criteria andElChipnumEqualTo(String value) {
            addCriterion("el_chipnum =", value, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumNotEqualTo(String value) {
            addCriterion("el_chipnum <>", value, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumGreaterThan(String value) {
            addCriterion("el_chipnum >", value, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumGreaterThanOrEqualTo(String value) {
            addCriterion("el_chipnum >=", value, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumLessThan(String value) {
            addCriterion("el_chipnum <", value, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumLessThanOrEqualTo(String value) {
            addCriterion("el_chipnum <=", value, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumLike(String value) {
            addCriterion("el_chipnum like", value, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumNotLike(String value) {
            addCriterion("el_chipnum not like", value, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumIn(List<String> values) {
            addCriterion("el_chipnum in", values, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumNotIn(List<String> values) {
            addCriterion("el_chipnum not in", values, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumBetween(String value1, String value2) {
            addCriterion("el_chipnum between", value1, value2, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElChipnumNotBetween(String value1, String value2) {
            addCriterion("el_chipnum not between", value1, value2, "elChipnum");
            return (Criteria) this;
        }

        public Criteria andElNumberIsNull() {
            addCriterion("el_number is null");
            return (Criteria) this;
        }

        public Criteria andElNumberIsNotNull() {
            addCriterion("el_number is not null");
            return (Criteria) this;
        }

        public Criteria andElNumberEqualTo(String value) {
            addCriterion("el_number =", value, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberNotEqualTo(String value) {
            addCriterion("el_number <>", value, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberGreaterThan(String value) {
            addCriterion("el_number >", value, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberGreaterThanOrEqualTo(String value) {
            addCriterion("el_number >=", value, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberLessThan(String value) {
            addCriterion("el_number <", value, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberLessThanOrEqualTo(String value) {
            addCriterion("el_number <=", value, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberLike(String value) {
            addCriterion("el_number like", value, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberNotLike(String value) {
            addCriterion("el_number not like", value, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberIn(List<String> values) {
            addCriterion("el_number in", values, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberNotIn(List<String> values) {
            addCriterion("el_number not in", values, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberBetween(String value1, String value2) {
            addCriterion("el_number between", value1, value2, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElNumberNotBetween(String value1, String value2) {
            addCriterion("el_number not between", value1, value2, "elNumber");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeIsNull() {
            addCriterion("el_badtypetime is null");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeIsNotNull() {
            addCriterion("el_badtypetime is not null");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeEqualTo(Date value) {
            addCriterion("el_badtypetime =", value, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeNotEqualTo(Date value) {
            addCriterion("el_badtypetime <>", value, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeGreaterThan(Date value) {
            addCriterion("el_badtypetime >", value, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("el_badtypetime >=", value, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeLessThan(Date value) {
            addCriterion("el_badtypetime <", value, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeLessThanOrEqualTo(Date value) {
            addCriterion("el_badtypetime <=", value, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeIn(List<Date> values) {
            addCriterion("el_badtypetime in", values, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeNotIn(List<Date> values) {
            addCriterion("el_badtypetime not in", values, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeBetween(Date value1, Date value2) {
            addCriterion("el_badtypetime between", value1, value2, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElBadtypetimeNotBetween(Date value1, Date value2) {
            addCriterion("el_badtypetime not between", value1, value2, "elBadtypetime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeIsNull() {
            addCriterion("el_datatime is null");
            return (Criteria) this;
        }

        public Criteria andElDatatimeIsNotNull() {
            addCriterion("el_datatime is not null");
            return (Criteria) this;
        }

        public Criteria andElDatatimeEqualTo(Date value) {
            addCriterion("el_datatime =", value, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeNotEqualTo(Date value) {
            addCriterion("el_datatime <>", value, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeGreaterThan(Date value) {
            addCriterion("el_datatime >", value, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("el_datatime >=", value, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeLessThan(Date value) {
            addCriterion("el_datatime <", value, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeLessThanOrEqualTo(Date value) {
            addCriterion("el_datatime <=", value, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeIn(List<Date> values) {
            addCriterion("el_datatime in", values, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeNotIn(List<Date> values) {
            addCriterion("el_datatime not in", values, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeBetween(Date value1, Date value2) {
            addCriterion("el_datatime between", value1, value2, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElDatatimeNotBetween(Date value1, Date value2) {
            addCriterion("el_datatime not between", value1, value2, "elDatatime");
            return (Criteria) this;
        }

        public Criteria andElBathIsNull() {
            addCriterion("el_bath is null");
            return (Criteria) this;
        }

        public Criteria andElBathIsNotNull() {
            addCriterion("el_bath is not null");
            return (Criteria) this;
        }

        public Criteria andElBathEqualTo(String value) {
            addCriterion("el_bath =", value, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathNotEqualTo(String value) {
            addCriterion("el_bath <>", value, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathGreaterThan(String value) {
            addCriterion("el_bath >", value, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathGreaterThanOrEqualTo(String value) {
            addCriterion("el_bath >=", value, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathLessThan(String value) {
            addCriterion("el_bath <", value, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathLessThanOrEqualTo(String value) {
            addCriterion("el_bath <=", value, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathLike(String value) {
            addCriterion("el_bath like", value, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathNotLike(String value) {
            addCriterion("el_bath not like", value, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathIn(List<String> values) {
            addCriterion("el_bath in", values, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathNotIn(List<String> values) {
            addCriterion("el_bath not in", values, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathBetween(String value1, String value2) {
            addCriterion("el_bath between", value1, value2, "elBath");
            return (Criteria) this;
        }

        public Criteria andElBathNotBetween(String value1, String value2) {
            addCriterion("el_bath not between", value1, value2, "elBath");
            return (Criteria) this;
        }

        public Criteria andElExtendIsNull() {
            addCriterion("el_extend is null");
            return (Criteria) this;
        }

        public Criteria andElExtendIsNotNull() {
            addCriterion("el_extend is not null");
            return (Criteria) this;
        }

        public Criteria andElExtendEqualTo(String value) {
            addCriterion("el_extend =", value, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendNotEqualTo(String value) {
            addCriterion("el_extend <>", value, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendGreaterThan(String value) {
            addCriterion("el_extend >", value, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendGreaterThanOrEqualTo(String value) {
            addCriterion("el_extend >=", value, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendLessThan(String value) {
            addCriterion("el_extend <", value, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendLessThanOrEqualTo(String value) {
            addCriterion("el_extend <=", value, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendLike(String value) {
            addCriterion("el_extend like", value, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendNotLike(String value) {
            addCriterion("el_extend not like", value, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendIn(List<String> values) {
            addCriterion("el_extend in", values, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendNotIn(List<String> values) {
            addCriterion("el_extend not in", values, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendBetween(String value1, String value2) {
            addCriterion("el_extend between", value1, value2, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtendNotBetween(String value1, String value2) {
            addCriterion("el_extend not between", value1, value2, "elExtend");
            return (Criteria) this;
        }

        public Criteria andElExtend1IsNull() {
            addCriterion("el_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andElExtend1IsNotNull() {
            addCriterion("el_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andElExtend1EqualTo(String value) {
            addCriterion("el_extend1 =", value, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1NotEqualTo(String value) {
            addCriterion("el_extend1 <>", value, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1GreaterThan(String value) {
            addCriterion("el_extend1 >", value, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("el_extend1 >=", value, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1LessThan(String value) {
            addCriterion("el_extend1 <", value, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1LessThanOrEqualTo(String value) {
            addCriterion("el_extend1 <=", value, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1Like(String value) {
            addCriterion("el_extend1 like", value, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1NotLike(String value) {
            addCriterion("el_extend1 not like", value, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1In(List<String> values) {
            addCriterion("el_extend1 in", values, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1NotIn(List<String> values) {
            addCriterion("el_extend1 not in", values, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1Between(String value1, String value2) {
            addCriterion("el_extend1 between", value1, value2, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend1NotBetween(String value1, String value2) {
            addCriterion("el_extend1 not between", value1, value2, "elExtend1");
            return (Criteria) this;
        }

        public Criteria andElExtend2IsNull() {
            addCriterion("el_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andElExtend2IsNotNull() {
            addCriterion("el_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andElExtend2EqualTo(String value) {
            addCriterion("el_extend2 =", value, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2NotEqualTo(String value) {
            addCriterion("el_extend2 <>", value, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2GreaterThan(String value) {
            addCriterion("el_extend2 >", value, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("el_extend2 >=", value, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2LessThan(String value) {
            addCriterion("el_extend2 <", value, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2LessThanOrEqualTo(String value) {
            addCriterion("el_extend2 <=", value, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2Like(String value) {
            addCriterion("el_extend2 like", value, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2NotLike(String value) {
            addCriterion("el_extend2 not like", value, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2In(List<String> values) {
            addCriterion("el_extend2 in", values, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2NotIn(List<String> values) {
            addCriterion("el_extend2 not in", values, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2Between(String value1, String value2) {
            addCriterion("el_extend2 between", value1, value2, "elExtend2");
            return (Criteria) this;
        }

        public Criteria andElExtend2NotBetween(String value1, String value2) {
            addCriterion("el_extend2 not between", value1, value2, "elExtend2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}