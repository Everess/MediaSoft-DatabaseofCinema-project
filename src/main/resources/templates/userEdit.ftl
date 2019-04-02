<#import "parts/common.ftl" as common>
<#import "parts/copyright.ftl" as copyright>

<@common.page>
    <a href="/user">Admin panel</a>
    <form action="/user" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="hidden" name="userId" value="${user.id}">
        <input type="text" name="username" value="${user.username}">
        <input type="text" name="password" value="${user.password}">
        <#list roles as role>
            <div>
               <input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
            </div>
        </#list>
        <button type="Submit">Send</button>
    </form>
</@common.page>