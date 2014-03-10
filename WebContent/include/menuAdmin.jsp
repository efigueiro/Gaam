<%@ page import="com.gaam.util.Msg"%>
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
          					<li><a href="<%=request.getContextPath()%>/modules/admin/createCustomer.jsp"><%=Msg.getProperty("action.add")%></a></li>
          					<li><a href="#"><%=Msg.getProperty("action.search")%></a></li>
        				</ul>
      				</li>
      				
      				<li class="dropdown">
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=Msg.getProperty("menu.insurance.company")%> <b class="caret"></b></a>
        				<ul class="dropdown-menu">
          					<li><a href="<%=request.getContextPath()%>/modules/admin/createInsuranceCompany.jsp"><%=Msg.getProperty("action.add")%></a></li>
          					<li><a href="<%=request.getContextPath()%>/modules/admin/retrieveInsuranceCompany.jsp"><%=Msg.getProperty("action.search")%></a></li>
          					<li><a href="#"><%=Msg.getProperty("action.report")%></a></li>
        				</ul>
      				</li>
      				
      				<li class="dropdown">
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=Msg.getProperty("menu.medic")%> <b class="caret"></b></a>
        				<ul class="dropdown-menu">
          					<li><a href="<%=request.getContextPath()%>/modules/admin/createMedic.jsp"><%=Msg.getProperty("action.add")%></a></li>
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
          						<li><a href="/Gaam/login?action=logout" class="logout"><%=Msg.getProperty("link.logoff")%></a></li>
        					</ul>
      					</li>
          			</ul>
				</c:if>
          		
        	</div>
      	</div>
    </div>
