package kz.theeurasia.policy.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.kz.country.KZArea;

import kz.theeurasia.policy.services.KZAreaService;

@Named("kzAreaService")
@ApplicationScoped
public class DefaultKZAreaService extends EnumService<KZArea> implements KZAreaService {

    public List<KZArea> getAllItems() {
	return CollectionUtils.toList(KZArea.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return KZArea.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return KZArea.BUNDLE_VAR;
    }
}
