<#include "security.ftl">
<#import "login.ftl" as login>

<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Something page</title>
        <link rel="stylesheet" href="/static/login.css">
    </head>
    <body>
    <header class="text-center">
        <h1>База данных о кинематографе</h1>
        <#if user??>
            <div>
                <@login.logout />
            </div>
        </#if>
    </header>
    <#include "navbar.ftl">
    <div class="container">
        <#nested>
    </div>
    </body>
    </html>
</#macro>