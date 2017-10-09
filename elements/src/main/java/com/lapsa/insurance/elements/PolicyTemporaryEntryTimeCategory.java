package com.lapsa.insurance.elements;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.commons.elements.LocalizedElement;

public enum PolicyTemporaryEntryTimeCategory implements LocalizedElement {
    TO_15D_INCL, // до 15 дней включительно
    FROM_16D_TO_1M_INCL, // от 16 дней до 1 месяца
    FROM_1M_TO_2M_INCL, // 2 месяца
    FROM_2M_TO_3M_INCL, // 3 месяца
    FROM_3M_TO_4M_INCL, // 4 месяца
    FROM_4M_TO_5M_INCL, // от 4 до 5 месяцев включительно
    FROM_5M_TO_6M_INCL, // от 5 до 6 месяцев включительно
    FROM_6M_TO_7M_INCL, // от 6 до 7 месяцев включительно
    FROM_7M_TO_8M_INCL, // от 7 до 8 месяцев включительно
    FROM_8M_TO_9M_INCL, // от 8 до 9 месяцев включительно
    FROM_9M, // свыше 11 месяцев
    ;

    //

    private final boolean selectable;

    //

    private PolicyTemporaryEntryTimeCategory() {
	this.selectable = true;
    }

    private PolicyTemporaryEntryTimeCategory(boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<PolicyTemporaryEntryTimeCategory> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<PolicyTemporaryEntryTimeCategory> SELECTABLE_FILTER = PolicyTemporaryEntryTimeCategory::isSelectable;

    public static final PolicyTemporaryEntryTimeCategory[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(PolicyTemporaryEntryTimeCategory[]::new);
    }

    private static final Predicate<PolicyTemporaryEntryTimeCategory> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PolicyTemporaryEntryTimeCategory[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(PolicyTemporaryEntryTimeCategory[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }
}
