package ru.homecredit.select2cf.customfields;

import com.atlassian.jira.issue.customfields.impl.VersionCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.rest.json.beans.JiraBaseUrls;
import com.atlassian.jira.issue.fields.util.VersionHelperBean;
import com.atlassian.jira.project.version.VersionManager;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import lombok.extern.slf4j.Slf4j;
import com.atlassian.jira.security.PermissionManager;

import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Named
public class Select2versionSingleCF extends VersionCFType {
    @Inject
    public Select2versionSingleCF(@ComponentImport PermissionManager permissionManager,
                                  @ComponentImport JiraAuthenticationContext jiraAuthenticationContext,
                                  @ComponentImport VersionManager versionManager,
                                  @ComponentImport CustomFieldValuePersister customFieldValuePersister,
                                  @ComponentImport GenericConfigManager genericConfigManager,
                                  //@ComponentImport VersionHelperBean versionHelperBean,
                                  @ComponentImport JiraBaseUrls jiraBaseUrls) {
        super(permissionManager,
              jiraAuthenticationContext,
              versionManager,
              customFieldValuePersister,
              genericConfigManager,
              //versionHelperBean,
              new VersionHelperBean(versionManager, permissionManager),
              jiraBaseUrls);
        log.info("Select2versionSingleCF instance construction");
    }
}
