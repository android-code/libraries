public class UserActivity extends AppCompatActivity {

    @Inject 
    UserManager manager; //from dependent component

    @Inject 
    SharedPreferences sharedPreferences; //from parent component

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        
        //get parent component
        AppComponent appComponent = ((App) getApplication()).getAppComponent();
        
        //create child component
        UserComponent userComponent = DaggerUserComponent.builder()
                .appComponent(appComponent)
                .userModule(new UserModule(this))
                .build();
        
        //inject
        userComponent.inject(this);

        //do something with dependencies
        manager.getConfiguration();
        sharedPreferences.contains("KEY");
    }
}