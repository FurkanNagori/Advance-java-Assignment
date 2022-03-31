 <head>
 <link rel='stylesheet' type='text/css' href='/customerRegistration/css/styles.css'>
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