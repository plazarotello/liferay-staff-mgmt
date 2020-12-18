<%-- General imports needed in every JSP --%>
<%-- Includes the portlet object definitions --%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.telefonica.services.service.PhoneLocalServiceUtil"%>
<%@page import="com.telefonica.services.service.DepartmentLocalServiceUtil"%>
<%@ page import="com.telefonica.services.service.EmployeeLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.util.Base64"%>

<portlet:defineObjects />