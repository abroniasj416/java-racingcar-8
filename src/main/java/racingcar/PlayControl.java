package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayControl {
    private final OutputView outputView = new OutputView();

    void start() {
        outputView.printGameStartMessage();
        List<Car> cars = readCars();

        outputView.printTryCountMessage();
        int rounds = readRounds();

        outputView.printResultHeader();

        Play play = new Play(cars, outputView);
        for (int i = 0; i < rounds; i++) {
            play.playOneRound();
        }

        printWinners(cars);
    }


    List<Car> readCars() {
        InputView inputView = new InputView();
        return inputView.readCars();
    }

    int readRounds() {
        InputView inputView = new InputView();
        return inputView.readRounds();
    }

    private void printWinners(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(c -> c.position() == max)
                .map(Car::name)
                .toList();

        outputView.printWinners(winners);
    }
}
