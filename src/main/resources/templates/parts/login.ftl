<#macro login path>
    <section id="authForms">
        <div class="authForms_wrapper">
            <div class="authForms_wrapper_left">
                <div class="authForms_form">
                    <div class="authForms_text">
                        <h2>Авторизация</h2>
                        <p>Авторизуйтесь при помощи логина и<br>пароля от вашего аккаунта</p>
                    </div>
                    <form action="${path}" method="post">
                        <div><label><span>Логин: </span><br><input class="authForms_input" type="text" name="username"/> </label></div>
                        <div><label><span>Пароль: </span><br><input class="authForms_input" type="password" name="password"/> </label></div>
                        <input class="authForms_input" type="hidden" name="_csrf" value="${_csrf.token}" />
                        <div>
                            <button class="signin_btn">Войти</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="authForms_wrapper_right">
                <div class="authForms_regtext">
                    <p>Вы здесь впервые? Для использования<br>этого сайта необходимо зарегистрироваться.</p>
                </div>
                <div>
                    <a href="/registration"><input type="submit" value="Регистрация" class="signup_btn"></a>
                </div>
            </div>
        </div>
    </section>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Выход"/>
    </form>
</#macro>