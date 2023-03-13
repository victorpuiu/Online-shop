package victorpuiu.realestateapp.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import victorpuiu.realestateapp.entity.Product;
import victorpuiu.realestateapp.repository.PropertyRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PropertyRepository propertyRepository;

    public DevBootstrap(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        for (int i = 0; i < 10 ; i++) {
            Product product = new Product();
            product.setDescription("des" + i);
            propertyRepository.save(product);
        }

        //lifeHook
        System.out.println("Am pornit");
    }




}