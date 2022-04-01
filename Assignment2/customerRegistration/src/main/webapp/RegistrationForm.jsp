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

 <link rel='stylesheet' type='text/css' href='/customerRegistration/css/registrationForm.css'>
<jsp:useBean id='errorBean' scope='request' class='bean.ErrorBean' />
 <div class="container">
                <div class="header">
                    Create Account
                 </div>
                  <br>
                 <div class = 'error'>
                 <jsp:getProperty name='errorBean' property='error' />
                 </div>

         <form class="form-login" action='/customerRegistration/Registration.jsp'>

              <div class="form-input">
                  <label>First name</label>
                  <input type="text" id ="firstName" name="firstName" class="name-input" placeholder="Enter your first name">
                  <small>Error</small>
              </div>

               <div class="form-input">
                            <label>Last name</label>
                            <input type="text" id ="lastName" name="lastName" class="name-input" placeholder="Enter your last name">
                            <small>Error</small>
              </div>

             <div class="form-input">
                             <label>Address</label>
                             <input type="text" id ="address" name="address"class="name-input" placeholder="Address">
                             <small>Error</small>
             </div>

             <div class="form-input">
                           <label>City</label>
                           <input type="text" id ="city" name="city" class="name-input" placeholder="city">
                           <small>Error</small>
             </div>


            <div class="form-input">
                <label>State</label>
                <input type="text" id="state" name="state" class="email-input" placeholder="state">
                <small>Error</small>
            </div>


            <div class="form-input">
                <label>Country</label>
                <input type="text" id="country" name="country" class="email-input" placeholder="country">
                <small>Error</small>
            </div>

            <div class="form-input">
                            <label>Zip</label>
                            <input type="number" id="zip" name="zip" class="email-input" placeholder="zip code">
                            <small>Error</small>
            </div>

            <div class="form-input">
                <label>Phone</label>
                <input type="number" id="phone" name="phone" class="email-input" placeholder="phone no.">
                <small>Error</small>
            </div>

            <div class="form-input">
                <label>Username</label>
                <input type="text" id="username" name="username" class="email-input" placeholder="username">
                <small>Error</small>
            </div>

            <div class="form-input">
                <label>Password</label>
                <input type="password" name="password" class="psd-input" placeholder="Enter your password">
                <small>Error</small>
            </div>

            <div class="form-input">
                <button type="submit" >Register</button>
            </div>
        </form>

     </div>

     <jsp:include page='/Footer.jsp'/>

