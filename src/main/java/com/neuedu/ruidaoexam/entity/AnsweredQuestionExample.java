package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.List;

public class AnsweredQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnsweredQuestionExample() {
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

        public Criteria andAnswerIdIsNull() {
            addCriterion("answer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(Integer value) {
            addCriterion("answer_id =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(Integer value) {
            addCriterion("answer_id <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(Integer value) {
            addCriterion("answer_id >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_id >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(Integer value) {
            addCriterion("answer_id <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(Integer value) {
            addCriterion("answer_id <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<Integer> values) {
            addCriterion("answer_id in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<Integer> values) {
            addCriterion("answer_id not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(Integer value1, Integer value2) {
            addCriterion("answer_id between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_id not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdIsNull() {
            addCriterion("paper_result_id is null");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdIsNotNull() {
            addCriterion("paper_result_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdEqualTo(Integer value) {
            addCriterion("paper_result_id =", value, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdNotEqualTo(Integer value) {
            addCriterion("paper_result_id <>", value, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdGreaterThan(Integer value) {
            addCriterion("paper_result_id >", value, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("paper_result_id >=", value, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdLessThan(Integer value) {
            addCriterion("paper_result_id <", value, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdLessThanOrEqualTo(Integer value) {
            addCriterion("paper_result_id <=", value, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdIn(List<Integer> values) {
            addCriterion("paper_result_id in", values, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdNotIn(List<Integer> values) {
            addCriterion("paper_result_id not in", values, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdBetween(Integer value1, Integer value2) {
            addCriterion("paper_result_id between", value1, value2, "paperResultId");
            return (Criteria) this;
        }

        public Criteria andPaperResultIdNotBetween(Integer value1, Integer value2) {
            addCriterion("paper_result_id not between", value1, value2, "paperResultId");
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

        public Criteria andQuesTypeEqualTo(Integer value) {
            addCriterion("ques_type =", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeNotEqualTo(Integer value) {
            addCriterion("ques_type <>", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeGreaterThan(Integer value) {
            addCriterion("ques_type >", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ques_type >=", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeLessThan(Integer value) {
            addCriterion("ques_type <", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ques_type <=", value, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeIn(List<Integer> values) {
            addCriterion("ques_type in", values, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeNotIn(List<Integer> values) {
            addCriterion("ques_type not in", values, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeBetween(Integer value1, Integer value2) {
            addCriterion("ques_type between", value1, value2, "quesType");
            return (Criteria) this;
        }

        public Criteria andQuesTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ques_type not between", value1, value2, "quesType");
            return (Criteria) this;
        }

        public Criteria andCqIdIsNull() {
            addCriterion("cq_id is null");
            return (Criteria) this;
        }

        public Criteria andCqIdIsNotNull() {
            addCriterion("cq_id is not null");
            return (Criteria) this;
        }

        public Criteria andCqIdEqualTo(Integer value) {
            addCriterion("cq_id =", value, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdNotEqualTo(Integer value) {
            addCriterion("cq_id <>", value, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdGreaterThan(Integer value) {
            addCriterion("cq_id >", value, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cq_id >=", value, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdLessThan(Integer value) {
            addCriterion("cq_id <", value, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdLessThanOrEqualTo(Integer value) {
            addCriterion("cq_id <=", value, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdIn(List<Integer> values) {
            addCriterion("cq_id in", values, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdNotIn(List<Integer> values) {
            addCriterion("cq_id not in", values, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdBetween(Integer value1, Integer value2) {
            addCriterion("cq_id between", value1, value2, "cqId");
            return (Criteria) this;
        }

        public Criteria andCqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cq_id not between", value1, value2, "cqId");
            return (Criteria) this;
        }

        public Criteria andEqIdIsNull() {
            addCriterion("eq_id is null");
            return (Criteria) this;
        }

        public Criteria andEqIdIsNotNull() {
            addCriterion("eq_id is not null");
            return (Criteria) this;
        }

        public Criteria andEqIdEqualTo(Integer value) {
            addCriterion("eq_id =", value, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdNotEqualTo(Integer value) {
            addCriterion("eq_id <>", value, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdGreaterThan(Integer value) {
            addCriterion("eq_id >", value, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("eq_id >=", value, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdLessThan(Integer value) {
            addCriterion("eq_id <", value, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdLessThanOrEqualTo(Integer value) {
            addCriterion("eq_id <=", value, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdIn(List<Integer> values) {
            addCriterion("eq_id in", values, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdNotIn(List<Integer> values) {
            addCriterion("eq_id not in", values, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdBetween(Integer value1, Integer value2) {
            addCriterion("eq_id between", value1, value2, "eqId");
            return (Criteria) this;
        }

        public Criteria andEqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("eq_id not between", value1, value2, "eqId");
            return (Criteria) this;
        }

        public Criteria andJqIdIsNull() {
            addCriterion("jq_id is null");
            return (Criteria) this;
        }

        public Criteria andJqIdIsNotNull() {
            addCriterion("jq_id is not null");
            return (Criteria) this;
        }

        public Criteria andJqIdEqualTo(Integer value) {
            addCriterion("jq_id =", value, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdNotEqualTo(Integer value) {
            addCriterion("jq_id <>", value, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdGreaterThan(Integer value) {
            addCriterion("jq_id >", value, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jq_id >=", value, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdLessThan(Integer value) {
            addCriterion("jq_id <", value, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdLessThanOrEqualTo(Integer value) {
            addCriterion("jq_id <=", value, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdIn(List<Integer> values) {
            addCriterion("jq_id in", values, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdNotIn(List<Integer> values) {
            addCriterion("jq_id not in", values, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdBetween(Integer value1, Integer value2) {
            addCriterion("jq_id between", value1, value2, "jqId");
            return (Criteria) this;
        }

        public Criteria andJqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("jq_id not between", value1, value2, "jqId");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(Integer value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(Integer value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(Integer value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(Integer value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(Integer value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<Integer> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<Integer> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(Integer value1, Integer value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(Integer value1, Integer value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIsNull() {
            addCriterion("right_answer is null");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIsNotNull() {
            addCriterion("right_answer is not null");
            return (Criteria) this;
        }

        public Criteria andRightAnswerEqualTo(Integer value) {
            addCriterion("right_answer =", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotEqualTo(Integer value) {
            addCriterion("right_answer <>", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerGreaterThan(Integer value) {
            addCriterion("right_answer >", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerGreaterThanOrEqualTo(Integer value) {
            addCriterion("right_answer >=", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerLessThan(Integer value) {
            addCriterion("right_answer <", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerLessThanOrEqualTo(Integer value) {
            addCriterion("right_answer <=", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIn(List<Integer> values) {
            addCriterion("right_answer in", values, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotIn(List<Integer> values) {
            addCriterion("right_answer not in", values, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerBetween(Integer value1, Integer value2) {
            addCriterion("right_answer between", value1, value2, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotBetween(Integer value1, Integer value2) {
            addCriterion("right_answer not between", value1, value2, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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