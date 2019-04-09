interface ProductService {

    @GET("products")
    fun getProducts() : Call<List<Product>>

    @GET("products") //add some optional query to request
    fun getProducts(@Query("sort") sort: String) : Call<List<Product>>

    @GET("product/{id}") //parametrize request
    fun getProduct(@Path("id") id: Int) : Call<Product>

    @Headers("Cache-Control: max-age=1000000") //set additional static header
    @GET("producer/{id}")
    fun getProducer(@Path("id") id: Int) : Call<Producer>

    @POST("products/new")
    fun createProduct(@Body product: Product) : Call<ResponseBody>

    @FormUrlEncoded //send as form url encoded
    @POST("producers/new")
    fun createProducer(@Field("name") name: String, @Field("country") country: String) : Call<ResponseBody>

    @Multipart //send as multipart - mainly for files
    @PUT("producer/{id}")
    fun updateProducer(@Path("id") id: Int, @Part("image") image: RequestBody) : Call<ResponseBody>

    @DELETE("product/{id}")
    fun deleteProduct(@Path("id") id: Int) : Call<ResponseBody>

    //add authorization to every single request
    @GET("products")
    fun getProducts(@Header("Authorization") String credentials) : Call<List<Product>>

    //some more REST API methods
}