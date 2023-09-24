package com.mariejuana.mobdevcompilationcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.Abc
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.HdrStrong
import androidx.compose.material.icons.rounded.Notes
import androidx.compose.material.icons.rounded.Numbers
import androidx.compose.material.icons.rounded.WrapText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mariejuana.mobdevcompilationcompose.R
import com.mariejuana.mobdevcompilationcompose.destinations.AllDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    route: String,
    modifier: Modifier = Modifier,

    navigateToHome: () -> Unit = {},

    navigateToOddOrEven: () -> Unit = {},
    navigateToPrintName: () -> Unit = {},
    navigateToAndroidStatus: () -> Unit = {},
    navigateToMiniCalculator: () -> Unit = {},

    navigateToLM1: () -> Unit = {},
    navigateToLM2: () -> Unit = {},

    navigateToTheStruggle: () -> Unit = {},
    navigateToRandomQuotes: () -> Unit = {},

    closeDrawer: () -> Unit = {}
) {
    ModalDrawerSheet(modifier = Modifier) {
        DrawerHeader(modifier)
        Spacer(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_padding)))
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_home),
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            modifier = Modifier.padding(10.dp),
            selected = route == AllDestinations.HOME,
            onClick = {
                navigateToHome()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    Modifier.size(30.dp))},
            shape = MaterialTheme.shapes.medium
        )

        //Basic Activities text
        Text(
            text = "Basic Bullshite",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
            style = MaterialTheme.typography.titleMedium
        )

        //Odd Or Even
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_evenodd),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            selected = route == AllDestinations.ODD_OR_EVEN,
            onClick = {
                navigateToOddOrEven()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Numbers,
                    contentDescription = null,
                    Modifier.size(30.dp))},
            shape = MaterialTheme.shapes.medium
        )

        //Print Name
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_printname),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            selected = route == AllDestinations.PRINT_NAME,
            onClick = {
                navigateToPrintName()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Abc,
                    contentDescription = null,
                    Modifier.size(30.dp))},
            shape = MaterialTheme.shapes.medium
        )

        //Android Status
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_android_status),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            selected = route == AllDestinations.ANDROID_STATUS,
            onClick = {
                navigateToAndroidStatus()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Android,
                    contentDescription = null,
                    Modifier.size(30.dp)) },
            shape = MaterialTheme.shapes.medium
        )

        //Mini Calculator
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_calculator),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            selected = route == AllDestinations.MINI_CALCULATOR,
            onClick = {
                navigateToMiniCalculator()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Calculate,
                    contentDescription = null,
                    Modifier.size(30.dp)) },
            shape = MaterialTheme.shapes.medium
        )

        //Lectures
        Text(
            text = "Lectures",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
            style = MaterialTheme.typography.titleMedium
        )

        //LM1
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_LM1),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            selected = route == AllDestinations.LM1,
            onClick = {
                navigateToLM1()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Notes,
                    contentDescription = null,
                    Modifier.size(30.dp)) },
            shape = MaterialTheme.shapes.medium
        )

        //LM2
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_LM2),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            selected = route == AllDestinations.LM2,
            onClick = {
                navigateToLM2()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Notes,
                    contentDescription = null,
                    Modifier.size(30.dp)) },
            shape = MaterialTheme.shapes.medium
        )

        //Lectures
        Text(
            text = "Activities",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
            style = MaterialTheme.typography.titleMedium
        )

        //The Struggle
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_minigame1),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            selected = route == AllDestinations.THE_STRUGGLE,
            onClick = {
                navigateToTheStruggle()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.HdrStrong,
                    contentDescription = null,
                    Modifier.size(30.dp)) },
            shape = MaterialTheme.shapes.medium
        )

        //Random Quote
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_randomquotes),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            selected = route == AllDestinations.RANDOM_QUOTES,
            onClick = {
                navigateToRandomQuotes()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.WrapText,
                    contentDescription = null,
                    Modifier.size(30.dp)) },
            shape = MaterialTheme.shapes.medium
        )
    }
}


@Composable
fun DrawerHeader(modifier: Modifier) {
    Row (
        modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(dimensionResource(id = R.dimen.header_padding))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(dimensionResource(id = R.dimen.header_image_size))
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_padding)))
        Column {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = stringResource(id = R.string.app_made_by),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview
@Composable
fun AppDrawerPreview() {
    AppDrawer(modifier = Modifier, route = AllDestinations.HOME)
}

@Preview
@Composable
fun DrawerHeaderPreview() {
    DrawerHeader(modifier = Modifier)
}