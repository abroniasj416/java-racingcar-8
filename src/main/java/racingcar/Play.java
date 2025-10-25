package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Play {
    private final List<Car> cars;

    public Play(List<Car> cars) {
        this.cars = cars;
    }

    // 라운드 진행만, 콘솔 출력은 다음 커밋에서 처리
    void playOneRound() {
        for (Car car : cars) {
            boolean movable = Randoms.pickNumberInRange(0, 9) >= 4;
            car.moveIf(movable);
            System.out.println(car.name() + " : " + "-".repeat(car.position()));
        }
        System.out.println(); // 라운드 종료 후 빈 줄
    }
}
