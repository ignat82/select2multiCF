package ru.homecredit.select2cf.customfields;

import com.atlassian.jira.issue.customfields.impl.SelectCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.manager.OptionsManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.rest.json.beans.JiraBaseUrls;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Named
public class Select2singleCF extends SelectCFType {
    @Inject
    public Select2singleCF(@ComponentImport OptionsManager optionsManager
                            , @ComponentImport CustomFieldValuePersister customFieldValuePersister
                            , @ComponentImport GenericConfigManager genericConfigManager
                            , @ComponentImport JiraBaseUrls jiraBaseUrls) {

        super(customFieldValuePersister,
                optionsManager,
                genericConfigManager,
                jiraBaseUrls);
        log.info("SingleSelect2 instance construction");
    }
}
