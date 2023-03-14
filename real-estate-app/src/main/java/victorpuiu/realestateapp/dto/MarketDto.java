package victorpuiu.realestateapp.dto;


import lombok.Getter;
import lombok.Setter;
import victorpuiu.realestateapp.entity.MarketCategory;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MarketDto {

    private List<MarketCategory> marketCategories =  new ArrayList<>();

}
