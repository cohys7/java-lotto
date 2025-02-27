package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {
    @Test
    void create_number() {
        assertThatNoException().isThrownBy(() -> new Number(0));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void parse_null_or_empty(String number) {
        assertThatThrownBy(() -> Number.valueOf(number))
                .isInstanceOf(CaculateException.class)
                .hasMessage(ErrorCode.NUMBER_IS_NULL.getErrorMessage());
    }

    @Test
    void parse_number() {
        assertThat(Number.valueOf("1")).isEqualTo(new Number(1));
    }

    @Test
    void parse_not_number() {
        assertThatThrownBy(() -> Number.valueOf("a"))
                .isInstanceOf(CaculateException.class)
                .hasMessage(ErrorCode.WRONG_NUMBER_FORMAT.getErrorMessage());
    }

    @Test
    void plus_number() {
        assertThat(new Number(1).plus(new Number(2))).isEqualTo(new Number(3));
    }

    @Test
    void subtract_number() {
        assertThat(new Number(2).subtract(new Number(1))).isEqualTo(new Number(1));
    }

    @Test
    void multiply_number() {
        assertThat(new Number(2).multiply(new Number(4))).isEqualTo(new Number(8));
    }

    @Test
    void divide_by_zero() {
        Number a = new Number(2);
        Number b = new Number(0);
        assertThatThrownBy(() -> a.divide(b))
                .isInstanceOf(CaculateException.class)
                .hasMessage(ErrorCode.DIVIDE_WITH_ZERO.getErrorMessage());
    }

    @Test
    void division_result_is_not_integer() {
        Number a = new Number(2);
        Number b = new Number(3);
        assertThatThrownBy(() -> a.divide(b))
                .isInstanceOf(CaculateException.class)
                .hasMessage(ErrorCode.EXIST_REMAINDER.getErrorMessage());
    }

    @Test
    void divide_number() {
        assertThat(new Number(4).divide(new Number(2))).isEqualTo(new Number(2));
    }
}
