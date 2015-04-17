
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Customer"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.service.CustomerService"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.viewModel.Address"%>
<%@page import="edu.pitt.sis.infsci2730.finalProject.service.AddressService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Customer c = (Customer) request.getSession().getAttribute("Customer");
    if (c == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
    Customer customer = null;

    customer = CustomerHandler.getCustomerHandler().getCustomerById(c.getCustomer_id() + "");

    Address currentAddress = AddressHandler.getAddressHandler().getAddressById(c.getAddress_id() + "");
%>

<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Customer Profile</title>

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
                        <li><a href="product.jsp">Search Products</a></li>
                        <li><a href="customerOrderHistory.jsp">Order History</a></li>
                        <li><a href="shoppingBag.jsp">Shopping Bag</a></li>
                        <li><a href="../Logout">Log out</a></li>
                    </ul>

                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row-main">

                <div class="col-sm-8 col-sm-offset-2 main">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-user"></span>
                            Basic Information
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label">Customer ID</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=customer.getCustomer_id()%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-5 control-label">Customer Name</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=customer.getCustomer_name()%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-5 control-label">Gender</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=customer.getGender()%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-5 control-label">Age</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=customer.getAge()%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-5 control-label">Income</label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static"><%=customer.getIncome()%></p>
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

                    <div class="col-sm-4 col-sm-offset-3">
                        <button class="btn btn-primary btn-block" data-toggle="modal" data-target="#myModal" >Update Information</button>
                    </div>

                </div>

                <!-- Modal 
                =======================================================================   -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Update Customer Information</h4>
                            </div>
                            <div class="modal-body">

                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Customer ID</label>
                                        <div class="col-sm-6">
                                            <input type="text" id="update_customer_id" class="form-control" value="<%=customer.getCustomer_id()%>" disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Customer Name</label>
                                        <div class="col-sm-6">
                                            <input type="text" id="update_customer_name" class="form-control" value="<%=customer.getCustomer_name()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Customer Address</label>
                                        <div class="col-sm-6">                                   
                                            <input type="text" id="update_address_id" class="form-control" value="<%=currentAddress.getAddress_id()%>" style="display:none">
                                            <input type="text" id="update_street" class="form-control" value="<%=currentAddress.getStreet()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"></label>
                                        <div class="col-sm-2">
                                            <input type="text" id="update_city" class="form-control" value="<%=currentAddress.getCity()%>">
                                        </div>
                                        <div class="col-sm-2">
                                            <input type="text" id="update_state" class="form-control" value="<%=currentAddress.getState_()%>">
                                        </div>
                                        <div class="col-sm-2">
                                            <input type="text" id="update_zipcode" class="form-control" value="<%=currentAddress.getZipCode()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Gender</label>
                                        <div class="col-sm-6">
                                            <input type="text" id="update_gender" class="form-control" value="<%=customer.getGender()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Age</label>
                                        <div class="col-sm-6">
                                            <input type="text" id="update_age" class="form-control" value="<%=customer.getAge()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Income</label>
                                        <div class="col-sm-6">
                                            <input type="text" id="update_income" class="form-control" value="<%=customer.getIncome()%>">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Update</button>
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

