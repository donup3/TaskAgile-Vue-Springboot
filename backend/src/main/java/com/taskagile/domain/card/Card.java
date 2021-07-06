package com.taskagile.domain.card;

import com.taskagile.controller.card.dto.CardRequest;
import com.taskagile.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "card")
public class Card extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_list_id")
    private CardList cardList;

    public static Card create(CardRequest.CreateCard request, CardList cardList) {
        return Card.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .position(request.getPosition())
                .cardList(cardList)
                .build();
    }
}
