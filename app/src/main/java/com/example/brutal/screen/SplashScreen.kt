package com.example.brutal.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brutal.R
import com.example.brutal.core.presentation.theme.BrutalTheme

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = stringResource(id = R.string.app_name),
            fontSize = 200.sp,
            modifier = Modifier.rotate(90f).width(1000.dp))
    }
}

@Composable
@Preview(showSystemUi = true)
fun SplashScreenPreview() {
    BrutalTheme {
        SplashScreen()
    }
}
