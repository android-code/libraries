//implement HasActivityInjector and inject DispatchingAndroidInjector
//for other Android components do in similar same way, e.g. for Fragment use HasFragmentInjector
public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .managerModule(new ManagerModule("androidcode.pl"))
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}