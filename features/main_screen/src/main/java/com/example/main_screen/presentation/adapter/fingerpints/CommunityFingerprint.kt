package com.example.main_screen.presentation.adapter.fingerpints


//class CollectionsFingerprint : ItemFingerprint<ItemCommunityBinding, CommunityItem> {
//
//    override fun isRelativeItem(item: Item) = item is CommunityItem
//
//    override fun getLayoutId() = R.layout.item_test
//
//    override fun getViewHolder(
//        layoutInflater: LayoutInflater,
//        parent: ViewGroup,
//    ): BaseViewHolder<ItemCommunityBinding, CommunityItem> {
//        val binding = ItemCommunityBinding.inflate(layoutInflater, parent, false)
//        return CollectionViewHolder(binding)
//    }
//
//    override fun getDiffUtil() = diffUtil
//
//    private val diffUtil = object : DiffUtil.ItemCallback<CommunityItem>() {
//
//        override fun areItemsTheSame(
//            oldItem: CommunityItem,
//            newItem: CommunityItem,
//        ) = oldItem.community.title == newItem.community.title
//
//        override fun areContentsTheSame(
//            oldItem: CommunityItem,
//            newItem: CommunityItem,
//        ) = oldItem == newItem
//    }
//
//}
//
//class CollectionViewHolder(
//    binding: ItemCommunityBinding,
//) : BaseViewHolder<ItemCommunityBinding, CommunityItem>(binding) {
//
//    override fun onBind(item: CommunityItem) {
//        super.onBind(item)
//        setupViews()
//        setOnClickListeners()
//    }
//
//    private fun setupViews() = with(binding) {
//        Glide
//            .with(itemView.context)
//            .load(item.community.imageView)
//            .into(cover)
////        title.text = itemView.context.getText(item.community.title.id)
//    }
//
//    private fun setOnClickListeners() = with(binding) {
//        root.setOnDownEffectClickListener { item.listener.collectionItemOnClick(item.community) }
////        goFragmentBtn.setOnDownEffectClickListener {}
//
//    }
//
//}
//
