package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionBankExample() {
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

        public Criteria andQuesBankIdIsNull() {
            addCriterion("ques_bank_id is null");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdIsNotNull() {
            addCriterion("ques_bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdEqualTo(Integer value) {
            addCriterion("ques_bank_id =", value, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdNotEqualTo(Integer value) {
            addCriterion("ques_bank_id <>", value, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdGreaterThan(Integer value) {
            addCriterion("ques_bank_id >", value, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ques_bank_id >=", value, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdLessThan(Integer value) {
            addCriterion("ques_bank_id <", value, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdLessThanOrEqualTo(Integer value) {
            addCriterion("ques_bank_id <=", value, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdIn(List<Integer> values) {
            addCriterion("ques_bank_id in", values, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdNotIn(List<Integer> values) {
            addCriterion("ques_bank_id not in", values, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdBetween(Integer value1, Integer value2) {
            addCriterion("ques_bank_id between", value1, value2, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ques_bank_id not between", value1, value2, "quesBankId");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameIsNull() {
            addCriterion("ques_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameIsNotNull() {
            addCriterion("ques_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameEqualTo(String value) {
            addCriterion("ques_bank_name =", value, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameNotEqualTo(String value) {
            addCriterion("ques_bank_name <>", value, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameGreaterThan(String value) {
            addCriterion("ques_bank_name >", value, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("ques_bank_name >=", value, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameLessThan(String value) {
            addCriterion("ques_bank_name <", value, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameLessThanOrEqualTo(String value) {
            addCriterion("ques_bank_name <=", value, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameLike(String value) {
            addCriterion("ques_bank_name like", value, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameNotLike(String value) {
            addCriterion("ques_bank_name not like", value, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameIn(List<String> values) {
            addCriterion("ques_bank_name in", values, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameNotIn(List<String> values) {
            addCriterion("ques_bank_name not in", values, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameBetween(String value1, String value2) {
            addCriterion("ques_bank_name between", value1, value2, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankNameNotBetween(String value1, String value2) {
            addCriterion("ques_bank_name not between", value1, value2, "quesBankName");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledIsNull() {
            addCriterion("ques_bank_filed is null");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledIsNotNull() {
            addCriterion("ques_bank_filed is not null");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledEqualTo(Integer value) {
            addCriterion("ques_bank_filed =", value, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledNotEqualTo(Integer value) {
            addCriterion("ques_bank_filed <>", value, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledGreaterThan(Integer value) {
            addCriterion("ques_bank_filed >", value, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledGreaterThanOrEqualTo(Integer value) {
            addCriterion("ques_bank_filed >=", value, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledLessThan(Integer value) {
            addCriterion("ques_bank_filed <", value, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledLessThanOrEqualTo(Integer value) {
            addCriterion("ques_bank_filed <=", value, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledIn(List<Integer> values) {
            addCriterion("ques_bank_filed in", values, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledNotIn(List<Integer> values) {
            addCriterion("ques_bank_filed not in", values, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledBetween(Integer value1, Integer value2) {
            addCriterion("ques_bank_filed between", value1, value2, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andQuesBankFiledNotBetween(Integer value1, Integer value2) {
            addCriterion("ques_bank_filed not between", value1, value2, "quesBankFiled");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridIsNull() {
            addCriterion("createdByTeacherId is null");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridIsNotNull() {
            addCriterion("createdByTeacherId is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridEqualTo(Integer value) {
            addCriterion("createdByTeacherId =", value, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridNotEqualTo(Integer value) {
            addCriterion("createdByTeacherId <>", value, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridGreaterThan(Integer value) {
            addCriterion("createdByTeacherId >", value, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("createdByTeacherId >=", value, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridLessThan(Integer value) {
            addCriterion("createdByTeacherId <", value, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridLessThanOrEqualTo(Integer value) {
            addCriterion("createdByTeacherId <=", value, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridIn(List<Integer> values) {
            addCriterion("createdByTeacherId in", values, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridNotIn(List<Integer> values) {
            addCriterion("createdByTeacherId not in", values, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridBetween(Integer value1, Integer value2) {
            addCriterion("createdByTeacherId between", value1, value2, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCreatedbyteacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("createdByTeacherId not between", value1, value2, "createdbyteacherid");
            return (Criteria) this;
        }

        public Criteria andPointPriceIsNull() {
            addCriterion("point_price is null");
            return (Criteria) this;
        }

        public Criteria andPointPriceIsNotNull() {
            addCriterion("point_price is not null");
            return (Criteria) this;
        }

        public Criteria andPointPriceEqualTo(Integer value) {
            addCriterion("point_price =", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceNotEqualTo(Integer value) {
            addCriterion("point_price <>", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceGreaterThan(Integer value) {
            addCriterion("point_price >", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("point_price >=", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceLessThan(Integer value) {
            addCriterion("point_price <", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceLessThanOrEqualTo(Integer value) {
            addCriterion("point_price <=", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceIn(List<Integer> values) {
            addCriterion("point_price in", values, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceNotIn(List<Integer> values) {
            addCriterion("point_price not in", values, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceBetween(Integer value1, Integer value2) {
            addCriterion("point_price between", value1, value2, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("point_price not between", value1, value2, "pointPrice");
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