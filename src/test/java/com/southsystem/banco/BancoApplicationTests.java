package com.southsystem.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.southsystem.banco.persistence.model.BusinessAccount;
import com.southsystem.banco.persistence.model.CurrentAccount;
import com.southsystem.banco.persistence.model.LegalPerson;
import com.southsystem.banco.persistence.model.PhysicalPerson;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BancoApplicationTests {

	private CurrentAccount currentAccount = new CurrentAccount();
	private BusinessAccount businessAccount = new BusinessAccount();
	private PhysicalPerson physicalPerson = new PhysicalPerson();
	private LegalPerson legalPerson = new LegalPerson();

	@Test
	void contextLoads() {
	}

	@Test
	void testGeneratePhysicalPersonScore() {
		assertTrue(physicalPerson.generatePersonScore() >= 0 || physicalPerson.generatePersonScore() <= 9);
	}

	@Test
	void testGenerateLegalPersonScore() {
		assertTrue(legalPerson.generatePersonScore() >= 0 || legalPerson.generatePersonScore() <= 9);
	}

	@Test
	void testGenerateLimitsCurrentAcountScore0() {
		testGenerateCurrentAccountLimits(0, null, null);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore1() {
		testGenerateCurrentAccountLimits(1, null, null);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore2() {
		testGenerateCurrentAccountLimits(2, 1000.0, 200.0);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore3() {
		testGenerateCurrentAccountLimits(3, 1000.0, 200.0);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore4() {
		testGenerateCurrentAccountLimits(4, 1000.0, 200.0);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore5() {
		testGenerateCurrentAccountLimits(5, 1000.0, 200.0);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore6() {
		testGenerateCurrentAccountLimits(6, 2000.0, 2000.0);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore7() {
		testGenerateCurrentAccountLimits(7, 2000.0, 2000.0);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore8() {
		testGenerateCurrentAccountLimits(8, 2000.0, 2000.0);
	};

	@Test
	void testGenerateCurrentAccountLimitsScore9() {
		testGenerateCurrentAccountLimits(9, 5000.0, 15000.0);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore0() {
		testGenerateBusinessAccountLimits(0, null, null);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore1() {
		testGenerateBusinessAccountLimits(1, null, null);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore2() {
		testGenerateBusinessAccountLimits(2, 1000.0, 200.0);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore3() {
		testGenerateBusinessAccountLimits(3, 1000.0, 200.0);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore4() {
		testGenerateBusinessAccountLimits(4, 1000.0, 200.0);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore5() {
		testGenerateBusinessAccountLimits(5, 1000.0, 200.0);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore6() {
		testGenerateBusinessAccountLimits(6, 2000.0, 2000.0);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore7() {
		testGenerateBusinessAccountLimits(7, 2000.0, 2000.0);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore8() {
		testGenerateBusinessAccountLimits(8, 2000.0, 2000.0);
	};

	@Test
	void testGenerateLimitsBusinessAcountScore9() {
		testGenerateBusinessAccountLimits(9, 5000.0, 15000.0);
	};

	void testGenerateCurrentAccountLimits(int score, Double overdraftLimitExpected, Double creditCardLimitExpected) {
		currentAccount.generateCreditCardLimit(score);
		currentAccount.generateOverdraftLimit(score);
		assertEquals(currentAccount.getOverdraftLimit(), overdraftLimitExpected);
		assertEquals(currentAccount.getCreditCardLimit(), creditCardLimitExpected);
	}

	void testGenerateBusinessAccountLimits(int score, Double overdraftLimitExpected, Double creditCardLimitExpected) {
		businessAccount.generateCreditCardLimit(score);
		businessAccount.generateOverdraftLimit(score);
		assertEquals(businessAccount.getOverdraftLimit(), overdraftLimitExpected);
		assertEquals(businessAccount.getCreditCardLimit(), creditCardLimitExpected);
	}
}
