package com.lps.action.operation.manage;

import java.util.List;

import com.lps.action.basic.ActionSupportLps;
import com.lps.model.Test;
import com.lps.service.impl.TestServiceImpl;

public class ManageTestAction extends ActionSupportLps {

	private static final long serialVersionUID = 945787319894242975L;

	private TestServiceImpl testImpl;
	
	public TestServiceImpl getTestImpl() {
		return testImpl;
	}

	public void setTestImpl(TestServiceImpl testImpl) {
		this.testImpl = testImpl;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	private Test test;

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String save() {
		testImpl.save(test);
		return SUCCESS;
	}

	public String delete(){
		testImpl.delete(test);
		return SUCCESS;
	}

	public String update() {
		testImpl.update(test);
		return SUCCESS;
	}

	private List<Test> tests;

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public String findAll() {
		tests = testImpl.findAll();
		return SUCCESS;
	}
}
