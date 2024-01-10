package mapan.developer.testassesment.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen (
    viewModel: HomeViewModel = hiltViewModel(),
){
    Scaffold(
        topBar = {
            Surface (
                shadowElevation = 1.dp,){
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Test Assesment")
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black,
                    ),
                )
            }

        }, content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                var isLoading = viewModel.state.value.isLoading
                var list = viewModel.state.value.list
                var errorMessage = viewModel.state.value.errorMessage
                if(errorMessage.equals("")){
                    if(!isLoading || list.size > 0){
                        LazyColumn(content = {
                            items(count = list.size){ index ->
                                var data = list[index]
                                Column (modifier = Modifier.padding(10.dp)){
                                    Text(
                                        modifier = Modifier
                                            .padding(5.dp)
                                            .fillMaxWidth(),
                                        text = data.title!!.uppercase(),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                    Text(
                                        modifier = Modifier
                                            .padding(vertical = 10.dp, horizontal = 5.dp),
                                        text = data.body!!,
                                        fontSize = 14.sp
                                    )
                                    Divider(
                                        color = Color.Gray,
                                        thickness = 1.dp,
                                        modifier = Modifier
                                            .padding(horizontal = 5.dp, vertical = 5.dp))
                                }
                            }
                        })
                    }else{
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(
                                color = Color.Black
                            )
                        }
                    }
                }else{
                    Text(text = errorMessage, color = MaterialTheme.colorScheme.onSurface)
                }

            }
        })
}