package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView(new InputParser());

        LottoService lottoService = new LottoService();

        OutputView outputView = new OutputView();

        int money = inputView.inputPurchaseMoney();
        int cnt = money/1000;    // 로또 구매 개수

        List<Lotto> lottos = lottoService.purChase(cnt);
        outputView.printLottos(lottos, cnt);    // 구매한 로또 프린트

        Lotto winningLottos = inputView.inputWinningNumbers();
        BonusNumber bonus = inputView.inputBonusNumbers();
        WinningNumbers winningLotto = new WinningNumbers(winningLottos, bonus);
        WinningStatistics winningStatistics = lottoService.calculateResults(lottos, winningLotto);

        System.out.println();    // 한 칸 띄기
        outputView.printStats(money, winningStatistics);    // 당첨 통계
    }
}
