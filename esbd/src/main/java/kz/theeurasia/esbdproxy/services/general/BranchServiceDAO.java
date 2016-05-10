package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.BranchEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface BranchServiceDAO extends GeneralServiceDAO<BranchEntity, Long> {
    List<BranchEntity> getAll();
}
