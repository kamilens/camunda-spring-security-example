package com.reunico.enterprise.config;

import org.camunda.bpm.engine.impl.plugin.AdministratorAuthorizationPlugin;
import org.camunda.bpm.identity.impl.ldap.plugin.LdapIdentityProviderPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaLdapConfig {
    @Value("${camunda.bpm.adminGroup}")
    private String camundaAdminGroup;
    @Value("${spring.ldap.base}")
    private String base;
    @Value("${spring.ldap.userIdAttribute}")
    private String userIdAttribute;
    @Value("${spring.ldap.urls}")
    private String url;
    @Value("${spring.ldap.userSearchBase}")
    private String userSearchBase;
    @Value("${spring.ldap.groupSearchBase}")
    private String groupSearchBase;
    @Value("${spring.ldap.username}")
    private String managerDn;
    @Value("${spring.ldap.password}")
    private String managerPassword;
    @Value("${spring.ldap.groupMemberAttribute}")
    private String groupMemberAttribute;
    @Value("${spring.ldap.userMailAttribute}")
    private String userMailAttribute;
    @Value("${spring.ldap.userFirstNameAttribute}")
    private String userFirstNameAttribute;
    @Value("${spring.ldap.userLastnameAttribute}")
    private String userLastnameAttribute;
    @Value("${spring.ldap.userSearchFilter}")
    private String userSearchFilter;
    @Value("${spring.ldap.groupSearchFilter}")
    private String groupSearchFilter;
    @Value("${spring.ldap.groupIdAttribute}")
    private String groupIdAttribute;
    @Value("${spring.ldap.groupNameAttribute}")
    private String groupNameAttribute;

    @Bean
    public AdministratorAuthorizationPlugin administratorAuthorizationPlugin() {
        AdministratorAuthorizationPlugin administratorAuthorizationPlugin = new AdministratorAuthorizationPlugin();
        administratorAuthorizationPlugin.setAdministratorGroupName(camundaAdminGroup);

        return administratorAuthorizationPlugin;
    }

    @Bean
    public LdapIdentityProviderPlugin ldapIdentityProviderPlugin() {
        LdapIdentityProviderPlugin ldapIdentityProviderPlugin = new LdapIdentityProviderPlugin();
        ldapIdentityProviderPlugin.setBaseDn(base);
        ldapIdentityProviderPlugin.setServerUrl(url);
        ldapIdentityProviderPlugin.setUserIdAttribute(userIdAttribute);
        ldapIdentityProviderPlugin.setGroupSearchBase(groupSearchBase);
        ldapIdentityProviderPlugin.setUserSearchBase(userSearchBase);
        ldapIdentityProviderPlugin.setManagerDn(managerDn);
        ldapIdentityProviderPlugin.setManagerPassword(managerPassword);
        ldapIdentityProviderPlugin.setGroupMemberAttribute(groupMemberAttribute);
        ldapIdentityProviderPlugin.setUserFirstnameAttribute(userFirstNameAttribute);
        ldapIdentityProviderPlugin.setUserLastnameAttribute(userLastnameAttribute);
        ldapIdentityProviderPlugin.setUserEmailAttribute(userMailAttribute);
        ldapIdentityProviderPlugin.setUserSearchFilter(userSearchFilter);
        ldapIdentityProviderPlugin.setGroupSearchFilter(groupSearchFilter);
        ldapIdentityProviderPlugin.setGroupIdAttribute(groupIdAttribute);
        ldapIdentityProviderPlugin.setGroupNameAttribute(groupNameAttribute);
        return ldapIdentityProviderPlugin;
    }
}
