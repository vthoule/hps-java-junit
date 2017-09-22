package com.coffeemachine.display_errors;

import junit.framework.TestCase;
import com.coffeemachine.Actionwords;

public class WaterTest extends TestCase {

    public Actionwords actionwords = new Actionwords();
    protected void setUp() throws Exception {
        super.setUp();

        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // And I handle everything except the water tank
        actionwords.iHandleEverythingExceptTheWaterTank();
    }

    // 
    // Tags: priority:high
    public void testMessageFillWaterTankIsDisplayedAfter50CoffeesAreTaken() {
        // Then message "Fill tank" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Fill tank");
    }
    // 
    // Tags: priority:low
    public void testItIsPossibleToTake10CoffeesAfterTheMessageFillWaterTankIsDisplayed() {
        // Then coffee should be served
        actionwords.coffeeShouldBeServed();
        // When I take a coffee
        actionwords.iTakeACoffee();
        // Then coffee should not be served
        actionwords.coffeeShouldNotBeServed();
    }
    // 
    // Tags: priority:high
    public void testWhenTheWaterTankIsFilledTheMessageDisappears() {
        // And I fill the water tank
        actionwords.iFillTheWaterTank();
        // Then message "Ready" should be displayed
        actionwords.messageMessageShouldBeDisplayed("Ready");
    }
}