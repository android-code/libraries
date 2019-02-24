@Singleton
@Component(modules={AppModule.class, ManagerModule.class})
public interface AppComponent {

    //remove injection methods if child performs this and no need to use only base component
    void inject(MainActivity activity);

    //methods return dependencies
    @Named("red") 
    SimpleDependency simpleDependencyRed();

    @Named("blue") 
    SimpleDependency simpleDependencyBlue();

    Application application();

    ComplexDependency complexDependency();

    NetworkManager networkManager();

    SharedPreferences sharedPreferences();
}
