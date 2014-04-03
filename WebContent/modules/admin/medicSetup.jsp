<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.gaam.model.entity.Category"%>
<%@ page import="com.gaam.model.service.CategoryService"%>
<%@ page import="java.util.*"%>
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
  
    <!-- scripts java -->
  	<%
  		// Retrieve all insurance companies for insurance company combo box.
  		List<Category> categoryList = new ArrayList<Category>();
        categoryList = CategoryService.getInstance().retrieveAll();
        request.setAttribute("categoryList", categoryList);
	%>
  <!-- end scripts -->

  <body>
  
    <!-- Fixed top menu
    ================================================== -->
	<jsp:include page="/include/menuAdmin.jsp" />
	
    
    <!-- Data container
    ================================================== -->
    <div class="container">
    	<div class="row">
    		<div class="col-md-12">
    			<div class="panel panel-default">
  					<div class="panel-heading"><%=Msg.getProperty("title.medic.setup.category")%></div>
  					<div class="panel-body">
  						<c:if test="${!empty message}">
  							<div class="alert alert-info">${message}</div>
                        </c:if>
  					
  						<table class="table table-hover">
  							<tr>
  								<th class="header"><%=Msg.getProperty("label.speciality")%></th>
								<th class="header"><%=Msg.getProperty("label.action")%></th>
							</tr>
							
							<c:forEach var="category" items="${categoryList}">
								<tr>
									<td>${category.name}</td>
									<td>
										<a data-toggle="modal" href="#dialog" title="<%=Msg.getProperty("tip.delete")%>" style="margin-left: 10px;" onclick="document.getElementById('selectedValueId').value ='${category.categoryId}';document.getElementById('selectedValueName').value ='${category.name}'" ><img src="<%=request.getContextPath()%>/img/Cross.png" border="0"></a>
									</td>
								</tr>
							</c:forEach>
						</table>
						<a data-toggle="modal" href="#newCategory" title="<%=Msg.getProperty("tip.add")%>" style="margin-left: 10px;" onclick="document.getElementById('selectedValueId').value ='${category.categoryId}';document.getElementById('selectedValueName').value ='${category.name}'" ><img src="<%=request.getContextPath()%>/img/Add.png" border="0"></a>
					</div>
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
        			<form action="/Gaam/deleteCategory" method="post">
          				<div class="form-group">
    						<input name="selectedValueId" type="hidden" class="form-control" id="selectedValueId">
    						<input readonly="readonly" name="selectedValueName" type="" class="form-control" id="selectedValueName">
  						</div>
  						<button type="submit" class="btn btn-default"><%=Msg.getProperty("button.yes")%></button>
  						<button type="submit" class="btn btn-default" data-dismiss="modal" ><%=Msg.getProperty("button.no")%></button>
  					</form>
        		</div>
        		<div class="modal-footer">
        		</div>
      		</div>
    	</div>
  	</div>
    
    <!-- Modal for new category
    ================================================== -->
  	<div class="modal fade" id="newCategory" tabindex="-1" role="dialog" aria-labelledby="dialog" aria-hidden="true">
  		<div class="modal-dialog">
  			<div class="modal-content">
        		<div class="modal-header">
          			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          			<h4 class="modal-title"><%=Msg.getProperty("title.add.category")%></h4>
        		</div>
        		<div class="modal-body">
        			<form action="/Gaam/createCategory" method="post">
          				<div class="form-group">
    						<label for="name"><%=Msg.getProperty("label.name")%></label>
    						<input name="name" type="" class="form-control" id="name" value="">
  						</div>
  						<button type="submit" class="btn btn-default"><%=Msg.getProperty("button.add")%></button>
  						<button type="submit" class="btn btn-default" data-dismiss="modal" ><%=Msg.getProperty("button.cancel")%></button>
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
