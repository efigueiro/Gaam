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
  						<form role="form" action="/Gaam/retrieveInsuranceCompany" method="post">
    						<div class="form-group">
    							<c:if test="${!empty message}">
                                 	<div class="alert alert-info">${message}</div>
                        		</c:if>
    							<label for="name"><%=Msg.getProperty("label.insuranceCompany")%></label>
    							<input name="keyword" type="" class="form-control" id="keyword">
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
    				<c:if test="${not empty insuranceCompanyList}">
  					<div class="panel-heading"><%=Msg.getProperty("title.searchResult")%></div>
  					<div class="panel-body">
  					
  						<table class="table table-hover">
  							<tr>
  								<th class="header"><%=Msg.getProperty("label.name")%></th>
								<th class="header"><%=Msg.getProperty("label.phone")%></th>
								<th class="header"><%=Msg.getProperty("label.address")%></th>
								<th class="header"><%=Msg.getProperty("label.action")%></th>
							</tr>
							
							<c:forEach var="insuranceCompany" items="${insuranceCompanyList}">
								<tr>
									<td>${insuranceCompany.name}</td>
									<td>${insuranceCompany.phone}</td>
									<td>${insuranceCompany.address}</td>
									<td>
										<a href="/EasyDays/updateArticle?articleId=${insuranceCompany.insuranceCompanyId}" title="<%=Msg.getProperty("tip.edit")%>" ><img src="<%=request.getContextPath()%>/img/Notepad.png" border="0"></a>
										<a data-toggle="modal" href="#dialog" title="<%=Msg.getProperty("tip.delete")%>" style="margin-left: 10px;" onclick="document.getElementById('selectedValue').value ='${insuranceCompany.insuranceCompanyId}';" ><img src="<%=request.getContextPath()%>/img/Cross.png" border="0"></a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					</c:if>
  				</div>
  			</div>
    	</div>
    </div>
    
    <!-- Modal for action confirmation
    ================================================== -->
  	<div class="modal fade" id="dialog" tabindex="-1" role="dialog" aria-labelledby="dialog" aria-hidden="true">
  		<div class="modal-dialog">
  			<div class="modal-content">
        		<div class="modal-header">
          			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          			<h4 class="modal-title"><%=Msg.getProperty("message.delete.confirmation")%></h4>
        		</div>
        		<div class="modal-body">
        			<form action="/Gaam/login" method="post">
        				${message}
          				<div class="form-group">
    						<input name="selectedValue" type="" class="form-control" id="selectedValue">
  						</div>
  						<button type="submit" class="btn btn-default"><%=Msg.getProperty("button.yes")%></button>
  					</form>
        		</div>
        		<div class="modal-footer">
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
    <script type="text/javascript"> 
		var selectedValue;
    </script>
    
  </body>
  
</html>
