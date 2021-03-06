package com.quest.accounts.saving.appplication.commands;

import com.ddd.common.annotations.Command;
import lombok.Value;

@Command
@Value
public class CreateUserCommand {
    private final String emailAddress;
    private final String country;
    private final String city;
    private final String username;
    private final String password;
    private final long epochBirthDate;
}
