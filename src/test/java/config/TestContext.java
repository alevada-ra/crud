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

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messages";

    @Bean
    public DogService dogServiceService() {
        return Mockito.mock(DogServiceImplemantation.class);
    }

    @Bean
    public DogDao dogDao() {return  Mockito.mock(DogDaoImplementation.class);}
}
