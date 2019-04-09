@GlideModule
class CustomAppGlideModule : AppGlideModule() {

    //this will apply as global settings
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        //create custom options
        val requestOptions = RequestOptions()
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.DATA)

        val transitionOptions = DrawableTransitionOptions()
            .crossFade()

        //set custom memory size
        val customMemoryCacheSize = (MemorySizeCalculator.Builder(context)
            .build().memoryCacheSize * 1.1).toLong()

        //apply some custom settings
        builder
            .setDefaultRequestOptions(requestOptions)
            .setDefaultTransitionOptions(Drawable::class.java, transitionOptions)
            .setLogLevel(Log.ERROR)
            .setMemoryCache(LruResourceCache(customMemoryCacheSize))
    }

    //body can be also empty
}