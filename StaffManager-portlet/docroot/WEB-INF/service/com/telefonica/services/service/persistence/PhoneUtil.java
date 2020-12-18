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

import com.telefonica.services.model.Phone;

import java.util.List;

/**
 * The persistence utility for the phone service. This utility wraps {@link PhonePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author plazaro
 * @see PhonePersistence
 * @see PhonePersistenceImpl
 * @generated
 */
public class PhoneUtil {
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
	public static void clearCache(Phone phone) {
		getPersistence().clearCache(phone);
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
	public static List<Phone> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Phone> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Phone> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Phone update(Phone phone, boolean merge)
		throws SystemException {
		return getPersistence().update(phone, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Phone update(Phone phone, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(phone, merge, serviceContext);
	}

	/**
	* Caches the phone in the entity cache if it is enabled.
	*
	* @param phone the phone
	*/
	public static void cacheResult(com.telefonica.services.model.Phone phone) {
		getPersistence().cacheResult(phone);
	}

	/**
	* Caches the phones in the entity cache if it is enabled.
	*
	* @param phones the phones
	*/
	public static void cacheResult(
		java.util.List<com.telefonica.services.model.Phone> phones) {
		getPersistence().cacheResult(phones);
	}

	/**
	* Creates a new phone with the primary key. Does not add the phone to the database.
	*
	* @param phone_no the primary key for the new phone
	* @return the new phone
	*/
	public static com.telefonica.services.model.Phone create(int phone_no) {
		return getPersistence().create(phone_no);
	}

	/**
	* Removes the phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param phone_no the primary key of the phone
	* @return the phone that was removed
	* @throws com.telefonica.services.NoSuchPhoneException if a phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.services.model.Phone remove(int phone_no)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchPhoneException {
		return getPersistence().remove(phone_no);
	}

	public static com.telefonica.services.model.Phone updateImpl(
		com.telefonica.services.model.Phone phone, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(phone, merge);
	}

	/**
	* Returns the phone with the primary key or throws a {@link com.telefonica.services.NoSuchPhoneException} if it could not be found.
	*
	* @param phone_no the primary key of the phone
	* @return the phone
	* @throws com.telefonica.services.NoSuchPhoneException if a phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.services.model.Phone findByPrimaryKey(
		int phone_no)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchPhoneException {
		return getPersistence().findByPrimaryKey(phone_no);
	}

	/**
	* Returns the phone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param phone_no the primary key of the phone
	* @return the phone, or <code>null</code> if a phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.services.model.Phone fetchByPrimaryKey(
		int phone_no)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(phone_no);
	}

	/**
	* Returns all the phones.
	*
	* @return the phones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.services.model.Phone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the phones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of phones
	* @param end the upper bound of the range of phones (not inclusive)
	* @return the range of phones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.services.model.Phone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the phones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of phones
	* @param end the upper bound of the range of phones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of phones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.services.model.Phone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the phones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of phones.
	*
	* @return the number of phones
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PhonePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PhonePersistence)PortletBeanLocatorUtil.locate(com.telefonica.services.service.ClpSerializer.getServletContextName(),
					PhonePersistence.class.getName());

			ReferenceRegistry.registerReference(PhoneUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PhonePersistence persistence) {
	}

	private static PhonePersistence _persistence;
}