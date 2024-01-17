package BusinessLayer.services;

import DataAccessLayer.repositories.PriceRepository;

public class PriceService {
    private final PriceRepository priceRepository = new PriceRepository();
    public PriceService() {

    }

    public void createPrice(double price) {
        priceRepository.createPrice(price);
    }
}