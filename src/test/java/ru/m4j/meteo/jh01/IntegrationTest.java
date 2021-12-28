package ru.m4j.meteo.jh01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import ru.m4j.meteo.jh01.Jh01App;
import ru.m4j.meteo.jh01.RedisTestContainerExtension;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = Jh01App.class)
@ExtendWith(RedisTestContainerExtension.class)
public @interface IntegrationTest {
}
