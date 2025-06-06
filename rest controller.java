@RestController
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeRateService service;

    @GetMapping("/convert")
    public ResponseEntity<Double> convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {
        return ResponseEntity.ok(service.convert(from, to, amount));
    }

    @GetMapping("/rates")
    public ResponseEntity<List<ExchangeRate>> getRates() {
        return ResponseEntity.ok(service.getAllRates());
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshCache() {
        service.refreshCache();
        return ResponseEntity.ok("Cache refreshed");
    }
}
