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

import com.telefonica.services.model.Department;

import java.io.Serializable;

/**
 * The cache model class for representing Department in entity cache.
 *
 * @author plazaro
 * @see Department
 * @generated
 */
public class DepartmentCacheModel implements CacheModel<Department>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{dpt_name=");
		sb.append(dpt_name);

		return sb.toString();
	}

	public Department toEntityModel() {
		DepartmentImpl departmentImpl = new DepartmentImpl();

		if (dpt_name == null) {
			departmentImpl.setDpt_name(StringPool.BLANK);
		}
		else {
			departmentImpl.setDpt_name(dpt_name);
		}

		departmentImpl.resetOriginalValues();

		return departmentImpl;
	}

	public String dpt_name;
}