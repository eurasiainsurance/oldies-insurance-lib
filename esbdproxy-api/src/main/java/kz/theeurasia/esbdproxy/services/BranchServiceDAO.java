package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.BranchEntity;

public interface BranchServiceDAO extends AbstractServiceDAO<BranchEntity, Long> {
    List<BranchEntity> getAll();
}
