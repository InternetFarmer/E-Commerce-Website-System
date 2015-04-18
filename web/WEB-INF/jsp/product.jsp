
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Product"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.service.ProductService"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.ProductCategory"%>
<%@page import="java.util.List"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.service.ProductCategoryService"%>
<!DOCTYPE html>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Employee"%>
<%
    Employee currentEmployee = (Employee) request.getSession().getAttribute("Employee");
    if (currentEmployee == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Products</title>

        <!-- CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/dbStyle.css">

        <!-- js -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/main.js"></script>
        <!-- jQuery-->

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
                        <li><a href="shoppingBag.jsp">Shopping Bag</a></li>
                        <li><a href="../Logout">Log out</a></li>
                    </ul>

                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row-main">
                <div class="col-sm-2 col-sm-offset-1 sidebar">
                    <ul class="nav nav-sidebar">
                        <li><a href="startShopping.jsp">Start Shopping</a></li>
                        <li class="active"><a href="product.jsp">Manage Products</a></li>
                        <li><a href="category.jsp">Product Category</a></li>
                        <li><a href="customer.jsp">Customer</a></li>
                        <li><a href="transaction.jsp">Transaction</a></li>
                        <li><a href="storeRegion.jsp">Store & Region</a></li>
                    </ul>
                </div>
                <div class="col-sm-8 col-sm-offset-3 main">

                    <h3 class="page-header">Manage Products</h3>

                    <!-- functions for search/add/delete/update products
                    =============================================================================-->
                    <div class="row" style="margin: 0 1px 0 1px;">    
                        <div id="accordion" class="panel-group" aria-multiselectable="true" role="tablist">

                            <!-- search products -->
                            <div class="panel panel-default">
                                <div id="headingOne" class="panel-heading" role="tab">
                                    <h4 class="panel-title">
                                        <a class="collapsed" aria-controls="collapseOne" aria-expanded="false" href="#collapseOne" data-parent="#accordion" data-toggle="collapse">
                                            <span class="glyphicon glyphicon-zoom-in"></span>
                                            Search Products
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse" aria-labelledby="headingOne" role="tabpanel" aria-expanded="false" style="height: 0px;">
                                    <div class="panel-body">

                                        <!-- form for searching products-->
                                        <form class="form-horizontal" role="form">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"> By Product ID</label>
                                                <div class="col-sm-4">
                                                    <input type="text" id="product_id" class="form-control" placeholder="Product ID">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"> By Product Name</label>
                                                <div class="col-sm-4">
                                                    <input type="text" id="product_name" class="form-control" placeholder="Product Name">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"> By Product Category</label>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="product_category">
                                                        <option value="-1">Category</option>
                                                        <%
                                                            List<ProductCategory> l = ProductCategoryHandler.getProductCategoryHandler().getProductCategory();
                                                            for (int i = 0; i < l.size(); i++) {
                                                                out.println("<option value='" + l.get(i).getCategory_id() + "'>" + l.get(i).getCategory_name() + "</option>");
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"> By Product Price</label>
                                                <div class="col-sm-2">
                                                    <input type="text" id="price_from" class="form-control" placeholder="From">
                                                </div>
                                                <div class="col-sm-2">
                                                    <input type="text" id="price_to" class="form-control" placeholder="to">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-3 col-sm-2">
                                                    <button class="btn btn-primary btn-block" type="button" onclick="searchProduct(2)">Search</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <!-- add products -->
                            <div class="panel panel-default">
                                <div id="headingTwo" class="panel-heading" role="tab">
                                    <h4 class="panel-title">
                                        <a class="collapsed" aria-controls="collapseTwo" aria-expanded="false" href="#collapseTwo" data-parent="#accordion" data-toggle="collapse">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                            Add Products
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse" aria-labelledby="headingTwo" role="tabpanel" aria-expanded="false" style="height: 0px;">
                                    <div class="panel-body">

                                        <!-- form for adding products-->
                                        <form class="form-horizontal" role="form">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Product Name</label>
                                                <div class="col-sm-4">
                                                    <input type="text" id="addProductName" class="form-control" placeholder="Product Name">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Inventory Amount</label>
                                                <div class="col-sm-4">
                                                    <input type="text" id="addInventoryAmount" class="form-control" placeholder="Inventory Amount">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Product Price</label>
                                                <div class="col-sm-4">
                                                    <input type="text" id="addProductPrice" class="form-control" placeholder="Product Price">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Product Category</label>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="AddProductCategory">
                                                        <%
                                                            for (int i = 0; i < l.size(); i++) {
                                                                out.println("<option value='" + l.get(i).getCategory_id() + "'>" + l.get(i).getCategory_name() + "</option>");
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Buying Price</label>
                                                <div class="col-sm-4">
                                                    <input type="text" id="addBuyingPrice" class="form-control" placeholder="Buying Price">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-3 col-sm-2">
                                                    <button class="btn btn-primary btn-block" onclick="addProduct()" type="button">Add</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <!-- search results -->
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
                                            <th>Inventory</th>
                                            <th>Price</th>
                                            <th>Category</th>
                                            <th>Buying Price</th>
                                            <th>Functions</th>
                                        </tr>
                                    </thead>
                                    <tbody id="displayProductArea">
                                        <%
                                            List<Product> lp = ProductHandler.getProductHandler().GetAllProduct();
                                            for (int j = 0; j < lp.size(); j++) {
                                                Product p = lp.get(j);
                                                out.println("<tr id='product-" + p.getProduct_id() + "'>");
                                                out.println("<td>" + p.getProduct_id() + "</td>");
                                                out.println("<td>" + p.getProduct_name() + "</td>");
                                                out.println("<td>" + p.getInventory_amount() + "</td>");
                                                out.println("<td>" + p.getPrice() + "</td>");
                                                out.println("<td>" + ProductCategoryHandler.getProductCategoryHandler().getProductCategoryById(p.getCategory_id() + "").getCategory_name() + "</td>");
                                                out.println("<td>" + p.getBuying_price() + "</td>");
                                        %>
                                    <td>
                                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" onclick="showProduct(<%=p.getProduct_id()%>)">
                                            <span class="glyphicon glyphicon-wrench"></span>
                                        </button>&nbsp
                                        <button type="button" class="btn btn-primary btn-sm" onclick="deleteProduct(<%=p.getProduct_id()%>)">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </button>
                                    </td>
                                    </tr>
                                    <%
                                        }
                                    %>

                                    </tbody>
                                </table>
                                <!-- Modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                                <h4 class="modal-title" id="myModalLabel">Update Products</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form class="form-horizontal" role="form">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 col-sm-offset-2 control-label">Product ID</label>
                                                        <div class="col-sm-4">
                                                            <input type="text" id="update_product_id" class="form-control" placeholder="Product ID" disabled="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 col-sm-offset-2 control-label">Product Name</label>
                                                        <div class="col-sm-4">
                                                            <input type="text" id="update_product_name" class="form-control" placeholder="Product Name">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 col-sm-offset-2 control-label">Inventory Amount</label>
                                                        <div class="col-sm-4">
                                                            <input type="text" id="update_inventory_amount" class="form-control" placeholder="Inventory Amount">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 col-sm-offset-2 control-label">Product Price</label>
                                                        <div class="col-sm-4">
                                                            <input type="text" id="update_price" class="form-control" placeholder="Product Price">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 col-sm-offset-2 control-label">Product Category</label>
                                                        <div class="col-sm-4">
                                                            <select class="form-control" id="update_category">
                                                                <%
                                                                    for (int i = 0; i < l.size(); i++) {
                                                                        out.println("<option value='" + l.get(i).getCategory_id() + "'>" + l.get(i).getCategory_name() + "</option>");
                                                                    }
                                                                %>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 col-sm-offset-2 control-label">Buying Price</label>
                                                        <div class="col-sm-4">
                                                            <input type="text" id="update_buying_price" class="form-control" placeholder="Buying Price">
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary" onclick="updateProduct()">Update</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

