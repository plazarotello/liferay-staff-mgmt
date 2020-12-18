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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Phone}.
 * </p>
 *
 * @author    plazaro
 * @see       Phone
 * @generated
 */
public class PhoneWrapper implements Phone, ModelWrapper<Phone> {
	public PhoneWrapper(Phone phone) {
		_phone = phone;
	}

	public Class<?> getModelClass() {
		return Phone.class;
	}

	public String getModelClassName() {
		return Phone.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("phone_no", getPhone_no());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer phone_no = (Integer)attributes.get("phone_no");

		if (phone_no != null) {
			setPhone_no(phone_no);
		}
	}

	/**
	* Returns the primary key of this phone.
	*
	* @return the primary key of this phone
	*/
	public int getPrimaryKey() {
		return _phone.getPrimaryKey();
	}

	/**
	* Sets the primary key of this phone.
	*
	* @param primaryKey the primary key of this phone
	*/
	public void setPrimaryKey(int primaryKey) {
		_phone.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the phone_no of this phone.
	*
	* @return the phone_no of this phone
	*/
	public int getPhone_no() {
		return _phone.getPhone_no();
	}

	/**
	* Sets the phone_no of this phone.
	*
	* @param phone_no the phone_no of this phone
	*/
	public void setPhone_no(int phone_no) {
		_phone.setPhone_no(phone_no);
	}

	public boolean isNew() {
		return _phone.isNew();
	}

	public void setNew(boolean n) {
		_phone.setNew(n);
	}

	public boolean isCachedModel() {
		return _phone.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_phone.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _phone.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _phone.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_phone.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _phone.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_phone.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PhoneWrapper((Phone)_phone.clone());
	}

	public int compareTo(com.telefonica.services.model.Phone phone) {
		return _phone.compareTo(phone);
	}

	@Override
	public int hashCode() {
		return _phone.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.telefonica.services.model.Phone> toCacheModel() {
		return _phone.toCacheModel();
	}

	public com.telefonica.services.model.Phone toEscapedModel() {
		return new PhoneWrapper(_phone.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _phone.toString();
	}

	public java.lang.String toXmlString() {
		return _phone.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_phone.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Phone getWrappedPhone() {
		return _phone;
	}

	public Phone getWrappedModel() {
		return _phone;
	}

	public void resetOriginalValues() {
		_phone.resetOriginalValues();
	}

	private Phone _phone;
}