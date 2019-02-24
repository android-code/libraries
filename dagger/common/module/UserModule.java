@Module
public class UserModule {

    private final UserActivity activity;

    public UserModule(UserActivity activity) {
        this.activity = activity;
    }

    @Provides @UserScope
    public UserManager providesUserDependency() {
        return new UserManager("global");
    }
}