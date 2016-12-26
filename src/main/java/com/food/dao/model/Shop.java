package com.food.dao.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.food.model.ShopModel;

import java.math.BigDecimal;

public class Shop implements Comparable {
    private Long id;

    private String name;

    private String address;

    private String shopHours;

    private Integer consumptionPerPerson;

    private Float environmentalScience;

    private Float service;

    @JSONField(name = "lat", serialzeFeatures = {SerializerFeature.WriteMapNullValue})
    private BigDecimal lat;

    @JSONField(name = "lng", serialzeFeatures = {SerializerFeature.WriteMapNullValue})
    private BigDecimal lng;

    private Float flavor;

    @JSONField(name = "tel", serialzeFeatures = {SerializerFeature.WriteMapNullValue})
    private String tel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getShopHours() {
        return shopHours;
    }

    public void setShopHours(String shopHours) {
        this.shopHours = shopHours == null ? null : shopHours.trim();
    }

    public Integer getConsumptionPerPerson() {
        return consumptionPerPerson;
    }

    public void setConsumptionPerPerson(Integer consumptionPerPerson) {
        this.consumptionPerPerson = consumptionPerPerson;
    }

    public Float getEnvironmentalScience() {
        return environmentalScience;
    }

    public void setEnvironmentalScience(Float environmentalScience) {
        this.environmentalScience = environmentalScience;
    }

    public Float getService() {
        return service;
    }

    public void setService(Float service) {
        this.service = service;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public Float getFlavor() {
        return flavor;
    }

    public void setFlavor(Float flavor) {
        this.flavor = flavor;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 静态工厂 返回新的实例
     *
     * @param shopModel
     * @return
     */
    public static Shop getNewInstance(ShopModel shopModel) {

        Shop shop = new Shop();
        shop.setShopHours(shopModel.getShopHours());
        shop.setAddress(shopModel.getAddress());
        shop.setConsumptionPerPerson(shopModel.getConsumptionPerPerson());
        shop.setEnvironmentalScience(shopModel.getEnvironmentalScience());
        shop.setFlavor(shopModel.getFlavor());
        shop.setLat(shopModel.getPoint().getLatitude());
        shop.setLng(shopModel.getPoint().getLongitude());
        shop.setName(shopModel.getName());
        shop.setService(shopModel.getService());
        shop.setTel(shopModel.getTels().get(0));

        return shop;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Shop)) {
            return -1;
        }

        Shop shop = (Shop) o;
        if (this.getName().equals(shop.getName())
                && this.getLng().compareTo(shop.getLng()) == 0
                && this.getLat().compareTo(shop.getLat()) == 0) {
            return 0;
        }

        return -1;
    }
}