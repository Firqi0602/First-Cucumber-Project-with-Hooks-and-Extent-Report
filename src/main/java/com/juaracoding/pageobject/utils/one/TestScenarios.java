package com.juaracoding.pageobject.utils.one;

public enum TestScenarios {
	T1("Account failed login"),
	T2("Account succes login"),
	T3("Search product"),
	T4("Add 2 product and checkout");

private String testName;

TestScenarios(String value) {
	testName = value;
}

public String getTestName(){
	return testName;
}
}


