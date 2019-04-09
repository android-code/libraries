//just simple adapter
class CustomAdapter(val urls: List<String>, val context: Context) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        init {
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //set some data on item
        GlideApp.with(context).load(urls[position]).into(holder.imageView) //standard Glide loading
    }

    override fun getItemCount(): Int = urls.size
}