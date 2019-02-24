//install AndroidInjectionModule from library and add own BinderComponentsModule
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ManagerModule.class, BinderComponentsModule.class})
public interface AppComponent {

    void inject(App app);
}

//or

//install AndroidInjectionModule from library and add own BinderActivityModule
@Component(modules = {AndroidInjectionModule.class, AppModule.class, BinderActivityModule.class})
public interface AppComponent {

    void inject(App app);
}