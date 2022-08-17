package tg;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.util.List;

public class Main {
    private static final String KEY;
    private static final String KEY_NAME = "TG_KEY";
    private static final String HELLO_MSG = "Hello, %s";

    static {
        KEY = System.getenv(KEY_NAME);
    }

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(KEY);

        GetUpdates getUpdatesRequest = new GetUpdates().limit(10).offset(-1).timeout(0);

        GetUpdatesResponse updatesResponse = bot.execute(getUpdatesRequest);

        List<Update> updates = updatesResponse.updates();

        updates.forEach(update -> {
            System.out.println(update.message());
            bot.execute(new SendMessage(update.message().chat().id(), HELLO_MSG.formatted(update.message().from().firstName())));
        });

    }
}

