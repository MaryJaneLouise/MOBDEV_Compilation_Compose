package com.mariejuana.mobdevcompilationcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
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

    navigateToPrintName: () -> Unit = {},
    navigateToOddOrEven: () -> Unit = {},
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
                    style = MaterialTheme.typography.labelMedium
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
                    contentDescription = null) },
            shape = MaterialTheme.shapes.medium
        )

        //Basic Activities text
        Text(
            text = "Basic Activities",
            modifier = Modifier.padding(10.dp),
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
            modifier = Modifier.padding(10.dp),
            selected = route == AllDestinations.ODD_OR_EVEN,
            onClick = {
                navigateToOddOrEven()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null) },
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
            modifier = Modifier.padding(10.dp),
            selected = route == AllDestinations.PRINT_NAME,
            onClick = {
                navigateToPrintName()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null) },
            shape = MaterialTheme.shapes.medium
        )

        //
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_printname),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(10.dp),
            selected = route == AllDestinations.PRINT_NAME,
            onClick = {
                navigateToOddOrEven()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null) },
            shape = MaterialTheme.shapes.medium
        )
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.menu_printname),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            modifier = Modifier.padding(10.dp),
            selected = route == AllDestinations.PRINT_NAME,
            onClick = {
                navigateToOddOrEven()
                closeDrawer()
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null) },
            shape = MaterialTheme.shapes.medium
        )
    }
}


@Composable
fun DrawerHeader(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondary)
            .padding(dimensionResource(id = R.dimen.header_padding))
            .fillMaxWidth()
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

        Text(
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Preview
@Composable
fun DrawerHeaderPreview() {
    AppDrawer(modifier = Modifier, route = AllDestinations.HOME)
}