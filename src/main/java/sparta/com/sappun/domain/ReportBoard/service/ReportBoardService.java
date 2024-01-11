package sparta.com.sappun.domain.ReportBoard.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.com.sappun.domain.ReportBoard.dto.request.ReportBoardReq;
import sparta.com.sappun.domain.ReportBoard.dto.response.ReportBoardRes;
import sparta.com.sappun.domain.ReportBoard.entity.ReportBoard;
import sparta.com.sappun.domain.ReportBoard.repository.ReportBoardRepository;
import sparta.com.sappun.domain.board.entity.Board;
import sparta.com.sappun.domain.board.repository.BoardRepository;
import sparta.com.sappun.domain.user.entity.User;
import sparta.com.sappun.domain.user.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportBoardService {
    private final ReportBoardRepository reportBoardRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public ReportBoardRes reportBoardRes(Long boardId, ReportBoardReq req, Long userId) {
        Board board = boardRepository.findById(boardId);
        User user = userRepository.findById(userId);

        ReportBoard reportBoard =
                ReportBoard.builder().reason(req.getReason()).board(board).user(user).build();

        reportBoardRepository.save(reportBoard);

        return ReportBoardServiceMapper.INSTANCE.toReportBoardRes(reportBoard);
    }
}
