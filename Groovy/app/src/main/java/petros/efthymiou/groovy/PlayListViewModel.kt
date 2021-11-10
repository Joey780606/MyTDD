package petros.efthymiou.groovy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PlayListViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    val playlists = MutableLiveData<Result<List<Playlist>>>()   // Result是後來Refactor,

    init {
        viewModelScope.launch {
            repository.getPlaylists() //如果放在 viewModelScope.launch 外面,就會有問題,因為沒有在 Coroutine的範圍裡
                .collect {
                    playlists.value = it
                }
        }
    }
}
