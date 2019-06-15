package com.neuedu.ruidaoexam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportExample() {
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

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(Integer value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(Integer value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(Integer value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(Integer value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<Integer> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<Integer> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(Integer value1, Integer value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
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

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreIsNull() {
            addCriterion("acquired_score is null");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreIsNotNull() {
            addCriterion("acquired_score is not null");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreEqualTo(Integer value) {
            addCriterion("acquired_score =", value, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreNotEqualTo(Integer value) {
            addCriterion("acquired_score <>", value, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreGreaterThan(Integer value) {
            addCriterion("acquired_score >", value, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("acquired_score >=", value, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreLessThan(Integer value) {
            addCriterion("acquired_score <", value, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreLessThanOrEqualTo(Integer value) {
            addCriterion("acquired_score <=", value, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreIn(List<Integer> values) {
            addCriterion("acquired_score in", values, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreNotIn(List<Integer> values) {
            addCriterion("acquired_score not in", values, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreBetween(Integer value1, Integer value2) {
            addCriterion("acquired_score between", value1, value2, "acquiredScore");
            return (Criteria) this;
        }

        public Criteria andAcquiredScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("acquired_score not between", value1, value2, "acquiredScore");
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

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampIsNull() {
            addCriterion("begin_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampIsNotNull() {
            addCriterion("begin_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampEqualTo(Date value) {
            addCriterion("begin_timestamp =", value, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampNotEqualTo(Date value) {
            addCriterion("begin_timestamp <>", value, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampGreaterThan(Date value) {
            addCriterion("begin_timestamp >", value, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_timestamp >=", value, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampLessThan(Date value) {
            addCriterion("begin_timestamp <", value, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampLessThanOrEqualTo(Date value) {
            addCriterion("begin_timestamp <=", value, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampIn(List<Date> values) {
            addCriterion("begin_timestamp in", values, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampNotIn(List<Date> values) {
            addCriterion("begin_timestamp not in", values, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampBetween(Date value1, Date value2) {
            addCriterion("begin_timestamp between", value1, value2, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andBeginTimestampNotBetween(Date value1, Date value2) {
            addCriterion("begin_timestamp not between", value1, value2, "beginTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampIsNull() {
            addCriterion("end_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andEndTimestampIsNotNull() {
            addCriterion("end_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimestampEqualTo(Date value) {
            addCriterion("end_timestamp =", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampNotEqualTo(Date value) {
            addCriterion("end_timestamp <>", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampGreaterThan(Date value) {
            addCriterion("end_timestamp >", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("end_timestamp >=", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampLessThan(Date value) {
            addCriterion("end_timestamp <", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampLessThanOrEqualTo(Date value) {
            addCriterion("end_timestamp <=", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampIn(List<Date> values) {
            addCriterion("end_timestamp in", values, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampNotIn(List<Date> values) {
            addCriterion("end_timestamp not in", values, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampBetween(Date value1, Date value2) {
            addCriterion("end_timestamp between", value1, value2, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampNotBetween(Date value1, Date value2) {
            addCriterion("end_timestamp not between", value1, value2, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesIsNull() {
            addCriterion("switch_times is null");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesIsNotNull() {
            addCriterion("switch_times is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesEqualTo(Integer value) {
            addCriterion("switch_times =", value, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesNotEqualTo(Integer value) {
            addCriterion("switch_times <>", value, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesGreaterThan(Integer value) {
            addCriterion("switch_times >", value, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("switch_times >=", value, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesLessThan(Integer value) {
            addCriterion("switch_times <", value, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesLessThanOrEqualTo(Integer value) {
            addCriterion("switch_times <=", value, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesIn(List<Integer> values) {
            addCriterion("switch_times in", values, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesNotIn(List<Integer> values) {
            addCriterion("switch_times not in", values, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesBetween(Integer value1, Integer value2) {
            addCriterion("switch_times between", value1, value2, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andSwitchTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("switch_times not between", value1, value2, "switchTimes");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeIsNull() {
            addCriterion("is_allowed_to_see is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeIsNotNull() {
            addCriterion("is_allowed_to_see is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeEqualTo(Integer value) {
            addCriterion("is_allowed_to_see =", value, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeNotEqualTo(Integer value) {
            addCriterion("is_allowed_to_see <>", value, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeGreaterThan(Integer value) {
            addCriterion("is_allowed_to_see >", value, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_allowed_to_see >=", value, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeLessThan(Integer value) {
            addCriterion("is_allowed_to_see <", value, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeLessThanOrEqualTo(Integer value) {
            addCriterion("is_allowed_to_see <=", value, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeIn(List<Integer> values) {
            addCriterion("is_allowed_to_see in", values, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeNotIn(List<Integer> values) {
            addCriterion("is_allowed_to_see not in", values, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeBetween(Integer value1, Integer value2) {
            addCriterion("is_allowed_to_see between", value1, value2, "isAllowedToSee");
            return (Criteria) this;
        }

        public Criteria andIsAllowedToSeeNotBetween(Integer value1, Integer value2) {
            addCriterion("is_allowed_to_see not between", value1, value2, "isAllowedToSee");
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