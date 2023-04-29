package victorpuiu.realestateapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import victorpuiu.realestateapp.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class RealEstateAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealEstateAppApplication.class, args);
    }

}
