 <link rel='stylesheet' type='text/css' href='/customerRegistration/css/headerFooter.css'>
<jsp:include page='/Header.jsp'/>
 <link rel='stylesheet' type='text/css' href='/customerRegistration/css/registrationForm.css'>
 <script src='/customerRegistration/js/LoginForm.js'></script>
<jsp:useBean id='userBean' scope='request' class='bean.UserBean' />
<jsp:useBean id='errorBean' scope='request' class='bean.ErrorBean' />
 <div class="container">
                <div class="header">
                    Edit User
                 </div>
                  <br>
                 <div class = 'error'>
                 <jsp:getProperty name='errorBean' property='error' />
                 </div>

         <form method='post' class="form-login"  onsubmit="return validateForm(this)" action='/customerRegistration/UpdateUser.jsp'>
             <input type='hidden' id='partyId' name='partyId' value='<jsp:getProperty name="userBean" property="partyId" />'>
              <div class="form-input">
                  <label>First name</label>
                  <input type="text" id ="firstName" name="firstName" class="name-input" value="<jsp:getProperty name="userBean" property="firstName" />" required>
                  <small>Error</small>
              </div>

               <div class="form-input">
                            <label>Last name</label>
                            <input type="text" id ="lastName" name="lastName" class="name-input" value="<jsp:getProperty name="userBean" property="lastName" />" required>
                            <small>Error</small>
              </div>

             <div class="form-input">
                             <label>Address</label>
                             <input type="text" id ="address" name="address"class="name-input" value="<jsp:getProperty name="userBean" property="address" />">
                             <small>Error</small>
             </div>

             <div class="form-input">
                           <label>City</label>
                           <input type="text" id ="city" name="city" class="name-input" value="<jsp:getProperty name="userBean" property="city" />">
                           <small>Error</small>
             </div>


            <div class="form-input">
                <label>State</label>
                <input type="text" id="state" name="state" class="email-input" value="<jsp:getProperty name="userBean" property="state" />">
                <small>Error</small>
            </div>


            <div class="form-input">
                <label>Country</label>
                <input type="text" id="country" name="country" class="email-input" value="<jsp:getProperty name="userBean" property="country" />">
                <small>Error</small>
            </div>

            <div class="form-input">
                            <label>Zip</label>
                            <input type="number" id="zip" name="zip" class="email-input" value="<jsp:getProperty name="userBean" property="zip" />">
                            <small>Error</small>
            </div>

            <div class="form-input">
                <label>Phone</label>
                <input type="number" id="phone" name="phone" class="email-input" value="<jsp:getProperty name="userBean" property="phone" />" required>
                <small>Error</small>
            </div>


            <div class="form-input">
                <button type="submit" >Update</button>
            </div>
        </form>

     </div>

     <jsp:include page='/Footer.jsp'/>

