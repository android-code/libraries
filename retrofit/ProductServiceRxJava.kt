interface ProductServiceRxJava {

    @GET("products")
    fun getProducts() : Observable<List<Product>> //or other type of RxJava observables

    companion object {
        fun create(): ProductServiceRxJava {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://api.androidcode.pl/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create<ProductServiceRxJava>(ProductServiceRxJava::class.java)
        }
    }
}