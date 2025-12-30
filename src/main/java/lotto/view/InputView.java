package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.util.InputParser;
import camp.nextstep.edu.missionutils.Console;

import java.awt.*;
import java.util.function.Supplier;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    // refactor : Supplier 기반 람다 로직으로 변경
    public int inputPurchaseMoney() {
        return retryOnError(() -> {    // ② 최종 결과를 메서드 밖으로
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(Console.readLine());    // ① 람다 → retryOnError로
        });
    }

    // refactor : Supplier 기반 람다 로직으로 변경
    public Lotto inputWinningNumbers() {
        return retryOnError(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbers = Console.readLine();
            return new Lotto(inputParser.parsingNumbers(winningNumbers));
        });
    }

    // refactor : Supplier 기반 람다 로직으로 변경
    public BonusNumber inputBonusNumbers() {
        return retryOnError(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());
            return new BonusNumber(bonusNumber);
        });
    }

    // refactor : Supplier를 사용해서 로직 집중
    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }
    }
}
