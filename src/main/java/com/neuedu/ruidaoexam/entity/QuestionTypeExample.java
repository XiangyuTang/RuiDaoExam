package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.List;

public class QuestionTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionTypeExample() {
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

        public Criteria andQuesTypeIdIsNull() {
            addCriterion("ques_type_id is null");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdIsNotNull() {
            addCriterion("ques_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdEqualTo(Integer value) {
            addCriterion("ques_type_id =", value, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdNotEqualTo(Integer value) {
            addCriterion("ques_type_id <>", value, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdGreaterThan(Integer value) {
            addCriterion("ques_type_id >", value, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ques_type_id >=", value, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdLessThan(Integer value) {
            addCriterion("ques_type_id <", value, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("ques_type_id <=", value, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdIn(List<Integer> values) {
            addCriterion("ques_type_id in", values, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdNotIn(List<Integer> values) {
            addCriterion("ques_type_id not in", values, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("ques_type_id between", value1, value2, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ques_type_id not between", value1, value2, "quesTypeId");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIsNull() {
            addCriterion("ques_type is null");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIsNotNull() {
            addCriterion("ques_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuesTypeEqualTo(String value) {
            addCriterion("ques_type =", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeNotEqualTo(String value) {
            addCriterion("ques_type <>", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeGreaterThan(String value) {
            addCriterion("ques_type >", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ques_type >=", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeLessThan(String value) {
            addCriterion("ques_type <", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeLessThanOrEqualTo(String value) {
            addCriterion("ques_type <=", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeLike(String value) {
            addCriterion("ques_type like", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeNotLike(String value) {
            addCriterion("ques_type not like", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIn(List<String> values) {
            addCriterion("ques_type in", values, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeNotIn(List<String> values) {
            addCriterion("ques_type not in", values, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeBetween(String value1, String value2) {
            addCriterion("ques_type between", value1, value2, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeNotBetween(String value1, String value2) {
            addCriterion("ques_type not between", value1, value2, "quesType");
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