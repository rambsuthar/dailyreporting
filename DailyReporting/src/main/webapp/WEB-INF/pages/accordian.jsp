<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<nav class="primary-nav">
	<ul>
		<li class="first"><a href="index.html"><div class="icon-home"></div></a></li>
		<li id="daily-reports-tab" class="parent"><a href="dailyReports.htm">Daily Reports</a></li>

		<li class="parent"><a href="#">View</a>
			<ul class="subnav" style="display: none">
				<li><a href="training materials.html">Daily Reports</a></li>
				<li><a href="reference.html">Monthly Reports</a></li>
			</ul></li>
		<li class="parent"><a href="#">Billing</a>
			<ul class="subnav" style="display: none">
				<li><a href="training materials.html">View bills</a></li>
				<li><a href="reference.html">Generate Bills</a></li>
			</ul></li>

		<li class="parent"><a href="admintools.html">Admin Tools</a>
			<ul class="subnav" style="display: none">
				<li><a href="manage-user.html">Manage Users</a></li>
				<li><a href="manage-daily-reports.html">Manage Daily Reports</a></li>
				<li><a href="manage-vehicles.html">Manage Vehicles</a></li>
			</ul></li>
	</ul>
</nav>