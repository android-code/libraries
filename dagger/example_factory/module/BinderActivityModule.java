@Module
public abstract class BinderActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = UserModule.class)
    abstract UserActivity userActivity();
}