<#macro registration pathh>
    <form action="${pathh}" method="post">
        <div><label> User Name: <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign Up"/></div>
    </form>
</#macro>