package victorpuiu.realestateapp.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import victorpuiu.realestateapp.entity.Property;
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
            Property property = new Property();
            property.setDescription("des" + i);
            propertyRepository.save(property);
        }

        //lifeHook
        System.out.println("Am pornit");
    }




}