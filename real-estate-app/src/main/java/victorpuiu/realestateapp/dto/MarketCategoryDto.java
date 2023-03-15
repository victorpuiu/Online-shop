package victorpuiu.realestateapp.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MarketCategoryDto {

    public Long id;
    private Long marketId;

    private String name;

    private String imageUrl;

    private String redirectLink;


//    private List<ProductDto> products = new ArrayList<>();


}
