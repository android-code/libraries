//create factory module for subcomponents, if needed create one module for each component
@Module(subcomponents = {MainComponent.class, UserComponent.class})
public abstract class BinderComponentsModule {

    @Binds @IntoMap @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> bindMainActivityInjectorFactory(MainComponent.Builder builder);

    @Binds @IntoMap @ClassKey(UserActivity.class)
    abstract AndroidInjector.Factory<?> bindUserActivityInjectorFactory(UserComponent.Builder builder);
}