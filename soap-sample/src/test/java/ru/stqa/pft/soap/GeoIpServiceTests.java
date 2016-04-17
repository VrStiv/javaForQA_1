package ru.stqa.pft.soap;/* Created by Vrstiv on 17.04.2016  */


import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("192.168.0.96");
    assertEquals(geoIP.getCountryCode(), "ZZZ");
  }

  @Test
  public void testInvalidIp(){
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("192.168.0.xxx");
    assertEquals(geoIP.getCountryCode(), "ZZZ");
  }
}
