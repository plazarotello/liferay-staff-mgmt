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
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author    plazaro
 * @see       Employee
 * @generated
 */
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	public Class<?> getModelClass() {
		return Employee.class;
	}

	public String getModelClassName() {
		return Employee.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emp_id", getEmp_id());
		attributes.put("name", getName());
		attributes.put("dpt_name", getDpt_name());
		attributes.put("phone_no", getPhone_no());
		attributes.put("photo", getPhoto());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long emp_id = (Long)attributes.get("emp_id");

		if (emp_id != null) {
			setEmp_id(emp_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String dpt_name = (String)attributes.get("dpt_name");

		if (dpt_name != null) {
			setDpt_name(dpt_name);
		}

		Integer phone_no = (Integer)attributes.get("phone_no");

		if (phone_no != null) {
			setPhone_no(phone_no);
		}

		String photo = (String)attributes.get("photo");

		if (photo != null) {
			setPhoto(photo);
		}
	}

	/**
	* Returns the primary key of this employee.
	*
	* @return the primary key of this employee
	*/
	public long getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employee.
	*
	* @param primaryKey the primary key of this employee
	*/
	public void setPrimaryKey(long primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp_id of this employee.
	*
	* @return the emp_id of this employee
	*/
	public long getEmp_id() {
		return _employee.getEmp_id();
	}

	/**
	* Sets the emp_id of this employee.
	*
	* @param emp_id the emp_id of this employee
	*/
	public void setEmp_id(long emp_id) {
		_employee.setEmp_id(emp_id);
	}

	/**
	* Returns the name of this employee.
	*
	* @return the name of this employee
	*/
	public java.lang.String getName() {
		return _employee.getName();
	}

	/**
	* Sets the name of this employee.
	*
	* @param name the name of this employee
	*/
	public void setName(java.lang.String name) {
		_employee.setName(name);
	}

	/**
	* Returns the dpt_name of this employee.
	*
	* @return the dpt_name of this employee
	*/
	public java.lang.String getDpt_name() {
		return _employee.getDpt_name();
	}

	/**
	* Sets the dpt_name of this employee.
	*
	* @param dpt_name the dpt_name of this employee
	*/
	public void setDpt_name(java.lang.String dpt_name) {
		_employee.setDpt_name(dpt_name);
	}

	/**
	* Returns the phone_no of this employee.
	*
	* @return the phone_no of this employee
	*/
	public int getPhone_no() {
		return _employee.getPhone_no();
	}

	/**
	* Sets the phone_no of this employee.
	*
	* @param phone_no the phone_no of this employee
	*/
	public void setPhone_no(int phone_no) {
		_employee.setPhone_no(phone_no);
	}

	/**
	* Returns the photo of this employee.
	*
	* @return the photo of this employee
	*/
	public java.lang.String getPhoto() {
		return _employee.getPhoto();
	}

	/**
	* Sets the photo of this employee.
	*
	* @param photo the photo of this employee
	*/
	public void setPhoto(java.lang.String photo) {
		_employee.setPhoto(photo);
	}

	public boolean isNew() {
		return _employee.isNew();
	}

	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	public int compareTo(com.telefonica.services.model.Employee employee) {
		return _employee.compareTo(employee);
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.telefonica.services.model.Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	public com.telefonica.services.model.Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employee.toString();
	}

	public java.lang.String toXmlString() {
		return _employee.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employee.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Employee getWrappedEmployee() {
		return _employee;
	}

	public Employee getWrappedModel() {
		return _employee;
	}

	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private Employee _employee;
}