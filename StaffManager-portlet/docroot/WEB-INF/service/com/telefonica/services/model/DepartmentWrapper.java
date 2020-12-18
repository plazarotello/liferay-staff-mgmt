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
 * This class is a wrapper for {@link Department}.
 * </p>
 *
 * @author    plazaro
 * @see       Department
 * @generated
 */
public class DepartmentWrapper implements Department, ModelWrapper<Department> {
	public DepartmentWrapper(Department department) {
		_department = department;
	}

	public Class<?> getModelClass() {
		return Department.class;
	}

	public String getModelClassName() {
		return Department.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dpt_name", getDpt_name());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String dpt_name = (String)attributes.get("dpt_name");

		if (dpt_name != null) {
			setDpt_name(dpt_name);
		}
	}

	/**
	* Returns the primary key of this department.
	*
	* @return the primary key of this department
	*/
	public java.lang.String getPrimaryKey() {
		return _department.getPrimaryKey();
	}

	/**
	* Sets the primary key of this department.
	*
	* @param primaryKey the primary key of this department
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_department.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dpt_name of this department.
	*
	* @return the dpt_name of this department
	*/
	public java.lang.String getDpt_name() {
		return _department.getDpt_name();
	}

	/**
	* Sets the dpt_name of this department.
	*
	* @param dpt_name the dpt_name of this department
	*/
	public void setDpt_name(java.lang.String dpt_name) {
		_department.setDpt_name(dpt_name);
	}

	public boolean isNew() {
		return _department.isNew();
	}

	public void setNew(boolean n) {
		_department.setNew(n);
	}

	public boolean isCachedModel() {
		return _department.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_department.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _department.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _department.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_department.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _department.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_department.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DepartmentWrapper((Department)_department.clone());
	}

	public int compareTo(com.telefonica.services.model.Department department) {
		return _department.compareTo(department);
	}

	@Override
	public int hashCode() {
		return _department.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.telefonica.services.model.Department> toCacheModel() {
		return _department.toCacheModel();
	}

	public com.telefonica.services.model.Department toEscapedModel() {
		return new DepartmentWrapper(_department.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _department.toString();
	}

	public java.lang.String toXmlString() {
		return _department.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_department.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Department getWrappedDepartment() {
		return _department;
	}

	public Department getWrappedModel() {
		return _department;
	}

	public void resetOriginalValues() {
		_department.resetOriginalValues();
	}

	private Department _department;
}