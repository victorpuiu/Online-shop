package victorpuiu.realestateapp.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import victorpuiu.realestateapp.dto.MarketDto;
import victorpuiu.realestateapp.service.MarketService;
import victorpuiu.realestateapp.service.ProductService;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final MarketService marketService;
    private final ProductService productService;

    public DevBootstrap(MarketService marketService, ProductService productService) {
        this.marketService = marketService;
        this.productService = productService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        MarketDto marketDto = new MarketDto();
        marketDto.setName("Real Estate");
        marketService.saveOrEdit(marketDto);


        marketDto = new MarketDto();
        marketDto.setName("Watches");
        marketService.saveOrEdit(marketDto);

        //lifeHook
        System.out.println("Am pornit");
    }




}