<%-- 
    Document   : customerHomepage
    Created on : 2014-11-28, 0:01:41
    Author     : yanyanzhou
--%>

<%@ include file="include.jsp" %>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Customer"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Product"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.service.ProductService"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.ProductCategory"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.service.ProductCategoryService"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
    Customer customer = (Customer) request.getSession().getAttribute("customer");
    if (customer == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home page for customers</title>

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
                        <li><a href="customerProfile.jsp">Profile</a></li>
                        <li><a href="customerHomepage.jsp">Search Products</a></li>
                        <li><a href="customerOrderHistory.jsp">Order History</a></li>
                        <li><a href="../Logout">Log out</a></li>
                    </ul>

                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row-main">
                <div class="col-sm-3 col-sm-offset-1 sidebar">

                    <h4 class="page-header" align="center" style="margin-top: 0">
                        <span class="glyphicon glyphicon-zoom-in"></span>
                        Search Products
                    </h4>
                    <form role="form">
                        <div class="form-group">
                            <label>Product ID</label>
                            <input type="text" id="product_id" class="form-control" placeholder="Product ID">
                        </div>
                        <div class="form-group">
                            <label>Product Name</label>
                            <input type="text" id="product_name" class="form-control" placeholder="Product Name">
                        </div>
                        <div class="form-group">
                            <label>Product Category</label>
                            <select id="product_category" class="form-control">
                                <option value="-1">Category</option>
                                <%
                                    List<ProductCategory> l = ;
                                    for (int i = 0; i < l.size(); i++) {
                                        out.println("<option value='" + l.get(i).getCategory_id() + "'>" + l.get(i).getCategory_name() + "</option>");
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Price From</label>
                            <input type="text" id="price_from" class="form-control" placeholder="From">
                        </div>
                        <div class="form-group">
                            <label>Price To</label>
                            <input type="text" id="price_to" class="form-control" placeholder="to">
                        </div>
                        <button class="btn btn-primary btn-block" type="button" onclick="searchProduct()">Search</button>
                    </form>
                </div>


                <div class="col-sm-7 col-sm-offset-4 main">

                    <!-- search results
                    =================================================-->

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-list"></span>
                            Search Results
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
                                            <th>Inventory</th>
                                        </tr>
                                    </thead>
                                    <tbody id="displayProductArea">
                                        <%
                                            List<Product> lp = ;
                                            for (int j = 0; j < lp.size(); j++) {
                                                Product p = lp.get(j);
                                                out.println("<tr id='product-" + p.getProduct_id() + "'>");
                                                out.println("<td>" + p.getProduct_id() + "</td>");
                                                out.println("<td>" + p.getProduct_name() + "</td>");
                                                out.println("<td>" + p.getPrice() + "</td>");
                                                out.println("<td>" + .getProductCategoryHandler().getProductCategoryById(p.getCategory_id() + "").getCategory_name() + "</td>"
                                                );
                                                out.println("<td>" + p.getInventory_amount() + "</td>");
                                        %>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>

    </body>
    <%@ include file="footer.jsp" %>
    <script src="<c:url value='/resources/js/login.js'/>"></script>
</html>



