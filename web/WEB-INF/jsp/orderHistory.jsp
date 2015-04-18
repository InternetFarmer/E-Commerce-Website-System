<%-- 
    Document   : customerOrderHistory
    Created on : 2014-11-28, 0:03:26
    Author     : yanyanzhou
--%>

<%@page import="edu.pitt.sis.infsci2730.finalProject.model.TransactionDBModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Customer"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Transaction"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.service.TransactionService"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Map<String, Object> map = (Map) request.getAttribute("modelMap");
%>
<%@ include file="include.jsp" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Customer Order History</title>

        <!-- CSS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />">
        <link rel="stylesheet" href="<c:url value='/resources/css/stylesheet.css' />">

    </head>

    <body>

        <%@ include file="nav.jsp" %>

        <div class="container-fluid">
            <div class="row-main">


                <div class="col-sm-8 col-sm-offset-2 main">

                    <!-- search results
                    =================================================-->

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-list"></span>
                            Order History
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Order ID</th>
                                            <th>Order Date</th>
                                            <th>Total Amount</th>
                                            <th>Status</th>
                                            <th>Details</th>
                                        </tr>
                                    </thead>
                                    <tbody id="history-table">
                                        <%
                                            List<TransactionDBModel> lt = (ArrayList) map.get("transactionList");
                                            if (lt != null) {
                                                for (TransactionDBModel t : lt) {
                                                    out.println("<tr>");
                                                    out.println("<td>" + t.getTransaction_id() + "</td>");
                                                    out.println("<td>" + t.getTransaction_date() + "</td>");
                                                    out.println("<td>" + t.getTotoalAmount() + "</td>");
                                                    out.println("<td>Delieved</td>");
                                        %>
                                    <td>
                                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" data-id="<%=t.getTransaction_id()%>">
                                            <span class="glyphicon glyphicon-eye-open"></span>
                                        </button>
                                    </td></tr>
                                    <%
                                            }
                                        }
                                    %>        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                    <h4 class="modal-title" id="myModalLabel">Transactions Details</h4>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Product ID</th>
                                                <th>Product Name</th>
                                                <th>Amount</th>
                                                <th>Price</th>
                                            </tr>
                                        </thead>
                                        <tbody id="recordDisplay">    
                                        </tbody>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>

    </body>
    <%@ include file="footer.jsp" %>
    <script src="<c:url value='/resources/js/history.js'/>"></script>
</html>
