class MainActivity : AppCompatActivity() {

    //lazy inject
    val simpleDependencyRed by inject<SimpleDependency>("red")
    val simpleDependencyBlue: SimpleDependency by inject("blue")
    val complexDependency: ComplexDependency by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inject by directly getting instance
        val pref: SharedPreferences = get()
    }
}