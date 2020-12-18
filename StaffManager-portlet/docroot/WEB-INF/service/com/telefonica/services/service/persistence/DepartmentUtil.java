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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.telefonica.services.model.Department;

import java.util.List;

/**
 * The persistence utility for the department service. This utility wraps {@link DepartmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author plazaro
 * @see DepartmentPersistence
 * @see DepartmentPersistenceImpl
 * @generated
 */
public class DepartmentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Department department) {
		getPersistence().clearCache(department);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Department update(Department department, boolean merge)
		throws SystemException {
		return getPersistence().update(department, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Department update(Department department, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(department, merge, serviceContext);
	}

	/**
	* Caches the department in the entity cache if it is enabled.
	*
	* @param department the department
	*/
	public static void cacheResult(
		com.telefonica.services.model.Department department) {
		getPersistence().cacheResult(department);
	}

	/**
	* Caches the departments in the entity cache if it is enabled.
	*
	* @param departments the departments
	*/
	public static void cacheResult(
		java.util.List<com.telefonica.services.model.Department> departments) {
		getPersistence().cacheResult(departments);
	}

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param dpt_name the primary key for the new department
	* @return the new department
	*/
	public static com.telefonica.services.model.Department create(
		java.lang.String dpt_name) {
		return getPersistence().create(dpt_name);
	}

	/**
	* Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dpt_name the primary key of the department
	* @return the department that was removed
	* @throws com.telefonica.services.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.services.model.Department remove(
		java.lang.String dpt_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchDepartmentException {
		return getPersistence().remove(dpt_name);
	}

	public static com.telefonica.services.model.Department updateImpl(
		com.telefonica.services.model.Department department, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(department, merge);
	}

	/**
	* Returns the department with the primary key or throws a {@link com.telefonica.services.NoSuchDepartmentException} if it could not be found.
	*
	* @param dpt_name the primary key of the department
	* @return the department
	* @throws com.telefonica.services.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.services.model.Department findByPrimaryKey(
		java.lang.String dpt_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchDepartmentException {
		return getPersistence().findByPrimaryKey(dpt_name);
	}

	/**
	* Returns the department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dpt_name the primary key of the department
	* @return the department, or <code>null</code> if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.services.model.Department fetchByPrimaryKey(
		java.lang.String dpt_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dpt_name);
	}

	/**
	* Returns all the departments.
	*
	* @return the departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.services.model.Department> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.telefonica.services.model.Department> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.telefonica.services.model.Department> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DepartmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DepartmentPersistence)PortletBeanLocatorUtil.locate(com.telefonica.services.service.ClpSerializer.getServletContextName(),
					DepartmentPersistence.class.getName());

			ReferenceRegistry.registerReference(DepartmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(DepartmentPersistence persistence) {
	}

	private static DepartmentPersistence _persistence;
}