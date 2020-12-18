<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.telefonica.services.model.Employee"%>
<%@ include file="/html/init.jsp" %>

<%
	long employee_id = ParamUtil.getLong(request, "id", -1);
	String back = ParamUtil.getString(request, "back", null);
	
	Employee employee = null;
	if(employee_id >= 0){
		employee = EmployeeLocalServiceUtil.fetchEmployee(employee_id);		
	}
%>

<h1>Employee Details</h1>

<label>Identifier:</label> <label><%= employee.getEmp_id() %></label>
<br/>
<label>Name:</label> <label><%= employee.getName() %></label>
<br/>
<label>Phone:</label> <label><%= employee.getPhone_no() %></label>
<br/>
<label>Department:</label> <label><%= employee.getDpt_name() %></label>
<br/>

<aui:button-row>
	<aui:button type="cancel" onClick="<%= back %>"  value="Back" />
</aui:button-row>