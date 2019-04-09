class MainActivity : AppCompatActivity() {

    private val url = "http://androidcode.pl/assets/img/main_banner.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //some transitions and transforms
    private fun loadImageCustom() {
        //load image with some custom modifications
        Glide.with(this).load(url)
            .centerCrop() //apply some transforms
            .transition(withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(imageView)
    }

    private fun loadImageCustomOptions() {
        //TransitionOptions are tied with specific type like DrawableTransitionOptions
        val transitionOptions = DrawableTransitionOptions()
            .crossFade()

        //create RequestOptions and reuse it
        val requestOptions = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        //add more transforms

        Glide.with(this).load(url)
            .transition(transitionOptions)
            .apply(requestOptions).into(imageView)
    }

    private fun loadImageMultipleTransforms() {
        Glide.with(this).load(url)
            .transform(FitCenter(), Rotate(90))
            .into(imageView)
    }

    //loading with custom cache strategies
    private fun loadImageWithCustomSignature() {
        Glide.with(this).load(url)
            .signature(ObjectKey("version")) //custom metadata if possible like last modified time
            .into(imageView)
    }

    private fun loadAndSaveImageBySomeStrategy() {
        Glide.with(this).load(url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC) //is default
            .into(imageView)

        /* use one of DiskStrategyCache:
        AUTOMATIC - optimal strategy based on data source
        DATA - stores original retrieved data in disk cache
        RESOURCE - stores data in disk cache after decoding
        ALL - remote data with both DATA and RESOURCE, local data only with RESOURCE
        NONE - saves no data to disk cache */
    }

    private fun loadImageOnylIfExistsInCache() {
        Glide.with(this).load(url)
            .onlyRetrieveFromCache(true)
            .into(imageView)

        //if image doesn't exists in memory or disk cache then load fail
    }

    private fun loadImageSkippingCache() {
        Glide.with(this).load(url)
            .skipMemoryCache(true)
            .into(imageView)

        //skip memory cache
    }
}