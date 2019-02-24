@Singleton
@Component(modules = {AppModule.class, ManagerModule.class})
public interface AppComponent {

    //inject methods
    void inject(MainActivity activity);
    
    //for subcomponent
    UserComponent userSubcomponent(UserModule module);
}