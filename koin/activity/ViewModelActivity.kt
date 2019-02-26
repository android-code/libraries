class ViewModelActivity : AppCompatActivity() {

    //lazy inject ViewModel
    val viewModel: SomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        //inject by directly getting ViewModel instance
        val viewModel: SomeViewModel = getViewModel()
    }
}