<%@page import="com.hs.vo.*"
		import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

  <title>HS</title>

  <!-- Custom fonts for this template -->
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <%@ include file="menubar/sidebar.jsp" %>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <%@ include file="menubar/top.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">AA Excel DB</h1>


<!-- DataTales Example -->
          <div class="card shadow mb-4">
          <div class="card shadow mb-4">
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>번 호</th>
                      <th>업 체</th>
                      <th>품 번</th>
                      <th>품 명</th>
                      <th>day 1</th>
                      <th>day 2</th>
                      <th>day 3</th>
                      <th>day 4</th>
                    </tr>
                  </thead>
                  <tbody>
                  <%List<AAVO> list = (List<AAVO>)session.getAttribute("alist"); %>
                  <%for(AAVO vo : list) {%>
                    <tr>
                      <td><%=vo.getNum() %></td>
                      <td><%=vo.getSupplier() %></td>
                      <td><%=vo.getNcode() %></td>
                      <td><%=vo.getPname() %></td>
                      <td><fmt:formatNumber value="<%=vo.getDay1() %>" type="number" /></td>
                      <td><fmt:formatNumber value="<%=vo.getDay2() %>" type="number" /></td>
                      <td><fmt:formatNumber value="<%=vo.getDay3() %>" type="number" /></td>
                      <td><fmt:formatNumber value="<%=vo.getDay4() %>" type="number" /></td>
                    </tr>
                    <%} %>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          </div>
          

      </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <%@ include file="menubar/footer.jsp" %>

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->


  <!-- Bootstrap core JavaScript-->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="resources/js/demo/datatables-demo.js"></script>

</body>

</html>