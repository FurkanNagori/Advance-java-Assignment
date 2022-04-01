 <link rel='stylesheet' type='text/css' href='/customerRegistration/css/headerFooter.css'>
  <!--
    templateType: global_partial
    label: Website header
  -->
  <header class="bg-primary-gradiant">
    <div class="pt-10 pb-10 pl-0-lg pr-0-lg pl-10 pr-10 c-container m-auto ">
      <ul class="list-style-type-none flex justify-between align-items-center m-0">
        <li class="head-nav-item w-10-lg w-50">

        </li>
        <li class="head-nav-item-button hidden-lg show-md w-50 text-right" id="navToggle">
          <div class="glow-on-hover inline-block">
          <svg xmlns="http://www.w3.org/2000/svg" height="30" width="30" class="text-white" fill="#fff" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
            <path stroke-linecap="round" stroke-linejoin="round" d="M4 6h16M4 12h8m-8 6h16" />
          </svg>
          </div>
        </li>
        <li class="show hidden-md w-50-lg w-100">
          <ul id="navLinkBox" class="m-0 list-style-type-none flex-lg hidden justify-between align-items-center">
            <li class="head-nav-item">
              <a href="#" class="text-decoration-none text-white ">HotWax</a>
            </li>
            <li class="head-nav-item">
              <a href="/customerRegistration/LoginPage.jsp"class="head-nav-item-button pt-10 pb-10 pl-15 pr-15 rounded-full inline-flex justify-center align-items-center shadow text-bold glow-on-hover position-relative mt-0-lg mt-15">
                <span class="text-white">Log in</span>
                <svg xmlns="http://www.w3.org/2000/svg" height="18" width="18" class="text-white" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                  <path stroke-linecap="round" stroke-linejoin="round" d="M9 5l7 7-7 7" />
                </svg>
              </a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </header>
  <main>

 <head>
 <link rel='stylesheet' type='text/css' href='/customerRegistration/css/loginPage.css'>
 <script src='/customerRegistration/js/LoginForm.js'></script>
 <title>Customer Registration</title>
 </head>
 <div class="container">
            <div class="myCard">
                <div class="row">
                    <div class="col-md-6">
                        <div class="myLeftCtn">
                        <form  method='post' class="myForm text-center needs-validation" onsubmit="return validateForm(this)"  action='/customerRegistration/Login.jsp'>
                            <header>LOGIN</header>
                            <div class="form-group">
                                <i class="fas fa-user"></i>
                                <input class="myInput" type="text" placeholder="Username" id="username" required>
                                <br><br>
                                <div class="invalid-feedback">Please fill out this field.</div>
                            </div>
                            <br>
                            <div class="form-group">
                                <i class="fas fa-lock"></i>
                                <input class="myInput" type="password" id="password" placeholder="Password" required>
                            <br><br>    <div class="invalid-feedback">Please fill out this field.</div>
                            </div>
                            <br>
                            <input type="submit" class="butt" value="LOGIN">
                            <br><br>
                            <header>New user</header>
                            <a href="/customerRegistration/RegistrationForm.jsp" class="butt">create new account</a>
                        </form>
                        </div>
                    </div>
                </div>
            </div>
    </div>
     <jsp:include page='/Footer.jsp'/>