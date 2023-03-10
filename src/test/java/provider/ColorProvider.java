package provider;

import com.innowise.ball.Ball;
import com.innowise.ball.Basketball;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static com.innowise.ball.Color.*;

public class ColorProvider {
    private ColorProvider() {
    }

    public static Stream<Arguments> orders() {
        return Stream.of(
                Arguments.of(List.of(RED), List.of(GREEN, BLUE, RED)),
                Arguments.of(List.of(GREEN), List.of(RED, BLUE, GREEN)),
                Arguments.of(List.of(BLUE), List.of(RED, GREEN, BLUE)),
                Arguments.of(List.of(BLUE, RED), List.of(GREEN, BLUE, RED)),
                Arguments.of(List.of(RED, GREEN), List.of(BLUE, RED, GREEN)),
                Arguments.of(List.of(RED, BLUE, GREEN), List.of(RED, BLUE, GREEN))
        );
    }


    public static Stream<Arguments> sortColorOrder() {
        return Stream.of(
                Arguments.of(List.of(RED), balls(), List.of(
                        GREEN, GREEN, GREEN, GREEN, GREEN, GREEN,
                        BLUE, BLUE, BLUE, BLUE, BLUE,
                        RED, RED, RED, RED, RED
                )),
                Arguments.of(List.of(GREEN), balls(), List.of(
                        RED, RED, RED, RED, RED,
                        BLUE, BLUE, BLUE, BLUE, BLUE,
                        GREEN, GREEN, GREEN, GREEN, GREEN, GREEN

                )),
                Arguments.of(List.of(BLUE), balls(), List.of(
                        RED, RED, RED, RED, RED,
                        GREEN, GREEN, GREEN, GREEN, GREEN, GREEN,
                        BLUE, BLUE, BLUE, BLUE, BLUE
                )),
                Arguments.of(List.of(BLUE, RED), balls(), List.of(
                        GREEN, GREEN, GREEN, GREEN, GREEN, GREEN,
                        BLUE, BLUE, BLUE, BLUE, BLUE,
                        RED, RED, RED, RED, RED
                )),
                Arguments.of(List.of(RED, GREEN), balls(), List.of(
                        BLUE, BLUE, BLUE, BLUE, BLUE,
                        RED, RED, RED, RED, RED,
                        GREEN, GREEN, GREEN, GREEN, GREEN, GREEN
                )),
                Arguments.of(List.of(RED, BLUE, GREEN), balls(), List.of(
                        RED, RED, RED, RED, RED,
                        BLUE, BLUE, BLUE, BLUE, BLUE,
                        GREEN, GREEN, GREEN, GREEN, GREEN, GREEN
                ))
        );
    }


    private static List<Ball> balls() {
        return List.of(
                new Basketball(RED, 0, 0),
                new Basketball(RED, 0, 0),
                new Basketball(BLUE, 0, 0),
                new Basketball(GREEN, 0, 0),
                new Basketball(GREEN, 0, 0),
                new Basketball(RED, 0, 0),
                new Basketball(BLUE, 0, 0),
                new Basketball(GREEN, 0, 0),
                new Basketball(RED, 0, 0),
                new Basketball(GREEN, 0, 0),
                new Basketball(GREEN, 0, 0),
                new Basketball(BLUE, 0, 0),
                new Basketball(BLUE, 0, 0),
                new Basketball(GREEN, 0, 0),
                new Basketball(RED, 0, 0),
                new Basketball(BLUE, 0, 0)
        );
    }


}
