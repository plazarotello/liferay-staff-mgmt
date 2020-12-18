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

import com.telefonica.services.NoSuchDepartmentException;
import com.telefonica.services.model.Department;
import com.telefonica.services.model.impl.DepartmentImpl;
import com.telefonica.services.model.impl.DepartmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author plazaro
 * @see DepartmentPersistence
 * @see DepartmentUtil
 * @generated
 */
public class DepartmentPersistenceImpl extends BasePersistenceImpl<Department>
	implements DepartmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DepartmentUtil} to access the department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DepartmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the department in the entity cache if it is enabled.
	 *
	 * @param department the department
	 */
	public void cacheResult(Department department) {
		EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey(), department);

		department.resetOriginalValues();
	}

	/**
	 * Caches the departments in the entity cache if it is enabled.
	 *
	 * @param departments the departments
	 */
	public void cacheResult(List<Department> departments) {
		for (Department department : departments) {
			if (EntityCacheUtil.getResult(
						DepartmentModelImpl.ENTITY_CACHE_ENABLED,
						DepartmentImpl.class, department.getPrimaryKey()) == null) {
				cacheResult(department);
			}
			else {
				department.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all departments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DepartmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DepartmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the department.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Department department) {
		EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Department> departments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Department department : departments) {
			EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
				DepartmentImpl.class, department.getPrimaryKey());
		}
	}

	/**
	 * Creates a new department with the primary key. Does not add the department to the database.
	 *
	 * @param dpt_name the primary key for the new department
	 * @return the new department
	 */
	public Department create(String dpt_name) {
		Department department = new DepartmentImpl();

		department.setNew(true);
		department.setPrimaryKey(dpt_name);

		return department;
	}

	/**
	 * Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dpt_name the primary key of the department
	 * @return the department that was removed
	 * @throws com.telefonica.services.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Department remove(String dpt_name)
		throws NoSuchDepartmentException, SystemException {
		return remove((Serializable)dpt_name);
	}

	/**
	 * Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department that was removed
	 * @throws com.telefonica.services.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department remove(Serializable primaryKey)
		throws NoSuchDepartmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Department department = (Department)session.get(DepartmentImpl.class,
					primaryKey);

			if (department == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(department);
		}
		catch (NoSuchDepartmentException nsee) {
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
	protected Department removeImpl(Department department)
		throws SystemException {
		department = toUnwrappedModel(department);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, department);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(department);

		return department;
	}

	@Override
	public Department updateImpl(
		com.telefonica.services.model.Department department, boolean merge)
		throws SystemException {
		department = toUnwrappedModel(department);

		boolean isNew = department.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, department, merge);

			department.setNew(false);
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

		EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey(), department);

		return department;
	}

	protected Department toUnwrappedModel(Department department) {
		if (department instanceof DepartmentImpl) {
			return department;
		}

		DepartmentImpl departmentImpl = new DepartmentImpl();

		departmentImpl.setNew(department.isNew());
		departmentImpl.setPrimaryKey(department.getPrimaryKey());

		departmentImpl.setDpt_name(department.getDpt_name());

		return departmentImpl;
	}

	/**
	 * Returns the department with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department
	 * @throws com.liferay.portal.NoSuchModelException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the department with the primary key or throws a {@link com.telefonica.services.NoSuchDepartmentException} if it could not be found.
	 *
	 * @param dpt_name the primary key of the department
	 * @return the department
	 * @throws com.telefonica.services.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Department findByPrimaryKey(String dpt_name)
		throws NoSuchDepartmentException, SystemException {
		Department department = fetchByPrimaryKey(dpt_name);

		if (department == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + dpt_name);
			}

			throw new NoSuchDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				dpt_name);
		}

		return department;
	}

	/**
	 * Returns the department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department, or <code>null</code> if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dpt_name the primary key of the department
	 * @return the department, or <code>null</code> if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Department fetchByPrimaryKey(String dpt_name)
		throws SystemException {
		Department department = (Department)EntityCacheUtil.getResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
				DepartmentImpl.class, dpt_name);

		if (department == _nullDepartment) {
			return null;
		}

		if (department == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				department = (Department)session.get(DepartmentImpl.class,
						dpt_name);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (department != null) {
					cacheResult(department);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
						DepartmentImpl.class, dpt_name, _nullDepartment);
				}

				closeSession(session);
			}
		}

		return department;
	}

	/**
	 * Returns all the departments.
	 *
	 * @return the departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Department> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Department> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<Department> findAll(int start, int end,
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

		List<Department> list = (List<Department>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEPARTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTMENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the departments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Department department : findAll()) {
			remove(department);
		}
	}

	/**
	 * Returns the number of departments.
	 *
	 * @return the number of departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DEPARTMENT);

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
	 * Initializes the department persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.telefonica.services.model.Department")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Department>> listenersList = new ArrayList<ModelListener<Department>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Department>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DepartmentImpl.class.getName());
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
	private static final String _SQL_SELECT_DEPARTMENT = "SELECT department FROM Department department";
	private static final String _SQL_COUNT_DEPARTMENT = "SELECT COUNT(department) FROM Department department";
	private static final String _ORDER_BY_ENTITY_ALIAS = "department.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Department exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DepartmentPersistenceImpl.class);
	private static Department _nullDepartment = new DepartmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Department> toCacheModel() {
				return _nullDepartmentCacheModel;
			}
		};

	private static CacheModel<Department> _nullDepartmentCacheModel = new CacheModel<Department>() {
			public Department toEntityModel() {
				return _nullDepartment;
			}
		};
}