
package com.zomla.zomlaapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("offer")
    @Expose
    private Offer_ offer;

    public Offer_ getOffer() {
        return offer;
    }

    public void setOffer(Offer_ offer) {
        this.offer = offer;
    }

}
