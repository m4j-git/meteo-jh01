package ru.m4j.meteo.jh01;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ru.m4j.meteo.jh01");

        noClasses()
            .that()
            .resideInAnyPackage("ru.m4j.meteo.jh01.service..")
            .or()
            .resideInAnyPackage("ru.m4j.meteo.jh01.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..ru.m4j.meteo.jh01.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
