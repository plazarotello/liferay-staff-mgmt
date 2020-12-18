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

import com.telefonica.services.service.DepartmentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author plazaro
 */
public class DepartmentClp extends BaseModelImpl<Department>
	implements Department {
	public DepartmentClp() {
	}

	public Class<?> getModelClass() {
		return Department.class;
	}

	public String getModelClassName() {
		return Department.class.getName();
	}

	public String getPrimaryKey() {
		return _dpt_name;
	}

	public void setPrimaryKey(String primaryKey) {
		setDpt_name(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _dpt_name;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dpt_name", getDpt_name());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String dpt_name = (String)attributes.get("dpt_name");

		if (dpt_name != null) {
			setDpt_name(dpt_name);
		}
	}

	public String getDpt_name() {
		return _dpt_name;
	}

	public void setDpt_name(String dpt_name) {
		_dpt_name = dpt_name;
	}

	public BaseModel<?> getDepartmentRemoteModel() {
		return _departmentRemoteModel;
	}

	public void setDepartmentRemoteModel(BaseModel<?> departmentRemoteModel) {
		_departmentRemoteModel = departmentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DepartmentLocalServiceUtil.addDepartment(this);
		}
		else {
			DepartmentLocalServiceUtil.updateDepartment(this);
		}
	}

	@Override
	public Department toEscapedModel() {
		return (Department)Proxy.newProxyInstance(Department.class.getClassLoader(),
			new Class[] { Department.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DepartmentClp clone = new DepartmentClp();

		clone.setDpt_name(getDpt_name());

		return clone;
	}

	public int compareTo(Department department) {
		String primaryKey = department.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DepartmentClp department = null;

		try {
			department = (DepartmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = department.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{dpt_name=");
		sb.append(getDpt_name());

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("com.telefonica.services.model.Department");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dpt_name</column-name><column-value><![CDATA[");
		sb.append(getDpt_name());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _dpt_name;
	private BaseModel<?> _departmentRemoteModel;
}