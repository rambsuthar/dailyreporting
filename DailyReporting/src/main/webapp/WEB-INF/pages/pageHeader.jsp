<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<%
	response.setHeader("Cache-Control",
			"no-cache, private, no-store, max-stale=0");
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>
<header>
	<div id="logo">
		<a href="index.htm"><img src="resources/img/logo.png" alt="GSLI"></a>
	</div>
	<div class="welcome">

		<div class="logout">
			<a href="#">Contact Us</a> | <a href="#">Logout</a>
		</div>
		<div style="clear: right"></div>

		<div class="account-name">

			<span>Welcome</span><strong>Ram Kripal, Suthar</strong> <br />
			Account :<strong>Gotan Stone Line Industries</strong>

		</div>

		<form action="#" class=" top-header-search">
			<div class="cb"></div>
			<div id="search">
				<select>
					<option value="Manakpur165">MKU M/L 165</option>
					<option value="Manakpur166">MKU M/L 166</option>
					<option selected value="Account Name">Gotan Stone Lime Industries</option>
				</select> <input type="submit" value="Select"
					class="primary-small-button submit">
				<div class="cb"></div>
			</div>
		</form>
	</div>

</header>
<div class="cb"></div>