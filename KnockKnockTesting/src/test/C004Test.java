package test;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.Context;
import core.ContextUtil;
import core.communication.ArduinoListener;
import testingmodule.ContextTest;
import testingmodule.conditions.DigitalWriteCheckCondition;
import testingmodule.conditions.VariableCheckCondition;
import testingmodule.enums.CheckingTime;
import testingmodule.enums.ConditionType;

public class C004Test extends ContextTest{

	public static Context c;
	
	@BeforeClass
	public static void beforeClass() {
		c = ContextUtil.readFromFile("context/C004.txt");
	}
	
	@Before
	public void before() {
		setPort("COM4");
		setContext(c);
		mapSensor(15, 0);
	}
	
	@Test
	public void T001() {
		addCondition(new DigitalWriteCheckCondition(13, "LOW"));
		runTest();
	}
	
}