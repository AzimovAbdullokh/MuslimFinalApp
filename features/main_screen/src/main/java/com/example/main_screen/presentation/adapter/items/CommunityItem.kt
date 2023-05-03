package com.example.main_screen.presentation.adapter.items

import com.example.common_api.base.adapter.Item
import com.example.main_screen.presentation.listeners.CommunityItemClickListener
import com.example.main_screen.presentation.models.Community

data class CommunityItem(
    val community: Community,
    val listener: CommunityItemClickListener,
) : Item