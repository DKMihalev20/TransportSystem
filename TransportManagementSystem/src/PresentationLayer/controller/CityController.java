package PresentationLayer.controller;

import BusinessLayer.services.CityService;
import PresentationLayer.menus.ServicesMenu;
import PresentationLayer.menus.TicketMenu;

public class CityController {
    private final CityService cityService = new CityService();

    public CityController() {

    }

    public void getServicesMenu() {
        ServicesMenu.servicesMenu();
    }

    public void getTicketMenu() {
        TicketMenu.ticketMenu();
    }

    public void viewAllCities() {
        cityService.viewAllCities();
    }
}