<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Tags</title>
	<link href="<c:url value="/resources/css/bootstrap-3.3.7/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>

<body>


<div class="container">
	<div class="row">
		<div class="col-md-12">
			<select id="tagList" label="Tag List" array="Tags" name="Tag List" class="m-t-50">
				<option disabled selected value> --- Select a Tag --- </option>
				<c:forEach var="tag" items="${tagItems}" varStatus="tagIndex">
					<option id="tag_${tag.id}" value="${tag.name}">
						<c:out value="${tag.name}"/>
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-md-12">
			<table id="contactsTable" width="100%">
				<caption>Contacts</caption>
				<thead>
					<tr><th>Full Name</th><th>Phone Number</th></tr>
				</thead>
				<tbody>
					<c:forEach var="tag" items="${tagItems}">
						<c:set var="parent_tagId" value="parent_tag_${tag.id}" />
						<c:forEach var="contact" items="${tag.contacts}">
							<tr class="hidden contact_items ${parent_tagId}"><td>${contact.fullName}</td><td>${contact.phoneNumber}</td></tr>
						</c:forEach>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
		<div class="col-md-12 m-t-50">
			<a href="${pageContext.request.contextPath}/">Go back to Home page</a><br/>
		</div>
	</div>
</div>


<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.0/jquery-3.1.0.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>