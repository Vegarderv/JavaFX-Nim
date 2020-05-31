package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import javax.swing.SwingUtilities;

import javafx.application.Platform;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;


import debugging.CoffeeCup;

public class SavingTest implements TestRule{

	private static boolean jfxIsSetup;

	@Override
	public Statement apply(Statement base, Description description) {
		return new OnJFXThreadStatement(statement);
	}
	
	
}
