package ru.netology.sender;

import org.testng.annotations.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.geo.GeoServiceTest;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;


public class MessageSenderTest {

    @Test
    public void testSendRussianMessage() {
        GeoService geoServiceMock = mock(GeoService.class);
        when(geoServiceMock.byIp("172.1.1.1")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationServiceMock = mock(LocalizationService.class);
        when(localizationServiceMock.locale(Country.RUSSIA)).thenReturn("Привет!");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);

        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "172.1.1.1");

        String result = messageSender.send(headers);

        assertNotNull(result);
        assertEquals("Привет!", result);
    }
}
