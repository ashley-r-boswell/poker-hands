package com.pokerhands.ui;

import javafx.scene.control.Button;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class PokerHandsApplicationTest extends ApplicationTest {

    @Before
    public void setup() throws Exception {
        ApplicationTest.launch(PokerHandsApplication.class);
    }

    @Test
    public void clickCompareButton() {
        Button button = lookup("#compareButton").queryButton();

        WaitForAsyncUtils.waitForAsyncFx(1000, button::fire);

        verifyThat("#resultLabel", hasText("Player 1 wins!"));
    }
}