package com.piza.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeixinAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeixinAccountExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andServerUrlIsNull() {
            addCriterion("server_url is null");
            return (Criteria) this;
        }

        public Criteria andServerUrlIsNotNull() {
            addCriterion("server_url is not null");
            return (Criteria) this;
        }

        public Criteria andServerUrlEqualTo(String value) {
            addCriterion("server_url =", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlNotEqualTo(String value) {
            addCriterion("server_url <>", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlGreaterThan(String value) {
            addCriterion("server_url >", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("server_url >=", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlLessThan(String value) {
            addCriterion("server_url <", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlLessThanOrEqualTo(String value) {
            addCriterion("server_url <=", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlLike(String value) {
            addCriterion("server_url like", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlNotLike(String value) {
            addCriterion("server_url not like", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlIn(List<String> values) {
            addCriterion("server_url in", values, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlNotIn(List<String> values) {
            addCriterion("server_url not in", values, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlBetween(String value1, String value2) {
            addCriterion("server_url between", value1, value2, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlNotBetween(String value1, String value2) {
            addCriterion("server_url not between", value1, value2, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andWeixinIdIsNull() {
            addCriterion("weixin_id is null");
            return (Criteria) this;
        }

        public Criteria andWeixinIdIsNotNull() {
            addCriterion("weixin_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinIdEqualTo(String value) {
            addCriterion("weixin_id =", value, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdNotEqualTo(String value) {
            addCriterion("weixin_id <>", value, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdGreaterThan(String value) {
            addCriterion("weixin_id >", value, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_id >=", value, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdLessThan(String value) {
            addCriterion("weixin_id <", value, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdLessThanOrEqualTo(String value) {
            addCriterion("weixin_id <=", value, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdLike(String value) {
            addCriterion("weixin_id like", value, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdNotLike(String value) {
            addCriterion("weixin_id not like", value, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdIn(List<String> values) {
            addCriterion("weixin_id in", values, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdNotIn(List<String> values) {
            addCriterion("weixin_id not in", values, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdBetween(String value1, String value2) {
            addCriterion("weixin_id between", value1, value2, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinIdNotBetween(String value1, String value2) {
            addCriterion("weixin_id not between", value1, value2, "weixinId");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeIsNull() {
            addCriterion("weixin_code is null");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeIsNotNull() {
            addCriterion("weixin_code is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeEqualTo(String value) {
            addCriterion("weixin_code =", value, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeNotEqualTo(String value) {
            addCriterion("weixin_code <>", value, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeGreaterThan(String value) {
            addCriterion("weixin_code >", value, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_code >=", value, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeLessThan(String value) {
            addCriterion("weixin_code <", value, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeLessThanOrEqualTo(String value) {
            addCriterion("weixin_code <=", value, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeLike(String value) {
            addCriterion("weixin_code like", value, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeNotLike(String value) {
            addCriterion("weixin_code not like", value, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeIn(List<String> values) {
            addCriterion("weixin_code in", values, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeNotIn(List<String> values) {
            addCriterion("weixin_code not in", values, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeBetween(String value1, String value2) {
            addCriterion("weixin_code between", value1, value2, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeNotBetween(String value1, String value2) {
            addCriterion("weixin_code not between", value1, value2, "weixinCode");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgIsNull() {
            addCriterion("weixin_code_img is null");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgIsNotNull() {
            addCriterion("weixin_code_img is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgEqualTo(String value) {
            addCriterion("weixin_code_img =", value, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgNotEqualTo(String value) {
            addCriterion("weixin_code_img <>", value, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgGreaterThan(String value) {
            addCriterion("weixin_code_img >", value, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_code_img >=", value, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgLessThan(String value) {
            addCriterion("weixin_code_img <", value, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgLessThanOrEqualTo(String value) {
            addCriterion("weixin_code_img <=", value, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgLike(String value) {
            addCriterion("weixin_code_img like", value, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgNotLike(String value) {
            addCriterion("weixin_code_img not like", value, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgIn(List<String> values) {
            addCriterion("weixin_code_img in", values, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgNotIn(List<String> values) {
            addCriterion("weixin_code_img not in", values, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgBetween(String value1, String value2) {
            addCriterion("weixin_code_img between", value1, value2, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andWeixinCodeImgNotBetween(String value1, String value2) {
            addCriterion("weixin_code_img not between", value1, value2, "weixinCodeImg");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNull() {
            addCriterion("app_key is null");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNotNull() {
            addCriterion("app_key is not null");
            return (Criteria) this;
        }

        public Criteria andAppKeyEqualTo(String value) {
            addCriterion("app_key =", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualTo(String value) {
            addCriterion("app_key <>", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThan(String value) {
            addCriterion("app_key >", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_key >=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThan(String value) {
            addCriterion("app_key <", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualTo(String value) {
            addCriterion("app_key <=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLike(String value) {
            addCriterion("app_key like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotLike(String value) {
            addCriterion("app_key not like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyIn(List<String> values) {
            addCriterion("app_key in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotIn(List<String> values) {
            addCriterion("app_key not in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyBetween(String value1, String value2) {
            addCriterion("app_key between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotBetween(String value1, String value2) {
            addCriterion("app_key not between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppTokenIsNull() {
            addCriterion("app_token is null");
            return (Criteria) this;
        }

        public Criteria andAppTokenIsNotNull() {
            addCriterion("app_token is not null");
            return (Criteria) this;
        }

        public Criteria andAppTokenEqualTo(String value) {
            addCriterion("app_token =", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenNotEqualTo(String value) {
            addCriterion("app_token <>", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenGreaterThan(String value) {
            addCriterion("app_token >", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenGreaterThanOrEqualTo(String value) {
            addCriterion("app_token >=", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenLessThan(String value) {
            addCriterion("app_token <", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenLessThanOrEqualTo(String value) {
            addCriterion("app_token <=", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenLike(String value) {
            addCriterion("app_token like", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenNotLike(String value) {
            addCriterion("app_token not like", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenIn(List<String> values) {
            addCriterion("app_token in", values, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenNotIn(List<String> values) {
            addCriterion("app_token not in", values, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenBetween(String value1, String value2) {
            addCriterion("app_token between", value1, value2, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenNotBetween(String value1, String value2) {
            addCriterion("app_token not between", value1, value2, "appToken");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andAccountCodeIsNull() {
            addCriterion("account_code is null");
            return (Criteria) this;
        }

        public Criteria andAccountCodeIsNotNull() {
            addCriterion("account_code is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCodeEqualTo(String value) {
            addCriterion("account_code =", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeNotEqualTo(String value) {
            addCriterion("account_code <>", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeGreaterThan(String value) {
            addCriterion("account_code >", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeGreaterThanOrEqualTo(String value) {
            addCriterion("account_code >=", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeLessThan(String value) {
            addCriterion("account_code <", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeLessThanOrEqualTo(String value) {
            addCriterion("account_code <=", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeLike(String value) {
            addCriterion("account_code like", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeNotLike(String value) {
            addCriterion("account_code not like", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeIn(List<String> values) {
            addCriterion("account_code in", values, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeNotIn(List<String> values) {
            addCriterion("account_code not in", values, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeBetween(String value1, String value2) {
            addCriterion("account_code between", value1, value2, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeNotBetween(String value1, String value2) {
            addCriterion("account_code not between", value1, value2, "accountCode");
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