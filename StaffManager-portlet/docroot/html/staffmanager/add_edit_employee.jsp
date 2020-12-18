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

<portlet:actionURL var="addEmployee" name="addEmployee">
</portlet:actionURL>

<aui:form action="<%= addEmployee %>" method="POST" enctype="multipart/form-data" name="fm">
	<aui:model-context bean="<%= employee %>" model="<%= Employee.class %>" />
	
	<aui:fieldset>
		<aui:input name="id" value="<%= employee != null ? employee.getEmp_id() : \"\" %>"
			type="hidden">
		</aui:input>
		
		<aui:input name="name" value="<%= employee != null ? employee.getName() : \"\" %>" 
			helpMessage="Name of the employee" label="Name"
			placeholder="John Doe" type="text">
			<aui:validator name="required" />
			<aui:validator name="alpha" />
		</aui:input>
		
		<aui:input name="phone" value="<%= employee != null ? employee.getPhone_no() : \"\" %>" 
			helpMessage="Phone number of the employee" label="Phone number"
			placeholder="123456789" type="text">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="minLength">9</aui:validator>
		</aui:input>
		
		<aui:input name="department" value="<%= employee != null ? employee.getDpt_name() : \"\" %>" 
			helpMessage="Department the employee belongs to" label="Department"
			placeholder="Human Resources" type="text">
			<aui:validator name="required" />
			<aui:validator name="alpha" />
		</aui:input>
		
		<aui:input name="photo" type="file"	helpMessage="Employee's photo (will only change if a new one is set)" 
			label="Photo" >
<%-- 			<aui:validator name="acceptFiles">jpg,png</aui:validator> --%>
		</aui:input>
		
		<c:if test="<%= employee != null %>">
			<aui:input name="deletePhoto" type="checkbox" value="false" label="Delete photo"
				helpMessage="Mark the checkbox to delete the employee's photo" />
			<label>Current photo: </label>
			<img width="16px" src="data:image/png;base64, <%= employee.getPhoto() %>" />
		</c:if>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= back %>" />
	</aui:button-row>
	
</aui:form>