package ru.netology.i18n;


import org.testng.annotations.Test;
import ru.netology.entity.Country;

import static org.testng.AssertJUnit.assertEquals;

public class LocalizationServiceTest {

    @Test
    public void testLocale_RussianCountry() {

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String localizedText = localizationService.locale(Country.RUSSIA);

        assertEquals("Добро пожаловать", localizedText);
    }
}
