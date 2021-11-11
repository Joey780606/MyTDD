package petros.efthymiou.groovy.playlist

import androidx.lifecycle.*

class PlayListViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    val playlists = liveData<Result<List<Playlist>>> {
        emitSource(repository.getPlaylists().asLiveData())
    }


}
