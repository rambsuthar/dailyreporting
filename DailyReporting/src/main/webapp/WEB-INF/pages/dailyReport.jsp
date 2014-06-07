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
							<c:forEach var="dailyReport" items="${dailyReportVOList}"
								varStatus="i">
								<tr id='addr0'>
								<td>${i.index+1}</td>
								<td>${dailyReport.date}</td>
								<td>${dailyReport.ravannaNo}</td>
								<td>${dailyReport.vehicleRegNo}</td>
								<td>${dailyReport.time}</td>
								<td>${dailyReport.weight}</td>
								<td>${dailyReport.royalty}</td>
								<td>${dailyReport.labourName}</td>
								<td>${dailyReport.clientName}</td>
								</tr>
							</c:forEach>
							<tr id='addr0'>
								<td>1</td>
								<td><input type="text" name='date' placeholder='Date'
									class="form-control datepicker" /></td>
								<td><input type="text" name='ravannaNo'
									placeholder='Ravanna No' class="form-control" /></td>
								<td><select class="form-control">
										<option value="Manakpur165">MKU M/L 165</option>
										<option value="Manakpur166">MKU M/L 166</option>
										<option selected value="Account Name">Gotan Stone
											Lime Industries</option>
								</select></td>
								<td><input type="text" name='time' placeholder='Time'
									class="form-control timepicker" /></td>
								<td><input type="text" name='weight' placeholder='Weight'
									class="form-control" /></td>
								<td><input type="text" name='royalty' placeholder='Royalty'
									class="form-control" /></td>
								<td><input type="text" name='labour' placeholder='Labour'
									class="form-control" /></td>
								<td><input type="text" name='partyName'
									placeholder='PartyName' class="form-control" /></td>

							</tr>
							<tr id='addr1'></tr>
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
		    $('.multiselect').multiselect();
		  });
		
	    
		
		</script>
	</div>
</body>
</html>