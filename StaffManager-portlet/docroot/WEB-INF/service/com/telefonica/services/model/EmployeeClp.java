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

import com.telefonica.services.service.EmployeeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author plazaro
 */
public class EmployeeClp extends BaseModelImpl<Employee> implements Employee {
	public EmployeeClp() {
	}

	public Class<?> getModelClass() {
		return Employee.class;
	}

	public String getModelClassName() {
		return Employee.class.getName();
	}

	public long getPrimaryKey() {
		return _emp_id;
	}

	public void setPrimaryKey(long primaryKey) {
		setEmp_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_emp_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emp_id", getEmp_id());
		attributes.put("name", getName());
		attributes.put("dpt_name", getDpt_name());
		attributes.put("phone_no", getPhone_no());
		attributes.put("photo", getPhoto());

		return attributes;
	}

	@Override
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

	public long getEmp_id() {
		return _emp_id;
	}

	public void setEmp_id(long emp_id) {
		_emp_id = emp_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDpt_name() {
		return _dpt_name;
	}

	public void setDpt_name(String dpt_name) {
		_dpt_name = dpt_name;
	}

	public int getPhone_no() {
		return _phone_no;
	}

	public void setPhone_no(int phone_no) {
		_phone_no = phone_no;
	}

	public String getPhoto() {
		return _photo;
	}

	public void setPhoto(String photo) {
		_photo = photo;
	}

	public BaseModel<?> getEmployeeRemoteModel() {
		return _employeeRemoteModel;
	}

	public void setEmployeeRemoteModel(BaseModel<?> employeeRemoteModel) {
		_employeeRemoteModel = employeeRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EmployeeLocalServiceUtil.addEmployee(this);
		}
		else {
			EmployeeLocalServiceUtil.updateEmployee(this);
		}
	}

	@Override
	public Employee toEscapedModel() {
		return (Employee)Proxy.newProxyInstance(Employee.class.getClassLoader(),
			new Class[] { Employee.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmployeeClp clone = new EmployeeClp();

		clone.setEmp_id(getEmp_id());
		clone.setName(getName());
		clone.setDpt_name(getDpt_name());
		clone.setPhone_no(getPhone_no());
		clone.setPhoto(getPhoto());

		return clone;
	}

	public int compareTo(Employee employee) {
		int value = 0;

		if (getEmp_id() < employee.getEmp_id()) {
			value = -1;
		}
		else if (getEmp_id() > employee.getEmp_id()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EmployeeClp employee = null;

		try {
			employee = (EmployeeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = employee.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{emp_id=");
		sb.append(getEmp_id());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", dpt_name=");
		sb.append(getDpt_name());
		sb.append(", phone_no=");
		sb.append(getPhone_no());
		sb.append(", photo=");
		sb.append(getPhoto());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.telefonica.services.model.Employee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>emp_id</column-name><column-value><![CDATA[");
		sb.append(getEmp_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dpt_name</column-name><column-value><![CDATA[");
		sb.append(getDpt_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone_no</column-name><column-value><![CDATA[");
		sb.append(getPhone_no());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>photo</column-name><column-value><![CDATA[");
		sb.append(getPhoto());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _emp_id;
	private String _name;
	private String _dpt_name;
	private int _phone_no;
	private String _photo;
	private BaseModel<?> _employeeRemoteModel;
}