package kz.theeurasia.esbd.services;

import java.util.List;

import kz.theeurasia.esbd.domain.DocumentTypeInfo;

public interface DocumentTypeServiceDAO extends EntityServiceDAO<DocumentTypeInfo, Long> {
    List<DocumentTypeInfo> getAll();
}
