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

package com.telefonica.services.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.telefonica.services.model.Department;

/**
 * The persistence interface for the department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author plazaro
 * @see DepartmentPersistenceImpl
 * @see DepartmentUtil
 * @generated
 */
public interface DepartmentPersistence extends BasePersistence<Department> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartmentUtil} to access the department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the department in the entity cache if it is enabled.
	*
	* @param department the department
	*/
	public void cacheResult(com.telefonica.services.model.Department department);

	/**
	* Caches the departments in the entity cache if it is enabled.
	*
	* @param departments the departments
	*/
	public void cacheResult(
		java.util.List<com.telefonica.services.model.Department> departments);

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param dpt_name the primary key for the new department
	* @return the new department
	*/
	public com.telefonica.services.model.Department create(
		java.lang.String dpt_name);

	/**
	* Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dpt_name the primary key of the department
	* @return the department that was removed
	* @throws com.telefonica.services.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Department remove(
		java.lang.String dpt_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchDepartmentException;

	public com.telefonica.services.model.Department updateImpl(
		com.telefonica.services.model.Department department, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the department with the primary key or throws a {@link com.telefonica.services.NoSuchDepartmentException} if it could not be found.
	*
	* @param dpt_name the primary key of the department
	* @return the department
	* @throws com.telefonica.services.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Department findByPrimaryKey(
		java.lang.String dpt_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchDepartmentException;

	/**
	* Returns the department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dpt_name the primary key of the department
	* @return the department, or <code>null</code> if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Department fetchByPrimaryKey(
		java.lang.String dpt_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the departments.
	*
	* @return the departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.services.model.Department> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.services.model.Department> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.services.model.Department> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}