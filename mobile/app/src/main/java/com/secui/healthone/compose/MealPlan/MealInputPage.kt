package com.secui.healthone.compose.MealPlan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.secui.healthone.data.MealPlan.Food
import com.secui.healthone.ui.mealplanpage.MealInput.MealInputDate
import com.secui.healthone.ui.mealplanpage.MealInput.SearchBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.secui.healthone.ui.common.AppColors
import com.secui.healthone.ui.mealplanpage.MealInput.MealSearchResults
import com.secui.healthone.util.PageRoutes
import com.secui.healthone.viewmodel.FoodViewModel
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun MealInputPage(navController: NavController) {
    val viewModel: FoodViewModel = viewModel()
    val searchResults: State<List<Food>> = viewModel.searchResults.observeAsState(emptyList())
    var showWarning by remember { mutableStateOf(false) }
    var searchTerm by remember { mutableStateOf("") }
    var selectedFoodId by remember { mutableStateOf(-1) }

    val onSearchTermChanged: (String) -> Unit = { newTerm ->
        searchTerm = newTerm
        if (searchTerm.isNotBlank()) {
            viewModel.searchFood(searchTerm)
        }
    }

    val onFoodSelected: (Int) -> Unit = { selectedId ->
        selectedFoodId = selectedId
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Card(modifier = Modifier.fillMaxWidth(), elevation = 4.dp) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "식단 기록", modifier = Modifier.align(Alignment.CenterVertically),
                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Card(modifier = Modifier.fillMaxWidth(), elevation = 4.dp) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MealInputDate()
                }
            }
        }
        item {
            // 메뉴 검색 텍스트
            Text(
                text = "메뉴 검색",
                modifier = Modifier.padding(8.dp),
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
        }
        item {
            // 검색창 컴포저블
            SearchBar("Food", searchTerm, onSearchTermChanged)
        }
        item {
            // 검색결과 컴포저블
            MealSearchResults(searchResults.value, selectedFoodId, onFoodSelected)
        }
        item {
            if (showWarning) {
                Text(
                    text = "식단을 선택해주세요.",
                    modifier = Modifier.padding(8.dp),
                    color = AppColors.red200,
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        }
        item {
            Button(
                onClick = {
                    if (selectedFoodId != -1) {
                        navController.navigate(PageRoutes.MealPlan.route)
                    } else {
                        showWarning = true
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = AppColors.green200),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 16.dp)
            ) {
                Text("저장")
            }
        }
    }
}