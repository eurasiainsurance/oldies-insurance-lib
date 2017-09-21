package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.TransactionProblem;

public interface TransactionProblemService extends NamingListingService<TransactionProblem> {

    @Override
    default TransactionProblem[] getAll() {
	return TransactionProblem.values();
    }

    @Override
    default TransactionProblem[] getSelectable() {
	return TransactionProblem.values();
    }

    @Override
    default TransactionProblem[] getNonSelectable() {
	return new TransactionProblem[0];
    }
}
