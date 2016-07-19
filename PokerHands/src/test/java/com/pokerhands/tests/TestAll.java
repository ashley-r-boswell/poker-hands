package com.pokerhands.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ComparisonTests.class, SpecificAnalyserTests.class, BadInput.class })
public class TestAll {

}
