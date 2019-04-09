//usage of RecyclerViewPreloader in RecyclerView
class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var preloader: RecyclerViewPreloader<Any>
    private val urls = listOf("url1", "url2", "url3") //mock some url

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerView)

        initPreloader()
        initRecyclerView()
    }

    private fun initPreloader() {
        val size = 100
        val maxPreload = 10
        val sizeProvider: ListPreloader.PreloadSizeProvider<Any> = FixedPreloadSizeProvider(size, size)
        val modelProvider = CustomPreloadModelProvider(urls, this) //own implementation of PreloadModelProvider
        preloader = RecyclerViewPreloader(this, modelProvider, sizeProvider, maxPreload)
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CustomAdapter(urls, this@MainActivity)
            addOnScrollListener(preloader) //set RecyclerViewPreloader as scroll listener
        }
    }
}