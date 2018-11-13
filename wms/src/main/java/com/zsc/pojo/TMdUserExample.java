package com.zsc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMdUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMdUserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("DEL is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("DEL is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Integer value) {
            addCriterion("DEL =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Integer value) {
            addCriterion("DEL <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Integer value) {
            addCriterion("DEL >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEL >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Integer value) {
            addCriterion("DEL <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Integer value) {
            addCriterion("DEL <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Integer> values) {
            addCriterion("DEL in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Integer> values) {
            addCriterion("DEL not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Integer value1, Integer value2) {
            addCriterion("DEL between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Integer value1, Integer value2) {
            addCriterion("DEL not between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(String value) {
            addCriterion("LOGIN_TIME =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(String value) {
            addCriterion("LOGIN_TIME <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(String value) {
            addCriterion("LOGIN_TIME >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_TIME >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(String value) {
            addCriterion("LOGIN_TIME <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_TIME <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLike(String value) {
            addCriterion("LOGIN_TIME like", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotLike(String value) {
            addCriterion("LOGIN_TIME not like", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<String> values) {
            addCriterion("LOGIN_TIME in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<String> values) {
            addCriterion("LOGIN_TIME not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(String value1, String value2) {
            addCriterion("LOGIN_TIME between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(String value1, String value2) {
            addCriterion("LOGIN_TIME not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andModiByIsNull() {
            addCriterion("MODI_BY is null");
            return (Criteria) this;
        }

        public Criteria andModiByIsNotNull() {
            addCriterion("MODI_BY is not null");
            return (Criteria) this;
        }

        public Criteria andModiByEqualTo(String value) {
            addCriterion("MODI_BY =", value, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByNotEqualTo(String value) {
            addCriterion("MODI_BY <>", value, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByGreaterThan(String value) {
            addCriterion("MODI_BY >", value, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByGreaterThanOrEqualTo(String value) {
            addCriterion("MODI_BY >=", value, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByLessThan(String value) {
            addCriterion("MODI_BY <", value, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByLessThanOrEqualTo(String value) {
            addCriterion("MODI_BY <=", value, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByLike(String value) {
            addCriterion("MODI_BY like", value, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByNotLike(String value) {
            addCriterion("MODI_BY not like", value, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByIn(List<String> values) {
            addCriterion("MODI_BY in", values, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByNotIn(List<String> values) {
            addCriterion("MODI_BY not in", values, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByBetween(String value1, String value2) {
            addCriterion("MODI_BY between", value1, value2, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiByNotBetween(String value1, String value2) {
            addCriterion("MODI_BY not between", value1, value2, "modiBy");
            return (Criteria) this;
        }

        public Criteria andModiTimeIsNull() {
            addCriterion("MODI_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModiTimeIsNotNull() {
            addCriterion("MODI_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModiTimeEqualTo(Date value) {
            addCriterion("MODI_TIME =", value, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeNotEqualTo(Date value) {
            addCriterion("MODI_TIME <>", value, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeGreaterThan(Date value) {
            addCriterion("MODI_TIME >", value, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODI_TIME >=", value, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeLessThan(Date value) {
            addCriterion("MODI_TIME <", value, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODI_TIME <=", value, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeIn(List<Date> values) {
            addCriterion("MODI_TIME in", values, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeNotIn(List<Date> values) {
            addCriterion("MODI_TIME not in", values, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeBetween(Date value1, Date value2) {
            addCriterion("MODI_TIME between", value1, value2, "modiTime");
            return (Criteria) this;
        }

        public Criteria andModiTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODI_TIME not between", value1, value2, "modiTime");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNull() {
            addCriterion("PASS_WORD is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("PASS_WORD is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("PASS_WORD =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("PASS_WORD <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("PASS_WORD >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("PASS_WORD >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("PASS_WORD <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("PASS_WORD <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("PASS_WORD like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("PASS_WORD not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("PASS_WORD in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("PASS_WORD not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("PASS_WORD between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("PASS_WORD not between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andTheOwnerIsNull() {
            addCriterion("THE_OWNER is null");
            return (Criteria) this;
        }

        public Criteria andTheOwnerIsNotNull() {
            addCriterion("THE_OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andTheOwnerEqualTo(String value) {
            addCriterion("THE_OWNER =", value, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerNotEqualTo(String value) {
            addCriterion("THE_OWNER <>", value, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerGreaterThan(String value) {
            addCriterion("THE_OWNER >", value, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("THE_OWNER >=", value, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerLessThan(String value) {
            addCriterion("THE_OWNER <", value, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerLessThanOrEqualTo(String value) {
            addCriterion("THE_OWNER <=", value, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerLike(String value) {
            addCriterion("THE_OWNER like", value, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerNotLike(String value) {
            addCriterion("THE_OWNER not like", value, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerIn(List<String> values) {
            addCriterion("THE_OWNER in", values, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerNotIn(List<String> values) {
            addCriterion("THE_OWNER not in", values, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerBetween(String value1, String value2) {
            addCriterion("THE_OWNER between", value1, value2, "theOwner");
            return (Criteria) this;
        }

        public Criteria andTheOwnerNotBetween(String value1, String value2) {
            addCriterion("THE_OWNER not between", value1, value2, "theOwner");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andWhCodeIsNull() {
            addCriterion("WH_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWhCodeIsNotNull() {
            addCriterion("WH_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWhCodeEqualTo(String value) {
            addCriterion("WH_CODE =", value, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeNotEqualTo(String value) {
            addCriterion("WH_CODE <>", value, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeGreaterThan(String value) {
            addCriterion("WH_CODE >", value, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WH_CODE >=", value, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeLessThan(String value) {
            addCriterion("WH_CODE <", value, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeLessThanOrEqualTo(String value) {
            addCriterion("WH_CODE <=", value, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeLike(String value) {
            addCriterion("WH_CODE like", value, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeNotLike(String value) {
            addCriterion("WH_CODE not like", value, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeIn(List<String> values) {
            addCriterion("WH_CODE in", values, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeNotIn(List<String> values) {
            addCriterion("WH_CODE not in", values, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeBetween(String value1, String value2) {
            addCriterion("WH_CODE between", value1, value2, "whCode");
            return (Criteria) this;
        }

        public Criteria andWhCodeNotBetween(String value1, String value2) {
            addCriterion("WH_CODE not between", value1, value2, "whCode");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlIsNull() {
            addCriterion("USER_PIC_URL is null");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlIsNotNull() {
            addCriterion("USER_PIC_URL is not null");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlEqualTo(String value) {
            addCriterion("USER_PIC_URL =", value, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlNotEqualTo(String value) {
            addCriterion("USER_PIC_URL <>", value, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlGreaterThan(String value) {
            addCriterion("USER_PIC_URL >", value, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PIC_URL >=", value, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlLessThan(String value) {
            addCriterion("USER_PIC_URL <", value, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlLessThanOrEqualTo(String value) {
            addCriterion("USER_PIC_URL <=", value, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlLike(String value) {
            addCriterion("USER_PIC_URL like", value, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlNotLike(String value) {
            addCriterion("USER_PIC_URL not like", value, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlIn(List<String> values) {
            addCriterion("USER_PIC_URL in", values, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlNotIn(List<String> values) {
            addCriterion("USER_PIC_URL not in", values, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlBetween(String value1, String value2) {
            addCriterion("USER_PIC_URL between", value1, value2, "userPicUrl");
            return (Criteria) this;
        }

        public Criteria andUserPicUrlNotBetween(String value1, String value2) {
            addCriterion("USER_PIC_URL not between", value1, value2, "userPicUrl");
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