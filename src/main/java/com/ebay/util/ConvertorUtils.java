package com.ebay.util;

import com.ebay.model.SkuFinal;

import java.text.ParseException;


public class ConvertorUtils {

    public static SkuFinal parseArgs2SkuFinalFeed (String[] dataLine) throws ParseException {
        SkuFinal skuFinalFeed = new SkuFinal();
        skuFinalFeed.setStartDate(DateUtil.parseSimpleDate(dataLine[0]));
        skuFinalFeed.setEndDate(DateUtil.parseSimpleDate(dataLine[1]));
        skuFinalFeed.setMetaId(dataLine[2]);
        skuFinalFeed.setLv2Id(dataLine[3]);
        skuFinalFeed.setLv3Id(dataLine[4]);
        skuFinalFeed.setLv4Id(dataLine[5]);
        skuFinalFeed.setSkuId(dataLine[6]);
        skuFinalFeed.setSkuKeyWord(dataLine[7]);
        skuFinalFeed.setBrand(dataLine[8]);
        skuFinalFeed.setSiteId(dataLine[9]);
        skuFinalFeed.setLv3SoldItem(dataLine[10]);
        skuFinalFeed.setLv3Gmv(dataLine[11]);
        skuFinalFeed.setLv3LiveListing(dataLine[12]);
        skuFinalFeed.setSkuSoldItemPct(dataLine[13]);
        skuFinalFeed.setSkuGmvPct(dataLine[14]);
        skuFinalFeed.setSkuLiveListingPct(dataLine[15]);
        skuFinalFeed.setDemandSupplyRatio(dataLine[16]);
        skuFinalFeed.setSoldItemTotal(dataLine[17]);
        skuFinalFeed.setSoldItemCm(dataLine[18]);
        skuFinalFeed.setSoldItemP1m(dataLine[19]);
        skuFinalFeed.setSoldItemP2m(dataLine[20]);
        skuFinalFeed.setSoldItemP3m(dataLine[21]);
        skuFinalFeed.setGmvTotal(dataLine[22]);
        skuFinalFeed.setGmvCm(dataLine[23]);
        skuFinalFeed.setGmvP1m(dataLine[24]);
        skuFinalFeed.setGmvP2m(dataLine[25]);
        skuFinalFeed.setGmvP3m(dataLine[26]);
        skuFinalFeed.setLiveListingTotal(dataLine[27]);
        skuFinalFeed.setLiveListingCount(dataLine[28]);
        skuFinalFeed.setLiveListingCm(dataLine[29]);
        skuFinalFeed.setLiveListingP1m(dataLine[30]);
        skuFinalFeed.setLiveListingP2m(dataLine[31]);
        skuFinalFeed.setLiveListingP3m(dataLine[32]);
        skuFinalFeed.setTransTotal(dataLine[33]);
        skuFinalFeed.setTransCm(dataLine[34]);
        skuFinalFeed.setTransP1m(dataLine[35]);
        skuFinalFeed.setTransP2m(dataLine[36]);
        skuFinalFeed.setTransP3m(dataLine[37]);
        skuFinalFeed.setAspTotal(dataLine[38]);
        skuFinalFeed.setAspCm(dataLine[39]);
        skuFinalFeed.setAspP1m(dataLine[40]);
        skuFinalFeed.setAspP2m(dataLine[41]);
        skuFinalFeed.setAspP3m(dataLine[42]);
        skuFinalFeed.setSrpTotal(dataLine[43]);
        skuFinalFeed.setSrpCm(dataLine[44]);
        skuFinalFeed.setSrpP1m(dataLine[45]);
        skuFinalFeed.setSrpP2m(dataLine[46]);
        skuFinalFeed.setSrpP3m(dataLine[47]);
        skuFinalFeed.setViTotal(dataLine[48]);
        skuFinalFeed.setViCm(dataLine[49]);
        skuFinalFeed.setViP1m(dataLine[50]);
        skuFinalFeed.setViP2m(dataLine[51]);
        skuFinalFeed.setViP3m(dataLine[52]);
        skuFinalFeed.setGcSellerSoldItemPct(dataLine[53]);
        skuFinalFeed.setGcSellerGmvPct(dataLine[54]);
        skuFinalFeed.setGcSellerLiveListingPct(dataLine[55]);
        skuFinalFeed.setQualityDefectRate(dataLine[56]);
        skuFinalFeed.setNshtmDefectRate(dataLine[57]);
        skuFinalFeed.setShtmDefectRate(dataLine[58]);
        skuFinalFeed.setDomesticBuyerSoldItemPct(dataLine[59]);
        skuFinalFeed.setDailyDealSoldItemPct(dataLine[60]);
        skuFinalFeed.setFixedPriceSoldItemPct(dataLine[61]);
        skuFinalFeed.setAuctionSoldItemPct(dataLine[62]);
        skuFinalFeed.setFreeShippingSoldItemPct(dataLine[63]);
        skuFinalFeed.setShippingCostChargedToBuyer(dataLine[64]);
        skuFinalFeed.setShippingGcSeller1(dataLine[65]);
        skuFinalFeed.setShippingDomesticSeller1(dataLine[66]);
        skuFinalFeed.setShippingGcSeller2(dataLine[67]);
        skuFinalFeed.setShippingDomesticSeller2(dataLine[68]);
        skuFinalFeed.setShippingGcSeller3(dataLine[69]);
        skuFinalFeed.setShippingDomesticSeller3(dataLine[70]);
        skuFinalFeed.setShippingGcSeller1Pct(dataLine[71]);
        skuFinalFeed.setShippingDomesticSeller1Pct(dataLine[72]);
        skuFinalFeed.setShippingGcSeller2Pct(dataLine[73]);
        skuFinalFeed.setShippingDomesticSeller2Pct(dataLine[74]);
        skuFinalFeed.setShippingGcSeller3Pct(dataLine[75]);
        skuFinalFeed.setShippingDomesticSeller3Pct(dataLine[76]);
        skuFinalFeed.setSampleItem(dataLine[77]);
        skuFinalFeed.setTraitSequence11(dataLine[78]);
        skuFinalFeed.setTraitSequence12(dataLine[79]);
        skuFinalFeed.setTraitSequence13(dataLine[80]);
        skuFinalFeed.setTraitSequence21(dataLine[81]);
        skuFinalFeed.setTraitSequence22(dataLine[82]);
        skuFinalFeed.setTraitSequence23(dataLine[83]);
        skuFinalFeed.setTraitSequence31(dataLine[84]);
        skuFinalFeed.setTraitSequence32(dataLine[85]);
        skuFinalFeed.setTraitSequence33(dataLine[86]);
        skuFinalFeed.setTagSequence11(dataLine[87]);
        skuFinalFeed.setTagSequence12(dataLine[88]);
        skuFinalFeed.setTagSequence13(dataLine[89]);
        skuFinalFeed.setTagSequence21(dataLine[90]);
        skuFinalFeed.setTagSequence22(dataLine[91]);
        skuFinalFeed.setTagSequence23(dataLine[92]);
        skuFinalFeed.setTagSequence31(dataLine[93]);
        skuFinalFeed.setTagSequence32(dataLine[94]);
        skuFinalFeed.setTagSequence33(dataLine[95]);
        skuFinalFeed.setSellerCnt(dataLine[96]);
        skuFinalFeed.setB2cSellerCnt(dataLine[97]);
        skuFinalFeed.setB2CUserRate(dataLine[98]);
        skuFinalFeed.setTop1SlrProfile(dataLine[99]);
        skuFinalFeed.setTop2SlrProfile(dataLine[100]);
        skuFinalFeed.setTop3SlrProfile(dataLine[101]);

        return skuFinalFeed;
    }
}
