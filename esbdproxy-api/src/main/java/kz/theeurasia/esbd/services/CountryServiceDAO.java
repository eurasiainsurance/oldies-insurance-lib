package kz.theeurasia.esbd.services;

import java.util.List;

import kz.theeurasia.esbd.domain.CountryInfo;

public interface CountryServiceDAO extends EntityServiceDAO<CountryInfo, Long> {
    List<CountryInfo> getAll();
}
