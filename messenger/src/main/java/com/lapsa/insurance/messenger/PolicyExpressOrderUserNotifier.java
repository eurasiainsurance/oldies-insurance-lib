package com.lapsa.insurance.messenger;

import com.lapsa.insurance.domain.PolicyExpressOrder;
import com.lapsa.localization.LocalizationLanguage;

public interface PolicyExpressOrderUserNotifier {
    void notifyUser(PolicyExpressOrder policyExpressOrder, LocalizationLanguage language);

    void enqueueNotifyUser(PolicyExpressOrder policyExpressOrder, LocalizationLanguage language);
}
