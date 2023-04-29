package victorpuiu.realestateapp.model;


/**
 * Define the level of permission user has
 */
public enum Role {

    ADMIN("ADMIN"),
    MODERATOR("MODERATOR"),

    USER("USER");

    private String value;


    Role(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }



    public static Role fromValue(final String value){
        for (final Role type: Role.values()){
            if (type.getValue().equals(value)){
                return type;
            }
        }

        throw new IllegalArgumentException("No matching constant for ["+ value + "]");
    }

}

















