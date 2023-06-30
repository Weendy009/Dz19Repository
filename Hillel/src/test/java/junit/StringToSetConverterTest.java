package junit;

import C_W.main.StringToSetConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class StringToSetConverterTest {

    @BeforeEach
    void setUp() {



    }

    @AfterEach
    void tearDown() {



    }

    @Test
    void should_return_correct_string_with_number() {

        List<Integer> integers = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            integers.add(i);
        }
        integers.add(0);

        String result = StringToSetConverter.toString(integers);

        Assertions.assertEquals("[1][2][3][4][5][6][7][8][9][0]", result);

    }

    @Test
    void should_return_or_throw_exception_with_incorrect_number() {
        Assertions.assertNull(StringToSetConverter.toString(null));

    }

}