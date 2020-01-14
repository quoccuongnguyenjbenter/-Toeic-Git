<%--
  Created by IntelliJ IDEA.
  User: QuocCuongJBE
  Date: 10-Dec-19
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title><dec:title default="Admin page"/></title>
    <link rel="stylesheet" href="<c:url value='/templete/admin/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/templete/admin/font-awesome/4.5.0/css/font-awesome.min.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/templete/admin/css/fonts.googleapis.com.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/templete/admin/css/ace.min.css'/>" class="ace-main-stylesheet"
          id="main-ace-style"/>
    <!-- ace settings handler -->
    <script src="assets/js/ace-extra.min.js"></script>
    <dec:head/>
</head>
<body class="no-skin">
<%@include file="/common/admin/header.jsp" %>
<%--    <%@include file="/common/admin/menu.jsp"%>--%>
<dec:body/>
<%--    <%@include file="/common/admin/footer.jsp"%>--%>

<%--<script href="<c:url value='/templete/admin/js/bootstrap.min.js'/>"></script>--%>
<script src="<c:url value='/templete/admin/js/ace-extra.min.js'/>"></script>
<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="<c:url value='/templete/admin/js/excanvas.min.js'/>"></script>
<![endif]-->
<script src="<c:url value='/templete/admin/js/jquery-ui.custom.min.js'/>"></script>
<script src="<c:url value='/templete/admin/js/jquery.ui.touch-punch.min.js'/>"></script>
<script src="<c:url value='/templete/admin/js/jquery.easypiechart.min.js'/>"></script>
<script src="<c:url value='/templete/admin/js/jquery.sparkline.index.min.js'/>"></script>
<script src="<c:url value='/templete/admin/js/jquery.flot.min.js'/>"></script>
<script src="<c:url value='/templete/admin/js/jquery.flot.pie.min.js'/>"></script>
<script src="<c:url value='/templete/admin/js/jquery.flot.resize.min.js'/>"></script>

<!-- ace scripts -->
<script src="<c:url value='/templete/admin/js/ace-elements.min.js'/>"></script>
<script src="<c:url value='/templete/admin/js/ace.min.js'/>"></script>
</body>
</html>