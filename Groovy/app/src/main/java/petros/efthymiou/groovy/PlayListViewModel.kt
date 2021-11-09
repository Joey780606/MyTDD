package petros.efthymiou.groovy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayListViewModel : ViewModel() {

    val playlists = MutableLiveData<Result<List<Playlist>>>()   // Result是後來Refactor,
}
