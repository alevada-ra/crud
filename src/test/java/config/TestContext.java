package config;

import dogsmanager.dao.DogDao;
import dogsmanager.dao.DogDaoImplementation;
import dogsmanager.service.DogService;
import dogsmanager.service.DogServiceImplemantation;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestContext {
    @Bean
    public DogService dogServiceService() {
        return Mockito.mock(DogServiceImplemantation.class);
    }

    @Bean
    public DogDao dogDao() {
        return  Mockito.mock(DogDaoImplementation.class);
    }
}
