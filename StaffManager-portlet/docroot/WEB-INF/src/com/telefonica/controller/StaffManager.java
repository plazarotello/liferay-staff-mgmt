package com.telefonica.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.telefonica.services.model.Department;
import com.telefonica.services.model.Employee;
import com.telefonica.services.model.Phone;
import com.telefonica.services.service.DepartmentLocalServiceUtil;
import com.telefonica.services.service.EmployeeLocalServiceUtil;
import com.telefonica.services.service.PhoneLocalServiceUtil;

/**
 * Portlet implementation class StaffManager
 */
public class StaffManager extends MVCPortlet {

	private static final int PHONE_NO_DIGITS = 9;

	public void addEmployee(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		/*
		 * As the request is now multipart encripted, we must use the upload
		 * portlet request
		 */
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);

		// retrieve params from request
		long id = ParamUtil.get(uploadRequest, "id", -1);
		String name = ParamUtil.getString(uploadRequest, "name", null);
		int phoneNo = ParamUtil.get(uploadRequest, "phone", -1);
		String dptName = ParamUtil
				.getString(uploadRequest, "department", null);
		boolean deletePhoto = ParamUtil.get(uploadRequest, "deletePhoto", false);

		// server-side validation
		if (String.valueOf(phoneNo).length() != PHONE_NO_DIGITS) {
			SessionMessages.add(request, "error");
			return;
		}
		if (name == null || name.length() == 0) {
			SessionMessages.add(request, "error");
			return;
		}
		if (dptName == null || dptName.length() == 0) {
			SessionMessages.add(request, "error");
			return;
		}

		// create entities
		Employee employee = null;
		Phone phone = PhoneLocalServiceUtil.fetchPhone(phoneNo);
		Department dpt = DepartmentLocalServiceUtil.fetchDepartment(dptName);

		// manage photo upload
		String photo = null;
		try {
			File photoFile = uploadRequest.getFile("photo");
			if (photoFile != null) {
				photo = getPhotoFromRequestFile(photoFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
			SessionMessages.add(request, "error");
			return;
		}

		// retrieve entities, or create them in database
		if (id >= 0) {
			employee = EmployeeLocalServiceUtil.getEmployee(id);
		} else {
			employee = EmployeeLocalServiceUtil
					.createEmployee(CounterLocalServiceUtil
							.increment(Employee.class.getName()));
		}

		if (phone == null) {
			phone = PhoneLocalServiceUtil.createPhone(phoneNo);
			PhoneLocalServiceUtil.updatePhone(phone);
		}

		if (dpt == null) {
			dpt = DepartmentLocalServiceUtil.createDepartment(dptName);
			DepartmentLocalServiceUtil.updateDepartment(dpt);
		}

		// populate employee with the new values
		employee.setName(name);
		employee.setPhone_no(phone.getPhone_no());
		employee.setDpt_name(dpt.getDpt_name());
		if(photo != null){
			employee.setPhoto(photo);	//update only if there is a new photo			
		}
		if(deletePhoto){
			employee.setPhoto(null);
		}

		// create or update db record
		EmployeeLocalServiceUtil.updateEmployee(employee);

		SessionMessages.add(request, "success");
	}

	public void deleteEmployee(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		// retrieve params from request
		long id = ParamUtil.getLong(request, "id", -1);

		if (id < 0) {
			System.err
					.println("No employee to delete. Aborting the operation...");
			SessionMessages.add(request, "error");
			return;
		}

		EmployeeLocalServiceUtil.deleteEmployee(id);
		SessionMessages.add(request, "success");
	}

	public static String getPhotoFromRequestFile(File photoFile)
			throws IOException {
		InputStream is = new FileInputStream(photoFile);
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];
		int len;

		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		byte[] raw = os.toByteArray();

		is.close();
		os.close();
		
		return Base64.encode(raw);
	}

}
