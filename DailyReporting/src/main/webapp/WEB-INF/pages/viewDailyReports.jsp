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
			<nav class="navbar navbar-default" role="navigation">
				<div>
					<form class="navbar-form navbar-left" role="form">
						<div class="form-group">
							<label class="sr-only" for="reportType">Report Type</label> <select
								class="form-control">
								<option selected value="dailyReport">Daily Report</option>
								<option value="monthlyReport">Monthly Report</option>
							</select>
						</div>
						<div class="form-group ">
							<input id="dateMonth" type="text" class="form-control">
						</div>
						<div class="checkbox">
							<label> <select class="multiselect" multiple
								class="form-control">
									<option selected value="MKU165">MKU165</option>
									<option value="MKU166">MKU166</option>
							</select>
						</div>
						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>
			</nav>
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
								<th class="text-center">Party's Name</th>

							</tr>
						</thead>
						<tbody>
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
			<a id="add_row" class="btn btn-default pull-left">Save</a>

		</div>
		<%@include file="footer.jsp"%>
		<script type="text/javascript">
			$(function() {
				$(".datepicker").datepicker();
				$('.multiselect').multiselect();
				$("#dateMonth").datepicker("setDate", new Date());

			});

			$(document)
					.ready(
							function() {
								var i = 1;
								$("#add_row")
										.click(
												function() {
													$('#addr' + i)
															.html(
																	"<td>"
																			+ (i + 1)
																			+ "</td><td><input name='name"+i+"' type='text' placeholder='Name' class='form-control input-md'  /> </td><td><input  name='mail"+i+"' type='text' placeholder='Mail'  class='form-control input-md'></td><td><input  name='mobile"+i+"' type='text' placeholder='Mobile'  class='form-control input-md'></td>");

													$('#tab_logic')
															.append(
																	'<tr id="addr'
																			+ (i + 1)
																			+ '"></tr>');
													i++;
												});
								$("#delete_row").click(function() {
									if (i > 1) {
										$("#addr" + (i - 1)).html('');
										i--;
									}
								});

							});
		</script>
	</div>
</body>
</html>