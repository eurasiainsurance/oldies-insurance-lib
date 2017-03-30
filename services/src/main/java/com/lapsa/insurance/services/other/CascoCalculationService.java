package com.lapsa.insurance.services.other;

import java.time.LocalDate;
import java.util.Calendar;

import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.domain.casco.Casco;

public interface CascoCalculationService {
    CalculationData calculateCasco(Casco casco) throws CalculationFailed;

    CalculationData calculateCasco(Casco casco, Calendar startDate, Calendar endDate) throws CalculationFailed;

    CalculationData calculateCasco(Casco casco, Calendar startDate, int days) throws CalculationFailed;

    CalculationData calculateCasco(Casco casco, LocalDate startDate, LocalDate endDate) throws CalculationFailed;

    CalculationData calculateCasco(Casco casco, LocalDate startDate, int days) throws CalculationFailed;

    void calculateCascoCost(Casco casco) throws CalculationFailed;

    void calculateCascoCost(Casco casco, Calendar startDate, Calendar endDate) throws CalculationFailed;

    void calculateCascoCost(Casco casco, Calendar startDate, int days) throws CalculationFailed;

    void calculateCascoCost(Casco casco, LocalDate startDate, LocalDate endDate) throws CalculationFailed;

    void calculateCascoCost(Casco casco, LocalDate startDate, int days) throws CalculationFailed;
}
