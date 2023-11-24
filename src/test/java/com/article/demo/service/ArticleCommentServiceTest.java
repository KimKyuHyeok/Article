package com.article.demo.service;


import com.article.demo.domain.Article;
import com.article.demo.domain.ArticleComment;
import com.article.demo.dto.ArticleCommentDto;
import com.article.demo.repository.ArticleCommentRepository;
import com.article.demo.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@DisplayName("비지니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 ID 로 조회하면 해당하는 댓글 리스트를 반환")
    @Test
    void articleId_SearchingArticleComments_ReturnsArticleComments() {

        Long articleId = 1L;

        given(articleRepository.findById(articleId)).willReturn(
                Optional.of(Article.of("title", "content", "hashtag")));

        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);

        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }


}