//create subcomponent for each calling class
@Subcomponent(modules = ManagerModule.class)
public interface MainComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
        //some additional config
    }
}