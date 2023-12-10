package lotto.model;

import java.util.HashSet;
import java.util.List;

public class LottoNumbers {

    private static final int LOW_BOUND = 1;
    private static final int MAX_BOUND = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumberSize(lottoNumbers);
        validateLottoNumberDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public long matchCount(WinningNumbers winningNumbers) {
        return this.lottoNumbers
            .stream()
            .filter(winningNumbers::contains)
            .count();
    }

    public boolean matchBonusNumber(WinningNumbers winningNumbers) {
        return this.lottoNumbers
            .stream()
            .anyMatch(winningNumbers::matchBonusNumber);
    }

    public boolean contains(int lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private void validateLottoNumberSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또번호는 6개를 선택해야 합니다");
        }
    }

    private void validateLottoNumberDuplicate(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또번호는 중복이 불가능합니다.");
        }
    }

    private void validateLottoNumberRange(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
            .filter(lottoNumber -> lottoNumber < LOW_BOUND || lottoNumber > MAX_BOUND)
            .forEach(lottoNumber -> {
                throw new IllegalArgumentException("로또번호 범위를 벗어났습니다.");
            });
    }


    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
