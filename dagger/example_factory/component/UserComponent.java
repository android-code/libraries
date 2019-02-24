@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent extends AndroidInjector<UserActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UserActivity> {
        
        public abstract Builder userModule(UserModule module);

        @Override
        public void seedInstance(UserActivity instance) {
            //additional config like specify module constructor
            userModule(new UserModule()); 
        }
    }
}