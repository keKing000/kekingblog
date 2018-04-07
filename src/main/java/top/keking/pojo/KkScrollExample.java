package top.keking.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KkScrollExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KkScrollExample() {
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

        public Criteria andScrollidIsNull() {
            addCriterion("scrollId is null");
            return (Criteria) this;
        }

        public Criteria andScrollidIsNotNull() {
            addCriterion("scrollId is not null");
            return (Criteria) this;
        }

        public Criteria andScrollidEqualTo(String value) {
            addCriterion("scrollId =", value, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidNotEqualTo(String value) {
            addCriterion("scrollId <>", value, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidGreaterThan(String value) {
            addCriterion("scrollId >", value, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidGreaterThanOrEqualTo(String value) {
            addCriterion("scrollId >=", value, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidLessThan(String value) {
            addCriterion("scrollId <", value, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidLessThanOrEqualTo(String value) {
            addCriterion("scrollId <=", value, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidLike(String value) {
            addCriterion("scrollId like", value, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidNotLike(String value) {
            addCriterion("scrollId not like", value, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidIn(List<String> values) {
            addCriterion("scrollId in", values, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidNotIn(List<String> values) {
            addCriterion("scrollId not in", values, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidBetween(String value1, String value2) {
            addCriterion("scrollId between", value1, value2, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrollidNotBetween(String value1, String value2) {
            addCriterion("scrollId not between", value1, value2, "scrollid");
            return (Criteria) this;
        }

        public Criteria andScrolltitleIsNull() {
            addCriterion("scrollTitle is null");
            return (Criteria) this;
        }

        public Criteria andScrolltitleIsNotNull() {
            addCriterion("scrollTitle is not null");
            return (Criteria) this;
        }

        public Criteria andScrolltitleEqualTo(String value) {
            addCriterion("scrollTitle =", value, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleNotEqualTo(String value) {
            addCriterion("scrollTitle <>", value, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleGreaterThan(String value) {
            addCriterion("scrollTitle >", value, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleGreaterThanOrEqualTo(String value) {
            addCriterion("scrollTitle >=", value, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleLessThan(String value) {
            addCriterion("scrollTitle <", value, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleLessThanOrEqualTo(String value) {
            addCriterion("scrollTitle <=", value, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleLike(String value) {
            addCriterion("scrollTitle like", value, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleNotLike(String value) {
            addCriterion("scrollTitle not like", value, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleIn(List<String> values) {
            addCriterion("scrollTitle in", values, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleNotIn(List<String> values) {
            addCriterion("scrollTitle not in", values, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleBetween(String value1, String value2) {
            addCriterion("scrollTitle between", value1, value2, "scrolltitle");
            return (Criteria) this;
        }

        public Criteria andScrolltitleNotBetween(String value1, String value2) {
            addCriterion("scrollTitle not between", value1, value2, "scrolltitle");
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

        public Criteria andScrollimgIsNull() {
            addCriterion("scrollImg is null");
            return (Criteria) this;
        }

        public Criteria andScrollimgIsNotNull() {
            addCriterion("scrollImg is not null");
            return (Criteria) this;
        }

        public Criteria andScrollimgEqualTo(String value) {
            addCriterion("scrollImg =", value, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgNotEqualTo(String value) {
            addCriterion("scrollImg <>", value, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgGreaterThan(String value) {
            addCriterion("scrollImg >", value, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgGreaterThanOrEqualTo(String value) {
            addCriterion("scrollImg >=", value, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgLessThan(String value) {
            addCriterion("scrollImg <", value, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgLessThanOrEqualTo(String value) {
            addCriterion("scrollImg <=", value, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgLike(String value) {
            addCriterion("scrollImg like", value, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgNotLike(String value) {
            addCriterion("scrollImg not like", value, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgIn(List<String> values) {
            addCriterion("scrollImg in", values, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgNotIn(List<String> values) {
            addCriterion("scrollImg not in", values, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgBetween(String value1, String value2) {
            addCriterion("scrollImg between", value1, value2, "scrollimg");
            return (Criteria) this;
        }

        public Criteria andScrollimgNotBetween(String value1, String value2) {
            addCriterion("scrollImg not between", value1, value2, "scrollimg");
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