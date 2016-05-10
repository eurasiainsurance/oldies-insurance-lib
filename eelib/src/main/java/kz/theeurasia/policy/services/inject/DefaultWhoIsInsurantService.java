package kz.theeurasia.policy.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.WhoIsInsurant;

import kz.theeurasia.policy.services.WhoIsInsurantService;

@Named("whoIsInsurantService")
@ApplicationScoped
public class DefaultWhoIsInsurantService extends EnumService<WhoIsInsurant> implements WhoIsInsurantService {

    public List<WhoIsInsurant> getAllItems() {
	return CollectionUtils.toList(WhoIsInsurant.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return WhoIsInsurant.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return WhoIsInsurant.BUNDLE_VAR;
    }
}
