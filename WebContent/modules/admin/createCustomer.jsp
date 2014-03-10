<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.gaam.util.Msg"%>
<%@ page import="com.gaam.model.entity.InsuranceCompany"%>
<%@ page import="com.gaam.model.service.InsuranceCompanyService"%>
<%@ page import="java.util.*"%>

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
  
  <!-- scripts java -->
  	<%
  		// Retrieve all categories for category combo box.
  		List<InsuranceCompany> insuranceCompanyList = new ArrayList<InsuranceCompany>();
        insuranceCompanyList = InsuranceCompanyService.getInstance().retrieveAll();
        request.setAttribute("insuranceCompanyList", insuranceCompanyList);
	%>
  <!-- end scripts -->

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
  					<div class="panel-heading"><%=Msg.getProperty("title.createCustomer")%></div>
  					<div class="panel-body">
  						<form role="form" action="/Gaam/createCustomer" method="post">
    						<div class="form-group">
    							<c:if test="${!empty message}">
                                 	<div class="alert alert-info">${message}</div>
                        		</c:if>
    							<label for="email"><%=Msg.getProperty("label.email")%></label>
    							<input name="email" type="email" class="form-control" id="email">
  							</div>
  							<div class="form-group">
  								<label for="password"><%=Msg.getProperty("label.password")%></label>
    							<input name="password" type="" class="form-control" id="password">
  							</div>
  							<div class="form-group">
  								<label for="name"><%=Msg.getProperty("label.name")%></label>
    							<input name="name" type="" class="form-control" id="name">
  							</div>
  							<div class="form-group">
  								<label for="phone"><%=Msg.getProperty("label.phone")%></label>
    							<input name="phone" type="" class="form-control" id="phone">
  							</div>
  							<div class="form-group">
  								<label for="address"><%=Msg.getProperty("label.address")%></label>
    							<input name="address" type="" class="form-control" id="address">
  							</div>
  							<div class="form-group">
  								<label for="cpf"><%=Msg.getProperty("label.cpf")%></label>
    							<input name="cpf" type="" class="form-control" id="cpf">
  							</div>
  							<div class="form-group">
  								<label for="rg"><%=Msg.getProperty("label.rg")%></label>
    							<input name="rg" type="" class="form-control" id="rg">
  							</div>
  							<div class="form-group">
  								<label for="insuranceCompany"><%=Msg.getProperty("label.insuranceCompany")%></label>
    							<select class="form-control" name="insuranceCompany">
    								<c:forEach var="insuranceCompany" items="${insuranceCompanyList}">
                                    	<option value="${insuranceCompany.insuranceCompanyId}">${insuranceCompany.name}</option>
									</c:forEach>
								</select>
  							</div>
  							<div class="form-group">
  								<label for="insuranceCompanyIdentification"><%=Msg.getProperty("label.insuranceCompanyIdentification")%></label>
    							<input name="insuranceCompanyIdentification" type="" class="form-control" id="insuranceCompanyIdentification">
  							</div>
  							<div class="form-group">
  								<label for="observation"><%=Msg.getProperty("label.observation")%></label>
    							<input name="observation" type="" class="form-control" id="observation">
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
