package victorpuiu.realestateapp.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.dto.MarketDto;
import victorpuiu.realestateapp.service.MarketCategoryService;
import victorpuiu.realestateapp.service.MarketService;
import victorpuiu.realestateapp.service.ProductService;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final MarketService marketService;

    private final MarketCategoryService marketCategoryService;
    private final ProductService productService;

    public DevBootstrap(
            MarketService marketService,
            MarketCategoryService marketCategoryService,
            ProductService productService) {
        this.marketService = marketService;
        this.marketCategoryService = marketCategoryService;
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


        MarketCategoryDto marketCategoryDto = new MarketCategoryDto();
        marketCategoryDto.setName("Residential");
        marketCategoryDto.setImageUrl("https://fastly.picsum.photos/id/49/1280/792.jpg?hmac=NnUJy0O9-pXHLmY2loqVs2pJmgw9xzuixgYOk4ALCXU");
        marketCategoryDto.setRedirectLink("/residential");
        marketCategoryService.saveOrEdit(marketCategoryDto);

//        marketCategoryDto = new MarketCategoryDto();
//        marketCategoryDto.setName("Commercial");
//        marketCategoryDto.setImageUrl("https://fastly.picsum.photos/id/43/1280/831.jpg?hmac=glK-rQ0ppFClW-lvjk9FqEWKog07XkOxJf6Xg_cU9LI");
//        marketCategoryDto.setRedirectLink("/commercial");
//        marketCategoryService.saveOrEdit(marketCategoryDto);



        //lifeHook
        System.out.println("Am pornit");
    }




}