package com.lucrotek.javalearning.jackson.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AssetClasses {
    List<AssetClass> assetClass;
}
