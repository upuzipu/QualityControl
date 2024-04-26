package org.example.third.entity;

import org.example.third.entity.enums.ApproachState;
import org.example.third.entity.enums.BodyState;
import org.example.third.entity.enums.FingerState;

public class MainHero extends Person {
    public MainHero(String name, BodyState bodyState, FingerState fingerState, ApproachState approachState){
        super(name, bodyState, fingerState, approachState);
    }
}
