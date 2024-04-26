package org.example.first.math;

import org.example.third.entity.MainHero;
import org.example.third.entity.enums.ApproachState;
import org.example.third.entity.enums.BodyState;
import org.example.third.entity.enums.FingerState;
import org.example.third.exceptions.BodyStateException;
import org.example.third.exceptions.FingerStateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class ThirdTest {
    private MainHero mainHero;

    @BeforeEach
    public void setUp() {
        mainHero = new MainHero("Harry Potter", BodyState.SEND, FingerState.OPEN, ApproachState.CAREFULLY);
    }

    @Test
    public void testApproach() {
        Assertions.assertEquals("Harry Potter приближается к объекту CAREFULLY", mainHero.approach(ApproachState.CAREFULLY));
    }

    @Test
    public void testApproach2() {
        Assertions.assertEquals("Harry Potter приближается к объекту SLOWLY", mainHero.approach(ApproachState.SLOWLY));
    }

    @Test
    public void testManipulateFingers() {
        Assertions.assertEquals("Harry Potter сжимал его COMPRESS пальцами", mainHero.manipulateFingers(FingerState.COMPRESS));
    }

    @Test
    public void testNullBodyState(){
        Assertions.assertThrows(BodyStateException.class,() -> mainHero.updateBodyState(null));
    }

    @Test
    public void testBodyState(){
        Assertions.assertEquals("Harry Potter сейчас SEND", mainHero.updateBodyState(BodyState.REMOVE_LEG));
        mainHero.updateBodyState(BodyState.REMOVE_LEG);
        Assertions.assertEquals("Harry Potter сейчас REMOVE_LEG", mainHero.updateBodyState(BodyState.REMOVE_LEG));
    }

    @Test
    public void testUpdateFingerState(){
        Assertions.assertEquals("Harry Potter сейчас OPEN", mainHero.updateFingerState(FingerState.COMPRESS));
        mainHero.updateFingerState(FingerState.COMPRESS);
        Assertions.assertEquals("Harry Potter сейчас COMPRESS", mainHero.updateFingerState(FingerState.COMPRESS));
    }

    @Test
    public void testUpdateNullFingerState() {
        Assertions.assertThrowsExactly(FingerStateException.class,() -> mainHero.updateFingerState(null));
    }
}
