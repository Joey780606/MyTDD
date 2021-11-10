package petros.efthymiou.groovy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import petros.efthymiou.groovy.utils.MainCoroutineScopeRule
import petros.efthymiou.groovy.utils.getValueForTest

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PlayListViewModelShould {

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @get:Rule
    var instantTestExecutorRule = InstantTaskExecutorRule() //這是為 LiveData

    val viewModel: PlayListViewModel
    val repository: PlaylistRepository = mock()

    init {
        viewModel = PlayListViewModel()
    }

    @Test
    fun getPlaylistsFromRepository() {
        viewModel.playlists.getValueForTest()

        verify(repository, times(1)).getPlaylists()
    }
}