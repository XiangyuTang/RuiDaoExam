package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        public Criteria andNewsIdIsNull() {
            addCriterion("news_id is null");
            return (Criteria) this;
        }

        public Criteria andNewsIdIsNotNull() {
            addCriterion("news_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewsIdEqualTo(Integer value) {
            addCriterion("news_id =", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotEqualTo(Integer value) {
            addCriterion("news_id <>", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThan(Integer value) {
            addCriterion("news_id >", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_id >=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThan(Integer value) {
            addCriterion("news_id <", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThanOrEqualTo(Integer value) {
            addCriterion("news_id <=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdIn(List<Integer> values) {
            addCriterion("news_id in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotIn(List<Integer> values) {
            addCriterion("news_id not in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdBetween(Integer value1, Integer value2) {
            addCriterion("news_id between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("news_id not between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdIsNull() {
            addCriterion("receive_type_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdIsNotNull() {
            addCriterion("receive_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdEqualTo(Integer value) {
            addCriterion("receive_type_id =", value, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdNotEqualTo(Integer value) {
            addCriterion("receive_type_id <>", value, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdGreaterThan(Integer value) {
            addCriterion("receive_type_id >", value, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_type_id >=", value, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdLessThan(Integer value) {
            addCriterion("receive_type_id <", value, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("receive_type_id <=", value, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdIn(List<Integer> values) {
            addCriterion("receive_type_id in", values, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdNotIn(List<Integer> values) {
            addCriterion("receive_type_id not in", values, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("receive_type_id between", value1, value2, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_type_id not between", value1, value2, "receiveTypeId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdIsNull() {
            addCriterion("receive_teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdIsNotNull() {
            addCriterion("receive_teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdEqualTo(Integer value) {
            addCriterion("receive_teacher_id =", value, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdNotEqualTo(Integer value) {
            addCriterion("receive_teacher_id <>", value, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdGreaterThan(Integer value) {
            addCriterion("receive_teacher_id >", value, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_teacher_id >=", value, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdLessThan(Integer value) {
            addCriterion("receive_teacher_id <", value, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("receive_teacher_id <=", value, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdIn(List<Integer> values) {
            addCriterion("receive_teacher_id in", values, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdNotIn(List<Integer> values) {
            addCriterion("receive_teacher_id not in", values, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("receive_teacher_id between", value1, value2, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_teacher_id not between", value1, value2, "receiveTeacherId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdIsNull() {
            addCriterion("receive_student_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdIsNotNull() {
            addCriterion("receive_student_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdEqualTo(Integer value) {
            addCriterion("receive_student_id =", value, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdNotEqualTo(Integer value) {
            addCriterion("receive_student_id <>", value, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdGreaterThan(Integer value) {
            addCriterion("receive_student_id >", value, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_student_id >=", value, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdLessThan(Integer value) {
            addCriterion("receive_student_id <", value, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("receive_student_id <=", value, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdIn(List<Integer> values) {
            addCriterion("receive_student_id in", values, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdNotIn(List<Integer> values) {
            addCriterion("receive_student_id not in", values, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("receive_student_id between", value1, value2, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andReceiveStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_student_id not between", value1, value2, "receiveStudentId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdIsNull() {
            addCriterion("send_type_id is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdIsNotNull() {
            addCriterion("send_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdEqualTo(Integer value) {
            addCriterion("send_type_id =", value, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdNotEqualTo(Integer value) {
            addCriterion("send_type_id <>", value, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdGreaterThan(Integer value) {
            addCriterion("send_type_id >", value, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_type_id >=", value, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdLessThan(Integer value) {
            addCriterion("send_type_id <", value, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("send_type_id <=", value, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdIn(List<Integer> values) {
            addCriterion("send_type_id in", values, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdNotIn(List<Integer> values) {
            addCriterion("send_type_id not in", values, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("send_type_id between", value1, value2, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("send_type_id not between", value1, value2, "sendTypeId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdIsNull() {
            addCriterion("send_teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdIsNotNull() {
            addCriterion("send_teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdEqualTo(Integer value) {
            addCriterion("send_teacher_id =", value, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdNotEqualTo(Integer value) {
            addCriterion("send_teacher_id <>", value, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdGreaterThan(Integer value) {
            addCriterion("send_teacher_id >", value, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_teacher_id >=", value, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdLessThan(Integer value) {
            addCriterion("send_teacher_id <", value, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("send_teacher_id <=", value, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdIn(List<Integer> values) {
            addCriterion("send_teacher_id in", values, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdNotIn(List<Integer> values) {
            addCriterion("send_teacher_id not in", values, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("send_teacher_id between", value1, value2, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("send_teacher_id not between", value1, value2, "sendTeacherId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdIsNull() {
            addCriterion("send_student_id is null");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdIsNotNull() {
            addCriterion("send_student_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdEqualTo(Integer value) {
            addCriterion("send_student_id =", value, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdNotEqualTo(Integer value) {
            addCriterion("send_student_id <>", value, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdGreaterThan(Integer value) {
            addCriterion("send_student_id >", value, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_student_id >=", value, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdLessThan(Integer value) {
            addCriterion("send_student_id <", value, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("send_student_id <=", value, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdIn(List<Integer> values) {
            addCriterion("send_student_id in", values, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdNotIn(List<Integer> values) {
            addCriterion("send_student_id not in", values, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("send_student_id between", value1, value2, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("send_student_id not between", value1, value2, "sendStudentId");
            return (Criteria) this;
        }

        public Criteria andSendNameIsNull() {
            addCriterion("send_name is null");
            return (Criteria) this;
        }

        public Criteria andSendNameIsNotNull() {
            addCriterion("send_name is not null");
            return (Criteria) this;
        }

        public Criteria andSendNameEqualTo(String value) {
            addCriterion("send_name =", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotEqualTo(String value) {
            addCriterion("send_name <>", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameGreaterThan(String value) {
            addCriterion("send_name >", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameGreaterThanOrEqualTo(String value) {
            addCriterion("send_name >=", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLessThan(String value) {
            addCriterion("send_name <", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLessThanOrEqualTo(String value) {
            addCriterion("send_name <=", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLike(String value) {
            addCriterion("send_name like", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotLike(String value) {
            addCriterion("send_name not like", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameIn(List<String> values) {
            addCriterion("send_name in", values, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotIn(List<String> values) {
            addCriterion("send_name not in", values, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameBetween(String value1, String value2) {
            addCriterion("send_name between", value1, value2, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotBetween(String value1, String value2) {
            addCriterion("send_name not between", value1, value2, "sendName");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIsNull() {
            addCriterion("news_type is null");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIsNotNull() {
            addCriterion("news_type is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTypeEqualTo(Integer value) {
            addCriterion("news_type =", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotEqualTo(Integer value) {
            addCriterion("news_type <>", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeGreaterThan(Integer value) {
            addCriterion("news_type >", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_type >=", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeLessThan(Integer value) {
            addCriterion("news_type <", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("news_type <=", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIn(List<Integer> values) {
            addCriterion("news_type in", values, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotIn(List<Integer> values) {
            addCriterion("news_type not in", values, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeBetween(Integer value1, Integer value2) {
            addCriterion("news_type between", value1, value2, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("news_type not between", value1, value2, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIsNull() {
            addCriterion("news_time is null");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIsNotNull() {
            addCriterion("news_time is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTimeEqualTo(Date value) {
            addCriterion("news_time =", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotEqualTo(Date value) {
            addCriterion("news_time <>", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeGreaterThan(Date value) {
            addCriterion("news_time >", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("news_time >=", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeLessThan(Date value) {
            addCriterion("news_time <", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeLessThanOrEqualTo(Date value) {
            addCriterion("news_time <=", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIn(List<Date> values) {
            addCriterion("news_time in", values, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotIn(List<Date> values) {
            addCriterion("news_time not in", values, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeBetween(Date value1, Date value2) {
            addCriterion("news_time between", value1, value2, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotBetween(Date value1, Date value2) {
            addCriterion("news_time not between", value1, value2, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsContentIsNull() {
            addCriterion("news_content is null");
            return (Criteria) this;
        }

        public Criteria andNewsContentIsNotNull() {
            addCriterion("news_content is not null");
            return (Criteria) this;
        }

        public Criteria andNewsContentEqualTo(String value) {
            addCriterion("news_content =", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentNotEqualTo(String value) {
            addCriterion("news_content <>", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentGreaterThan(String value) {
            addCriterion("news_content >", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentGreaterThanOrEqualTo(String value) {
            addCriterion("news_content >=", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentLessThan(String value) {
            addCriterion("news_content <", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentLessThanOrEqualTo(String value) {
            addCriterion("news_content <=", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentLike(String value) {
            addCriterion("news_content like", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentNotLike(String value) {
            addCriterion("news_content not like", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentIn(List<String> values) {
            addCriterion("news_content in", values, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentNotIn(List<String> values) {
            addCriterion("news_content not in", values, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentBetween(String value1, String value2) {
            addCriterion("news_content between", value1, value2, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentNotBetween(String value1, String value2) {
            addCriterion("news_content not between", value1, value2, "newsContent");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Integer> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Integer> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("reserve1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("reserve1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(String value) {
            addCriterion("reserve1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(String value) {
            addCriterion("reserve1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(String value) {
            addCriterion("reserve1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(String value) {
            addCriterion("reserve1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(String value) {
            addCriterion("reserve1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(String value) {
            addCriterion("reserve1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Like(String value) {
            addCriterion("reserve1 like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotLike(String value) {
            addCriterion("reserve1 not like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<String> values) {
            addCriterion("reserve1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<String> values) {
            addCriterion("reserve1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(String value1, String value2) {
            addCriterion("reserve1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(String value1, String value2) {
            addCriterion("reserve1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("reserve2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("reserve2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(Integer value) {
            addCriterion("reserve2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(Integer value) {
            addCriterion("reserve2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(Integer value) {
            addCriterion("reserve2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(Integer value) {
            addCriterion("reserve2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(Integer value) {
            addCriterion("reserve2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<Integer> values) {
            addCriterion("reserve2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<Integer> values) {
            addCriterion("reserve2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(Integer value1, Integer value2) {
            addCriterion("reserve2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(Integer value1, Integer value2) {
            addCriterion("reserve2 not between", value1, value2, "reserve2");
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