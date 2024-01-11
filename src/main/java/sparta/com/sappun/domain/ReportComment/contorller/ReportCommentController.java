package sparta.com.sappun.domain.ReportComment.contorller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sparta.com.sappun.domain.ReportComment.dto.request.ReportCommentReq;
import sparta.com.sappun.domain.ReportComment.dto.response.ReportCommentRes;
import sparta.com.sappun.domain.ReportComment.service.ReportCommentService;
import sparta.com.sappun.global.security.UserDetailsImpl;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class ReportCommentController {
    @Autowired private ReportCommentService reportCommentService;

    @PostMapping("/{commentId}/report")
    public ResponseEntity<ReportCommentRes> reportComment(
            @PathVariable Long commentId,
            @RequestBody @Valid ReportCommentReq req,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        req.setUserId(userDetails.getUser().getId());
        return ResponseEntity.ok(reportCommentService.reporCommentRes(commentId, req));
    }
}
