/*
 * Copyright 2021 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package com.keygenqt.stack_2021.ui.home

import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.People
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import com.keygenqt.stack_2021.R
import com.keygenqt.stack_2021.models.ModelFollower
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.ui.main.ViewModelMain
import com.keygenqt.stack_2021.ui.theme.Purple700

@Composable
fun TabsHome(
    viewModelMain: ViewModelMain,
    viewModel: ViewModelHome,
    navigateToDetailsRepo: (Long) -> Unit,
) {
    val tabs = HomeTab.values()
    val selectedTab = HomeTab.getTabFromResource(viewModel.selectedTab.value)
    val lazyRepos: LazyPagingItems<ModelRepo> = viewModel.repos.collectAsLazyPagingItems()
    val lazyFollowers: LazyPagingItems<ModelFollower> = viewModel.followers.collectAsLazyPagingItems()
    val showSnackBar: Boolean by viewModelMain.showSnackBar.observeAsState(false)

    ConstraintLayout {
        val (body) = createRefs()
        Scaffold(
            topBar = {
                Crossfade(selectedTab) { destination ->
                    when (destination) {
                        HomeTab.REPOS -> PosterAppBar(stringResource(id = R.string.title_repos))
                        HomeTab.FOLLOWERS -> PosterAppBar(stringResource(id = R.string.title_followers))
                    }
                }
            },
            modifier = Modifier.constrainAs(body) {
                top.linkTo(parent.top)
            },
            bottomBar = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        if (showSnackBar) {
                            SnackbarInfo()
                        }
                        BottomNavigation(
                            backgroundColor = Purple700,
                            modifier = Modifier.navigationBarsHeight(56.dp)
                        ) {
                            tabs.forEach { tab ->
                                BottomNavigationItem(
                                    icon = { Icon(imageVector = tab.icon, contentDescription = null) },
                                    selected = tab == selectedTab,
                                    onClick = { viewModel.selectTab(tab.title) },
                                    selectedContentColor = Color.White,
                                    unselectedContentColor = Color.White,
                                    modifier = Modifier.navigationBarsPadding()
                                )
                            }
                        }
                    }
                }
            }
        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            Crossfade(selectedTab) { destination ->
                when (destination) {
                    HomeTab.REPOS -> ReposList(modifier, lazyRepos, navigateToDetailsRepo)
                    HomeTab.FOLLOWERS -> ListFollowers(modifier, lazyFollowers)
                }
            }
        }
    }
}

@Composable
fun SnackbarInfo(
    modifier: Modifier = Modifier
) {
    Column {
        Snackbar(modifier = modifier.padding(8.dp)) { Text(text = stringResource(id = R.string.exit_info)) }
    }
}

@Composable
fun PosterAppBar(title: String) {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = Purple700,
        modifier = Modifier.height(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

enum class HomeTab(
    @StringRes val title: Int,
    val icon: ImageVector
) {

    REPOS(R.string.menu_repos, Icons.Filled.List),
    FOLLOWERS(R.string.menu_followers, Icons.Filled.People);

    companion object {
        fun getTabFromResource(@StringRes resource: Int): HomeTab {
            return when (resource) {
                R.string.menu_repos -> REPOS
                R.string.menu_followers -> FOLLOWERS
                else -> REPOS
            }
        }
    }
}
