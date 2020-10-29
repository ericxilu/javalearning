package com.lucrotek.javalearning.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lucrotek.javalearning.jackson.model.*;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;


@Slf4j
public class JavaToJson {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Staff[] staffs = new Staff[2];
        staffs[0] = createStaff();
        staffs[1] = createStaff();

        try {
            String jsonString  = objectMapper.writeValueAsString(staffs);
            log.info(jsonString);
        } catch (JsonProcessingException e) {
            log.error(e.toString());
        }


        SubProduct dairy = SubProduct.builder().name("Dairy").build();
        SubProduct frostrey = SubProduct.builder().name("frostery").build();
        List<SubProduct> agricultureSubProducts = new ArrayList<>();
        agricultureSubProducts.add(dairy);
        agricultureSubProducts.add(frostrey);
        BaseProduct agriculture = BaseProduct.builder().name("agriculture").subProducts(agricultureSubProducts).build();

        SubProduct coal = SubProduct.builder().name("coal").build();
        SubProduct oil = SubProduct.builder().name("oil").build();
        List<SubProduct> energySubProducts = new ArrayList<>();
        energySubProducts.add(coal);
        energySubProducts.add(oil);
        BaseProduct energy = BaseProduct.builder().name("energy").subProducts(agricultureSubProducts).build();

        List<BaseProduct> commodityBaseProducts = new ArrayList<>();
        commodityBaseProducts.add(agriculture);
        commodityBaseProducts.add(energy);
        AssetClass commodity = AssetClass.builder().name("commodity").baseProducts(commodityBaseProducts).build();


        BaseProduct ndf = BaseProduct.builder().name("NDF").build();
        BaseProduct fwd = BaseProduct.builder().name("Forward").build();
        List<BaseProduct> fxBaseProducts = new ArrayList<>();
        fxBaseProducts.add(ndf);
        fxBaseProducts.add(fwd);

        AssetClass fx = AssetClass.builder().name("FX").baseProducts(fxBaseProducts).build();

        List<AssetClass> assetClassList = new ArrayList<>();
        assetClassList.add(commodity);
        assetClassList.add(fx);

        AssetClasses assetClasses = AssetClasses.builder().assetClass(assetClassList).build();


        try{

            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String jsonString = objectMapper.writeValueAsString(assetClasses);
org.bson.Document doc = Document.parse(jsonString);

            log.info(jsonString);
            log.info(doc.toJson());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        SubProductSimple dairySimple = SubProductSimple.builder().name("dairy").build();
        SubProductSimple frosteySimple =SubProductSimple.builder().name("frosety").build();
        List<SubProductSimple> agricultureSubproductSimples = new ArrayList<>();
        agricultureSubproductSimples.add(dairySimple);
        agricultureSubproductSimples.add(frosteySimple);
        BaseProductSimple agricultureSimple = BaseProductSimple.builder().name("agriculture").build();
        SubProductSimple coalSimple = SubProductSimple.builder().name("coal").build();
        SubProductSimple oilSimple =SubProductSimple.builder().name("oil").build();
        List<SubProductSimple> energySubproductSimples = new ArrayList<>();
        energySubproductSimples.add(coalSimple);
        energySubproductSimples.add(oilSimple);
        BaseProductSimple energySimple = BaseProductSimple.builder().name("energy").build();
        AssetClassSimple commoditySimple = AssetClassSimple.builder().name("commodity").build();

        BaseProductSimple ndfSimple = BaseProductSimple.builder().name("ndf").build();
        BaseProductSimple fwdSimple = BaseProductSimple.builder().name("fwd").build();
        AssetClassSimple fxSimple = AssetClassSimple.builder().name("fx").build();


        Map<BaseProductSimple, List<SubProductSimple>> commoditySimpleBaseProducts = new HashMap<>();
        commoditySimpleBaseProducts.put(agricultureSimple, agricultureSubproductSimples);
        commoditySimpleBaseProducts.put(energySimple, energySubproductSimples );

        Map<BaseProductSimple, List<SubProductSimple>> fxSimpleBaseProducts = new HashMap<>();
        fxSimpleBaseProducts.put(ndfSimple, null);
        fxSimpleBaseProducts.put(fwdSimple, null);



        Map<AssetClassSimple, Map<BaseProductSimple, List<SubProductSimple>>> assetClassMap = new HashMap<>();
        assetClassMap.put(commoditySimple, commoditySimpleBaseProducts);
        assetClassMap.put(fxSimple, fxSimpleBaseProducts);
        try{

//            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String jsonString = objectMapper.writeValueAsString(assetClassMap);
            log.info(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    private static Staff createStaff() {
        Staff.StaffBuilder builder = Staff.builder();
        builder.name("John Adams");
        builder.age(38);
        builder.position(new String[]{"Developer", "Tech Lead", "CTC"});
        Map<String, BigDecimal> salaryMap = new HashMap();
        salaryMap.put("2010", new BigDecimal(100000));
        salaryMap.put("2011", new BigDecimal(110000));
        salaryMap.put("2012", new BigDecimal(120000));
        builder.salary(salaryMap);
        return builder
                .build();
    }
}
