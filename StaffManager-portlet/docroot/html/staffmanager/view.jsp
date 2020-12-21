<%@ include file="/html/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:success key="success" message="Success" />
<liferay-ui:error key="error" />

<aui:button-row>
	<portlet:renderURL var="add_edit_url">
		<portlet:param name="mvcPath" value="/html/staffmanager/add_edit_employee.jsp"/>
		<portlet:param name="back" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<aui:button value="Add employee" onClick="<%= add_edit_url.toString() %>" ></aui:button>

</aui:button-row>


<!-- Staff table and search UI -->
<liferay-ui:search-container delta="5" deltaConfigurable="true" emptyResultsMessage="No staff available.">
	<liferay-ui:search-container-results
		results="<%= EmployeeLocalServiceUtil.getEmployees(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= EmployeeLocalServiceUtil.getEmployeesCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.telefonica.services.model.Employee"
		modelVar="employee"
	>
	
		<%
			String dpt = "";
			String phone = "";
			try{
				dpt = DepartmentLocalServiceUtil.getDepartment(employee.getDpt_name()).getDpt_name();
				phone = Integer.toString(PhoneLocalServiceUtil.getPhone(employee.getPhone_no()).getPhone_no());
			} catch(Exception e){
			}
		%>
	
		<liferay-ui:search-container-column-text property="emp_id" name="Identifier" />
		<liferay-ui:search-container-column-jsp path="/html/staffmanager/display_photo.jsp"
			name="Photo" />
		<liferay-ui:search-container-column-text property="name" name="Name" />
		<liferay-ui:search-container-column-text value="<%= dpt %>" name="Department" />
		<liferay-ui:search-container-column-text value="<%= phone %>" name="Phone number" />
		<liferay-ui:search-container-column-jsp path="/html/staffmanager/actions.jsp" 
			align="right" name="Actions" />

		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>