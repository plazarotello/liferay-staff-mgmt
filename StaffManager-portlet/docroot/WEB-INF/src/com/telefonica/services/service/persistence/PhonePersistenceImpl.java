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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.telefonica.services.NoSuchPhoneException;
import com.telefonica.services.model.Phone;
import com.telefonica.services.model.impl.PhoneImpl;
import com.telefonica.services.model.impl.PhoneModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the phone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author plazaro
 * @see PhonePersistence
 * @see PhoneUtil
 * @generated
 */
public class PhonePersistenceImpl extends BasePersistenceImpl<Phone>
	implements PhonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PhoneUtil} to access the phone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PhoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PhoneModelImpl.ENTITY_CACHE_ENABLED,
			PhoneModelImpl.FINDER_CACHE_ENABLED, PhoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PhoneModelImpl.ENTITY_CACHE_ENABLED,
			PhoneModelImpl.FINDER_CACHE_ENABLED, PhoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PhoneModelImpl.ENTITY_CACHE_ENABLED,
			PhoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the phone in the entity cache if it is enabled.
	 *
	 * @param phone the phone
	 */
	public void cacheResult(Phone phone) {
		EntityCacheUtil.putResult(PhoneModelImpl.ENTITY_CACHE_ENABLED,
			PhoneImpl.class, phone.getPrimaryKey(), phone);

		phone.resetOriginalValues();
	}

	/**
	 * Caches the phones in the entity cache if it is enabled.
	 *
	 * @param phones the phones
	 */
	public void cacheResult(List<Phone> phones) {
		for (Phone phone : phones) {
			if (EntityCacheUtil.getResult(PhoneModelImpl.ENTITY_CACHE_ENABLED,
						PhoneImpl.class, phone.getPrimaryKey()) == null) {
				cacheResult(phone);
			}
			else {
				phone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PhoneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PhoneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phone.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Phone phone) {
		EntityCacheUtil.removeResult(PhoneModelImpl.ENTITY_CACHE_ENABLED,
			PhoneImpl.class, phone.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Phone> phones) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Phone phone : phones) {
			EntityCacheUtil.removeResult(PhoneModelImpl.ENTITY_CACHE_ENABLED,
				PhoneImpl.class, phone.getPrimaryKey());
		}
	}

	/**
	 * Creates a new phone with the primary key. Does not add the phone to the database.
	 *
	 * @param phone_no the primary key for the new phone
	 * @return the new phone
	 */
	public Phone create(int phone_no) {
		Phone phone = new PhoneImpl();

		phone.setNew(true);
		phone.setPrimaryKey(phone_no);

		return phone;
	}

	/**
	 * Removes the phone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phone_no the primary key of the phone
	 * @return the phone that was removed
	 * @throws com.telefonica.services.NoSuchPhoneException if a phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phone remove(int phone_no)
		throws NoSuchPhoneException, SystemException {
		return remove(Integer.valueOf(phone_no));
	}

	/**
	 * Removes the phone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phone
	 * @return the phone that was removed
	 * @throws com.telefonica.services.NoSuchPhoneException if a phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Phone remove(Serializable primaryKey)
		throws NoSuchPhoneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Phone phone = (Phone)session.get(PhoneImpl.class, primaryKey);

			if (phone == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(phone);
		}
		catch (NoSuchPhoneException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Phone removeImpl(Phone phone) throws SystemException {
		phone = toUnwrappedModel(phone);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, phone);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(phone);

		return phone;
	}

	@Override
	public Phone updateImpl(com.telefonica.services.model.Phone phone,
		boolean merge) throws SystemException {
		phone = toUnwrappedModel(phone);

		boolean isNew = phone.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, phone, merge);

			phone.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PhoneModelImpl.ENTITY_CACHE_ENABLED,
			PhoneImpl.class, phone.getPrimaryKey(), phone);

		return phone;
	}

	protected Phone toUnwrappedModel(Phone phone) {
		if (phone instanceof PhoneImpl) {
			return phone;
		}

		PhoneImpl phoneImpl = new PhoneImpl();

		phoneImpl.setNew(phone.isNew());
		phoneImpl.setPrimaryKey(phone.getPrimaryKey());

		phoneImpl.setPhone_no(phone.getPhone_no());

		return phoneImpl;
	}

	/**
	 * Returns the phone with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the phone
	 * @return the phone
	 * @throws com.liferay.portal.NoSuchModelException if a phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Phone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the phone with the primary key or throws a {@link com.telefonica.services.NoSuchPhoneException} if it could not be found.
	 *
	 * @param phone_no the primary key of the phone
	 * @return the phone
	 * @throws com.telefonica.services.NoSuchPhoneException if a phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phone findByPrimaryKey(int phone_no)
		throws NoSuchPhoneException, SystemException {
		Phone phone = fetchByPrimaryKey(phone_no);

		if (phone == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + phone_no);
			}

			throw new NoSuchPhoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				phone_no);
		}

		return phone;
	}

	/**
	 * Returns the phone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phone
	 * @return the phone, or <code>null</code> if a phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Phone fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the phone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phone_no the primary key of the phone
	 * @return the phone, or <code>null</code> if a phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phone fetchByPrimaryKey(int phone_no) throws SystemException {
		Phone phone = (Phone)EntityCacheUtil.getResult(PhoneModelImpl.ENTITY_CACHE_ENABLED,
				PhoneImpl.class, phone_no);

		if (phone == _nullPhone) {
			return null;
		}

		if (phone == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				phone = (Phone)session.get(PhoneImpl.class,
						Integer.valueOf(phone_no));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (phone != null) {
					cacheResult(phone);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PhoneModelImpl.ENTITY_CACHE_ENABLED,
						PhoneImpl.class, phone_no, _nullPhone);
				}

				closeSession(session);
			}
		}

		return phone;
	}

	/**
	 * Returns all the phones.
	 *
	 * @return the phones
	 * @throws SystemException if a system exception occurred
	 */
	public List<Phone> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Phone> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Phone> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Phone> list = (List<Phone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PHONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHONE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Phone>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Phone>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the phones from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Phone phone : findAll()) {
			remove(phone);
		}
	}

	/**
	 * Returns the number of phones.
	 *
	 * @return the number of phones
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PHONE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the phone persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.telefonica.services.model.Phone")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Phone>> listenersList = new ArrayList<ModelListener<Phone>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Phone>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PhoneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DepartmentPersistence.class)
	protected DepartmentPersistence departmentPersistence;
	@BeanReference(type = EmployeePersistence.class)
	protected EmployeePersistence employeePersistence;
	@BeanReference(type = PhonePersistence.class)
	protected PhonePersistence phonePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PHONE = "SELECT phone FROM Phone phone";
	private static final String _SQL_COUNT_PHONE = "SELECT COUNT(phone) FROM Phone phone";
	private static final String _ORDER_BY_ENTITY_ALIAS = "phone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Phone exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PhonePersistenceImpl.class);
	private static Phone _nullPhone = new PhoneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Phone> toCacheModel() {
				return _nullPhoneCacheModel;
			}
		};

	private static CacheModel<Phone> _nullPhoneCacheModel = new CacheModel<Phone>() {
			public Phone toEntityModel() {
				return _nullPhone;
			}
		};
}