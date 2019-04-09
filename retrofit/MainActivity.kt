class MainActivity : AppCompatActivity() {

    private lateinit service: ProductService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buildService() //or use builderServiceWithAuthorization

        //set some actions like on click for getting data
    }

    private fun buildService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.androidcode.pl/") //address not exists, only for example purpose
            .addConverterFactory(GsonConverterFactory.create()) //Gson is default
            .client(OkHttpClient.Builder().build()) //OkHttpClient is default
            .build()

        service = retrofit.create(ProductService::class.java) //instance of ProductService
        //do calls on service object
    }

    private fun buildServiceWithAuthorization() {
        //create interceptor which add credentials to request
        val interceptor = object: Interceptor {
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                val originalRequest = chain.request()
                val builder = originalRequest.newBuilder()
                    .header("Authorization", Credentials.basic("username", "password"))
                return chain.proceed(builder.build())
            }
        }
        
        //pass interceptor to http client
        val okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
        
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.androidcode.pl/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) 
            .build()

        service = retrofit.create(ProductService::class.java) //instance of ProductService
    }

    //run on some event
    private fun getProductsSync() {
        val call : Call<List<Product>> = service.getProducts()
        val response : Response<List<Product>> = call.execute()
        //wait for response in this place
        if(response.isSuccessful) {
            //do something with data
            val data : List<Product>? = response.body()
        }
        else {
            //do some fail action
            val error = response.errorBody()
            val message = response.message()
        }
    }

    private fun getProductsAsync() {
        val call : Call<List<Product>> = service.getProducts()
        //do request at this point and do something else during waiting for response
        call.enqueue(object: Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                //response returned at some moment
                val products = response.body()
                //do something with data
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                //fail returned at some moment
            }
        })
    }
}