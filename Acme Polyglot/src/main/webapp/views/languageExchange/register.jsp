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

<form:form requestURI="${requestURI}" modelAttribute="languageExchangeForm">
	<fieldset>
		<legend align="left">
			<spring:message code="languageExchange.register" />
		</legend>
	
		<acme:textbox code="languageExchange.date"  placeholder="dd/mm/yyyy hh:mm" path="date"/>
		<acme:textbox code="languageExchange.place" path="place"/>
		
			<spring:message code="languageExchange.ExpectedTalk"></spring:message>
		<acme:multiCheckbox path="languages" items="${languages}" itemLabel="code"/>
	
			
		<acme:textbox code="languageExchange.title" path="title"/>
		<acme:textbox code="languageExchange.text" path="text"/>
		<acme:textbox code="languageExchange.links" path="links"/>
		<spring:message code="languageExchange.comma"></spring:message>
		<acme:textbox code="languageExchange.tag" path="tag"/>
		<spring:message code="languageExchange.comma"></spring:message>
	<acme:select code="languageExchange.descriptionLanguage" path="descriptionLanguage" items="${languages}" itemLabel="code" id="languages" />

		
	
	</fieldset>
	
	<input type="submit" name="save" value="<spring:message code="save"/>" />
	&nbsp;
	<input type="button" name="cancel" value="<spring:message code="return"/>" 
	onclick="javascript: window.location.replace('')"/>
</form:form>