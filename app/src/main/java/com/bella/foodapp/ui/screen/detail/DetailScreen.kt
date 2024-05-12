package com.bella.foodapp.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bella.foodapp.R
import com.bella.foodapp.di.Injection
import com.bella.foodapp.ui.ViewModelFactory
import com.bella.foodapp.ui.common.UiState
import com.bella.foodapp.ui.components.TopAppBarTitle
import com.bella.foodapp.ui.theme.FoodAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    foodId: Long,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateBack: () -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getFoodById(foodId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.food.image,
                    data.food.title,
                    data.food.price,
                    data.food.description,
                    onBackClick = navigateBack,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun DetailContent(
    @DrawableRes image: Int,
    title: String,
    price: String,
    description: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier.padding(8.dp)) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    text = price,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    FoodAppTheme {
        DetailContent(
            R.drawable.asinan_bogor,
            "Asinan Bogor",
            "Rp 20.000",
            "Asinan adalah sejenis makanan yang dibuat dengan cara pengacaran (melalui pengasinan dengan garam atau pengasaman dengan cuka), bahan yang diacarkan yaitu berbagai jenis sayuran dan buah-buahan. Di Indonesia, asinan menjadi salah satu hidangan khas seni kuliner Indonesia. Istilah asin mengacu kepada proses pengawetan dengan merendam buah atau sayur dalam larutan campuran air dan garam. Bahan asinan sedikit mirip dengan bahan rujak, perbedaan utamanya adalah bahan rujak disajikan dalam keadaan segar, sedangkan bahan asinan disajikan dalam keadaan diasinkan atau diacar. Terdapat banyak jenis asinan, akan tetapi yang paling terkenal adalah Asinan Betawi dan Asinan Bogor. Asinan dapat ditemukan dijual di rumah makan, warung, dan pedagang keliling di Indonesia.",
            onBackClick = {},
            modifier = Modifier.padding(8.dp)
        )
    }
}