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
          		<a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp"><%=Msg.getProperty("application.name")%></a>
        	</div>
        	<div class="navbar-collapse collapse">
          		<ul class="nav navbar-nav">
          		
            		<li><a href="<%=request.getContextPath()%>/modules/admin/main.jsp"><%=Msg.getProperty("menu.main")%></a></li>
            		
            		<li class="dropdown">
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=Msg.getProperty("menu.agenda")%> <b class="caret"></b></a>
        				<ul class="dropdown-menu">
          					<li><a href="#"><%=Msg.getProperty("action.config")%></a></li>
          					<li><a href="#"><%=Msg.getProperty("action.search")%></a></li>
        				</ul>
      				</li>
            		
            		<li class="dropdown">
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=Msg.getProperty("menu.customer")%> <b class="caret"></b></a>
        				<ul class="dropdown-menu">
          					<li><a href="#"><%=Msg.getProperty("action.add")%></a></li>
          					<li><a href="#"><%=Msg.getProperty("action.search")%></a></li>
        				</ul>
      				</li>
      				
      				<li class="dropdown">
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=Msg.getProperty("menu.insurance.company")%> <b class="caret"></b></a>
        				<ul class="dropdown-menu">
          					<li><a href="#"><%=Msg.getProperty("action.add")%></a></li>
          					<li><a href="#"><%=Msg.getProperty("action.search")%></a></li>
          					<li><a href="#"><%=Msg.getProperty("action.report")%></a></li>
        				</ul>
      				</li>
      				
      				<li class="dropdown">
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=Msg.getProperty("menu.medic")%> <b class="caret"></b></a>
        				<ul class="dropdown-menu">
          					<li><a href="#"><%=Msg.getProperty("action.add")%></a></li>
          					<li><a href="#"><%=Msg.getProperty("action.search")%></a></li>
        				</ul>
      				</li>
      				
          		</ul>
          		
          		<c:if test="${!empty authenticated.email}">
          			<ul class="nav navbar-nav navbar-right">
          				<li class="dropdown">
        					<a href="#" class="dropdown-toggle" data-toggle="dropdown">${authenticated.email} <b class="caret"></b></a>
        					<ul class="dropdown-menu">
        						<li><a href="#">Editar Perfil</a></li>
          						<li><a href="#">Sair</a></li>
        					</ul>
      					</li>
          			</ul>
				</c:if>
          		
        	</div>
      	</div>
    </div>

	<!-- Main container
    ================================================== -->
    <div class="container">
    	<div class="row">
    		<div class="col-md-4">
    			<div class="panel panel-default">
  					<div class="panel-heading"><%=Msg.getProperty("title.profile")%></div>
  					<div class="panel-body">
  						<form role="form" action="/Gaam/login" method="post">
						</form>
					</div>
  				</div>
  			</div>
  			<div class="col-md-8">
    			<div class="panel panel-default">
  					<div class="panel-heading"><%=Msg.getProperty("title.admin")%></div>
  					<div class="panel-body">
  						<form role="form" action="/Gaam/login" method="post">
						</form>
					</div>
  				</div>
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
