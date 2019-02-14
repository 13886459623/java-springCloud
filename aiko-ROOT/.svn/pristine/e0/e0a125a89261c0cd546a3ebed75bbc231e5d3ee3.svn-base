package com.ycb.domain;

import java.util.ArrayList;
import java.util.List;

public class messageABExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public messageABExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAiTypeIsNull() {
            addCriterion("ai_type is null");
            return (Criteria) this;
        }

        public Criteria andAiTypeIsNotNull() {
            addCriterion("ai_type is not null");
            return (Criteria) this;
        }

        public Criteria andAiTypeEqualTo(String value) {
            addCriterion("ai_type =", value, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeNotEqualTo(String value) {
            addCriterion("ai_type <>", value, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeGreaterThan(String value) {
            addCriterion("ai_type >", value, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ai_type >=", value, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeLessThan(String value) {
            addCriterion("ai_type <", value, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeLessThanOrEqualTo(String value) {
            addCriterion("ai_type <=", value, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeLike(String value) {
            addCriterion("ai_type like", value, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeNotLike(String value) {
            addCriterion("ai_type not like", value, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeIn(List<String> values) {
            addCriterion("ai_type in", values, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeNotIn(List<String> values) {
            addCriterion("ai_type not in", values, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeBetween(String value1, String value2) {
            addCriterion("ai_type between", value1, value2, "aiType");
            return (Criteria) this;
        }

        public Criteria andAiTypeNotBetween(String value1, String value2) {
            addCriterion("ai_type not between", value1, value2, "aiType");
            return (Criteria) this;
        }

        public Criteria andErrorLevelIsNull() {
            addCriterion("error_level is null");
            return (Criteria) this;
        }

        public Criteria andErrorLevelIsNotNull() {
            addCriterion("error_level is not null");
            return (Criteria) this;
        }

        public Criteria andErrorLevelEqualTo(String value) {
            addCriterion("error_level =", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelNotEqualTo(String value) {
            addCriterion("error_level <>", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelGreaterThan(String value) {
            addCriterion("error_level >", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelGreaterThanOrEqualTo(String value) {
            addCriterion("error_level >=", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelLessThan(String value) {
            addCriterion("error_level <", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelLessThanOrEqualTo(String value) {
            addCriterion("error_level <=", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelLike(String value) {
            addCriterion("error_level like", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelNotLike(String value) {
            addCriterion("error_level not like", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelIn(List<String> values) {
            addCriterion("error_level in", values, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelNotIn(List<String> values) {
            addCriterion("error_level not in", values, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelBetween(String value1, String value2) {
            addCriterion("error_level between", value1, value2, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelNotBetween(String value1, String value2) {
            addCriterion("error_level not between", value1, value2, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updateTime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updateTime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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