<#import "parts/common.ftl" as common>
<#import "parts/registration.ftl" as registration>
<#import "parts/copyright.ftl" as copyright>
<@common.page>
    ${message?ifExists}
    <@registration.registration "/registration"></@registration.registration>
    <@copyright.copyright></@copyright.copyright>
</@common.page>
