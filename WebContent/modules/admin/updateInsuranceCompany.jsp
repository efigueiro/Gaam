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
	
	<!-- Main container
    ================================================== -->
    <div class="container">
    	<div class="row">
    		<div class="col-md-12">
    			<div class="panel panel-default">
  					<div class="panel-heading"><%=Msg.getProperty("title.updateInsuranceCompany")%></div>
  					<div class="panel-body">
  						<form role="form" action="/Gaam/updateInsuranceCompany" method="post">
    						<div class="form-group">
    							<c:if test="${!empty message}">
                                 	<div class="alert alert-info">${message}</div>
                        		</c:if>
                        		<input name="insuranceCompanyId" type="" class="form-control" id="insuranceCompanyId" value="${selectedInsuranceCompany.insuranceCompanyId}">
                        		
    							<label for="name"><%=Msg.getProperty("label.name")%></label>
    							<input name="name" type="" class="form-control" id="name" value="${selectedInsuranceCompany.name}">
  							</div>
  							<div class="form-group">
  								<label for="phone"><%=Msg.getProperty("label.phone")%></label>
    							<input name="phone" type="" class="form-control" id="phone" value="${selectedInsuranceCompany.phone}">
  							</div>
  							<div class="form-group">
  								<label for="address"><%=Msg.getProperty("label.address")%></label>
    							<input name="address" type="" class="form-control" id="address" value="${selectedInsuranceCompany.address}">
  							</div>
  							<div class="form-group">
  								<label for="observation"><%=Msg.getProperty("label.observation")%></label>
    							<input name="observation" type="" class="form-control" id="observation" value="${selectedInsuranceCompany.observation}">
  							</div>
  							
  							<button type="submit" class="btn btn-default"><%=Msg.getProperty("button.submit")%></button>
						</form>
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
