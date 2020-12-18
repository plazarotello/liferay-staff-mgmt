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
public class EmployeeSoap implements Serializable {
	public static EmployeeSoap toSoapModel(Employee model) {
		EmployeeSoap soapModel = new EmployeeSoap();

		soapModel.setEmp_id(model.getEmp_id());
		soapModel.setName(model.getName());
		soapModel.setDpt_name(model.getDpt_name());
		soapModel.setPhone_no(model.getPhone_no());
		soapModel.setPhoto(model.getPhoto());

		return soapModel;
	}

	public static EmployeeSoap[] toSoapModels(Employee[] models) {
		EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
		EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[] toSoapModels(List<Employee> models) {
		List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(models.size());

		for (Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
	}

	public EmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _emp_id;
	}

	public void setPrimaryKey(long pk) {
		setEmp_id(pk);
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

	private long _emp_id;
	private String _name;
	private String _dpt_name;
	private int _phone_no;
	private String _photo;
}