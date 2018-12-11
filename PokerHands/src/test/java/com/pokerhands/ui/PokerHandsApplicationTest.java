package com.pokerhands.ui;

import javafx.scene.Node;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Set;

public class PokerHandsApplicationTest extends ApplicationTest {

    private final PokerHandsApplication pokerHandsApplication = new PokerHandsApplication();

    @Override
    public void start(Stage stage) throws Exception {
        pokerHandsApplication.start(stage);
    }

    @Test
    public void runApplication() {
        Set<Node> allNodes = this.fromAll().queryAll();
        
        Assert.assertEquals(1, allNodes.size());
    }
}