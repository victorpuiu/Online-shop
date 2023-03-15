package victorpuiu.realestateapp.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MarketDto {

    private Long id;

    private String name;

    private List<MarketCategoryDto> marketCategories =  new ArrayList<>();

}
