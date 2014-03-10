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
	<jsp:include page="/include/menuAdmin.jsp" />
	
	<!-- Search container
    ================================================== -->
    <div class="container">
    	<div class="row">
    		<div class="col-md-12">
    			<div class="panel panel-default">
  					<div class="panel-heading"><%=Msg.getProperty("title.searchInsuranceCompany")%></div>
  					<div class="panel-body">
  						<form role="form" action="/Gaam/searchInsuranceCompany" method="post">
    						<div class="form-group">
    							<c:if test="${!empty message}">
                                 	<div class="alert alert-info">${message}</div>
                        		</c:if>
    							<label for="name"><%=Msg.getProperty("label.insuranceCompany")%></label>
    							<input name="name" type="" class="form-control" id="name">
  							</div>
  							
  							<button type="submit" class="btn btn-default"><%=Msg.getProperty("button.search")%></button>
						</form>
					</div>
  				</div>
  			</div>
    	</div>
    </div> 
    
    <!-- Data container
    ================================================== -->
    <div class="container">
    	<div class="row">
    		<div class="col-md-12">
    			<div class="panel panel-default">
  					<div class="panel-heading"><%=Msg.getProperty("title.searchInsuranceCompany")%></div>
  					<div class="panel-body">
  						<table class="table table-hover">
  							<tr>
  								<td>Name</td>
  								<td>Phone</td>
  								<td>Address</td>
  								<td>Observation</td>
							</tr>
							
							<tr>
  								<td>Name</td>
  								<td>Phone</td>
  								<td>Address</td>
  								<td>Observation</td>
							</tr>
							
							<tr>
  								<td>Name</td>
  								<td>Phone</td>
  								<td>Address</td>
  								<td>Observation</td>
							</tr>
  						</table>
					</div>
  				</div>
  			</div>
    	</div>
    </div>
    
    <!-- Footer
    ================================================== -->
    <jsp:include page="/include/footer.jsp" />

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    
  </body>
  
</html>
