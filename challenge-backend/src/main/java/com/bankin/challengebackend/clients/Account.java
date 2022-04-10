package com.bankin.challengebackend.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("balance")
    public Double balance;

    @JsonProperty("type")
    public String type;

    @JsonProperty("currency_code")
    public String currencyCode;
}
