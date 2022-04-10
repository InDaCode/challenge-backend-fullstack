package com.bankin.challengebackend.controllers;

import com.bankin.challengebackend.clients.Account;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MyResponse {
    public Long roundedValue;
    public List<Account> accounts;
}
