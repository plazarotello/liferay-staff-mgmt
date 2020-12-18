<%@page import="com.telefonica.services.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(request);
	
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Employee employee = (Employee) row.getObject();
%>

<portlet:renderURL var="detail_url">
	<portlet:param name="mvcPath" value="/html/staffmanager/detail_employee.jsp"/>
	<portlet:param name="back" value="<%= redirect %>"/>
	<portlet:param name="id" value="<%= Long.toString(employee.getEmp_id()) %>"/>
</portlet:renderURL>

<portlet:renderURL var="add_edit_url">
	<portlet:param name="mvcPath" value="/html/staffmanager/add_edit_employee.jsp"/>
	<portlet:param name="back" value="<%= redirect %>"/>
	<portlet:param name="id" value="<%= Long.toString(employee.getEmp_id()) %>"/>
</portlet:renderURL>

<portlet:actionURL var="delete_url" name="deleteEmployee">
	<portlet:param name="back" value="<%= redirect %>"/>
	<portlet:param name="id" value="<%= Long.toString(employee.getEmp_id()) %>"/>
</portlet:actionURL>


<liferay-ui:icon-list>
	<liferay-ui:icon message="View" image="view" url="<%= detail_url.toString() %>" />
	<liferay-ui:icon message="Edit" image="edit" url="<%= add_edit_url.toString() %>" />
	<liferay-ui:icon-delete message="Delete" url="<%= delete_url.toString() %>" />
</liferay-ui:icon-list>