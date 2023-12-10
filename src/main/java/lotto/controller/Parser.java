package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.LottoNumbers;

public class Parser {

    public List<LottoNumbers> parseTextToLottoNumbersList(List<String> texts) {
        return texts.stream()
            .map(this::parseTextToLottoNumbers)
            .collect(Collectors.toList());
    }

    public LottoNumbers parseTextToLottoNumbers(String text) {
        return new LottoNumbers(
            Arrays.stream(text.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
    }

    public List<Integer> parseTextToIntegetList(String text) {
        return Arrays.stream(text.split(", "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
