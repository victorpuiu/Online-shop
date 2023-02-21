package victorpuiu.realestateapp.entity;

public enum PropertyType {
    DETACHED("Detached"),
    SEMI_DETACHED("Semi-detached"),
    VILLA("Villa"),
    APARTMENT("Apartment"),
    ROOM("Room"),
    LAND("Land");


    private String value;

    PropertyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PropertyType fromValue(final String value) {
        for (final PropertyType type : PropertyType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
    }



}

















