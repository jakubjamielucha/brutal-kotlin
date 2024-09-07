package com.jakub.brutal.core.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jakub.brutal.R
import com.jakub.brutal.core.presentation.theme.BrutalColors

@Composable
fun BrutalHeader(
    modifier: Modifier = Modifier,
    boxSize: Int = 100,
    textSize: Int = 20,
) {
    Box(
        modifier = modifier
            .size(boxSize.dp)
            .border(width = 1.dp, color = BrutalColors.darkGrey),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Brutal.", fontSize = textSize.sp, fontFamily = FontFamily(Font(R.font.serifpro)))
    }
}

@Composable
@Preview(showBackground = true)
private fun BrutalHeaderPreview() {
    Box {
        BrutalHeader(modifier = Modifier.padding(20.dp), boxSize = 200, textSize = 24)
    }
}
