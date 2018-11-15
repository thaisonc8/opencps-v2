/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.dossiermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.dossiermgt.model.PaymentConfig;
import org.opencps.dossiermgt.model.PaymentConfigModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PaymentConfig service. Represents a row in the &quot;opencps_paymentconfig&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PaymentConfigModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PaymentConfigImpl}.
 * </p>
 *
 * @author huymq
 * @see PaymentConfigImpl
 * @see PaymentConfig
 * @see PaymentConfigModel
 * @generated
 */
@ProviderType
public class PaymentConfigModelImpl extends BaseModelImpl<PaymentConfig>
	implements PaymentConfigModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a payment config model instance should use the {@link PaymentConfig} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_paymentconfig";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "paymentConfigId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "govAgencyCode", Types.VARCHAR },
			{ "govAgencyName", Types.VARCHAR },
			{ "govAgencyTaxNo", Types.VARCHAR },
			{ "invoiceTemplateNo", Types.VARCHAR },
			{ "invoiceIssueNo", Types.VARCHAR },
			{ "invoiceLastNo", Types.VARCHAR },
			{ "invoiceForm", Types.VARCHAR },
			{ "bankInfo", Types.VARCHAR },
			{ "epaymentConfig", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("paymentConfigId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("govAgencyCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("govAgencyName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("govAgencyTaxNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("invoiceTemplateNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("invoiceIssueNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("invoiceLastNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("invoiceForm", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bankInfo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("epaymentConfig", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_paymentconfig (uuid_ VARCHAR(75) null,paymentConfigId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,govAgencyCode VARCHAR(75) null,govAgencyName VARCHAR(75) null,govAgencyTaxNo VARCHAR(75) null,invoiceTemplateNo VARCHAR(75) null,invoiceIssueNo VARCHAR(75) null,invoiceLastNo VARCHAR(75) null,invoiceForm VARCHAR(75) null,bankInfo VARCHAR(75) null,epaymentConfig VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_paymentconfig";
	public static final String ORDER_BY_JPQL = " ORDER BY paymentConfig.paymentConfigId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_paymentconfig.paymentConfigId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.PaymentConfig"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.PaymentConfig"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.PaymentConfig"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GOVAGENCYCODE_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long INVOICETEMPLATENO_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long PAYMENTCONFIGID_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.PaymentConfig"));

	public PaymentConfigModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _paymentConfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPaymentConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _paymentConfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PaymentConfig.class;
	}

	@Override
	public String getModelClassName() {
		return PaymentConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("paymentConfigId", getPaymentConfigId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("govAgencyName", getGovAgencyName());
		attributes.put("govAgencyTaxNo", getGovAgencyTaxNo());
		attributes.put("invoiceTemplateNo", getInvoiceTemplateNo());
		attributes.put("invoiceIssueNo", getInvoiceIssueNo());
		attributes.put("invoiceLastNo", getInvoiceLastNo());
		attributes.put("invoiceForm", getInvoiceForm());
		attributes.put("bankInfo", getBankInfo());
		attributes.put("epaymentConfig", getEpaymentConfig());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long paymentConfigId = (Long)attributes.get("paymentConfigId");

		if (paymentConfigId != null) {
			setPaymentConfigId(paymentConfigId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		String govAgencyName = (String)attributes.get("govAgencyName");

		if (govAgencyName != null) {
			setGovAgencyName(govAgencyName);
		}

		String govAgencyTaxNo = (String)attributes.get("govAgencyTaxNo");

		if (govAgencyTaxNo != null) {
			setGovAgencyTaxNo(govAgencyTaxNo);
		}

		String invoiceTemplateNo = (String)attributes.get("invoiceTemplateNo");

		if (invoiceTemplateNo != null) {
			setInvoiceTemplateNo(invoiceTemplateNo);
		}

		String invoiceIssueNo = (String)attributes.get("invoiceIssueNo");

		if (invoiceIssueNo != null) {
			setInvoiceIssueNo(invoiceIssueNo);
		}

		String invoiceLastNo = (String)attributes.get("invoiceLastNo");

		if (invoiceLastNo != null) {
			setInvoiceLastNo(invoiceLastNo);
		}

		String invoiceForm = (String)attributes.get("invoiceForm");

		if (invoiceForm != null) {
			setInvoiceForm(invoiceForm);
		}

		String bankInfo = (String)attributes.get("bankInfo");

		if (bankInfo != null) {
			setBankInfo(bankInfo);
		}

		String epaymentConfig = (String)attributes.get("epaymentConfig");

		if (epaymentConfig != null) {
			setEpaymentConfig(epaymentConfig);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getPaymentConfigId() {
		return _paymentConfigId;
	}

	@Override
	public void setPaymentConfigId(long paymentConfigId) {
		_paymentConfigId = paymentConfigId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getGovAgencyCode() {
		if (_govAgencyCode == null) {
			return "";
		}
		else {
			return _govAgencyCode;
		}
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_columnBitmask |= GOVAGENCYCODE_COLUMN_BITMASK;

		if (_originalGovAgencyCode == null) {
			_originalGovAgencyCode = _govAgencyCode;
		}

		_govAgencyCode = govAgencyCode;
	}

	public String getOriginalGovAgencyCode() {
		return GetterUtil.getString(_originalGovAgencyCode);
	}

	@Override
	public String getGovAgencyName() {
		if (_govAgencyName == null) {
			return "";
		}
		else {
			return _govAgencyName;
		}
	}

	@Override
	public void setGovAgencyName(String govAgencyName) {
		_govAgencyName = govAgencyName;
	}

	@Override
	public String getGovAgencyTaxNo() {
		if (_govAgencyTaxNo == null) {
			return "";
		}
		else {
			return _govAgencyTaxNo;
		}
	}

	@Override
	public void setGovAgencyTaxNo(String govAgencyTaxNo) {
		_govAgencyTaxNo = govAgencyTaxNo;
	}

	@Override
	public String getInvoiceTemplateNo() {
		if (_invoiceTemplateNo == null) {
			return "";
		}
		else {
			return _invoiceTemplateNo;
		}
	}

	@Override
	public void setInvoiceTemplateNo(String invoiceTemplateNo) {
		_columnBitmask |= INVOICETEMPLATENO_COLUMN_BITMASK;

		if (_originalInvoiceTemplateNo == null) {
			_originalInvoiceTemplateNo = _invoiceTemplateNo;
		}

		_invoiceTemplateNo = invoiceTemplateNo;
	}

	public String getOriginalInvoiceTemplateNo() {
		return GetterUtil.getString(_originalInvoiceTemplateNo);
	}

	@Override
	public String getInvoiceIssueNo() {
		if (_invoiceIssueNo == null) {
			return "";
		}
		else {
			return _invoiceIssueNo;
		}
	}

	@Override
	public void setInvoiceIssueNo(String invoiceIssueNo) {
		_invoiceIssueNo = invoiceIssueNo;
	}

	@Override
	public String getInvoiceLastNo() {
		if (_invoiceLastNo == null) {
			return "";
		}
		else {
			return _invoiceLastNo;
		}
	}

	@Override
	public void setInvoiceLastNo(String invoiceLastNo) {
		_invoiceLastNo = invoiceLastNo;
	}

	@Override
	public String getInvoiceForm() {
		if (_invoiceForm == null) {
			return "";
		}
		else {
			return _invoiceForm;
		}
	}

	@Override
	public void setInvoiceForm(String invoiceForm) {
		_invoiceForm = invoiceForm;
	}

	@Override
	public String getBankInfo() {
		if (_bankInfo == null) {
			return "";
		}
		else {
			return _bankInfo;
		}
	}

	@Override
	public void setBankInfo(String bankInfo) {
		_bankInfo = bankInfo;
	}

	@Override
	public String getEpaymentConfig() {
		if (_epaymentConfig == null) {
			return "";
		}
		else {
			return _epaymentConfig;
		}
	}

	@Override
	public void setEpaymentConfig(String epaymentConfig) {
		_epaymentConfig = epaymentConfig;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PaymentConfig.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PaymentConfig.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PaymentConfig toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PaymentConfig)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PaymentConfigImpl paymentConfigImpl = new PaymentConfigImpl();

		paymentConfigImpl.setUuid(getUuid());
		paymentConfigImpl.setPaymentConfigId(getPaymentConfigId());
		paymentConfigImpl.setGroupId(getGroupId());
		paymentConfigImpl.setCompanyId(getCompanyId());
		paymentConfigImpl.setUserId(getUserId());
		paymentConfigImpl.setUserName(getUserName());
		paymentConfigImpl.setCreateDate(getCreateDate());
		paymentConfigImpl.setModifiedDate(getModifiedDate());
		paymentConfigImpl.setGovAgencyCode(getGovAgencyCode());
		paymentConfigImpl.setGovAgencyName(getGovAgencyName());
		paymentConfigImpl.setGovAgencyTaxNo(getGovAgencyTaxNo());
		paymentConfigImpl.setInvoiceTemplateNo(getInvoiceTemplateNo());
		paymentConfigImpl.setInvoiceIssueNo(getInvoiceIssueNo());
		paymentConfigImpl.setInvoiceLastNo(getInvoiceLastNo());
		paymentConfigImpl.setInvoiceForm(getInvoiceForm());
		paymentConfigImpl.setBankInfo(getBankInfo());
		paymentConfigImpl.setEpaymentConfig(getEpaymentConfig());

		paymentConfigImpl.resetOriginalValues();

		return paymentConfigImpl;
	}

	@Override
	public int compareTo(PaymentConfig paymentConfig) {
		long primaryKey = paymentConfig.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PaymentConfig)) {
			return false;
		}

		PaymentConfig paymentConfig = (PaymentConfig)obj;

		long primaryKey = paymentConfig.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PaymentConfigModelImpl paymentConfigModelImpl = this;

		paymentConfigModelImpl._originalUuid = paymentConfigModelImpl._uuid;

		paymentConfigModelImpl._originalGroupId = paymentConfigModelImpl._groupId;

		paymentConfigModelImpl._setOriginalGroupId = false;

		paymentConfigModelImpl._originalCompanyId = paymentConfigModelImpl._companyId;

		paymentConfigModelImpl._setOriginalCompanyId = false;

		paymentConfigModelImpl._setModifiedDate = false;

		paymentConfigModelImpl._originalGovAgencyCode = paymentConfigModelImpl._govAgencyCode;

		paymentConfigModelImpl._originalInvoiceTemplateNo = paymentConfigModelImpl._invoiceTemplateNo;

		paymentConfigModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PaymentConfig> toCacheModel() {
		PaymentConfigCacheModel paymentConfigCacheModel = new PaymentConfigCacheModel();

		paymentConfigCacheModel.uuid = getUuid();

		String uuid = paymentConfigCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			paymentConfigCacheModel.uuid = null;
		}

		paymentConfigCacheModel.paymentConfigId = getPaymentConfigId();

		paymentConfigCacheModel.groupId = getGroupId();

		paymentConfigCacheModel.companyId = getCompanyId();

		paymentConfigCacheModel.userId = getUserId();

		paymentConfigCacheModel.userName = getUserName();

		String userName = paymentConfigCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			paymentConfigCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			paymentConfigCacheModel.createDate = createDate.getTime();
		}
		else {
			paymentConfigCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			paymentConfigCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			paymentConfigCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		paymentConfigCacheModel.govAgencyCode = getGovAgencyCode();

		String govAgencyCode = paymentConfigCacheModel.govAgencyCode;

		if ((govAgencyCode != null) && (govAgencyCode.length() == 0)) {
			paymentConfigCacheModel.govAgencyCode = null;
		}

		paymentConfigCacheModel.govAgencyName = getGovAgencyName();

		String govAgencyName = paymentConfigCacheModel.govAgencyName;

		if ((govAgencyName != null) && (govAgencyName.length() == 0)) {
			paymentConfigCacheModel.govAgencyName = null;
		}

		paymentConfigCacheModel.govAgencyTaxNo = getGovAgencyTaxNo();

		String govAgencyTaxNo = paymentConfigCacheModel.govAgencyTaxNo;

		if ((govAgencyTaxNo != null) && (govAgencyTaxNo.length() == 0)) {
			paymentConfigCacheModel.govAgencyTaxNo = null;
		}

		paymentConfigCacheModel.invoiceTemplateNo = getInvoiceTemplateNo();

		String invoiceTemplateNo = paymentConfigCacheModel.invoiceTemplateNo;

		if ((invoiceTemplateNo != null) && (invoiceTemplateNo.length() == 0)) {
			paymentConfigCacheModel.invoiceTemplateNo = null;
		}

		paymentConfigCacheModel.invoiceIssueNo = getInvoiceIssueNo();

		String invoiceIssueNo = paymentConfigCacheModel.invoiceIssueNo;

		if ((invoiceIssueNo != null) && (invoiceIssueNo.length() == 0)) {
			paymentConfigCacheModel.invoiceIssueNo = null;
		}

		paymentConfigCacheModel.invoiceLastNo = getInvoiceLastNo();

		String invoiceLastNo = paymentConfigCacheModel.invoiceLastNo;

		if ((invoiceLastNo != null) && (invoiceLastNo.length() == 0)) {
			paymentConfigCacheModel.invoiceLastNo = null;
		}

		paymentConfigCacheModel.invoiceForm = getInvoiceForm();

		String invoiceForm = paymentConfigCacheModel.invoiceForm;

		if ((invoiceForm != null) && (invoiceForm.length() == 0)) {
			paymentConfigCacheModel.invoiceForm = null;
		}

		paymentConfigCacheModel.bankInfo = getBankInfo();

		String bankInfo = paymentConfigCacheModel.bankInfo;

		if ((bankInfo != null) && (bankInfo.length() == 0)) {
			paymentConfigCacheModel.bankInfo = null;
		}

		paymentConfigCacheModel.epaymentConfig = getEpaymentConfig();

		String epaymentConfig = paymentConfigCacheModel.epaymentConfig;

		if ((epaymentConfig != null) && (epaymentConfig.length() == 0)) {
			paymentConfigCacheModel.epaymentConfig = null;
		}

		return paymentConfigCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", paymentConfigId=");
		sb.append(getPaymentConfigId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", govAgencyName=");
		sb.append(getGovAgencyName());
		sb.append(", govAgencyTaxNo=");
		sb.append(getGovAgencyTaxNo());
		sb.append(", invoiceTemplateNo=");
		sb.append(getInvoiceTemplateNo());
		sb.append(", invoiceIssueNo=");
		sb.append(getInvoiceIssueNo());
		sb.append(", invoiceLastNo=");
		sb.append(getInvoiceLastNo());
		sb.append(", invoiceForm=");
		sb.append(getInvoiceForm());
		sb.append(", bankInfo=");
		sb.append(getBankInfo());
		sb.append(", epaymentConfig=");
		sb.append(getEpaymentConfig());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.PaymentConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentConfigId</column-name><column-value><![CDATA[");
		sb.append(getPaymentConfigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyName</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyTaxNo</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyTaxNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invoiceTemplateNo</column-name><column-value><![CDATA[");
		sb.append(getInvoiceTemplateNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invoiceIssueNo</column-name><column-value><![CDATA[");
		sb.append(getInvoiceIssueNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invoiceLastNo</column-name><column-value><![CDATA[");
		sb.append(getInvoiceLastNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invoiceForm</column-name><column-value><![CDATA[");
		sb.append(getInvoiceForm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankInfo</column-name><column-value><![CDATA[");
		sb.append(getBankInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>epaymentConfig</column-name><column-value><![CDATA[");
		sb.append(getEpaymentConfig());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = PaymentConfig.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			PaymentConfig.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _paymentConfigId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _govAgencyCode;
	private String _originalGovAgencyCode;
	private String _govAgencyName;
	private String _govAgencyTaxNo;
	private String _invoiceTemplateNo;
	private String _originalInvoiceTemplateNo;
	private String _invoiceIssueNo;
	private String _invoiceLastNo;
	private String _invoiceForm;
	private String _bankInfo;
	private String _epaymentConfig;
	private long _columnBitmask;
	private PaymentConfig _escapedModel;
}