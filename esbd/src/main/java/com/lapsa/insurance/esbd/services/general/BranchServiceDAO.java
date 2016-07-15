package com.lapsa.insurance.esbd.services.general;

import java.util.List;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;

import kz.theeurasia.esbdproxy.domain.entities.general.BranchEntity;

public interface BranchServiceDAO extends GeneralServiceDAO<BranchEntity, Long> {
    List<BranchEntity> getAll();
}
