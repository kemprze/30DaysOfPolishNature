package com.kemprze.a30daysofpolishnature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kemprze.a30daysofpolishnature.model.Animal
import com.kemprze.a30daysofpolishnature.model.DataWarehouse
import com.kemprze.a30daysofpolishnature.ui.theme._30DaysOfPolishNatureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfPolishNatureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainWindow(
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
                )
            {
                Icon(
                    painter = if (isSystemInDarkTheme()) painterResource(R.drawable.app_logo_dark) else painterResource(R.drawable.app_logo_light),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier
                        .size(100.dp)
                        .scale(1.25F)
                        .padding(end = 8.dp),
                    tint = MaterialTheme.colorScheme.onBackground
                    )
                Text(
                    text = "30 Days of Polish Nature"
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun ExpandButton(expanded: Boolean,
                 onClick: () -> Unit,
                 modifier: Modifier = Modifier
) {
    IconButton(
            onClick = onClick,
            modifier = modifier
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
}

@Composable
fun AnimalCard(animal: Animal, modifier: Modifier = Modifier) {
    var expand by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
    ) {
        Column {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column (modifier = Modifier
                    .weight(2f)
                ) {
                    Text(
                        text = stringResource(animal.name),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = stringResource(animal.latinName),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                    )
                }
                ExpandButton(
                    expanded = expand,
                    onClick = { expand = !expand }
                )
            }
            Column(Modifier
                .padding(8.dp)
                .background(Color.White)
                .border(1.dp, MaterialTheme.colorScheme.onPrimary)
                .clip(RoundedCornerShape(8.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(animal.photograph),
                    contentDescription = stringResource(animal.name),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                )
            }

            if (expand) {
                AnimalDescription(animal = animal)
            }
        }
    }
}

@Composable
fun AnimalDescription(modifier: Modifier = Modifier, animal: Animal) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Status: ${stringResource(animal.status)}",
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = stringResource(animal.description),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun MainWindow(modifier: Modifier = Modifier) {
    val animalList = DataWarehouse.animalList

    Scaffold(
        topBar = { Bar() }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(animalList) { item ->
                AnimalCard(item,
                    modifier = Modifier
                        .padding(
                            vertical = 8.dp,
                        horizontal = 8.dp
                        ))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun _30DaysPreview() {
    _30DaysOfPolishNatureTheme(darkTheme = false) {
        MainWindow()
    }
}

@Preview(showBackground = true)
@Composable
fun _30DaysPreviewDark() {
    _30DaysOfPolishNatureTheme(darkTheme = true) {
        MainWindow()
    }
}
