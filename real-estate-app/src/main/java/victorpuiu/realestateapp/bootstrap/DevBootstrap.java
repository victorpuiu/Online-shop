package victorpuiu.realestateapp.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import victorpuiu.realestateapp.dto.AddressDto;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.dto.MarketDto;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.entity.AdvertisementType;
import victorpuiu.realestateapp.entity.ProductType;
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

        MarketDto realEstateMarket = new MarketDto();
        realEstateMarket.setName("Real Estate");
        realEstateMarket =  marketService.saveOrEdit(realEstateMarket);

        MarketDto watchesMarket = new MarketDto();
        watchesMarket.setName("Watches");
        watchesMarket = marketService.saveOrEdit(watchesMarket);

        MarketCategoryDto residential = new MarketCategoryDto();
        residential.setName("Residential");
        residential.setImageUrl("https://fastly.picsum.photos/id/49/1280/792.jpg?hmac=NnUJy0O9-pXHLmY2loqVs2pJmgw9xzuixgYOk4ALCXU");
        residential.setRedirectLink("/residential");
        residential.setMarketId(realEstateMarket.getId());
        residential = marketCategoryService.saveOrEdit(residential);

        MarketCategoryDto commercial = new MarketCategoryDto();
        commercial.setName("Commercial");
        commercial.setImageUrl("https://fastly.picsum.photos/id/43/1280/831.jpg?hmac=glK-rQ0ppFClW-lvjk9FqEWKog07XkOxJf6Xg_cU9LI");
        commercial.setRedirectLink("/commercial");
        commercial.setMarketId(realEstateMarket.getId());
        commercial = marketCategoryService.saveOrEdit(commercial);

        MarketCategoryDto land = new MarketCategoryDto();
        land.setName("Land");
        land.setImageUrl("https://fastly.picsum.photos/id/46/3264/2448.jpg?hmac=ZHE8nk-Q9uRp4MxgKNvN7V7pYFvA-9BCv99ltY3HBv4");
        land.setRedirectLink("/land");
        land.setMarketId(realEstateMarket.getId());
        land = marketCategoryService.saveOrEdit(land);


        ProductDto productDto = new ProductDto();
        productDto.setPropertyType(ProductType.APARTMENT);
        productDto.setDescription("A beautiful apartment in the heart of the city");
        productDto.setPrice(200000);
        productDto.setMarketCategoryDto(residential);// ???????

        AddressDto addressDto = new AddressDto();
        addressDto.setCity("New York");
        addressDto.setStreet("Fifth Avenue");
        addressDto.setZipcode("10001");

        productDto.setAddress(addressDto);
        productDto.setAdvertisementType(AdvertisementType.SALE);
        productDto = productService.saveOrEdit(productDto);


        //lifeHook
        System.out.println("Am pornit");
    }




}