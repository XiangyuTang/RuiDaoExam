package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.List;

public class EssayQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EssayQuestionExample() {
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

        public Criteria andQuesAnsIdIsNull() {
            addCriterion("ques_ans_id is null");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdIsNotNull() {
            addCriterion("ques_ans_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdEqualTo(Integer value) {
            addCriterion("ques_ans_id =", value, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdNotEqualTo(Integer value) {
            addCriterion("ques_ans_id <>", value, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdGreaterThan(Integer value) {
            addCriterion("ques_ans_id >", value, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ques_ans_id >=", value, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdLessThan(Integer value) {
            addCriterion("ques_ans_id <", value, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdLessThanOrEqualTo(Integer value) {
            addCriterion("ques_ans_id <=", value, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdIn(List<Integer> values) {
            addCriterion("ques_ans_id in", values, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdNotIn(List<Integer> values) {
            addCriterion("ques_ans_id not in", values, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdBetween(Integer value1, Integer value2) {
            addCriterion("ques_ans_id between", value1, value2, "quesAnsId");
            return (Criteria) this;
        }

        public Criteria andQuesAnsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ques_ans_id not between", value1, value2, "quesAnsId");
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

        public Criteria andAbilityTypeIdIsNull() {
            addCriterion("ability_type_id is null");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdIsNotNull() {
            addCriterion("ability_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdEqualTo(Integer value) {
            addCriterion("ability_type_id =", value, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdNotEqualTo(Integer value) {
            addCriterion("ability_type_id <>", value, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdGreaterThan(Integer value) {
            addCriterion("ability_type_id >", value, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ability_type_id >=", value, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdLessThan(Integer value) {
            addCriterion("ability_type_id <", value, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("ability_type_id <=", value, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdIn(List<Integer> values) {
            addCriterion("ability_type_id in", values, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdNotIn(List<Integer> values) {
            addCriterion("ability_type_id not in", values, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("ability_type_id between", value1, value2, "abilityTypeId");
            return (Criteria) this;
        }

        public Criteria andAbilityTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ability_type_id not between", value1, value2, "abilityTypeId");
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