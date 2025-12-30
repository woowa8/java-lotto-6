package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.util.InputParser;
import camp.nextstep.edu.missionutils.Console;

import java.awt.*;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();

        int purchaseMoney;
        try {
            purchaseMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구매 금액은 숫자여야 합니다.");
            return inputPurchaseMoney();
        }
        return purchaseMoney;
    }

    public Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        Lotto lotto;
        try {
            lotto = new Lotto(inputParser.parsingNumbers(winningNumbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();     // TODO : 재귀 호출 시 return 필수
        }
        return lotto;
    }

    public BonusNumber inputBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        BonusNumber bonus;
        try {
            bonus = new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumbers();     // TODO : 재귀 호출 시 return 필수
        }
        return bonus;
    }
}
