class RxJavaActivity : AppCompatActivity() {

    private val service by lazy { ProductServiceRxJava.create() }
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)
        getProductsRxJava()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }

    private fun getProductsRxJava() {
        disposable = service.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> 
                    val products = result
                    //do something with data
                },
                { error ->
                    val message = error.message
                    //some error action
                }
            )
    }
}