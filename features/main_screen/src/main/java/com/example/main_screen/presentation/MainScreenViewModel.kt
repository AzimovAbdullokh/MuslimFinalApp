package com.example.main_screen.presentation

import android.os.Parcelable
import androidx.lifecycle.viewModelScope
import com.example.common_api.DispatchersProviderInCommonApi
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import com.example.main_screen.domain.models.MainScreenFeatureModuleItems
import com.example.main_screen.domain.usecases.FetchAllMainScreenItemsFeatureUseCase
import com.example.main_screen.presentation.adapter.items.MainCardItemClickListener
import com.example.main_screen.presentation.listeners.*
import com.example.main_screen.presentation.mappers.MainItemsToSearchFilteredFeatureModelMapper
import com.example.main_screen.presentation.models.Community
import com.example.main_screen.presentation.router.FragmentMainScreenRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    fetchAllMainScreenItemsUseCase: FetchAllMainScreenItemsFeatureUseCase,
    private val router: FragmentMainScreenRouter,
    private val itemsToSearchFilteredModelMapper: MainItemsToSearchFilteredFeatureModelMapper,
    private val resourcesProvider: ResourceProvider,
    private val dispatchersProvider: DispatchersProviderInCommonApi,
) : BaseViewModel(), CommunityItemClickListener, MainCardItemClickListener,
    MainScreenOpenMoreClickListeners, KhadisItemOnClickListener, ReaderItemOnClickListener {

    private val _playAudioNasheedFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val playAudioNasheedFlow get() = _playAudioNasheedFlow.asSharedFlow()

    private val recyclerViewStateFlow = MutableStateFlow<Parcelable?>(null)

    val allFilteredItemsFlow =
        fetchAllMainScreenItemsUseCase()
            .map { items -> mapToAdapterModel(items) }
            .onStart {}
            .flowOn(dispatchersProvider.default())
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope, SharingStarted.Lazily, null)


    private fun handleError(exception: Throwable) {
        emitToErrorMessageFlow(resourcesProvider.fetchIdErrorMessage(exception))
    }

    private fun mapToAdapterModel(items: MainScreenFeatureModuleItems) =
        itemsToSearchFilteredModelMapper.map(
            items = items,
            communityItemClickListener = this,
            cardItemClickListener = this,
            khadisItemOnClickListener = this,
            readerItemOnClickListener = this
        )

    fun saveRecyclerViewCurrentState(state: Parcelable?) = recyclerViewStateFlow.tryEmit(state)

    fun fetchRecyclerViewCurrentState(): Parcelable? = recyclerViewStateFlow.value

    override fun navigateToSurahFragment() {
        navigate(router.navigateToMainQuranFragment())
    }

    override fun navigateToIslamicTestsFragment() {
        navigate(router.navigateToMainTestsFragment())
    }

    override fun navigateToKhadissesFragment() {
        navigate(router.navigateToMainKhadissesFragment())
    }

    override fun navigateToBooksFragment() {
        navigate(router.navigateToMainBooksFragment())
    }

    override fun navigateToNamazTimesFragment() {
        navigate(router.navigateToNamazTimesScreen())
    }

    override fun navigateToTasbihFragment() {
        navigate(router.navigateToTasbihScreen())
    }

    override fun collectionItemOnClick(community: Community) {
        when (community) {
            Community.BOOKS -> navigateToBooksFragment()
            Community.NAMAZ_TIMES -> navigateToNamazTimesFragment()
            Community.QURAN -> navigateToSurahFragment()
            Community.TESTS -> navigateToIslamicTestsFragment()
            Community.KHADISSES -> navigateToKhadissesFragment()
            Community.TASBIH -> navigateToTasbihFragment()
            else -> {   }
        }
    }

    override fun onClick() {

    }

    override fun khadisItemOnClick(khadisId: String) {

    }

    override fun readerItemOnClick(readerId: String) {

    }
}