@Singleton
@Component(modules = {AppModule.class, ManagerModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
    //add more inject methods for activity, fragment or service
    //Dagger relies on strongly typed classes so do not pass base class
}