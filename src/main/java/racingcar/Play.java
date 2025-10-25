package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Play {
    private final List<Car> cars;
    private final OutputView outputView;

    public Play(List<Car> cars, OutputView outputView) {
        this.cars = cars;
        this.outputView = outputView;
    }

    void playOneRound() {
        for (Car car : cars) {
            boolean movable = Randoms.pickNumberInRange(0, 9) >= 4;
            car.moveIf(movable);
        }
        outputView.printRoundResult(cars);
    }
}
