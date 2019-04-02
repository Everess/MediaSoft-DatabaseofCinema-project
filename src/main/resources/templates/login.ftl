<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<#import "parts/copyright.ftl" as copyright>
<@common.page>
    <@login.login "/login" ></@login.login>
    <@copyright.copyright></@copyright.copyright>
</@common.page>