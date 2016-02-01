package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.BranchEntity;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface BranchServiceDAO extends AbstractServiceDAO<BranchEntity, Long> {
    List<BranchEntity> getAll();
}
