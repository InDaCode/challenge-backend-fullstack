package com.bankin.challengebackend.controllers;

import java.io.IOException;
import java.util.List;

import com.bankin.challengebackend.clients.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankin.challengebackend.services.BridgeService;

/**
 * MyController.myEndpoint is called when requesting GET /mycontroller/myroute
 * <p>
 * You can try it by running curl -X GET localhost:8080/mycontroller/myroute
 * <p>
 * The BridgeClient has been injected and ready for use. Maybe the controller, method and route need some renaming?
 */
@RestController
@RequestMapping("/bankin")
public class MyController {

    @Autowired
    private BridgeService bridgeService;

    @GetMapping("/accounts")
    public MyResponse getAccounts() throws IOException {
        List<Account> listOfClientAccounts = bridgeService.getListOfClientAccounts().accounts;
        Long accountsTotalBalance = bridgeService.getAccountsTotalBalance(listOfClientAccounts);

        return MyResponse.builder()
                .accounts(listOfClientAccounts)
                .roundedValue(accountsTotalBalance)
                .build();

    }

}
