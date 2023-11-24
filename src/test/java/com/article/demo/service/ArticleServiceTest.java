package com.article.demo.service;

import com.article.demo.domain.Article;
import com.article.demo.domain.type.SearchType;
import com.article.demo.dto.ArticleDto;
import com.article.demo.dto.ArticleUpdateDto;
import com.article.demo.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doNothing;

@DisplayName("비지니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면 게시글 리스트를 반환")
    @Test
    void searchParameters_SearchingArticles_ReturnArticleList() {


        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); //제목, 본문, ID, 닉네임, 해시태그

        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면 게시글을 반환")
    @Test
    void searchParameterId_SearchingArticle_ReturnArticle() {


        ArticleDto articles = sut.searchArticle(1L); //제목, 본문, ID, 닉네임, 해시태그

        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다")
    @Test
    void ArticleInfo_SavingArticle_SavesArticle() {
        //given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        //when

        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "Kim", "Title", "content", "#hashtag"));
        //then

        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID와 수정 정보를 입력하면, 게시글을 수정")
    @Test
    void ArticleIdAndModifiedInfo_SavingArticle_UpdateArticle() {
        //given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        //when

        sut.updateArticle(1L, ArticleUpdateDto.of("Title", "content", "#hashtag"));
        //then

        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID를 입력하면, 게시글을 삭제")
    @Test
    void ArticleId_DeletingArticle_DeletesArticle() {
        //given
        willDoNothing().given(articleRepository).delete(any(Article.class));
        //when

        sut.deleteArticle(1L);
        //then

        then(articleRepository).should().delete(any(Article.class));
    }

}