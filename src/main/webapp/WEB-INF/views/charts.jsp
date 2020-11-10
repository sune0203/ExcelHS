<%@page import="com.hs.vo.*"
		import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
          <h1 class="h3 mb-2 text-gray-800">result Excel DB</h1>


<!-- DataTales Example -->
          <div class="card shadow mb-4">
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div>
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
                      <td><%=vo.getDay1() %></td>
                      <td><%=vo.getDay2() %></td>
                      <td><%=vo.getDay3() %></td>
                      <td><%=vo.getDay4() %></td>
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

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

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