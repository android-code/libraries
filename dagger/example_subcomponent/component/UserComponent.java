@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {

    void inject(UserActivity userActivity);
}