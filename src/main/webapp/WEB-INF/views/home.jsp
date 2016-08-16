<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Home Page</title>
<link
	href="<c:url value="/resources/css/bootstrap-3.3.7/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.1.0/jquery-3.1.0.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/main.js" />"></script>
</head>

<body>

	<div class="jumbotron text-center">
		<h1 class="">User Accessed : ${name}</h1>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" id="search-form">
					<div class="form-group form-group-lg">
						<label class="col-sm-2 control-label">Tag Name</label>
						<div class="col-sm-10">
							<input type=text class="form-control" id="tagname">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="col-sm-4">
							<button type="submit" id="searchButton"
								class="btn btn-primary btn-lg">Search</button>
							</div>
							<div class="col-sm-8">
								<a href="${pageContext.request.contextPath}/display">View Saved Records</a><br/>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<p id="feedback" class="italic"></p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<table id="tags_table">
								<tr>
									<th>Tag Name</th>
									<th>Contact Names</th>
								</tr>
							</table>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>