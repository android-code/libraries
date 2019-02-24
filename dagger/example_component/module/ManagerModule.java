//some manager module
@Module
public class ManagerModule {

    private String url;

    public ManagerModule(String name) {
        this.url = name;
    }

    @Provides @Named("red")
    SimpleDependency provideSimpleDependencyRed() {
        SimpleDependency.Builder builder = new SimpleDependency.Builder();
        builder.setColor("red").setShape("oval");
        return builder.build();
    }

    @Provides @Named("blue")
    SimpleDependency provideSimpleDependencyBlue() {
        SimpleDependency.Builder builder = new SimpleDependency.Builder();
        builder.setColor("blue").setShape("triangle");
        return builder.build();
    }

    @Provides @Singleton
    ComplexDependency provideComplexDependency(NetworkManager networkDependency) {
        return new ComplexDependency(networkDependency);
    }

    @Provides @Singleton
    NetworkManager provideNetworkDependency() {
        return new NetworkManager(url, 80);
    }

    @Provides @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}