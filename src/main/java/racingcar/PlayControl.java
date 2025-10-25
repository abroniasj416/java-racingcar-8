package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayControl {

    // 이름 입력만 우선 구현
    List<Car> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();
        if (line == null) throw new IllegalArgumentException("이름을 입력해 주세요.");

        String[] tokens = Arrays.stream(line.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        if (tokens.length == 0) throw new IllegalArgumentException("이름을 입력해 주세요.");

        List<Car> cars = new ArrayList<>();
        for (String t : tokens) {
            if (t.isEmpty()) throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
            cars.add(new Car(t)); // Car가 길이 검증 수행
        }
        return cars;
    }

    int readRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String line = Console.readLine();
        try {
            int n = Integer.parseInt(line.trim());
            if (n < 1) throw new NumberFormatException();
            return n;
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
