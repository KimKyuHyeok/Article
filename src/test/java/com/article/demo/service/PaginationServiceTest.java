package com.article.demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("비지니스 로직 - 페이지네이션")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = PaginationService.class)
class PaginationServiceTest {

    private final PaginationService sut;

    public PaginationServiceTest(@Autowired PaginationService paginationService) {
        this.sut = paginationService;
    }

    @DisplayName("현재 페이지 번호와 총 페이지 수를 주면, 페이징 바 리스트를 만들어준다.")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0}, {1} => {2}")
    void currentPageNumberAndTotalPages_Calculating_ReturnsPaginationBarNumbers(int currentPageNumber, int totalPages, List<Integer> expected) {

        List<Integer> actual = sut.getPaginationBarNumbers(currentPageNumber, totalPages);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> currentPageNumberAndTotalPages_Calculating_ReturnsPaginationBarNumbers() {
        return Stream.of(
                arguments(1, 1, List.of(0))
        );
    }

    @DisplayName("현재 설정되어 있는 페이지네이션 바의 길이를 알려준다.")
    @Test
    void nothing_Calling_CurrentBarLength() {

        int barLength = sut.currentBarLength();

        assertThat(barLength).isEqualTo(5);
    }
}