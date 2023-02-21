package victorpuiu.realestateapp.entity;

/**
 * Determine if the advertisement is for rent or for sale
 */
public enum AdvertisementType {

    SALE("SALE"),
    RENT("RENT");


    private String value;


    AdvertisementType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AdvertisementType fromValue(final String value){
        for (AdvertisementType type : AdvertisementType.values()) {
            if (type.getValue().equals(value)){
                return type;
            }
        }
        throw new  IllegalArgumentException("No matching constant for [" + value + "]");
    }

}











