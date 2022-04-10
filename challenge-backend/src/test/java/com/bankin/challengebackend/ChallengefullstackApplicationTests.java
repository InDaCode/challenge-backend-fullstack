package com.bankin.challengebackend;

import com.bankin.challengebackend.clients.Account;
import com.bankin.challengebackend.services.BridgeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.hamcrest.MatcherAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ChallengefullstackApplicationTests {

	@Autowired
	private BridgeService bridgeService;

	@Test
	void contextLoads() {
	}

	@Test
	void getAccountsTotalBalance(){
		Account account1 = Account.builder()
				.id(134576L)
				.currencyCode("EUR")
				.name("bank A")
				.balance(113.35)
				.type("type bank A")
				.build();

		Account account2 = Account.builder()
				.id(131278L)
				.currencyCode("EUR")
				.name("bank B")
				.balance(555.00)
				.type("type bank B")
				.build();

		Account account3 = Account.builder()
				.id(134789L)
				.currencyCode("EUR")
				.name("bank C")
				.balance(3.33)
				.type("type bank C")
				.build();

		List<Account> accountsList = Arrays.asList(account1, account2, account3);

		Long accountsTotalBalance = bridgeService.getAccountsTotalBalance(accountsList);

		MatcherAssert.assertThat(accountsTotalBalance, Matchers.is(700L));

	}

	@Test
	void getAccountsTotalBalanceWithEmptyAccountList(){
		List<Account> accountsList = new ArrayList<>();

		Long accountsTotalBalance = bridgeService.getAccountsTotalBalance(accountsList);

		MatcherAssert.assertThat(accountsTotalBalance, Matchers.is(0L));

	}
}
