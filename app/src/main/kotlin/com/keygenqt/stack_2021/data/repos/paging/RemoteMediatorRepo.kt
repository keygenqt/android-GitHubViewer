package com.keygenqt.stack_2021.data.repos.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.keygenqt.stack_2021.data.AppDatabase
import com.keygenqt.stack_2021.data.repos.DaoRepo
import com.keygenqt.stack_2021.data.repos.impl.RepositoryRepo
import com.keygenqt.stack_2021.models.ModelRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

@ExperimentalPagingApi
class RemoteMediatorRepo(
    private val database: AppDatabase,
    private val repositoryRepo: RepositoryRepo,
) : RemoteMediator<Int, ModelRepo>() {

    private val repoDao: DaoRepo = database.repo()

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ModelRepo>
    ): MediatorResult {
        return try {
            val loadPage = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    // Pagination works, but the list is not updated
                    val lastItem = database.withTransaction {
                        repoDao.lastItemOrNull()
                    }
                    lastItem.page.plus(1)

                    // Pagination doesn't work, lastItemOrNull is always on the first page
//                    val lastItem = state.lastItemOrNull() ?: return MediatorResult.Success(endOfPaginationReached = true)
//                    lastItem.page.plus(1)
                }
            }

            val response = repositoryRepo.getModels(
                page = loadPage
            )

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    repoDao.clearAll()
                } else {
                    repoDao.deleteByPage(loadPage)
                }
                repoDao.insertAll(response)
            }

            MediatorResult.Success(
                endOfPaginationReached = response.isEmpty()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}