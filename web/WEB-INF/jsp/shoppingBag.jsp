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
    Customer customer = (Customer) request.getAttribute("Customer");
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

    <body>

        <%@ include file="nav.jsp"%>

        <div class="container-fluid">
            <div class="row-main">
                <div class="col-sm-10 col-sm-offset-1 main">

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
                                <button class="btn btn-primary btn-block" type="button" id="checkout-button">Check out</button>
                            </div>
                        </div>        

                    </form>

                </div>
            </div>
        </div>
    </body>

    <%@ include file="footer.jsp" %>
    <script src="<c:url value='/resources/js/cart.js'/>"></script>
</html>

