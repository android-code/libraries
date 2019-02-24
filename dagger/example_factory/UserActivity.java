//now just call AndroidInjection.inject(this) to perform injection
public class UserActivity extends AppCompatActivity {

    @Inject 
    UserManager manager;

    @Inject 
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this); //must be call before super.onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

         //do something with dependencies
    }
}