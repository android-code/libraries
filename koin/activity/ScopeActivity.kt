class ScopeActivity : AppCompatActivity() {

    //inject instance from current scope
    val simpleDependencyBlack: SimpleDependency by getActivityScope().inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope)

        //bind scope session to lifecycle
        bindScope(getActivityScope())
    }
}