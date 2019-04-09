//implement PreloadModelProvider
class CustomPreloadModelProvider(val urls: List<String>, val context: Context) : ListPreloader.PreloadModelProvider<Any> {

    override fun getPreloadItems(position: Int): MutableList<Any> {
        val url = urls[position]
        if (TextUtils.isEmpty(url)) {
            return Collections.emptyList()
        }
        return Collections.singletonList(url)
    }

    override fun getPreloadRequestBuilder(item: Any): RequestBuilder<*>? {
        return GlideApp.with(context).load(item)
    }
}