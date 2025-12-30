package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> purChase(int cnt) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public WinningStatistics calculateResults(List<Lotto> lottos, WinningNumbers winningLottos) {
        WinningStatistics winningStatistics = new WinningStatistics();

        for(Lotto lotto : lottos) {
            winningStatistics.add(winningLottos.calculateScore(lotto));
        }

        return winningStatistics;
    }
}
