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
<title>Report Books</title>
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
							<label>Create Daily Report : Date</label>
						</div>
						<div class="form-group ">
							<input id="dateMonth" type="text" class="form-control datepicker">
						</div>
						<div class="form-group">
							<label>Mines</label>
						</div>
						<div class="form-group">
							<select id="selectedMines" class="form-control"
								title="select mines">
								<option>Select</option>
								<option value="MKU165">MKU165</option>
								<option value="MKU166">MKU166</option>
							</select>
						</div>
					</form>
				</div>
			</nav>
			<div id="dailyEntry" class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-striped" id="tab_logic">
						<thead>
							<tr>
								<th class="text-center">Ravanna No</th>
								<th class="text-center">Transport</th>
								<th class="text-center">Weight</th>
								<th class="text-center">Royalty</th>
								<th class="text-center">Labour Name</th>
								<th class="text-center">Party's Name</th>

							</tr>
						</thead>
						<tbody>

							<tr>
								
									
							</tr>

						</tbody>
					</table>
					<nav class="navbar navbar-default" role="navigation">
					<div>
					<form:form id="createDailyEntryForm" action="create.htm"
									method="post" commandName="dailyReportVO" class="navbar-form navbar-left" role="form"
									enctype="multipart/form-data">
									<div class="form-group">
									<input id="date" name="date" type="hidden" class="form-control">
									<form:input type="text" path='ravannaNo'
											placeholder='Ravanna No' class="form-control" /></div>
									<div class="form-group"><form:select path="vehicleId" class="form-control">
											<option value="">Select</option>
											<c:forEach var="vehicle" items="${vehicleList}" varStatus="i">
												<option value="${vehicle.id}">${vehicle.regNumber}</option>
											</c:forEach>
										</form:select></div>

									<div class="form-group"><form:input type="text" path='weight'
											placeholder='Weight' class="form-control" /></div>
									<div class="form-group"><form:input type="text" path='royalty'
											placeholder='Royalty' class="form-control" /></div>
									<div class="form-group"><form:select path="contractorId" class="form-control">
											<option value="">Select</option>
											<c:forEach var="contractor" items="${contractorList}"
												varStatus="i">
												<option value="${contractor.id}">${contractor.name}</option>
											</c:forEach>
										</form:select></div>
									<div class="form-group"><form:select path="clientId" class="form-control">
											<option value="">Select</option>
											<c:forEach var="client" items="${clientsList}" varStatus="i">
												<option value="${client.id}">${client.firmName}</option>
											</c:forEach>
										</form:select></div>
					</form:form>
					</div>
					</nav>
				</div>
			</div>
			<a id="add_row" class="btn btn-default pull-left">Save</a>
			<div id="sPhoneFromResponse"></div>

		</div>
		<%@include file="footer.jsp"%>
		<script type="text/javascript">
			$(function() {
				$('.multiselect').multiselect({
					nonSelectedText : 'select mines'
				});
				$(".datepicker").datepicker("setDate", new Date());
				$("#dailyEntry").hide();
				$("#add_row").hide();
				$("#selectedMines").change(function() {
					var item = $(this);
					if (item.val() == "Select") {
						$("#dailyEntry").hide();
						$("#add_row").hide();
					} else {
						$("#dailyEntry").show();
						$("#add_row").show();
					}
				});

				var i = 1;
				$("#add_row").click(function() {
					$("#date").val($("#dateMonth").val());
					alert($("#date").val());
					$("#createDailyEntryForm").submit();
				});	
				
				/* $('#createDailyEntryForm')
				.submit(
						function(event) {

							var date = $('#date').val();
							var ravannaNo = $('#ravannaNo').val();
							var vehicleId = $('#vehicleId').val();
							var weight = $('#weight').val();
							var royalty = $('#royalty').val();
							var contractorId = $('#contractorId').val();
							var clientId = $('#clientId').val();
							var minesId = $('#selectedMines').val();
							var json = {
								"date" : date,
								"ravannaNo" : ravannaNo,
								"vehicleId" : vehicleId,
								"weight" : weight,
								"royalty" : royalty,
								"contractorId" : contractorId,
								"clientId" : clientId,
								"minesId" : minesId
							};
							alert(JSON.stringify(json));
							alert($("#createDailyEntryForm")
									.attr("action"));
							$.ajax({
								
										url : $("#createDailyEntryForm")
												.attr("action"),
										data : JSON.stringify(json),
										type:"POST", 
						                contentType: "application/json; charset=utf-8",
										success : function(smartphone) {
											var respContent = "";

											$("#sPhoneFromResponse")
													.html(respContent);
										}
								});

						});
				 */
				
			});
			
			
		</script>
	</div>
</body>
</html>