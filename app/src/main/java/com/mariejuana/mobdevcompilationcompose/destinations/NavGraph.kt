package com.mariejuana.mobdevcompilationcompose.destinations

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mariejuana.mobdevcompilationcompose.ui.screens.AppDrawer
import com.mariejuana.mobdevcompilationcompose.ui.screens.home.HomeScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.basics.odd_or_even.OddOrEvenScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.basics.print_name.PrintNameScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.HOME
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }

    ModalNavigationDrawer(drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateToHome = { navigationActions.navigateToHome() },
            navigateToOddOrEven = { navigationActions.navigateToOddOrEven() },
            navigateToPrintName = {navigationActions.navigateToPrintName()},
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier = Modifier
        )
    }, drawerState = drawerState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = currentRoute) },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = { IconButton(onClick = {
                        coroutineScope.launch { drawerState.open() }
                    },
                        content = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null
                        )
                    })
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer))
            }, modifier = Modifier
        ) {
            NavHost(
                navController = navController,
                startDestination = AllDestinations.HOME,
                modifier = modifier.padding(it)
            ) {
                composable(AllDestinations.HOME) {
                    HomeScreen()
                }

                composable(AllDestinations.ODD_OR_EVEN) {
                    OddOrEvenScreen()
                }
                composable(AllDestinations.PRINT_NAME) {
                    PrintNameScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NavGraphPreview() {
    NavGraph()
}