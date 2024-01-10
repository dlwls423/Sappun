package sparta.com.sappun.domain.comment.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentGetRes {
    private Long id;
    private String nickname;
    private String content;
    private String fileUrl;

    @Builder
    private CommentGetRes(Long id, String nickname, String content, String fileUrl) {
        this.id = id;
        this.nickname = nickname;
        this.content = content;
        this.fileUrl = fileUrl;
    }
}
