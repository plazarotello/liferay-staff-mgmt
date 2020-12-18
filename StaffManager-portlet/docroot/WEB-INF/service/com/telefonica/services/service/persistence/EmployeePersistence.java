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

import com.telefonica.services.model.Employee;

/**
 * The persistence interface for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author plazaro
 * @see EmployeePersistenceImpl
 * @see EmployeeUtil
 * @generated
 */
public interface EmployeePersistence extends BasePersistence<Employee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the employee in the entity cache if it is enabled.
	*
	* @param employee the employee
	*/
	public void cacheResult(com.telefonica.services.model.Employee employee);

	/**
	* Caches the employees in the entity cache if it is enabled.
	*
	* @param employees the employees
	*/
	public void cacheResult(
		java.util.List<com.telefonica.services.model.Employee> employees);

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param emp_id the primary key for the new employee
	* @return the new employee
	*/
	public com.telefonica.services.model.Employee create(long emp_id);

	/**
	* Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emp_id the primary key of the employee
	* @return the employee that was removed
	* @throws com.telefonica.services.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Employee remove(long emp_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchEmployeeException;

	public com.telefonica.services.model.Employee updateImpl(
		com.telefonica.services.model.Employee employee, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the employee with the primary key or throws a {@link com.telefonica.services.NoSuchEmployeeException} if it could not be found.
	*
	* @param emp_id the primary key of the employee
	* @return the employee
	* @throws com.telefonica.services.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Employee findByPrimaryKey(long emp_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchEmployeeException;

	/**
	* Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param emp_id the primary key of the employee
	* @return the employee, or <code>null</code> if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Employee fetchByPrimaryKey(long emp_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the employees.
	*
	* @return the employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.services.model.Employee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.services.model.Employee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.services.model.Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}