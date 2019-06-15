package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.List;

public class PaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaperExample() {
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

        public Criteria andPaperIdIsNull() {
            addCriterion("paper_id is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(Integer value) {
            addCriterion("paper_id =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(Integer value) {
            addCriterion("paper_id <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(Integer value) {
            addCriterion("paper_id >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("paper_id >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(Integer value) {
            addCriterion("paper_id <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("paper_id <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<Integer> values) {
            addCriterion("paper_id in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<Integer> values) {
            addCriterion("paper_id not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("paper_id between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("paper_id not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperNameIsNull() {
            addCriterion("paper_name is null");
            return (Criteria) this;
        }

        public Criteria andPaperNameIsNotNull() {
            addCriterion("paper_name is not null");
            return (Criteria) this;
        }

        public Criteria andPaperNameEqualTo(String value) {
            addCriterion("paper_name =", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameNotEqualTo(String value) {
            addCriterion("paper_name <>", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameGreaterThan(String value) {
            addCriterion("paper_name >", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameGreaterThanOrEqualTo(String value) {
            addCriterion("paper_name >=", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameLessThan(String value) {
            addCriterion("paper_name <", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameLessThanOrEqualTo(String value) {
            addCriterion("paper_name <=", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameLike(String value) {
            addCriterion("paper_name like", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameNotLike(String value) {
            addCriterion("paper_name not like", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameIn(List<String> values) {
            addCriterion("paper_name in", values, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameNotIn(List<String> values) {
            addCriterion("paper_name not in", values, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameBetween(String value1, String value2) {
            addCriterion("paper_name between", value1, value2, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameNotBetween(String value1, String value2) {
            addCriterion("paper_name not between", value1, value2, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperTypeIsNull() {
            addCriterion("paper_type is null");
            return (Criteria) this;
        }

        public Criteria andPaperTypeIsNotNull() {
            addCriterion("paper_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaperTypeEqualTo(Integer value) {
            addCriterion("paper_type =", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeNotEqualTo(Integer value) {
            addCriterion("paper_type <>", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeGreaterThan(Integer value) {
            addCriterion("paper_type >", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("paper_type >=", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeLessThan(Integer value) {
            addCriterion("paper_type <", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeLessThanOrEqualTo(Integer value) {
            addCriterion("paper_type <=", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeIn(List<Integer> values) {
            addCriterion("paper_type in", values, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeNotIn(List<Integer> values) {
            addCriterion("paper_type not in", values, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeBetween(Integer value1, Integer value2) {
            addCriterion("paper_type between", value1, value2, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("paper_type not between", value1, value2, "paperType");
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

        public Criteria andPaperTimeIsNull() {
            addCriterion("paper_time is null");
            return (Criteria) this;
        }

        public Criteria andPaperTimeIsNotNull() {
            addCriterion("paper_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaperTimeEqualTo(Integer value) {
            addCriterion("paper_time =", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeNotEqualTo(Integer value) {
            addCriterion("paper_time <>", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeGreaterThan(Integer value) {
            addCriterion("paper_time >", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("paper_time >=", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeLessThan(Integer value) {
            addCriterion("paper_time <", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeLessThanOrEqualTo(Integer value) {
            addCriterion("paper_time <=", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeIn(List<Integer> values) {
            addCriterion("paper_time in", values, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeNotIn(List<Integer> values) {
            addCriterion("paper_time not in", values, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeBetween(Integer value1, Integer value2) {
            addCriterion("paper_time between", value1, value2, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("paper_time not between", value1, value2, "paperTime");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNull() {
            addCriterion("total_score is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("total_score is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Integer value) {
            addCriterion("total_score =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Integer value) {
            addCriterion("total_score <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Integer value) {
            addCriterion("total_score >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_score >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Integer value) {
            addCriterion("total_score <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("total_score <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Integer> values) {
            addCriterion("total_score in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Integer> values) {
            addCriterion("total_score not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("total_score not between", value1, value2, "totalScore");
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