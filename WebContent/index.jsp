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
    <!-- Fixed navbar -->
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
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="row">
        	<div class="col-md-3"><img src="<%=request.getContextPath()%>/img/stethoscope.png"></div>
        	<div class="col-md-9"><h1><%=Msg.getProperty("application.name")%></h1>
        		<p>Agora você tem acesso a um sistema completo para agendamentos de consultas médicas com o especialista que você desejar e pelo convênio que você escolher.</p>
				<p>
          			<a class="btn btn-lg btn-primary" href="../../components/#navbar"><%=Msg.getProperty("button.appointment")%></a>
          			<a data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg"><%=Msg.getProperty("button.login")%></a>
        		</p>
        	</div>
      	</div>
      </div>

    </div> <!-- /container -->

    <!-- Modal -->
  	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
      		<div class="modal-content">
        		<div class="modal-header">
          			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          			<h4 class="modal-title"><%=Msg.getProperty("title.identification")%></h4>
        		</div>
        		<div class="modal-body">
          			...
        		</div>
        		<div class="modal-footer">
          			<button type="button" class="btn btn-default" data-dismiss="modal"><%=Msg.getProperty("button.close")%></button>
        		</div>
      		</div><!-- /.modal-content -->
    	</div><!-- /.modal-dialog -->
  	</div><!-- /.modal -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  </body>
</html>
