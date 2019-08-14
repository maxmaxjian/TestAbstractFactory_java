public class WeatherEndpointFactory extends EndpointFactory {

    static final ImmutableMap<DeviceStage, ImmutableMap<MarketPlace, String>> URLMap;

    static {
        ImmutableMap<MarketPlace, String> pfm_prod_map = new ImmutableMap<>()
                .put(US, US_PROD_URL)
                .put(UK, UK_PROD_URL);

        ImmutableMap<MarketPlace, String> pfm_beta_map = new ImmutableMap<>()
                .put(US, US_BETA_URL)
                .put(UK, UK_BETA_URL);


        URLMap = new ImmutableMap.Builder<DeviceStage, ImmutableMap<MarketPlace, String>>()
                .put(PROD, prod_map)
                .put(BETA, beta_map)
                .build();
    }

    private static WeatherEndpointFactory instance = null;

    private WeatherEndpointFactory() {}

    public static synchronized WeatherEndpointFactory getInstance() {
        if (instance == null)
            instance = new WeatherEndpointFactory();
        return instance;
    }

    @Override
    public String getURL() {
        return URLMap.get(mDeviceStage).get(mMarketPlace);
    }
}
