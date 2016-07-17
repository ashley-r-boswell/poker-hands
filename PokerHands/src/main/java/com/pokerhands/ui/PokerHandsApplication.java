package com.pokerhands.ui;

import java.util.Comparator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.comparison.StandardFiveCardPokerModule;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class PokerHandsApplication extends Application {

    private final Comparator<PokerHand> _comparator;
    private TextField player1CardsText;
    private TextField player2CardsText;
    private Label resultLabel;

    public PokerHandsApplication() {
	Injector injector = Guice.createInjector(new StandardFiveCardPokerModule());
	_comparator = injector.getInstance(Key.get(new TypeLiteral<Comparator<PokerHand>>() {
	}));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("Poker Hands");

	Button submitButton = new Button();
	submitButton.setText("Compare");
	submitButton.setOnAction((event) -> {
	    int comparison = _comparator.compare(new PokerHand(player1CardsText.getText()),
		    new PokerHand(player2CardsText.getText()));
	    if (comparison > 0) {
		resultLabel.setText("Player 1 wins!");
	    } else if (comparison < 0) {
		resultLabel.setText("Player 2 wins!");
	    } else {
		resultLabel.setText("Draw.");
	    }
	});

	player1CardsText = new TextField();
	player1CardsText.setText("2H3C6SAHAS");
	player2CardsText = new TextField();
	player2CardsText.setText("3H4C5SKHKS");
	resultLabel = new Label();

	VBox root = new VBox();
	root.getChildren().add(new Label("Player 1"));
	root.getChildren().add(player1CardsText);
	root.getChildren().add(new Label("Player 2"));
	root.getChildren().add(player2CardsText);
	root.getChildren().add(submitButton);
	root.getChildren().add(resultLabel);
	primaryStage.setScene(new Scene(root, 300, 250));
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

}
