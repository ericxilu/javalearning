package com.lucrotek.javalearning.jackson.model.party;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Party {
    List<PartyAttributes> summary;
    List<PartyAttributes> details;
    String[] displayOrder = {"canada", "common attr"};
}
