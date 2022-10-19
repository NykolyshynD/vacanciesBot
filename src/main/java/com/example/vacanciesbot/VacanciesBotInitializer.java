package com.example.vacanciesbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class VacanciesBotInitializer {

    private final VacanciesBot vacanciesBot;

    @Autowired
    public VacanciesBotInitializer(VacanciesBot vacanciesBot) {
        this.vacanciesBot = vacanciesBot;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void innit() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(vacanciesBot);
    }
}
