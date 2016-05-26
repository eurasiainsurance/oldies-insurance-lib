package com.lapsa.insurance.mesenger;

import java.util.List;

import com.lapsa.insurance.domain.PolicyExpressOrder;

public interface PolicyExpressOrderUserNotifier {
    void notifyUser(PolicyExpressOrder policyExpressOrder);
    void notifyUser(List<PolicyExpressOrder> policyExpressOrder);
}
