<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if IE 9]>    <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<title>Gotan Stone Lime Industries</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@include file="pageHeader.jsp"%>
		<%@include file="accordian.jsp"%>
		<div id="contentArea">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-striped" id="tab_logic">
						<thead>
							<tr>
								<th class="text-center">#</th>
								<th class="text-center">Date</th>
								<th class="text-center">Ravanna No</th>
								<th class="text-center">Transport</th>
								<th class="text-center">Time</th>
								<th class="text-center">Weight</th>
								<th class="text-center">Royalty</th>
								<th class="text-center">Labour</th>
								<th class="text-center">Patry's Name</th>
								
							</tr>
						</thead>
						<tbody>
							<tr id='addr0'>
								<td>1</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		<%@include file="footer.jsp"%>
		<script type="text/javascript">
		$(function() {
			$("#daily-reports-tab").addClass('active');
		    $( ".datepicker" ).datepicker();
		  });
		
	    
		
		</script>
	</div>
</body>
</html>