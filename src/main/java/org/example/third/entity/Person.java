package org.example.third.entity;


import org.example.third.entity.enums.ApproachState;
import org.example.third.entity.enums.BodyState;
import org.example.third.entity.enums.FingerState;
import org.example.third.exceptions.BodyStateException;
import org.example.third.exceptions.FingerStateException;
import org.example.third.interfaces.IApproachable;
import org.example.third.interfaces.IFingerManipulatable;

import java.util.Objects;


public class Person implements IApproachable, IFingerManipulatable {
    private String name;
    private BodyState bodyState;
    private FingerState fingerState;
    private ApproachState approachState;

    public Person(String name, BodyState bodyState, FingerState fingerState, ApproachState approachState) {
        this.name = name;
        this.bodyState = bodyState;
        this.fingerState = fingerState;
        this.approachState = approachState;
    }

    @Override
    public String approach(ApproachState approach) {
        return(String.format("%s приближается к объекту %s", name,approach.toString()));
    }

    @Override
    public String manipulateFingers(FingerState state) {
        return(String.format("%s сжимал его %s пальцами", name, state.toString()));
    }

    public String updateBodyState(BodyState bodyState) {
        if (Objects.isNull(bodyState)) {
            throw new BodyStateException("Недопустимый статус BodyState");
        }
        String val = String.format("%s сейчас %s", name, this.bodyState.toString());
        this.bodyState = bodyState;
        return val;
    }

    public String updateFingerState(FingerState fingerState) {
        if (Objects.isNull(fingerState)) {
            throw new FingerStateException("Недопустимый статус FingerState");
        }
        String val = String.format("%s сейчас %s", name, this.fingerState.toString());
        this.fingerState = fingerState;
        return val;
    }
}
