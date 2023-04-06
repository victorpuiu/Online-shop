package victorpuiu.realestateapp.model;


/**
 * Define the level of permission user has
 */
public enum PermissionLevel {

    ADMIN("ADMIN"),
    MODERATOR("MODERATOR"),

    USER("USER");

    private String value;


    PermissionLevel(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }



    public static PermissionLevel fromValue(final String value){
        for (final PermissionLevel type: PermissionLevel.values()){
            if (type.getValue().equals(value)){
                return type;
            }
        }

        throw new IllegalArgumentException("No matching constant for ["+ value + "]");
    }

}

















