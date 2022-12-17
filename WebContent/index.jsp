<%@page import="com.model.RegisterModel"%>
<jsp:include page="common/UserHeader.jsp"></jsp:include>

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center">

    <div class="container">
      <div class="row">
        <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
          <%
        RegisterModel rm= (RegisterModel)session.getAttribute("account");
        %>
        <h3 style="color: #FF5733">${sql}</h3>
        <h3 style="color: #000">welcome : <%=rm.getName() %></h3>
          <center><h1>Systematic Review Of Security Vulnerabilities In Ethereum Blockchain Smart Contract</h1></center>
         
       
        </div>
        <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
          <img src="assets/img/hero-img.png" class="img-fluid animated" alt="">
        </div>
      </div>
    </div>

  </section><!-- End Hero -->

  <main id="main">

</main>

  
   

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<jsp:include page="common/footer.jsp"></jsp:include>