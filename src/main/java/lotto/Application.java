package lotto;

import lotto.util.InputParser;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputParser inputParser = new InputParser();
        InputView inputView = new InputView(inputParser);

        inputView.inputPurchaseMoney();
        inputView.inputWinningNumbers();
        inputView.inputBonusNumbers();
    }
}
