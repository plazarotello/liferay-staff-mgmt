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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.telefonica.services.model.Employee;

import java.io.Serializable;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author plazaro
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{emp_id=");
		sb.append(emp_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", dpt_name=");
		sb.append(dpt_name);
		sb.append(", phone_no=");
		sb.append(phone_no);
		sb.append(", photo=");
		sb.append(photo);
		sb.append("}");

		return sb.toString();
	}

	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmp_id(emp_id);

		if (name == null) {
			employeeImpl.setName(StringPool.BLANK);
		}
		else {
			employeeImpl.setName(name);
		}

		if (dpt_name == null) {
			employeeImpl.setDpt_name(StringPool.BLANK);
		}
		else {
			employeeImpl.setDpt_name(dpt_name);
		}

		employeeImpl.setPhone_no(phone_no);

		if (photo == null) {
			employeeImpl.setPhoto(StringPool.BLANK);
		}
		else {
			employeeImpl.setPhoto(photo);
		}

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	public long emp_id;
	public String name;
	public String dpt_name;
	public int phone_no;
	public String photo;
}