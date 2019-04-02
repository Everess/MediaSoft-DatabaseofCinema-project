<#macro registration pathh>
    <section id="authForms">
        <div class="authForms_wrapper">
            <div class="authForms_wrapper_reg">
                <div class="authForms_form_reg">
                    <div class="authForms_text_reg">
                        <form action="${pathh}" method="post">
                            <div><label>Логин: <input type="text" name="username"/> </label></div>
                            <div><label>Пароль: <input type="password" name="password"/> </label></div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <div class="signup">
                                <button class="signup_btn_reg">Регистрация</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</#macro>