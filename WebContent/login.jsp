<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.gaam.util.Msg"%>

<!DOCTYPE html>
<html lang="en">
  <head>
  
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/stethoscope.ico">

    <title><%=Msg.getProperty("application.name")%></title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/navbar-fixed-top.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    
  </head>

  <body>
  
    <!-- Fixed top menu
    ================================================== -->
    <div class="navbar navbar-default navbar-fixed-top">
    	<div class="container">
    		<div class="navbar-header">
          		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            		<span class="icon-bar"></span>
            		<span class="icon-bar"></span>
            		<span class="icon-bar"></span>
          		</button>
          		<a class="navbar-brand" href="#"><%=Msg.getProperty("application.name")%></a>
        	</div>
        	<div class="navbar-collapse collapse">
          		<ul class="nav navbar-nav">
            		<li><a href="#"><%=Msg.getProperty("menu.main")%></a></li>
          		</ul>
        	</div>
      	</div>
    </div>

	<!-- Main container
    ================================================== -->
    <div class="container">
    	<div class="panel panel-default">
    		<div class="panel-heading"><%=Msg.getProperty("title.identification")%></div>
    		<div class="panel-body">
    			<form role="form" action="/Gaam/login" method="post">
    				<div class="form-group">
    					<label for="email"><%=Msg.getProperty("label.email")%></label>
    					<input name="email" type="email" class="form-control" id="email" placeholder="<%=Msg.getProperty("placeholder.email")%>">
  					</div>
  					<div class="form-group">
    					<label for="password"><%=Msg.getProperty("label.password")%></label>
    					<input type="password" class="form-control" id="password" placeholder="<%=Msg.getProperty("placeholder.password")%>">
  					</div>
  					<button type="submit" class="btn btn-default"><%=Msg.getProperty("button.enter")%></button>
				</form>
  			</div>
		</div>
    </div> 
    
    <!-- Bottom
    ================================================== -->
    <div class="container">
    	<div class="row">
    		<div class="col-md-8"></div>
    		<div class="col-md-4"><%=Msg.getProperty("application.rights")%></div>
     	</div>
     </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    
  </body>
  
</html>
