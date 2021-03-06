package ru.homecredit.jiraplugin.jira.customfields;

import com.atlassian.jira.bc.issue.search.SearchService;
import com.atlassian.jira.config.FeatureManager;
import com.atlassian.jira.issue.customfields.impl.MultiSelectCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.manager.OptionsManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.rest.json.beans.JiraBaseUrls;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;

/*
jira.core dependency in Atlassian SDK generated pom.xml should be uncommented for this plugin to work
*/
@Named // using @Named instead of @Scanned by Matveev's suggestion
public class Select2multiCF extends MultiSelectCFType {
    /*
    use of atlassian logger described it this tutorial
    https://developer.atlassian.com/server/jira/platform/writing-jira-event-listeners-with-the-atlassian-event-library/
    */
    // private static final Logger log = LoggerFactory.getLogger(MultiSelect2.class);
    private static final Logger logger = LoggerFactory.
            getLogger(MultiSelectCFType.class.getName());

    /*
    atlassian tutorial step 4.4 suggests to use @JiraImport annotation for
    constructor arguments to import them from host application with atlassian
    spring scanner
    https://developer.atlassian.com/server/jira/platform/creating-a-custom-field-in-jira/
    */
    @Autowired // appears to be unnecessary
    @Inject
    public Select2multiCF(@ComponentImport OptionsManager optionsManager
            , @ComponentImport CustomFieldValuePersister customFieldValuePersister
            , @ComponentImport GenericConfigManager genericConfigManager
            , @ComponentImport JiraBaseUrls jiraBaseUrls
            , @ComponentImport SearchService searchService
            , @ComponentImport FeatureManager featureManager
            , @ComponentImport JiraAuthenticationContext jiraAuthenticationContext) {
        /*
        Options manager is acquired trough ComponentAccessor and the rest of
        managers trough @ComponentImport annotation of Atlassian Spring Scanner
        I do not know what this matters for yet
         */
        super(optionsManager // this interface is used to manipulate options. not sure if I need it here
                , customFieldValuePersister // This interface is used to save an issue's custom field value to the database
                , genericConfigManager
                , jiraBaseUrls
                , searchService
                , featureManager
                , jiraAuthenticationContext); // This interface is used to store Generic configuration values for issue's custom field
        logger.info("MultiSelect2 instance construction");
    }

    /* when not overriding getVelocityParameters field uses default
    implementation from MultiSelectCFType superclass
    */

    /*
    @Override
    public Map<String, Object> getVelocityParameters(final Issue issue,
                                                     final CustomField field,
                                                     final FieldLayoutItem fieldLayoutItem) {
        final Map<String, Object> map = super.getVelocityParameters(issue,
        field, fieldLayoutItem);

        // This method is also called to get the default value, in
        // which case issue is null so we can't use it to add currencyLocale
        if (issue == null) {
            return map;
        }

        FieldConfig fieldConfig = field.getRelevantConfig(issue);
        //add what you need to the map here

        return map;
    }
    */
}
