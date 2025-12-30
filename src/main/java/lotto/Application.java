package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        InputView inputView = new InputView(inputParser);
        OutputView outputView = new OutputView();

        int money = inputView.inputPurchaseMoney();
        int cnt = money/1000;    // 로또 구매 개수

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }
        Lottos lottos = new Lottos(lottoList);
        outputView.printLottos(lottos, cnt);    // 구매한 로또 프린트

        Lotto winningLottos = inputView.inputWinningNumbers();
        BonusNumber bonus = inputView.inputBonusNumbers();

        lottos.calculateRank(winningLottos, bonus);

        System.out.println();    // 한 칸 띄기
        outputView.printStats(lottos, money);    // 당첨 통계
    }
}
