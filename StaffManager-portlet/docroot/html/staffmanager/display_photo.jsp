<%@page import="com.liferay.portal.kernel.util.Base64"%>
<%@page import="com.telefonica.services.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Employee employee = (Employee) row.getObject();
%>

<c:choose>
	<c:when test="<%= employee != null && employee.getPhoto() != null && employee.getPhoto().length() > 0 %>">
		<img width="16px" src="data:image/png;base64, <%= employee.getPhoto() %>" />
	</c:when>
</c:choose>