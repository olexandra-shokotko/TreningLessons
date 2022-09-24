package tg;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import tg.providers.BotNameProvider;
import tg.providers.TokenProvider;

public abstract class AbstractTgBot extends TelegramLongPollingBot {

    private final TokenProvider tokenProvider;
    private final BotNameProvider botNameProvider;

    protected AbstractTgBot(TokenProvider tokenProvider, BotNameProvider botNameProvider) {
        this.tokenProvider = tokenProvider;
        this.botNameProvider = botNameProvider;
    }

    @Override
    public final String getBotUsername() {
        return botNameProvider.get();
    }

    @Override
    public final String getBotToken() {
        return tokenProvider.get();
    }

}
