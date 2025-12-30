package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.util.InputParser;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public void inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
    }

    public Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        Lotto lotto = null;
        try{
            lotto = new Lotto(inputParser.parsingNumbers(winningNumbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumbers();
        }
        return lotto;
    }

    public BonusNumber inputBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        BonusNumber bonus = null;
        try{
            bonus = new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumbers();
        }
        return bonus;
    }
}
