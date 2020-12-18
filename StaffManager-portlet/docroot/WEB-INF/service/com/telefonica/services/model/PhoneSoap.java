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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    plazaro
 * @generated
 */
public class PhoneSoap implements Serializable {
	public static PhoneSoap toSoapModel(Phone model) {
		PhoneSoap soapModel = new PhoneSoap();

		soapModel.setPhone_no(model.getPhone_no());

		return soapModel;
	}

	public static PhoneSoap[] toSoapModels(Phone[] models) {
		PhoneSoap[] soapModels = new PhoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhoneSoap[][] toSoapModels(Phone[][] models) {
		PhoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhoneSoap[] toSoapModels(List<Phone> models) {
		List<PhoneSoap> soapModels = new ArrayList<PhoneSoap>(models.size());

		for (Phone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhoneSoap[soapModels.size()]);
	}

	public PhoneSoap() {
	}

	public int getPrimaryKey() {
		return _phone_no;
	}

	public void setPrimaryKey(int pk) {
		setPhone_no(pk);
	}

	public int getPhone_no() {
		return _phone_no;
	}

	public void setPhone_no(int phone_no) {
		_phone_no = phone_no;
	}

	private int _phone_no;
}