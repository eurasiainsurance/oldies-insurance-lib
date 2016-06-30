package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.SubjectType;
import com.lapsa.insurance.services.elements.SubjectTypeService;

@Named("subjectTypeService")
@ApplicationScoped
public class DefaultSubjectTypeService extends GenericEnumService<SubjectType> implements SubjectTypeService {

    public List<SubjectType> getAllItems() {
	return Arrays.asList(SubjectType.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return SubjectType.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return SubjectType.BUNDLE_VAR;
    }
}
