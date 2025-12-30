package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    // TODO : 단위로 잘라서 Lotto에 저장하기
    // TODO : 끝에 ,가 올 경우 어떻게 해야할지 모르겠으나, 일단 하기
    public List<Integer> parsingNumbers(String inputNumbers) {
        String[] numbers = inputNumbers.split(",");
        for (String number : numbers) {
            isNumber(number);
            isLotto(number);
        }
        List<Integer> winningNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    private void isNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 입력한 로또 당첨 번호는 숫자여야 합니다.");
        }
    }

    private void isLotto(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
            throw new IllegalArgumentException("[ERROR] 입력한 로또 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
