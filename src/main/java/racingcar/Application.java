package racingcar;

public class Application {
    public static void main(String[] args) {
        new PlayControl().start(); // 입출력 책임이 PlayControl 내부에서 InputView, OutputView로 분리됨
    }
}

