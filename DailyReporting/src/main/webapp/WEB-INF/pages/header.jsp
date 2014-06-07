<!-- <link rel="stylesheet" type="text/css" href="resources/home2.css"> -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	response.setHeader("Cache-Control",
			"no-cache, private, no-store, max-stale=0");
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>
<script>

</script>
<link rel="stylesheet" type="text/css" href="resources/css/gsli.min.css">
<script type="text/javascript" src="javascript/jquery-1.9.1.js"></script>
<script type="text/javascript" src="javascript/jquery-ui-1.10.4.min.js"></script>
<!--  BOOTSTRAP -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bs_grid/bootstrap.css">
<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<!--  DATAGRID plugin -->
<link rel="stylesheet" type="text/css" href="bs_grid/minified/jquery.bs_grid.min.css">
<script type="text/javascript" src="bs_grid/minified/jquery.bs_grid.min.js"></script>
<script type="text/javascript" src="bs_grid/localization/en.js"></script>

<!--[if lt IE 9]>
        <script src="release/js/html5shiv.min.js"></script>
<![endif]-->