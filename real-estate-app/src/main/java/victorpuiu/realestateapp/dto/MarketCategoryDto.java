package victorpuiu.realestateapp.dto;

import lombok.Getter;
import lombok.Setter;
import victorpuiu.realestateapp.model.ProductType;

import java.util.List;


@Getter
@Setter
public class MarketCategoryDto {

    public Long id;

    private Long marketId;

    private String name;

    private String imageUrl;

    private String redirectLink;

    private List<ProductType> productTypes; // private List<ProductTypeEntityDto> productTypes;




//    private List<ProductDto> products = new ArrayList<>();


}
