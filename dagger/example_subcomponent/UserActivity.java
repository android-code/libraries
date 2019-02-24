public class UserActivity extends AppCompatActivity {

    @Inject 
    UserManager manager; //from subcomponent

    @Inject 
    SharedPreferences sharedPreferences; //from parent component

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ((App) getApplication()).getAppComponent()
                .userSubcomponent(new UserModule(this))
                .inject(this);

        //do something with dependencies
        manager.getConfiguration();
        sharedPreferences.contains("KEY");
    }
}