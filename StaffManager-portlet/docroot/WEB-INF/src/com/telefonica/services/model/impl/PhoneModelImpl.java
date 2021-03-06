/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.telefonica.services.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.telefonica.services.model.Phone;
import com.telefonica.services.model.PhoneModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Phone service. Represents a row in the &quot;staffMgmt_Phone&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.telefonica.services.model.PhoneModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PhoneImpl}.
 * </p>
 *
 * @author plazaro
 * @see PhoneImpl
 * @see com.telefonica.services.model.Phone
 * @see com.telefonica.services.model.PhoneModel
 * @generated
 */
public class PhoneModelImpl extends BaseModelImpl<Phone> implements PhoneModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a phone model instance should use the {@link com.telefonica.services.model.Phone} interface instead.
	 */
	public static final String TABLE_NAME = "staffMgmt_Phone";
	public static final Object[][] TABLE_COLUMNS = {
			{ "phone_no", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table staffMgmt_Phone (phone_no INTEGER not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table staffMgmt_Phone";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.telefonica.services.model.Phone"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.telefonica.services.model.Phone"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.telefonica.services.model.Phone"));

	public PhoneModelImpl() {
	}

	public int getPrimaryKey() {
		return _phone_no;
	}

	public void setPrimaryKey(int primaryKey) {
		setPhone_no(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_phone_no);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	public Class<?> getModelClass() {
		return Phone.class;
	}

	public String getModelClassName() {
		return Phone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("phone_no", getPhone_no());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer phone_no = (Integer)attributes.get("phone_no");

		if (phone_no != null) {
			setPhone_no(phone_no);
		}
	}

	public int getPhone_no() {
		return _phone_no;
	}

	public void setPhone_no(int phone_no) {
		_phone_no = phone_no;
	}

	@Override
	public Phone toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Phone)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		PhoneImpl phoneImpl = new PhoneImpl();

		phoneImpl.setPhone_no(getPhone_no());

		phoneImpl.resetOriginalValues();

		return phoneImpl;
	}

	public int compareTo(Phone phone) {
		int primaryKey = phone.getPrimaryKey();

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
		if (obj == null) {
			return false;
		}

		Phone phone = null;

		try {
			phone = (Phone)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = phone.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Phone> toCacheModel() {
		PhoneCacheModel phoneCacheModel = new PhoneCacheModel();

		phoneCacheModel.phone_no = getPhone_no();

		return phoneCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{phone_no=");
		sb.append(getPhone_no());

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("com.telefonica.services.model.Phone");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>phone_no</column-name><column-value><![CDATA[");
		sb.append(getPhone_no());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Phone.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Phone.class
		};
	private int _phone_no;
	private Phone _escapedModelProxy;
}