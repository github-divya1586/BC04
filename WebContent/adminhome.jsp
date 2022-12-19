<%@page import="com.model.FileModel"%>
<%@page import="com.configurations.AppConfig"%>
<%@page import="com.service.UploadKycService"%>
<%@page import="java.util.List"%>
<%@page import="com.model.RegisterModel"%>
<jsp:include page="common/AdminHeader.jsp"></jsp:include>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center">

    <div class="container">
    
     <%if(request.getParameter("userpgage")!=null){
    	 if(request.getParameter("userpage").equalsIgnoreCase("home")){%>
    		 
    	<%  }%>
    	 
    	 <div class="row">
         <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
        
         <h3 style="color: #FF5733"></h3>
         <h3 style="color: #000">welcome : Admin</h3>
           <center><h1>Systematic Review Of Security Vulnerabilities In Ethereum Blockchain Smart Contract</h1></center>
          
        
         </div>
         <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
           <img src="assets/img/hero-img.png" class="img-fluid animated" alt="">
         </div>
       </div>
    	 
        	
      <% }%>
        
        <!-- smart contracts -->
         <%if(request.getParameter("userpage")!=null){
    	 if(request.getParameter("userpage").equalsIgnoreCase("smart")){%>
    		 
    		 <div class="row">
         <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
        
        
        <% 
        
        UploadKycService kyc=AppConfig.getuploadKycService();
        
        List<RegisterModel> rm= kyc.getAllUsers(); %>
        
        
      <table class="table" style="color: #FFF;">
     
      <tr class="thead-dark">
      <td>Name</td>
      <td>Email</td>
      <td>Mobile</td>
   
      </tr>
  
  <% for(RegisterModel rm1:rm){%>
	 
	  <tr>
	  <td><%=rm1.getName() %></td>
	   <td><%=rm1.getEmailid() %></td>
	    <td><%=rm1.getMobile() %></td>
	  
	  </tr>
	  
	  
 <% }%>
  
  
  
      </table>
          
          
        
         </div>
         <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
           <img src="assets/img/hero-img.png" class="img-fluid animated" alt="">
         </div>
       </div>
    	
    	
    	<%  }%> 
        	
      <% }%>
      
      
        <!-- Triggered manager -->
         <%if(request.getParameter("userpage")!=null){
    	 if(request.getParameter("userpage").equalsIgnoreCase("trigger") || request.getParameter("userpage").equalsIgnoreCase("scan")){
    	 
    		  UploadKycService uks=new UploadKycService();
    		     List<FileModel> files=uks.getFiles();%>
    		 
    		 <div class="row">
         <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
        
        <p style="color: #FFF" class="myFont">Your Files</p>
				<table class="table" style="color: #FFF;">
					<tr>
					    <td>FileId</td>
					    <td>Domain</td>
						<td>FileName</td>
						<td>HashKey</td>
					</tr>
					<%   for(FileModel fm:files){
      %>

					<tr>
					    <td><%=fm.getFileId() %></td>
					    <td><%=fm.getDomain() %></td>
						<td><%=fm.getFileName() %></td>
						<td><%=fm.getHashKey() %></td>
					</tr>



					<%}%>
					</table>
					<form action="ScanServlet" method="post">
					<input type="submit" value="Analyze Files" class="btn btn-primary"/>
					</form>
					
					<br/><br/>
					${info }
					
<c:forEach var="item" items="${files}">
  <p style="color:#FFF;">${item}</p>
 
</c:forEach>
					
					
         </div>
         <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
           <img src="assets/img/hero-img.png" class="img-fluid animated" alt="">
         </div>
       </div>
    	
    	
    	<%  }%> 
        	
      <% }%>
      
      
          <!-- Triggered manager -->
         <%if(request.getParameter("userpage")!=null){
    	 if(request.getParameter("userpage").equalsIgnoreCase("eth")){%>
    		 
    		 <div class="row">
         <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
        <%
        UploadKycService ukc=AppConfig.getuploadKycService();
        int s[]= ukc.getStatus();
        %>
     ${alert }
     ${info }
     <form action="Eth" method="post">      
      <div>
      <span  style="color:#FFF;">SQL injection &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <label style="color:#FFF;" class="switch">

  <input type="checkbox" name="checkbox">
  <span class="slider round"></span>
 
</label>
</div>
<%
if(s[0]==1){%>
	
	<p style="color:#FFF;">your previous status is <span>ON</span></p><br/><br/>
<%}else{%>
	<p style="color:#FFF;">your previous status is <span>OFF</span></p><br/><br/>
	
<%}

%>

 <span  style="color:#FFF;">DDOS Attack &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
        <label style="color:#FFF;" class="switch"> &nbsp;&nbsp;
  <input type="checkbox" name="checkbox1" >
  <span class="slider round"></span>
</label> 

<%
if(s[1]==1){%>
	
	<p style="color:#FFF;">your previous status is <span>ON</span></p><br/><br/>
<%}else{%>
	<p style="color:#FFF;">your previous status is <span>OFF</span></p><br/><br/>
	
<%}

%>

<br/><br/>

<input type="submit" value="submit"  class="btn btn-primary">
  </form>
         </div>
        
         <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
           <img src="assets/img/hero-img.png" class="img-fluid animated" alt="">
         </div>
       </div>
    
    	
    	<%  }%> 
        	
      <% }%>
    
  
    
    </div>

  </section><!-- End Hero -->

  <main id="main">

</main>

  
   



<jsp:include page="common/footer.jsp"></jsp:include>