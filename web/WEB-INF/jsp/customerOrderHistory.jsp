<%-- 
    Document   : customerOrderHistory
    Created on : 2014-11-28, 0:03:26
    Author     : yanyanzhou
--%>

<%@page import="Bean.Customer"%>
<%@page import="Handlers.TransactionHandler"%>
<%@page import="Bean.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Customer currentEmployee = (Customer) request.getSession().getAttribute("Customer");
    if (currentEmployee == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Customer Order History</title>

        <!-- CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/dbStyle.css">

        <!-- js -->
        <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/main.js"></script>
        <script src="../js/db.js"></script>


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
                        <li><a href="customerProfile.jsp">Profile</a></li>
                        <li><a href="customerHomepage.jsp">Search Products</a></li>
                        <li><a href="customerOrderHistory.jsp">Order History</a></li>
                        <li><a href="customerStartShopping.jsp">Stores & Regions</a></li>
                        <li><a href="../Logout">Log out</a></li>
                    </ul>

                </div>
            </div>
        </nav>

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
                                            <th>ID</th>
                                            <th>Date</th>
                                            <th>Customer ID</th>
                                            <th>Salesperson ID</th>
                                            <th>Total Amount</th>
                                            <th>Functions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Transaction> lt = TransactionHandler.getTransactionHandler().GetTransactionByCustomerID(currentEmployee.getCustomer_id() + "");
                                            if (lt != null) {
                                                for (Transaction t : lt) {
                                                    out.println("<tr>");
                                                    out.println("<td>" + t.getTransaction_id() + "</td>");
                                                    out.println("<td>" + t.getTransaction_date() + "</td>");
                                                    out.println("<td>" + t.getCustomer_id() + "</td>");
                                                    out.println("<td>" + t.getSalesperson_id() + "</td>");
                                                    out.println("<td>" + TransactionHandler.getTransactionHandler().GetTranactionTotalAmount(t.getTransaction_id() + "") + "</td>");
                                        %>
                                    <td>
                                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" onclick="showTransaction(<%=t.getTransaction_id()%>)">
                                            <span class="glyphicon glyphicon-eye-open"></span>
                                        </button>
                                    </td>
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
</html>
