@Entity
public class ExchangeRate {
    @Id
    private String symbol; // e.g., "USD_EUR", "BTC_USD"
    private double rate;
    private LocalDateTime lastUpdated;

    // Getters and setters
}
