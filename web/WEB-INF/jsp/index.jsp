<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="include.jsp" %>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Log in</title>

        <!-- CSS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />">
        <link rel="stylesheet" href="<c:url value='/resources/css/stylesheet.css' />">


    </head>
    <body>
        <div class="navbar-top navbar navbar-inverse navbar-fixed-top">
            <div class="container">
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
                        <li><a href="#"></a></li>
                </div>
            </div>
        </div>

        <div id="content">
            <div class="container">
                <div class="row">
                    <div id="login_block" class="col-sm-4 col-sm-offset-4"  style="background-color: #ffffff;opacity:0.9;">  
                        <h3 align="center">Log In</h3>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Username</label>
                                <div class="col-sm-6">
                                    <input type="text" id="username" class="form-control" placeholder="Username" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Password</label>
                                <div class="col-sm-6">
                                    <input type="password" id="password" class="form-control" placeholder="Password" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 col-sm-offset-2 radio-inline">
                                    <input type="radio" value="Customer" name="type" id="customer"> Customer
                                </label>
                                <label class="col-sm-3 radio-inline">
                                    <input type="radio" value="Employee" name="type" id="employee"> Employee
                                </label>
                                <label class="col-sm-3 radio-inline">
                                    <input type="radio" value="Admin" name="type" id="admin"> Admin
                                </label>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-4">
                                    <button class="btn btn-primary btn-block" type="button" onclick="login()">Log In</button>
                                </div>
                                <div class="col-sm-4">
                                    <button class="btn btn-primary btn-block" type="button" onclick="window.location.href='JSP/browse.jsp'">Browse</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@ include file="footer.jsp" %>
</html>

