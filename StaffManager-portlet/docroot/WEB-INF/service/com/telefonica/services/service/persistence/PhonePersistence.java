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

import com.telefonica.services.model.Phone;

/**
 * The persistence interface for the phone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author plazaro
 * @see PhonePersistenceImpl
 * @see PhoneUtil
 * @generated
 */
public interface PhonePersistence extends BasePersistence<Phone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhoneUtil} to access the phone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the phone in the entity cache if it is enabled.
	*
	* @param phone the phone
	*/
	public void cacheResult(com.telefonica.services.model.Phone phone);

	/**
	* Caches the phones in the entity cache if it is enabled.
	*
	* @param phones the phones
	*/
	public void cacheResult(
		java.util.List<com.telefonica.services.model.Phone> phones);

	/**
	* Creates a new phone with the primary key. Does not add the phone to the database.
	*
	* @param phone_no the primary key for the new phone
	* @return the new phone
	*/
	public com.telefonica.services.model.Phone create(int phone_no);

	/**
	* Removes the phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param phone_no the primary key of the phone
	* @return the phone that was removed
	* @throws com.telefonica.services.NoSuchPhoneException if a phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Phone remove(int phone_no)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchPhoneException;

	public com.telefonica.services.model.Phone updateImpl(
		com.telefonica.services.model.Phone phone, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phone with the primary key or throws a {@link com.telefonica.services.NoSuchPhoneException} if it could not be found.
	*
	* @param phone_no the primary key of the phone
	* @return the phone
	* @throws com.telefonica.services.NoSuchPhoneException if a phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Phone findByPrimaryKey(int phone_no)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.services.NoSuchPhoneException;

	/**
	* Returns the phone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param phone_no the primary key of the phone
	* @return the phone, or <code>null</code> if a phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.services.model.Phone fetchByPrimaryKey(int phone_no)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phones.
	*
	* @return the phones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.services.model.Phone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.services.model.Phone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.services.model.Phone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the phones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phones.
	*
	* @return the number of phones
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}