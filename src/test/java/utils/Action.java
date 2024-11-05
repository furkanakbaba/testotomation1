package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static utils.Driver.driver;


public class Action {

    public void tab(){

        final PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point tapPoint = new Point(672, 1245);
        Sequence tap = new Sequence(finger2, 1);
        tap.addAction(finger2.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.getX(), tapPoint.getY()));
        tap.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger2, Duration.ofMillis(50)));
        tap.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));
    }
}
