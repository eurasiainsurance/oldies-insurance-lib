package com.lapsa.insurance.elements;

public enum SteeringWheelLocation implements ElementsBundleBase {
    RIGHT_SIDE, // руль справа
    LEFT_SIDE, // руль слева
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
