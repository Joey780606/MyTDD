package petros.efthymiou.groovy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayListViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    val playlists = MutableLiveData<Result<List<Playlist>>>()   // Result是後來Refactor,

    init {
        repository.getPlaylists()
    }
}
