@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository repository;

    @Value("${external.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public double convert(String from, String to, double amount) {
        String symbol = from + "_" + to;
        ExchangeRate rate = repository.findById(symbol).orElseGet(() -> fetchAndCacheRate(symbol));
        return amount * rate.getRate();
    }

    public ExchangeRate fetchAndCacheRate(String symbol) {
        String url = apiUrl + "/latest?symbol=" + symbol;
        ResponseEntity<Map<String, Object>> response = restTemplate.getForEntity(url, Map.class);

        double rateValue = Double.parseDouble(response.getBody().get("rate").toString());
        ExchangeRate rate = new ExchangeRate();
        rate.setSymbol(symbol);
        rate.setRate(rateValue);
        rate.setLastUpdated(LocalDateTime.now());
        repository.save(rate);
        return rate;
    }

    public List<ExchangeRate> getAllRates() {
        return repository.findAll();
    }

    public void refreshCache() {
        repository.findAll().forEach(rate -> fetchAndCacheRate(rate.getSymbol()));
    }
}
