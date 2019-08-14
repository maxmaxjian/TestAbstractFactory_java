public abstract class EndpointFactory {

    public enum MarketPlace {
        US, UK, DE
    }

    public enum DeviceStage {
        ALPHA, BETA, GAMMA, PROD
    }

    protected MarketPlace mMarketPlace;
    protected DeviceStage mDeviceStage;

    public EndpointFactory getFactory(String factoryType) {
        if (factoryType.equals("WEATHER")) {
            return WeatherEndpointFactory.getInstance();
        } else if (factoryType.equals("AHS")) {
            return AHSEndpointFactory.getInstance();
        }
    }

    public abstract String getURL();
}
