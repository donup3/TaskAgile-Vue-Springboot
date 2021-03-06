package com.taskagile.domain.board;

import com.taskagile.domain.common.BaseEntity;
import com.taskagile.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "board_user")
public class BoardUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private void setBoard(Board board) {
        this.board = board;
        board.getBoardUsers().add(this);
    }

    public static BoardUser create(Board board, User user) {
        BoardUser boardUser = BoardUser.builder().user(user).build();
        boardUser.setBoard(board);
        return boardUser;
    }
}
