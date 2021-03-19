Camunda Empty Application

- Spring Boot
- Spring Security
- Spring Web MVC
- Spring LDAP
- Camunda WebApp (Admin, TaskList, Cockpit)
- Camunda REST API
- SSO Filters (REST, WebApp)
- LDAP Identity Plugin
- Admin Auth Plugin (Group)

Known issues and workarounds:

- CsrfAutoConfiguration - preventing bug in Camunda 7.13 (access to REST. WebApp)
- WebSecurityConfig - .csrf().ignoringAntMatchers("/camunda/**"); - prevent CSRF errors in Camunda WebApps