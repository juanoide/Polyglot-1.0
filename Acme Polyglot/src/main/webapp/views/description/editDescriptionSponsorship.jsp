<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="description/sponsorship/agent/edit.do?sponsorshipId=${sponsorshipId}" requestURI="${requestURI}" modelAttribute="description">
	<fieldset>
		<legend align="left">
			<spring:message code="sponsorship.register" />
		</legend>
		<acme:textbox code="sponsorship.title" path="title"/>
		<acme:textbox code="sponsorship.text" path="text"/>
		<acme:textbox code="sponsorship.links" path="links"/>
		<spring:message code="languageExchange.comma"></spring:message>
		<acme:textbox code="sponsorship.tag" path="tag"/>
		<spring:message code="languageExchange.comma"></spring:message>
	

		<form:hidden path="Language"/>	
	
	
	</fieldset>
	
	<input type="submit" name="save" value="<spring:message code="save"/>" />
	&nbsp;
	<input type="button" name="cancel" value="<spring:message code="return"/>" 
	onclick="javascript: window.location.replace('description/sponsorship/agent.do?sponsorshipId=${sponsorshipId}&&languageId=${description.language.id}')"/>
</form:form>