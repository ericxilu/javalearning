package com.lucrotek.javalearning.jackson.model.party;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartyAttributes {
    String displayName;
    String value;
    String regim;
    String attribute;
}
