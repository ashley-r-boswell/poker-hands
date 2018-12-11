package com.pokerhands.ui;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class PokerHandsApplicationTest extends ApplicationTest {

    private final PokerHandsApplication pokerHandsApplication = new PokerHandsApplication();

    @Override
    public void start(Stage stage) throws Exception {
        pokerHandsApplication.start(stage);
    }

    @Test
    public void clickCompareButton() {
        Button button = lookup("Compare").queryButton();

        Assert.assertNotNull(button);
        clickOn(button, MouseButton.PRIMARY);
    }
}