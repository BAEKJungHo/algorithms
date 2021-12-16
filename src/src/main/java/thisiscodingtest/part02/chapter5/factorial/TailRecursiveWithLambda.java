package thisiscodingtest.part02.chapter5.factorial;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * TailCalls Convenience Class
 */
class TailCalls {

    public static TailCall call(final TailCall nextCall) {
        return nextCall;
    }

    public static TailCall done(final int value) {
        return new TailCall() {
            @Override
            public boolean isComplete() { // true 를 반환하여 재귀의 끝을 보고한다.
                return true;
            }

            @Override
            public int result() {
                return value;
            }

            @Override
            public TailCall apply() {
                throw new Error("not implemented");
            }
        };
    }
}

/**
 * default 메서드를 이용하여 구현
 */
@FunctionalInterface
interface TailCall {

    // 실행 대기 중인 다음 TailCall 인스턴스를 반환
    TailCall apply();

    // 단순히 false 를 반환 : false 라는 것은 아직 대기중이라는 의미가 된다.
    default boolean isComplete() {
        return false;
    }

    default int result() {
        throw new Error("not implemented");
    }

    default int invoke() {
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isComplete)
                .findFirst()
                .get()
                .result();
    }
}

public class TailRecursiveWithLambda {

    /**
     * factorialTail() 메서드를 호출하면 TailCall 인스턴스와 함께 즉시 반환된다.
     * 핵심 아이디어는 done() 메서드를 호출 하면 재귀가 종료 된다는 신호를 보낸다는 것이다.
     * 반면에 call() 메서드를 사용하는 경우 재귀를 계속하도록 요청하지만 현재 스택 수준에서 한 단계 내려간 후에만 가능하다.
     * @param n 입력값
     * @param total 총 계산한 값
     * @return TailCall
     */
    public static TailCall factorialTail(final int n, final int total) {
        if (n == 1) {
            return TailCalls.done(total);
        } else {
            return TailCalls.call(() -> factorialTail(n - 1, n * total));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorialTail(n, 1).invoke());
    }

}
