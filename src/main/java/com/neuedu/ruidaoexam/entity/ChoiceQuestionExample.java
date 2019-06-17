package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.List;

public class ChoiceQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChoiceQuestionExample() {
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

        public Criteria andChoiceQuesIdIsNull() {
            addCriterion("choice_ques_id is null");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdIsNotNull() {
            addCriterion("choice_ques_id is not null");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdEqualTo(Integer value) {
            addCriterion("choice_ques_id =", value, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdNotEqualTo(Integer value) {
            addCriterion("choice_ques_id <>", value, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdGreaterThan(Integer value) {
            addCriterion("choice_ques_id >", value, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("choice_ques_id >=", value, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdLessThan(Integer value) {
            addCriterion("choice_ques_id <", value, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdLessThanOrEqualTo(Integer value) {
            addCriterion("choice_ques_id <=", value, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdIn(List<Integer> values) {
            addCriterion("choice_ques_id in", values, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdNotIn(List<Integer> values) {
            addCriterion("choice_ques_id not in", values, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdBetween(Integer value1, Integer value2) {
            addCriterion("choice_ques_id between", value1, value2, "choiceQuesId");
            return (Criteria) this;
        }

        public Criteria andChoiceQuesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("choice_ques_id not between", value1, value2, "choiceQuesId");
            return (Criteria) this;
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andChoice1IsNull() {
            addCriterion("choice1 is null");
            return (Criteria) this;
        }

        public Criteria andChoice1IsNotNull() {
            addCriterion("choice1 is not null");
            return (Criteria) this;
        }

        public Criteria andChoice1EqualTo(String value) {
            addCriterion("choice1 =", value, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1NotEqualTo(String value) {
            addCriterion("choice1 <>", value, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1GreaterThan(String value) {
            addCriterion("choice1 >", value, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1GreaterThanOrEqualTo(String value) {
            addCriterion("choice1 >=", value, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1LessThan(String value) {
            addCriterion("choice1 <", value, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1LessThanOrEqualTo(String value) {
            addCriterion("choice1 <=", value, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1Like(String value) {
            addCriterion("choice1 like", value, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1NotLike(String value) {
            addCriterion("choice1 not like", value, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1In(List<String> values) {
            addCriterion("choice1 in", values, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1NotIn(List<String> values) {
            addCriterion("choice1 not in", values, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1Between(String value1, String value2) {
            addCriterion("choice1 between", value1, value2, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice1NotBetween(String value1, String value2) {
            addCriterion("choice1 not between", value1, value2, "choice1");
            return (Criteria) this;
        }

        public Criteria andChoice2IsNull() {
            addCriterion("choice2 is null");
            return (Criteria) this;
        }

        public Criteria andChoice2IsNotNull() {
            addCriterion("choice2 is not null");
            return (Criteria) this;
        }

        public Criteria andChoice2EqualTo(String value) {
            addCriterion("choice2 =", value, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2NotEqualTo(String value) {
            addCriterion("choice2 <>", value, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2GreaterThan(String value) {
            addCriterion("choice2 >", value, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2GreaterThanOrEqualTo(String value) {
            addCriterion("choice2 >=", value, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2LessThan(String value) {
            addCriterion("choice2 <", value, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2LessThanOrEqualTo(String value) {
            addCriterion("choice2 <=", value, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2Like(String value) {
            addCriterion("choice2 like", value, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2NotLike(String value) {
            addCriterion("choice2 not like", value, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2In(List<String> values) {
            addCriterion("choice2 in", values, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2NotIn(List<String> values) {
            addCriterion("choice2 not in", values, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2Between(String value1, String value2) {
            addCriterion("choice2 between", value1, value2, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice2NotBetween(String value1, String value2) {
            addCriterion("choice2 not between", value1, value2, "choice2");
            return (Criteria) this;
        }

        public Criteria andChoice3IsNull() {
            addCriterion("choice3 is null");
            return (Criteria) this;
        }

        public Criteria andChoice3IsNotNull() {
            addCriterion("choice3 is not null");
            return (Criteria) this;
        }

        public Criteria andChoice3EqualTo(String value) {
            addCriterion("choice3 =", value, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3NotEqualTo(String value) {
            addCriterion("choice3 <>", value, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3GreaterThan(String value) {
            addCriterion("choice3 >", value, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3GreaterThanOrEqualTo(String value) {
            addCriterion("choice3 >=", value, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3LessThan(String value) {
            addCriterion("choice3 <", value, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3LessThanOrEqualTo(String value) {
            addCriterion("choice3 <=", value, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3Like(String value) {
            addCriterion("choice3 like", value, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3NotLike(String value) {
            addCriterion("choice3 not like", value, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3In(List<String> values) {
            addCriterion("choice3 in", values, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3NotIn(List<String> values) {
            addCriterion("choice3 not in", values, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3Between(String value1, String value2) {
            addCriterion("choice3 between", value1, value2, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice3NotBetween(String value1, String value2) {
            addCriterion("choice3 not between", value1, value2, "choice3");
            return (Criteria) this;
        }

        public Criteria andChoice4IsNull() {
            addCriterion("choice4 is null");
            return (Criteria) this;
        }

        public Criteria andChoice4IsNotNull() {
            addCriterion("choice4 is not null");
            return (Criteria) this;
        }

        public Criteria andChoice4EqualTo(String value) {
            addCriterion("choice4 =", value, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4NotEqualTo(String value) {
            addCriterion("choice4 <>", value, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4GreaterThan(String value) {
            addCriterion("choice4 >", value, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4GreaterThanOrEqualTo(String value) {
            addCriterion("choice4 >=", value, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4LessThan(String value) {
            addCriterion("choice4 <", value, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4LessThanOrEqualTo(String value) {
            addCriterion("choice4 <=", value, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4Like(String value) {
            addCriterion("choice4 like", value, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4NotLike(String value) {
            addCriterion("choice4 not like", value, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4In(List<String> values) {
            addCriterion("choice4 in", values, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4NotIn(List<String> values) {
            addCriterion("choice4 not in", values, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4Between(String value1, String value2) {
            addCriterion("choice4 between", value1, value2, "choice4");
            return (Criteria) this;
        }

        public Criteria andChoice4NotBetween(String value1, String value2) {
            addCriterion("choice4 not between", value1, value2, "choice4");
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

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(Integer value) {
            addCriterion("difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(Integer value) {
            addCriterion("difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(Integer value) {
            addCriterion("difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(Integer value) {
            addCriterion("difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<Integer> values) {
            addCriterion("difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<Integer> values) {
            addCriterion("difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("difficulty not between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNull() {
            addCriterion("analysis is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNotNull() {
            addCriterion("analysis is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisEqualTo(String value) {
            addCriterion("analysis =", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotEqualTo(String value) {
            addCriterion("analysis <>", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThan(String value) {
            addCriterion("analysis >", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("analysis >=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThan(String value) {
            addCriterion("analysis <", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThanOrEqualTo(String value) {
            addCriterion("analysis <=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLike(String value) {
            addCriterion("analysis like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotLike(String value) {
            addCriterion("analysis not like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisIn(List<String> values) {
            addCriterion("analysis in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotIn(List<String> values) {
            addCriterion("analysis not in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisBetween(String value1, String value2) {
            addCriterion("analysis between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotBetween(String value1, String value2) {
            addCriterion("analysis not between", value1, value2, "analysis");
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