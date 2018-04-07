package top.keking.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KkRecommendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KkRecommendExample() {
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

        public Criteria andRecommendidIsNull() {
            addCriterion("recommendId is null");
            return (Criteria) this;
        }

        public Criteria andRecommendidIsNotNull() {
            addCriterion("recommendId is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendidEqualTo(String value) {
            addCriterion("recommendId =", value, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidNotEqualTo(String value) {
            addCriterion("recommendId <>", value, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidGreaterThan(String value) {
            addCriterion("recommendId >", value, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidGreaterThanOrEqualTo(String value) {
            addCriterion("recommendId >=", value, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidLessThan(String value) {
            addCriterion("recommendId <", value, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidLessThanOrEqualTo(String value) {
            addCriterion("recommendId <=", value, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidLike(String value) {
            addCriterion("recommendId like", value, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidNotLike(String value) {
            addCriterion("recommendId not like", value, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidIn(List<String> values) {
            addCriterion("recommendId in", values, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidNotIn(List<String> values) {
            addCriterion("recommendId not in", values, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidBetween(String value1, String value2) {
            addCriterion("recommendId between", value1, value2, "recommendid");
            return (Criteria) this;
        }

        public Criteria andRecommendidNotBetween(String value1, String value2) {
            addCriterion("recommendId not between", value1, value2, "recommendid");
            return (Criteria) this;
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