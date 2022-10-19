package com.example.vacanciesbot;


import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class VacanciesBot extends TelegramLongPollingBot {

    String botName = "vacancies123123_bot";
    String botToken = "5625415221:AAHecAVv7zZ2UdrvbIHAn6FPhnyk2QBrtMM";

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            if (text.equals("/start")) {

                execute(new SendMessage(chatId, "test apload"));
            }
        }
    }
}
