package com.example.spring_boot_app.times;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class TimeProvider implements CommandLineRunner {

    private final TimeService timeService;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${custom.welcomeMessage}")
    private String welcomeMessage;

    @Autowired
    public TimeProvider(TimeService timeService) {
        this.timeService = timeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Logger.getLogger(TimeProvider.class.getName()).info("running " + appName);
        Logger.getLogger(TimeProvider.class.getName()).info("running " + welcomeMessage);
        this.timeService.printCurrentTime();
    }
}
