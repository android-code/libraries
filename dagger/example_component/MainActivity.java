public class MainActivity extends AppCompatActivity {

    @Inject @Named("red") 
    SimpleDependency simpleDependencyRed;

    @Inject @Named("blue") 
    SimpleDependency simpleDependencyBlue;

    @Inject 
    ComplexDependency complexDependency;

    @Inject 
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MainActivity shouldn't know anything about how it is injected
        //so main depedency injection principle is broken
        ((App) getApplication()).getAppComponent()
                .inject(this);

        //do something with dependencies
        simpleDependencyRed.getInfo();
        simpleDependencyBlue.getInfo();
        complexDependency.getInfo();
        sharedPreferences.contains("KEY");
    }
}