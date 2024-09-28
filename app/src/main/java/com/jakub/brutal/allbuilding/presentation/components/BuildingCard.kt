package com.jakub.brutal.allbuilding.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jakub.brutal.R
import com.jakub.brutal.allbuilding.domain.models.BuildingDomain
import com.jakub.brutal.allbuilding.presentation.states.AllBuildingUiEvent

@Composable
fun BuildingCard(
    building: BuildingDomain,
    modifier: Modifier = Modifier,
    onUiEvent: (AllBuildingUiEvent) -> Unit = {}
) {
    val context = LocalContext.current
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.White,
        onClick = {
            onUiEvent(AllBuildingUiEvent.OnBuildingClicked(building))
        }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(building.photoLink)
                    .crossfade(true)
                    .build(),
                contentDescription = "Building Photo",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }),
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(128.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = building.name,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.serifpro))
                )
                Text(
                    text = building.city,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.serifpro))
                )
            }
        }
    }
}

@Preview
@Composable
private fun BuildingCardPreview() {
    BuildingCard(BuildingDomain())
}