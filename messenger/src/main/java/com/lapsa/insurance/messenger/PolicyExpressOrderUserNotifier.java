package com.lapsa.insurance.messenger;

import com.lapsa.insurance.domain.PolicyExpressOrder;

public interface PolicyExpressOrderUserNotifier {
    void notifyUser(PolicyExpressOrder policyExpressOrder);
}
