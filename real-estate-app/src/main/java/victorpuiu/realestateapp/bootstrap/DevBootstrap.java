package victorpuiu.realestateapp.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import victorpuiu.realestateapp.dto.*;
import victorpuiu.realestateapp.model.AdvertisementType;
import victorpuiu.realestateapp.model.ProductType;
import victorpuiu.realestateapp.repository.UserRepository;
import victorpuiu.realestateapp.service.MarketCategoryService;
import victorpuiu.realestateapp.service.MarketService;
import victorpuiu.realestateapp.service.ProductService;
import victorpuiu.realestateapp.service.UserService;

import java.util.Arrays;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final MarketService marketService;

    private final MarketCategoryService marketCategoryService;
    private final ProductService productService;

    private final UserService userService;
    private final UserRepository userRepository;


    public DevBootstrap(
            MarketService marketService,
            MarketCategoryService marketCategoryService,
            ProductService productService,
            UserService userService,
            UserRepository userRepository) {
        this.marketService = marketService;
        this.marketCategoryService = marketCategoryService;
        this.productService = productService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        MarketDto realEstateMarket = new MarketDto();
        realEstateMarket.setName("real-estate");
        realEstateMarket.setMarketImageUrl("https://fastly.picsum.photos/id/49/1280/792.jpg?hmac=NnUJy0O9-pXHLmY2loqVs2pJmgw9xzuixgYOk4ALCXU");

        realEstateMarket =  marketService.saveOrEdit(realEstateMarket);

        MarketDto watchesMarket = new MarketDto();
        watchesMarket.setName("Watches");
        watchesMarket.setMarketImageUrl("https://images.unsplash.com/photo-1619976396248-56d05beb2919?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1064&q=80");

        watchesMarket = marketService.saveOrEdit(watchesMarket);

        MarketCategoryDto residential = new MarketCategoryDto();
        residential.setName("Residential");
        residential.setImageUrl("https://fastly.picsum.photos/id/49/1280/792.jpg?hmac=NnUJy0O9-pXHLmY2loqVs2pJmgw9xzuixgYOk4ALCXU");
        residential.setRedirectLink("/residential");
        residential.setMarketId(realEstateMarket.getId());
        residential.setProductTypes(Arrays.asList(ProductType.APARTMENT, ProductType.HOUSE));
        residential = marketCategoryService.saveOrEdit(residential);

        MarketCategoryDto commercial = new MarketCategoryDto();
        commercial.setName("Commercial");
        commercial.setImageUrl("https://fastly.picsum.photos/id/43/1280/831.jpg?hmac=glK-rQ0ppFClW-lvjk9FqEWKog07XkOxJf6Xg_cU9LI");
        commercial.setRedirectLink("/commercial");
        commercial.setMarketId(realEstateMarket.getId());
        commercial.setProductTypes(Arrays.asList(ProductType.OFFICE_SPACE, ProductType.WAREHOUSE));
        commercial = marketCategoryService.saveOrEdit(commercial);

        MarketCategoryDto land = new MarketCategoryDto();
        land.setName("Land");
        land.setImageUrl("https://fastly.picsum.photos/id/46/3264/2448.jpg?hmac=ZHE8nk-Q9uRp4MxgKNvN7V7pYFvA-9BCv99ltY3HBv4");
        land.setRedirectLink("/land");
        land.setMarketId(realEstateMarket.getId());

        land = marketCategoryService.saveOrEdit(land);


        MarketCategoryDto men = new MarketCategoryDto();
        men.setName("Men's watches");
        men.setImageUrl("https://unsplash.com/photos/LWPPpkn6NEQ");
        men.setRedirectLink("/");
        men.setMarketId(watchesMarket.getId());
        men = marketCategoryService.saveOrEdit(men);


//        User user1 = new User();
//        user1.setUsername("dan");
//        user1.setPassword("1234");
//        user1.setEmail("joe@black.com");
//        userRepository.save(user1);

        UserDto user = new UserDto();
        UserRegistrationRequest user1 = new UserRegistrationRequest();
        user1.setUsername("dan");
        user1.setPassword("1234");
        user1.setEmail("joe@black.com");
        user = userService.createUser(user1);


        ProductDto house1 = new ProductDto();
        house1.setPropertyType(ProductType.HOUSE);
        house1.setDescription("A beautiful house1 in the heart of the city");
        house1.setPrice(500000);
        house1.setMarketCategoryDto(residential);// ???????
        AddressDto address1 = new AddressDto();
        address1.setCity("New York");
        address1.setStreet("Fifth Avenue");
        address1.setZipcode("10001");
        house1.setAddress(address1);
        house1.setAdvertisementType(AdvertisementType.SALE);
        house1.setImage("https://images.unsplash.com/photo-1600585154340-be6161a56a0c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
        house1.setUser(user); //???
        house1 = productService.saveOrEdit(house1);


        ProductDto house2 = new ProductDto();
        house2.setPropertyType(ProductType.HOUSE);
        house2.setDescription("A beautiful house2 in the heart of the city");
        house2.setPrice(550000);
        house2.setMarketCategoryDto(residential);// ???????
        AddressDto address2 = new AddressDto();
        address2.setCity("Florida");
        address2.setStreet("Two Avenue");
        address2.setZipcode("5001");
        house2.setAddress(address2);
        house2.setAdvertisementType(AdvertisementType.SALE);
        house2.setImage("https://images.unsplash.com/photo-1588880331179-bc9b93a8cb5e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fGx1eGVyeSUyMGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
        house2.setUser(user);
        house2 = productService.saveOrEdit(house2);

        ProductDto house3 = new ProductDto();
        house3.setPropertyType(ProductType.HOUSE);
        house3.setDescription("A beautiful house3 in the heart of the city");
        house3.setPrice(575000);
        house3.setMarketCategoryDto(residential);// ???????
        AddressDto address3 = new AddressDto();
        address3.setCity("Kansas");
        address3.setStreet("Three Avenue");
        address3.setZipcode("4637");
        house3.setAddress(address3);
        house3.setAdvertisementType(AdvertisementType.SALE);
        house3.setImage("https://images.unsplash.com/photo-1549517045-bc93de075e53?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8aG91c2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60");
        house3.setUser(user);
        house3 = productService.saveOrEdit(house3);

        ProductDto house4 = new ProductDto();
        house4.setPropertyType(ProductType.HOUSE);
        house4.setDescription("A beautiful house4 in the heart of the city");
        house4.setPrice(1000000);
        house4.setMarketCategoryDto(residential);// ???????
        AddressDto address4 = new AddressDto();
        address4.setCity("Nevada");
        address4.setStreet("For Avenue");
        address4.setZipcode("7684");
        house4.setAddress(address4);
        house4.setAdvertisementType(AdvertisementType.SALE);
        house4.setImage("https://images.unsplash.com/photo-1564013799919-ab600027ffc6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8aG91c2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60");
        house4.setUser(user);
        house4 = productService.saveOrEdit(house4);

        ProductDto house5 = new ProductDto();
        house5.setPropertyType(ProductType.HOUSE);
        house5.setDescription("A beautiful house5 in the heart of the city");
        house5.setPrice(700000);
        house5.setMarketCategoryDto(residential);// ???????
        AddressDto address5 = new AddressDto();
        address5.setCity("Texas");
        address5.setStreet("Five Avenue");
        address5.setZipcode("8694");
        house5.setAddress(address5);
        house5.setAdvertisementType(AdvertisementType.SALE);
        house5.setImage("https://images.unsplash.com/photo-1512917774080-9991f1c4c750?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8aG91c2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60");
        house5.setUser(user);
        house5 = productService.saveOrEdit(house5);


        //lifeHook
        System.out.println("Am pornit");
    }




}