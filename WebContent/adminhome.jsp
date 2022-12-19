<%@page import="com.model.RegisterModel"%>
<jsp:include page="common/AdminHeader.jsp"></jsp:include>

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
        
      <table>
     
      <tr>
      <td>Name</td>
      <td>Email</td>
      <td>Mobile</td>
      </tr>
  
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
    	 if(request.getParameter("userpage").equalsIgnoreCase("trigger")){%>
    		 
    		 <div class="row">
         <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
        
         <h3 style="color: #FF5733"></h3>
         <h3 style="color: #000">Trigger Manager</h3>
           <center><h1>Triggered Manager</h1></center>
          
        
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