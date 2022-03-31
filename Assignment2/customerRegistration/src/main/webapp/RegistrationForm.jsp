 <jsp:include page='/Header.jsp'/>
 <link rel='stylesheet' type='text/css' href='/customerRegistration/css/registrationForm.css'>

 <div class="container">
        <div class="header">
            Create Account
        </div>
        <form class="form-login" method="POST"   action='/customerRegistration/Registration.jsp'>

            <div class="form-input">
                <label>First name</label>
                <input type="text" id ="firstName" class="name-input" placeholder="Enter your first name">
                <small>Error</small>
            </div>

             <div class="form-input">
                            <label>Last name</label>
                            <input type="text" id ="lastName" class="name-input" placeholder="Enter your last name">
                            <small>Error</small>
                        </div>

             <div class="form-input">
                             <label>Address</label>
                             <input type="text" id ="address" class="name-input" placeholder="Address">
                             <small>Error</small>
                         </div>

             <div class="form-input">
                           <label>City</label>
                           <input type="text" id ="city" class="name-input" placeholder="city">
                           <small>Error</small>
                         </div>


            <div class="form-input">
                <label>State</label>
                <input type="text" id="state" class="email-input" placeholder="state">
                <small>Error</small>
            </div>


            <div class="form-input">
                <label>Country</label>
                <input type="text" id="country" class="email-input" placeholder="country">
                <small>Error</small>
            </div>

            <div class="form-input">
                            <label>Zip</label>
                            <input type="number" id="zip" class="email-input" placeholder="zip code">
                            <small>Error</small>
                        </div>

            <div class="form-input">
                <label>Phone</label>
                <input type="number" id="phone" class="email-input" placeholder="phone no.">
                <small>Error</small>
            </div>

            <div class="form-input">
                <label>Username</label>
                <input type="text" id="username" class="email-input" placeholder="username">
                <small>Error</small>
            </div>

            <div class="form-input">
                <label>Password</label>
                <input type="password" class="psd-input" placeholder="Enter your password">
                <small>Error</small>
            </div>

            <div class="form-input">
                <button type="submit" class="submit-input">Register</button>
            </div>
        </form>
    </div>
     </div>
     <jsp:include page='/Footer.jsp'/>
