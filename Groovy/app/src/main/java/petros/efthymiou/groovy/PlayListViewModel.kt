package petros.efthymiou.groovy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayListViewModel : ViewModel() {

    val playlists = MutableLiveData<List<Playlist>>()
}
