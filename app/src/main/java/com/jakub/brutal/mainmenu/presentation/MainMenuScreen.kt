package com.jakub.brutal.mainmenu.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jakub.brutal.core.presentation.components.BrutalHeader
import com.jakub.brutal.core.presentation.theme.rememberDefaultFont

@Composable
fun MainMenuScreen(modifier: Modifier = Modifier) {
    val default = rememberDefaultFont()
    val menuStyle = remember {
        TextStyle(
            fontFamily = default,
            color = Color.Gray,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal
        )
    }
    val configuration = LocalConfiguration.current

    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BrutalHeader(boxSize = 250, textSize = 32, modifier = Modifier.padding(vertical = 32.dp))
        menuList.forEach {
            TextButton({}, modifier = Modifier.height((configuration.screenHeightDp / 6).dp)) {
                Text(
                    text = it,
                    style = menuStyle
                )
            }
        }
    }
}

val menuList = listOf(
    "All buildings.",
    "Maps.",
    "Favorites.",
    "Shops.",
    "Contact.",
)

@Composable
@Preview(showBackground = true)
@PreviewScreenSizes
private fun MainMenuScreenPreview() {
    MainMenuScreen()
}
