<%-- 
    Document   : header.jsp
    Created on : Apr 16, 2015, 7:32:14 PM
    Author     : Wu
--%>

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
            <ul class="nav navbar-nav navbar-left">
                <li><a href="<c:url value='/products'/>">Products</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value='/user'/>">Profile</a></li>
                <li><a href="<c:url value='/orderhistory'/>">Order History</a></li>
                <li><a href="<c:url value='/shoppingBag'/>">Cart</a></li>
                <li><a href="<c:url value='/logout'/>">Log out</a></li>
            </ul>
        </div>
    </div>
</nav>
