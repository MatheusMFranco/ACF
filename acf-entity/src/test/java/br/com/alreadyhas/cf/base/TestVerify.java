package br.com.alreadyhas.cf.base;

import org.eclipse.persistence.jpa.jpql.Assert;

import lombok.Getter;

public final class TestVerify {

	private static final TestVerify INSTANCE = new TestVerify();

	@Getter
	private Integer testNumber;

	private TestVerify() {
		this.testNumber = 0;
	}

	public static TestVerify getInstance(){
		return INSTANCE;
	}

	public void verifyTrue(Object object1, Object object2) {
		addTestNumber();
		Assert.isTrue(object1.equals(object2), notEqualsMessage());
		Assert.isTrue(object2.equals(object1), notEqualsMessage());
		Assert.isTrue(object1.hashCode() - object2.hashCode() == 0, notEqualsMessage());
	}

	public void verifyFalse(Object object1, Object object2) {
		addTestNumber();
		Assert.isFalse(object1.equals(object2), equalsMessage());
		Assert.isFalse(object2.equals(object1), equalsMessage());
		Assert.isFalse(object1.hashCode() - object2.hashCode() == 0, equalsMessage());
	}

	private String notEqualsMessage() {
		return message("Not Equals");
	}

	private String equalsMessage() {
		return message("Are Equals");
	}

	private String message(String message) {
		return String.format("Test[%d] - %s", testNumber, message);
	}

	private Integer addTestNumber() {
		return ++testNumber;
	}

}
