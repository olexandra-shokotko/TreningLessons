package tg;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import tg.providers.FileTokenProvider;

public class Main {

    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new CurrencyInfoBot(new FileTokenProvider("src/main/resources/token.txt"),
                () -> "DefaultName"));

    }
}

