package BusinessLayer.services;

import DataAccessLayer.models.City;
import DataAccessLayer.repositories.CityRepository;

public class CityService {
    private static final CityRepository cityRepository = new CityRepository();

    public CityService() {

    }

    public static void viewAllCities() {
        for(City city : cityRepository.getCities()) {
            System.out.println("|City: " + city.getCityName());
        }
    }

    public static String getCityById(int cityId) {
        City city = CityRepository.getCityById(cityId);
        if (city != null) {
            return city.getCityName();
        }
        else {
            return "City not found";
        }
    }
}