package top.keking.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KkBlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KkBlogExample() {
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

        public Criteria andBlogidIsNull() {
            addCriterion("blogId is null");
            return (Criteria) this;
        }

        public Criteria andBlogidIsNotNull() {
            addCriterion("blogId is not null");
            return (Criteria) this;
        }

        public Criteria andBlogidEqualTo(String value) {
            addCriterion("blogId =", value, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidNotEqualTo(String value) {
            addCriterion("blogId <>", value, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidGreaterThan(String value) {
            addCriterion("blogId >", value, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidGreaterThanOrEqualTo(String value) {
            addCriterion("blogId >=", value, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidLessThan(String value) {
            addCriterion("blogId <", value, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidLessThanOrEqualTo(String value) {
            addCriterion("blogId <=", value, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidLike(String value) {
            addCriterion("blogId like", value, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidNotLike(String value) {
            addCriterion("blogId not like", value, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidIn(List<String> values) {
            addCriterion("blogId in", values, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidNotIn(List<String> values) {
            addCriterion("blogId not in", values, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidBetween(String value1, String value2) {
            addCriterion("blogId between", value1, value2, "blogid");
            return (Criteria) this;
        }

        public Criteria andBlogidNotBetween(String value1, String value2) {
            addCriterion("blogId not between", value1, value2, "blogid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andBlogtitleIsNull() {
            addCriterion("blogTitle is null");
            return (Criteria) this;
        }

        public Criteria andBlogtitleIsNotNull() {
            addCriterion("blogTitle is not null");
            return (Criteria) this;
        }

        public Criteria andBlogtitleEqualTo(String value) {
            addCriterion("blogTitle =", value, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleNotEqualTo(String value) {
            addCriterion("blogTitle <>", value, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleGreaterThan(String value) {
            addCriterion("blogTitle >", value, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleGreaterThanOrEqualTo(String value) {
            addCriterion("blogTitle >=", value, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleLessThan(String value) {
            addCriterion("blogTitle <", value, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleLessThanOrEqualTo(String value) {
            addCriterion("blogTitle <=", value, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleLike(String value) {
            addCriterion("blogTitle like", value, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleNotLike(String value) {
            addCriterion("blogTitle not like", value, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleIn(List<String> values) {
            addCriterion("blogTitle in", values, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleNotIn(List<String> values) {
            addCriterion("blogTitle not in", values, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleBetween(String value1, String value2) {
            addCriterion("blogTitle between", value1, value2, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andBlogtitleNotBetween(String value1, String value2) {
            addCriterion("blogTitle not between", value1, value2, "blogtitle");
            return (Criteria) this;
        }

        public Criteria andDescidIsNull() {
            addCriterion("descId is null");
            return (Criteria) this;
        }

        public Criteria andDescidIsNotNull() {
            addCriterion("descId is not null");
            return (Criteria) this;
        }

        public Criteria andDescidEqualTo(String value) {
            addCriterion("descId =", value, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidNotEqualTo(String value) {
            addCriterion("descId <>", value, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidGreaterThan(String value) {
            addCriterion("descId >", value, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidGreaterThanOrEqualTo(String value) {
            addCriterion("descId >=", value, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidLessThan(String value) {
            addCriterion("descId <", value, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidLessThanOrEqualTo(String value) {
            addCriterion("descId <=", value, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidLike(String value) {
            addCriterion("descId like", value, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidNotLike(String value) {
            addCriterion("descId not like", value, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidIn(List<String> values) {
            addCriterion("descId in", values, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidNotIn(List<String> values) {
            addCriterion("descId not in", values, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidBetween(String value1, String value2) {
            addCriterion("descId between", value1, value2, "descid");
            return (Criteria) this;
        }

        public Criteria andDescidNotBetween(String value1, String value2) {
            addCriterion("descId not between", value1, value2, "descid");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNull() {
            addCriterion("creatDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNotNull() {
            addCriterion("creatDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatdateEqualTo(Date value) {
            addCriterion("creatDate =", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotEqualTo(Date value) {
            addCriterion("creatDate <>", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThan(Date value) {
            addCriterion("creatDate >", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThanOrEqualTo(Date value) {
            addCriterion("creatDate >=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThan(Date value) {
            addCriterion("creatDate <", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThanOrEqualTo(Date value) {
            addCriterion("creatDate <=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateIn(List<Date> values) {
            addCriterion("creatDate in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotIn(List<Date> values) {
            addCriterion("creatDate not in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateBetween(Date value1, Date value2) {
            addCriterion("creatDate between", value1, value2, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotBetween(Date value1, Date value2) {
            addCriterion("creatDate not between", value1, value2, "creatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(Date value) {
            addCriterion("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(Date value) {
            addCriterion("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(Date value) {
            addCriterion("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(Date value) {
            addCriterion("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(Date value) {
            addCriterion("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<Date> values) {
            addCriterion("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<Date> values) {
            addCriterion("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(Date value1, Date value2) {
            addCriterion("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(Date value1, Date value2) {
            addCriterion("updateDate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andKeepnumIsNull() {
            addCriterion("keepNum is null");
            return (Criteria) this;
        }

        public Criteria andKeepnumIsNotNull() {
            addCriterion("keepNum is not null");
            return (Criteria) this;
        }

        public Criteria andKeepnumEqualTo(Integer value) {
            addCriterion("keepNum =", value, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumNotEqualTo(Integer value) {
            addCriterion("keepNum <>", value, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumGreaterThan(Integer value) {
            addCriterion("keepNum >", value, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("keepNum >=", value, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumLessThan(Integer value) {
            addCriterion("keepNum <", value, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumLessThanOrEqualTo(Integer value) {
            addCriterion("keepNum <=", value, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumIn(List<Integer> values) {
            addCriterion("keepNum in", values, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumNotIn(List<Integer> values) {
            addCriterion("keepNum not in", values, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumBetween(Integer value1, Integer value2) {
            addCriterion("keepNum between", value1, value2, "keepnum");
            return (Criteria) this;
        }

        public Criteria andKeepnumNotBetween(Integer value1, Integer value2) {
            addCriterion("keepNum not between", value1, value2, "keepnum");
            return (Criteria) this;
        }

        public Criteria andReadnumIsNull() {
            addCriterion("readNum is null");
            return (Criteria) this;
        }

        public Criteria andReadnumIsNotNull() {
            addCriterion("readNum is not null");
            return (Criteria) this;
        }

        public Criteria andReadnumEqualTo(Integer value) {
            addCriterion("readNum =", value, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumNotEqualTo(Integer value) {
            addCriterion("readNum <>", value, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumGreaterThan(Integer value) {
            addCriterion("readNum >", value, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("readNum >=", value, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumLessThan(Integer value) {
            addCriterion("readNum <", value, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumLessThanOrEqualTo(Integer value) {
            addCriterion("readNum <=", value, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumIn(List<Integer> values) {
            addCriterion("readNum in", values, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumNotIn(List<Integer> values) {
            addCriterion("readNum not in", values, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumBetween(Integer value1, Integer value2) {
            addCriterion("readNum between", value1, value2, "readnum");
            return (Criteria) this;
        }

        public Criteria andReadnumNotBetween(Integer value1, Integer value2) {
            addCriterion("readNum not between", value1, value2, "readnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumIsNull() {
            addCriterion("reviewNum is null");
            return (Criteria) this;
        }

        public Criteria andReviewnumIsNotNull() {
            addCriterion("reviewNum is not null");
            return (Criteria) this;
        }

        public Criteria andReviewnumEqualTo(Integer value) {
            addCriterion("reviewNum =", value, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumNotEqualTo(Integer value) {
            addCriterion("reviewNum <>", value, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumGreaterThan(Integer value) {
            addCriterion("reviewNum >", value, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("reviewNum >=", value, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumLessThan(Integer value) {
            addCriterion("reviewNum <", value, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumLessThanOrEqualTo(Integer value) {
            addCriterion("reviewNum <=", value, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumIn(List<Integer> values) {
            addCriterion("reviewNum in", values, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumNotIn(List<Integer> values) {
            addCriterion("reviewNum not in", values, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumBetween(Integer value1, Integer value2) {
            addCriterion("reviewNum between", value1, value2, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andReviewnumNotBetween(Integer value1, Integer value2) {
            addCriterion("reviewNum not between", value1, value2, "reviewnum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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