package com.taskagile.controller.board;

import com.taskagile.controller.board.dto.BoardDto;
import com.taskagile.controller.board.dto.BoardRequest;
import com.taskagile.controller.board.dto.BoardResponse;
import com.taskagile.controller.user.dto.UserDto;
import com.taskagile.domain.board.Board;
import com.taskagile.securiy.userdetails.CurrentUser;
import com.taskagile.securiy.userdetails.CustomUserDetails;
import com.taskagile.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardDto.GetOne create(@RequestBody @Valid BoardRequest.create request, @CurrentUser CustomUserDetails customUserDetails) {
        Board board = boardService.create(request, customUserDetails.getUser());

        return BoardDto.GetOne.build(board);
    }

    @GetMapping("/{boardId}")
    public BoardResponse.GetBoard getBoard(@PathVariable Long boardId) {
        return BoardResponse.GetBoard.build(boardService.getBoard(boardId));
    }

    @PostMapping("/{boardId}/member")
    public UserDto.GetIdAndName addMember(@PathVariable Long boardId, @RequestBody @Valid BoardRequest.AddMember request) {
        return UserDto.GetIdAndName.build(boardService.addMember(boardId, request).getUser());
    }
}
