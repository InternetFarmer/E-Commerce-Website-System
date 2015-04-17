<%-- 
    Document   : shoppingBag
    Created on : 2014-11-25, 20:54:54
    Author     : yanyanzhou
--%>

<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Customer"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Customer customer = (Customer) request.getSession().getAttribute("Customer");
    if (customer == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<%@ include file="include.jsp" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Shopping Bag</title>

        <!-- CSS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />">
        <link rel="stylesheet" href="<c:url value='/resources/css/stylesheet.css' />">

    </head>

    <body onload="showBag()">

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
                        <li><a href="customerProfile.jsp">Profile</a></li>
                        <li><a href="customerHomepage.jsp">Search Products</a></li>
                        <li><a href="customerOrderHistory.jsp">Order History</a></li>
                        <li><a href="shoppingBag.jsp">Shopping Bag</a></li>
                        <li><a href="../Logout">Log out</a></li>
                    </ul>

                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row-main">
                <div class="col-sm-7 col-sm-offset-2 main">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-list"></span>
                            Shopping Bag
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Price</th>
                                            <th>Category</th>
                                            <th>Amount</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody id="shoppingbagarea">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Total</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="totle_money" type="text" disabled="">
                            </div>
                            <div class="col-sm-2">
                                <button class="btn btn-primary btn-block" type="button" onclick="checkout()">Check out</button>
                            </div>
                        </div>        

                    </form>

                </div>
            </div>
        </div>
    </body>

    <%@ include file="footer.jsp" %>
    <script src="<c:url value='/resources/js/login.js'/>"></script>
</html>

