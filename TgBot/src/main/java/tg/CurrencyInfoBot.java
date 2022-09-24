package tg;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tg.providers.BotNameProvider;
import tg.providers.TokenProvider;

import java.util.List;

public class CurrencyInfoBot extends AbstractTgBot {

    public CurrencyInfoBot(TokenProvider tokenProvider,
                           BotNameProvider botNameProvider) {
        super(tokenProvider, botNameProvider);
    }

    @Override
    public void onUpdateReceived(Update update) {

        try {
            super.execute(buildKeyboardResponse(update.getMessage()
                    .getChatId()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private SendMessage buildKeyboardResponse(Long chatId) {
        var button1 = new KeyboardButton("EUR");
        var button2 = new KeyboardButton("USD");
        var keyBoardRow = new KeyboardRow(List.of(button1, button2));

        var keyboard = ReplyKeyboardMarkup.builder()
                .keyboard(List.of(keyBoardRow))
                .build();

        return SendMessage.builder()
                .text("Hello please choose a button")
                .chatId(chatId)
                .replyMarkup(keyboard)
                .build();
    }
}
