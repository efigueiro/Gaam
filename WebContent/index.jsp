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
    	<!-- Main component -->
    	<div class="jumbotron">
    		<div class="row">
        		<div class="col-md-3"><img src="<%=request.getContextPath()%>/img/stethoscope.png"></div>
        		<div class="col-md-9"><h1><%=Msg.getProperty("application.name")%></h1>
        			<p>Agora você tem acesso a um sistema completo para agendamentos de consultas médicas com o especialista que você desejar e pelo convênio que você escolher.</p>
					<p>
          				<a class="btn btn-lg btn-primary" href="<%=request.getContextPath()%>/firstAppointment.jsp"><%=Msg.getProperty("button.appointment")%></a>
        			</p>
        		</div>
      		</div>
      	</div>
    </div> 
    
     <!-- Utility belt
    ================================================== -->
    <div class="container">
    	<div class="row">
    		<div class="col-md-4">
  				<div class="panel panel-default">
  					<div class="panel-heading"><%=Msg.getProperty("title.login")%></div>
  					<div class="panel-body">
  						<form role="form" action="/Gaam/login" method="post">
    						<div class="form-group">
    							${message}<br>
    							<label for="email"><%=Msg.getProperty("label.email")%></label>
    							<input name="email" type="email" class="form-control" id="email" placeholder="<%=Msg.getProperty("placeholder.email")%>">
  							</div>
  							<div class="form-group">
    							<label for="password"><%=Msg.getProperty("label.password")%></label>
    							<input name="password" type="password" class="form-control" id="password" placeholder="<%=Msg.getProperty("placeholder.password")%>">
  							</div>
  							<button type="submit" class="btn btn-default"><%=Msg.getProperty("button.enter")%></button>
						</form>
					</div>
  				</div>
  			</div>
    		<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Especialidades</div>
					<div class="panel-body">
						<p>..diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accums</p>
					</div>
				</div>
			</div>
  			<div class="col-md-4">
  				<div class="panel panel-default">
  					<div class="panel-heading">Convênios</div>
  					<div class="panel-body">
						<p>..diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accums</p>
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

    <!-- Modal for user identification
    ================================================== -->
  	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
  			<div class="modal-content">
        		<div class="modal-header">
          			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          			<h4 class="modal-title"><%=Msg.getProperty("title.identification")%></h4>
        		</div>
        		<div class="modal-body">
        			<form action="/Gaam/login" method="post">
        				${message}
          				<div class="form-group">
    						<label for="exampleInputEmail1"><%=Msg.getProperty("label.email")%></label>
    						<input name="email" type="email" class="form-control" id="exampleInputEmail1" placeholder="<%=Msg.getProperty("tip.email")%>">
  						</div>
  						<div class="form-group">
    						<label for="exampleInputPassword1"><%=Msg.getProperty("label.password")%></label>
    						<input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="<%=Msg.getProperty("tip.password")%>">
  						</div>
  						<button type="submit" class="btn btn-success"><%=Msg.getProperty("button.enter")%></button>
  					</form>
        		</div>
        		<div class="modal-footer">
        		</div>
      		</div>
    	</div>
  	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    
  </body>
  
</html>
