<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.DAO"%>
<jsp:include page="common/UserHeader.jsp"></jsp:include>
 <link href="assets/css/style.css" rel="stylesheet">
  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center">

    <div class="container">
      <div class="row">
        <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
      <% if(request.getParameter("userpage").equalsIgnoreCase("profile"))
      {%>
    	  <table class="table" style="color:#fff;">
 <tbody>
          <%
          String userId=request.getParameter("userid");
          
          DAO dao=new DAO();
        ResultSet rs=  dao.getUserDetails(Integer.parseInt(userId));
        if(rs.next()){%>
      <tr><td>User Id</td><td><%=rs.getInt(1) %></td></tr>
     <tr><td>Name</td><td><%=rs.getString(2) %></td></tr>
     <tr><td>Email</td><td><%=rs.getString(3) %></td></tr>
     <tr><td>Mobile</td><td><%=rs.getString(5) %></td></tr>
       <%  }%>
 
 
 </tbody>

</table>
    	  
    	<%}  
    	  %>  
    	  
    	   <% if(request.getParameter("userpage").equalsIgnoreCase("upload"))
      {%>
    	 <p style="color:#FFF" class="myFont">Welcome To The Upload Page</p>
    	 <form action="upload" method="post" enctype="multipart/form-data">
    	 <input type="file" name="file" class="form-control"></input>
    	 <br/>
    	 <select name="domain" class="form-select" aria-label="Default select example">
					<option>Cloud Computing</option>
					<option>Data Mining</option>
					<option>Network</option>
					<option>BlockChain</option>
				</select><br/>
		<input type="submit" value="submit" class="btn btn-success">
		</form>
    	<%}  
    	  %>  
         
         
        </div>
        <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
          <img src="assets/img/hero-img.png" class="img-fluid animated" alt="">
        </div>
      </div>
              
    </div>

  </section><!-- End Hero -->
  <div class="container">




</div>
  
   

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<jsp:include page="common/footer.jsp"></jsp:include>