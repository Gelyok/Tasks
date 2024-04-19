package ru.netology.geo;

import org.testng.annotations.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.testng.AssertJUnit.assertEquals;

public class GeoServiceImplTest {

    @Test
    public void testByIp_RussianIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location location = geoService.byIp("172.1.1.1");

        assertEquals(Country.RUSSIA, location.getCountry());
    }
}