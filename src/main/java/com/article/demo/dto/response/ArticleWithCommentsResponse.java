package com.article.demo.dto.response;


import com.article.demo.dto.ArticleCommentDto;
import com.article.demo.dto.ArticleWithCommentsDto;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public record ArticleWithCommentsResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String email,
        String nickname,
        String userId,
        Set<ArticleCommentResponse> articleCommentsResponse
) {

    public static ArticleWithCommentsResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String nickname, String userId, Set<ArticleCommentResponse> articleCommentResponses) {
        return new ArticleWithCommentsResponse(id, title, content, hashtag, createdAt, email, nickname, userId, articleCommentResponses);
    }

    public static ArticleWithCommentsResponse from(ArticleWithCommentsDto dto) {
        String nickname = dto.userAccountDto().nickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().userId();
        }

        return new ArticleWithCommentsResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                nickname,
                dto.userAccountDto().userId(),
                dto.articleCommentDtos().stream()
                        .map(ArticleCommentResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }


//    private static Set<ArticleCommentResponse> organizeChildComments(Set<ArticleCommentDto> dtos) {
//        Map<Long, ArticleCommentResponse> map = dtos.stream()
//                .map(ArticleCommentResponse::from)
//                .collect(Collectors.toMap(ArticleCommentResponse::id, Function.identity()));
//
//        map.values().stream()
//                .filter(ArticleCommentResponse::hasParentComment)
//                .forEach(comment -> {
//                    ArticleCommentResponse parentComment = map.get(comment.parentCommentId());
//                    parentComment.childComments().add(comment);
//                });
//
//        return map.values().stream()
//                .filter(comment -> !comment.hasParentComment())
//                .collect(Collectors.toCollection(() ->
//                        new TreeSet<>(Comparator
//                                .comparing(ArticleCommentResponse::createdAt)
//                                .reversed()
//                                .thenComparingLong(ArticleCommentResponse::id)
//                        )
//                ));
//    }
}