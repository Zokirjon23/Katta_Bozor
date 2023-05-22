package uz.test.kattabozor.ui.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import uz.test.kattabozor.data.model.response.Attribute
import uz.test.kattabozor.data.model.response.Image
import uz.test.kattabozor.data.model.response.OfferItem
import uz.test.kattabozor.data.model.uistate.OfferUiState
import uz.test.kattabozor.presenter.OfferViewModel
import uz.test.kattabozor.presenter.impl.OfferViewModelImpl
import uz.test.kattabozor.ui.theme.KattaBozorTheme

@Composable
fun OfferScreen() {
    val viewModel: OfferViewModel = hiltViewModel<OfferViewModelImpl>()
    OfferScreenContent(viewModel.uiState.collectAsState())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreenContent(uiState: State<OfferUiState>) = Box {
    val context = LocalContext.current

    LazyColumn {
        items(if (uiState.value.loading) 10 else uiState.value.offers.size) { pos ->
            if (uiState.value.loading)
                LoadingItem()
            else
                OfferItem(offer = uiState.value.offers[pos])
        }
    }

    uiState.value.error?.let { error ->
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    uiState.value.messageId?.let { id ->
        Toast.makeText(context, stringResource(id = id), Toast.LENGTH_SHORT).show()
    }
}

@Preview
@Composable
fun OfferScreenPreview() {
    KattaBozorTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            val state = remember {
                mutableStateOf(OfferUiState())
            }
//            OfferScreenContent(state)
            OfferItem(
                offer = OfferItem(
                    listOf(Attribute("sada", "sfd")),
                    "ssss",
                    "sss",
                    0,
                    Image(40, "", 40),
                    "333",
                    "name"
                )
            )
        }
    }
}

@Composable
fun OfferItem(offer: OfferItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp),
        horizontalArrangement = Arrangement.Start,
    ) {
        AsyncImage(
            modifier = Modifier
                .size(85.dp)
                .clip(RoundedCornerShape(5.dp))
                .align(Alignment.CenterVertically),
            model = ImageRequest.Builder(LocalContext.current).data(offer.image.url).crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            Modifier
                .padding(start = 10.dp)
                .fillMaxWidth()
        ) {
            Text(text = offer.name)
            Text(text = offer.category)
            Text(text = offer.merchant)
        }
    }
}

@Composable
fun LoadingItem() {
    val shimmer = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 13.dp, top = 4.dp, end = 13.dp)
//            .shimmer(shimmer)
//            .background(Color.Gray, RoundedCornerShape(12.dp))
    ) {
        Box(
            modifier = Modifier
                .size(85.dp)
                .align(Alignment.CenterVertically)
                .shimmer(shimmer)
                .background(Color.Gray)
        )
        Column(
            Modifier
                .padding(start = 10.dp)
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 2.dp)
                    .weight(0.3f)
                    .fillMaxWidth()
                    .shimmer(shimmer)
                    .background(Color.Gray)
            )
            Box(
                modifier = Modifier
                    .padding(bottom = 2.dp)
                    .weight(0.25f)
                    .fillMaxWidth()
                    .shimmer(shimmer)
                    .background(Color.Gray)
            )
            Box(
                modifier = Modifier
                    .padding(bottom = 2.dp)
                    .weight(0.25f)
                    .fillMaxWidth(0.7f)
                    .shimmer(shimmer)
                    .background(Color.Gray)
            )
        }
    }
}