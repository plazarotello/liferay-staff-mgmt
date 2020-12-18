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

package com.telefonica.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.telefonica.services.service.PhoneLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author plazaro
 */
public class PhoneClp extends BaseModelImpl<Phone> implements Phone {
	public PhoneClp() {
	}

	public Class<?> getModelClass() {
		return Phone.class;
	}

	public String getModelClassName() {
		return Phone.class.getName();
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

	public BaseModel<?> getPhoneRemoteModel() {
		return _phoneRemoteModel;
	}

	public void setPhoneRemoteModel(BaseModel<?> phoneRemoteModel) {
		_phoneRemoteModel = phoneRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PhoneLocalServiceUtil.addPhone(this);
		}
		else {
			PhoneLocalServiceUtil.updatePhone(this);
		}
	}

	@Override
	public Phone toEscapedModel() {
		return (Phone)Proxy.newProxyInstance(Phone.class.getClassLoader(),
			new Class[] { Phone.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PhoneClp clone = new PhoneClp();

		clone.setPhone_no(getPhone_no());

		return clone;
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

		PhoneClp phone = null;

		try {
			phone = (PhoneClp)obj;
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

	private int _phone_no;
	private BaseModel<?> _phoneRemoteModel;
}