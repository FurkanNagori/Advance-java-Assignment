 <link rel='stylesheet' type='text/css' href='/customerRegistration/css/styles.css'>
 <script src='/customerRegistration/js/LoginForm.js'></script>

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
                                <br><br><div class="invalid-feedback">Please fill out this field.</div>
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
                            <a href="">
                        </form>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="myRightCtn">
                                <div class="box"><header>Hello World!</header>

                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                                    sed do eiusmod tempor incididunt ut labore et dolore magna
                                    aliqua. Ut enim ad minim veniam.</p>
                                    <input type="button" class="butt_out" value="Learn More"/>
                                </div>

                        </div>
                    </div>
                </div>
            </div>
    </div>