package ru.homecredit.select2cf.customfields;

import com.atlassian.jira.bc.issue.search.SearchService;
import com.atlassian.jira.config.FeatureManager;
import com.atlassian.jira.issue.customfields.impl.MultiSelectCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.manager.OptionsManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.rest.json.beans.JiraBaseUrls;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;

/*
jira.core dependency in Atlassian SDK generated pom.xml should be uncommented for this plugin to work
*/
@Named
@Slf4j
public class Select2multiCF extends MultiSelectCFType {
    @Inject
    public Select2multiCF(@ComponentImport OptionsManager optionsManager
            , @ComponentImport CustomFieldValuePersister customFieldValuePersister
            , @ComponentImport GenericConfigManager genericConfigManager
            , @ComponentImport JiraBaseUrls jiraBaseUrls
            , @ComponentImport SearchService searchService
            , @ComponentImport FeatureManager featureManager
            , @ComponentImport JiraAuthenticationContext jiraAuthenticationContext) {

        super(optionsManager
                , customFieldValuePersister
                , genericConfigManager
                , jiraBaseUrls
                , searchService
                , featureManager
                , jiraAuthenticationContext);
        log.info("MultiSelect2 instance construction");
    }

}
