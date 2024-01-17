package DataAccessLayer.models;

public class Ticket {

    private int ticketId;
    private String passengerFirstName;
    private String passengerLastName;
    private int arrivalCityId;
    private int departureCityId;
    private int accountId;
    private int priceId;

    public Ticket() {

    }
    public Ticket(String passengerFirstName, String passengerLastName, int arrivalCityId, int departureCityId, int accountId, int priceId) {
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.arrivalCityId = arrivalCityId;
        this.departureCityId = departureCityId;
        this.accountId = accountId;
        this.priceId = priceId;
    }

    public Ticket(int ticketId, String passengerFirstName, String passengerLastName, int arrivalCityId, int departureCityId, int accountId, int priceId) {
        this.ticketId = ticketId;
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.arrivalCityId = arrivalCityId;
        this.departureCityId = departureCityId;
        this.accountId = accountId;
        this.priceId = priceId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public int getArrivalCityId() {
        return arrivalCityId;
    }

    public void setArrivalCityId(int arrivalCityId) {
        this.arrivalCityId = arrivalCityId;
    }

    public int getDepartureCityId() {
        return departureCityId;
    }

    public void setDepartureCityId(int departureCityId) {
        this.departureCityId = departureCityId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }
}