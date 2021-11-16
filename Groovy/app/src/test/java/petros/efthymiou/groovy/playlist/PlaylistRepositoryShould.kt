package petros.efthymiou.groovy.playlist

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import petros.efthymiou.groovy.utils.BaseUnitTest

class PlaylistRepositoryShould : BaseUnitTest() {
    private val service : PlaylistService = mock()

    @Test
    fun getsPlaylistsFromService() : Unit = runBlockingTest {
        val repository = PlaylistRepository(service)

        repository.getPlaylists()

        verify(service, times(1)).fetchPlaylists()
    }
}