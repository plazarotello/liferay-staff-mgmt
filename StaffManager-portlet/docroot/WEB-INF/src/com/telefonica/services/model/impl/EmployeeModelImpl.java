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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.telefonica.services.model.Employee;
import com.telefonica.services.model.EmployeeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Employee service. Represents a row in the &quot;staffMgmt_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.telefonica.services.model.EmployeeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeImpl}.
 * </p>
 *
 * @author plazaro
 * @see EmployeeImpl
 * @see com.telefonica.services.model.Employee
 * @see com.telefonica.services.model.EmployeeModel
 * @generated
 */
public class EmployeeModelImpl extends BaseModelImpl<Employee>
	implements EmployeeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee model instance should use the {@link com.telefonica.services.model.Employee} interface instead.
	 */
	public static final String TABLE_NAME = "staffMgmt_Employee";
	public static final Object[][] TABLE_COLUMNS = {
			{ "emp_id", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "dpt_name", Types.VARCHAR },
			{ "phone_no", Types.INTEGER },
			{ "photo", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table staffMgmt_Employee (emp_id LONG not null primary key,name VARCHAR(75) null,dpt_name VARCHAR(75) null,phone_no INTEGER,photo TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table staffMgmt_Employee";
	public static final String ORDER_BY_JPQL = " ORDER BY employee.emp_id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY staffMgmt_Employee.emp_id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.telefonica.services.model.Employee"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.telefonica.services.model.Employee"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.telefonica.services.model.Employee"));

	public EmployeeModelImpl() {
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

	public Class<?> getModelClass() {
		return Employee.class;
	}

	public String getModelClassName() {
		return Employee.class.getName();
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
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDpt_name() {
		if (_dpt_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _dpt_name;
		}
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
		if (_photo == null) {
			return StringPool.BLANK;
		}
		else {
			return _photo;
		}
	}

	public void setPhoto(String photo) {
		_photo = photo;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Employee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Employee toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Employee)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmp_id(getEmp_id());
		employeeImpl.setName(getName());
		employeeImpl.setDpt_name(getDpt_name());
		employeeImpl.setPhone_no(getPhone_no());
		employeeImpl.setPhoto(getPhoto());

		employeeImpl.resetOriginalValues();

		return employeeImpl;
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

		Employee employee = null;

		try {
			employee = (Employee)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Employee> toCacheModel() {
		EmployeeCacheModel employeeCacheModel = new EmployeeCacheModel();

		employeeCacheModel.emp_id = getEmp_id();

		employeeCacheModel.name = getName();

		String name = employeeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			employeeCacheModel.name = null;
		}

		employeeCacheModel.dpt_name = getDpt_name();

		String dpt_name = employeeCacheModel.dpt_name;

		if ((dpt_name != null) && (dpt_name.length() == 0)) {
			employeeCacheModel.dpt_name = null;
		}

		employeeCacheModel.phone_no = getPhone_no();

		employeeCacheModel.photo = getPhoto();

		String photo = employeeCacheModel.photo;

		if ((photo != null) && (photo.length() == 0)) {
			employeeCacheModel.photo = null;
		}

		return employeeCacheModel;
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

	private static ClassLoader _classLoader = Employee.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Employee.class
		};
	private long _emp_id;
	private String _name;
	private String _dpt_name;
	private int _phone_no;
	private String _photo;
	private Employee _escapedModelProxy;
}