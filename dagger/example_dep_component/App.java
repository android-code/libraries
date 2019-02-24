//initialize component
public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //DaggerAppComponent is generated class with name based on Dagger prefix and component name
        appComponent = DaggerAppComponent.builder()
                //set list of modules that are included in component
                .appModule(new AppModule(this)) //builder method name correspond to module name
                .managerModule(new ManagerModule("androidcode.pl"))
                .build();

        //if modules of component doesn't have any constructor with arguments than this build could be
        //appComponent = DaggerAppComponent.create()
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}