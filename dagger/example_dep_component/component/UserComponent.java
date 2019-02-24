@UserScope
@Component(dependencies = AppComponent.class, modules = UserModule.class)
public interface UserComponent {

    void inject(UserActivity userActivity);
}