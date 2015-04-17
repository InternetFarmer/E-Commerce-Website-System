
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Address"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.service.AddressService"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Employee currentEmployee = (Employee) request.getSession().getAttribute("Employee");
    if (currentEmployee == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
    Address currentAddress = (Address) AddressHandler.getAddressHandler().getAddressById(currentEmployee.getAddress_id() + "");
%>

<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Employee Profile</title>

        <!-- CSS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />">
        <link rel="stylesheet" href="<c:url value='/resources/css/stylesheet.css' />">

    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Sales System</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="employeeProfile.jsp">Profile</a></li>
                        <li><a href="../Logout">Log out</a></li>
                    </ul>

                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row-main">
                <div class="col-sm-2 col-sm-offset-1 sidebar">
                    <ul class="nav nav-sidebar">
                        <li><a href="product.jsp">Manage Products</a></li>
                        <li><a href="category.jsp">Product Category</a></li>
                        <li><a href="customer.jsp">Customer</a></li>
                        <li><a href="transaction.jsp">Transaction</a></li>
                    </ul>
                </div>
                <div class="col-sm-7 col-sm-offset-3 main">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-user"></span>
                            Basic Information
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Employee ID</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=currentEmployee.getEmployee_id()%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Employee Name</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=currentEmployee.getEmployee_name()%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Works in</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static">No.<%=currentEmployee.getStore_id()%> Store</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Salary</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=currentEmployee.getSalary()%></p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-home"></span>
                            Address
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Street</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=currentAddress.getStreet()%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">City & State</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=currentAddress.getCity()%>, <%=currentAddress.getState_()%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Zip Code</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=currentAddress.getZipCode()%></p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="col-sm-3 col-sm-offset-4">
                        <a href="employeeProfileUpdate.jsp" class="btn btn-primary btn-block" role="button">Update Information</a>
                    </div>

                </div>
            </div>
        </div>
    </body>
    <%@ include file="footer.jsp" %>
    <script src="<c:url value='/resources/js/login.js'/>"></script>
</html>
