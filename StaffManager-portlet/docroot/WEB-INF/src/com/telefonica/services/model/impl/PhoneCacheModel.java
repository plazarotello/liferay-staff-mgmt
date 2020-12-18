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
import com.liferay.portal.model.CacheModel;

import com.telefonica.services.model.Phone;

import java.io.Serializable;

/**
 * The cache model class for representing Phone in entity cache.
 *
 * @author plazaro
 * @see Phone
 * @generated
 */
public class PhoneCacheModel implements CacheModel<Phone>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{phone_no=");
		sb.append(phone_no);

		return sb.toString();
	}

	public Phone toEntityModel() {
		PhoneImpl phoneImpl = new PhoneImpl();

		phoneImpl.setPhone_no(phone_no);

		phoneImpl.resetOriginalValues();

		return phoneImpl;
	}

	public int phone_no;
}