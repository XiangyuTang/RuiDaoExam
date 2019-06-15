package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.List;

public class AnsweredPaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnsweredPaperExample() {
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

        public Criteria andAnsPaperIdIsNull() {
            addCriterion("ans_paper_id is null");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdIsNotNull() {
            addCriterion("ans_paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdEqualTo(Integer value) {
            addCriterion("ans_paper_id =", value, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdNotEqualTo(Integer value) {
            addCriterion("ans_paper_id <>", value, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdGreaterThan(Integer value) {
            addCriterion("ans_paper_id >", value, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ans_paper_id >=", value, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdLessThan(Integer value) {
            addCriterion("ans_paper_id <", value, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("ans_paper_id <=", value, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdIn(List<Integer> values) {
            addCriterion("ans_paper_id in", values, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdNotIn(List<Integer> values) {
            addCriterion("ans_paper_id not in", values, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("ans_paper_id between", value1, value2, "ansPaperId");
            return (Criteria) this;
        }

        public Criteria andAnsPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ans_paper_id not between", value1, value2, "ansPaperId");
            return (Criteria) this;
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

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridIsNull() {
            addCriterion("checkedByTeacherId is null");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridIsNotNull() {
            addCriterion("checkedByTeacherId is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridEqualTo(Integer value) {
            addCriterion("checkedByTeacherId =", value, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridNotEqualTo(Integer value) {
            addCriterion("checkedByTeacherId <>", value, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridGreaterThan(Integer value) {
            addCriterion("checkedByTeacherId >", value, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkedByTeacherId >=", value, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridLessThan(Integer value) {
            addCriterion("checkedByTeacherId <", value, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridLessThanOrEqualTo(Integer value) {
            addCriterion("checkedByTeacherId <=", value, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridIn(List<Integer> values) {
            addCriterion("checkedByTeacherId in", values, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridNotIn(List<Integer> values) {
            addCriterion("checkedByTeacherId not in", values, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridBetween(Integer value1, Integer value2) {
            addCriterion("checkedByTeacherId between", value1, value2, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andCheckedbyteacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("checkedByTeacherId not between", value1, value2, "checkedbyteacherid");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherIsNull() {
            addCriterion("is_modified_by_teacher is null");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherIsNotNull() {
            addCriterion("is_modified_by_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherEqualTo(String value) {
            addCriterion("is_modified_by_teacher =", value, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherNotEqualTo(String value) {
            addCriterion("is_modified_by_teacher <>", value, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherGreaterThan(String value) {
            addCriterion("is_modified_by_teacher >", value, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("is_modified_by_teacher >=", value, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherLessThan(String value) {
            addCriterion("is_modified_by_teacher <", value, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherLessThanOrEqualTo(String value) {
            addCriterion("is_modified_by_teacher <=", value, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherLike(String value) {
            addCriterion("is_modified_by_teacher like", value, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherNotLike(String value) {
            addCriterion("is_modified_by_teacher not like", value, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherIn(List<String> values) {
            addCriterion("is_modified_by_teacher in", values, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherNotIn(List<String> values) {
            addCriterion("is_modified_by_teacher not in", values, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherBetween(String value1, String value2) {
            addCriterion("is_modified_by_teacher between", value1, value2, "isModifiedByTeacher");
            return (Criteria) this;
        }

        public Criteria andIsModifiedByTeacherNotBetween(String value1, String value2) {
            addCriterion("is_modified_by_teacher not between", value1, value2, "isModifiedByTeacher");
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