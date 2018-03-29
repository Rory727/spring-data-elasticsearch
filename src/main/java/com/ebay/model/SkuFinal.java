package com.ebay.model;

import com.ebay.constants.EsConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Created by ruirli on 2018/3/29.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName =  EsConstant.PRODUCT_INDEX_NAME, type = EsConstant.PRODUCT_INDEX_TYPE,shards = EsConstant.PRIMARY_SHARDS,replicas = EsConstant.REPLICAS_SHARD)
public class SkuFinal {
    @Id
    @Field(type = FieldType.Long)
    private long id;
    @Field(type = FieldType.Date)
    private Date startDate;
    @Field(type = FieldType.Date)
    private Date endDate;
    @Field(type = FieldType.text)
    private String metaId;
    @Field(type = FieldType.text)
    private String lv2Id;
    @Field(type = FieldType.text)
    private String lv3Id;
    @Field(type = FieldType.text)
    private String lv4Id;
    @Field(type = FieldType.text)
    private String skuId;
    @Field(type = FieldType.keyword)
    private String skuKeyWord;
    @Field(type = FieldType.text)
    private String brand;
    @Field(type = FieldType.text)
    private String siteId;
    @Field(type = FieldType.text)
    private String lv3SoldItem;
    @Field(type = FieldType.text)
    private String lv3Gmv;
    @Field(type = FieldType.text)
    private String lv3LiveListing;
    @Field(type = FieldType.text)
    private String skuSoldItemPct;
    @Field(type = FieldType.text)
    private String skuGmvPct;
    @Field(type = FieldType.text)
    private String skuLiveListingPct;
    @Field(type = FieldType.text)
    private String demandSupplyRatio;
    @Field(type = FieldType.text)
    private String soldItemTotal;
    @Field(type = FieldType.text)
    private String soldItemCm;
    @Field(type = FieldType.text)
    private String soldItemP1m;
    @Field(type = FieldType.text)
    private String soldItemP2m;
    @Field(type = FieldType.text)
    private String soldItemP3m;
    @Field(type = FieldType.text)
    private String gmvTotal;
    @Field(type = FieldType.text)
    private String gmvCm;
    @Field(type = FieldType.text)
    private String gmvP1m;
    @Field(type = FieldType.text)
    private String gmvP2m;
    @Field(type = FieldType.text)
    private String gmvP3m;
    @Field(type = FieldType.text)
    private String liveListingTotal;
    @Field(type = FieldType.text)
    private String liveListingCount;
    @Field(type = FieldType.text)
    private String liveListingCm;
    @Field(type = FieldType.text)
    private String liveListingP1m;
    @Field(type = FieldType.text)
    private String liveListingP2m;
    @Field(type = FieldType.text)
    private String liveListingP3m;
    @Field(type = FieldType.text)
    private String transTotal;
    @Field(type = FieldType.text)
    private String transCm;
    @Field(type = FieldType.text)
    private String transP1m;
    @Field(type = FieldType.text)
    private String transP2m;
    @Field(type = FieldType.text)
    private String transP3m;
    @Field(type = FieldType.text)
    private String aspTotal;
    @Field(type = FieldType.text)
    private String aspCm;
    @Field(type = FieldType.text)
    private String aspP1m;
    @Field(type = FieldType.text)
    private String aspP2m;
    @Field(type = FieldType.text)
    private String aspP3m;
    @Field(type = FieldType.text)
    private String srpTotal;
    @Field(type = FieldType.text)
    private String srpCm;
    @Field(type = FieldType.text)
    private String srpP1m;
    @Field(type = FieldType.text)
    private String srpP2m;
    @Field(type = FieldType.text)
    private String srpP3m;
    @Field(type = FieldType.text)
    private String viTotal;
    @Field(type = FieldType.text)
    private String viCm;
    @Field(type = FieldType.text)
    private String viP1m;
    @Field(type = FieldType.text)
    private String viP2m;
    @Field(type = FieldType.text)
    private String viP3m;
    @Field(type = FieldType.text)
    private String gcSellerSoldItemPct;
    @Field(type = FieldType.text)
    private String gcSellerGmvPct;
    @Field(type = FieldType.text)
    private String gcSellerLiveListingPct;
    @Field(type = FieldType.text)
    private String qualityDefectRate;
    @Field(type = FieldType.text)
    private String nshtmDefectRate;
    @Field(type = FieldType.text)
    private String shtmDefectRate;
    @Field(type = FieldType.text)
    private String domesticBuyerSoldItemPct;
    @Field(type = FieldType.text)
    private String dailyDealSoldItemPct;
    @Field(type = FieldType.text)
    private String fixedPriceSoldItemPct;
    @Field(type = FieldType.text)
    private String auctionSoldItemPct;
    @Field(type = FieldType.text)
    private String freeShippingSoldItemPct;
    @Field(type = FieldType.text)
    private String shippingCostChargedToBuyer;
    @Field(type = FieldType.text)
    private String shippingGcSeller1;
    @Field(type = FieldType.text)
    private String shippingDomesticSeller1;
    @Field(type = FieldType.text)
    private String shippingGcSeller2;
    @Field(type = FieldType.text)
    private String shippingDomesticSeller2;
    @Field(type = FieldType.text)
    private String shippingGcSeller3;
    @Field(type = FieldType.text)
    private String shippingDomesticSeller3;
    @Field(type = FieldType.text)
    private String shippingGcSeller1Pct;
    @Field(type = FieldType.text)
    private String shippingDomesticSeller1Pct;
    @Field(type = FieldType.text)
    private String shippingGcSeller2Pct;
    @Field(type = FieldType.text)
    private String shippingDomesticSeller2Pct;
    @Field(type = FieldType.text)
    private String shippingGcSeller3Pct;
    @Field(type = FieldType.text)
    private String shippingDomesticSeller3Pct;
    @Field(type = FieldType.text)
    private String sampleItem;
    @Field(type = FieldType.text)
    private String traitSequence11;
    @Field(type = FieldType.text)
    private String traitSequence12;
    @Field(type = FieldType.text)
    private String traitSequence13;
    @Field(type = FieldType.text)
    private String traitSequence21;
    @Field(type = FieldType.text)
    private String traitSequence22;
    @Field(type = FieldType.text)
    private String traitSequence23;
    @Field(type = FieldType.text)
    private String traitSequence31;
    @Field(type = FieldType.text)
    private String traitSequence32;
    @Field(type = FieldType.text)
    private String traitSequence33;
    @Field(type = FieldType.text)
    private String tagSequence11;
    @Field(type = FieldType.text)
    private String tagSequence12;
    @Field(type = FieldType.text)
    private String tagSequence13;
    @Field(type = FieldType.text)
    private String tagSequence21;
    @Field(type = FieldType.text)
    private String tagSequence22;
    @Field(type = FieldType.text)
    private String tagSequence23;
    @Field(type = FieldType.text)
    private String tagSequence31;
    @Field(type = FieldType.text)
    private String tagSequence32;
    @Field(type = FieldType.text)
    private String tagSequence33;
    @Field(type = FieldType.text)
    private String sellerCnt;
    @Field(type = FieldType.text)
    private String b2cSellerCnt;
    @Field(type = FieldType.text)
    private String B2CUserRate;
    @Field(type = FieldType.text)
    private String top1SlrProfile;
    @Field(type = FieldType.text)
    private String top2SlrProfile;
    @Field(type = FieldType.text)
    private String top3SlrProfile;
}
