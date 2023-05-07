package com.secui.healthone.ui.common

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.secui.healthone.R
import com.secui.healthone.util.PageRoutes

@Composable
fun TopBar() {
    val navController = rememberNavController()
    val menuOpen = remember { mutableStateOf(false) } // 메뉴 상태를 기억하는 변수
    val menuOffset = animateDpAsState(if (menuOpen.value) 0.dp else 200.dp) // 애니메이션 상태
    val currentTitle = remember { mutableStateOf("메인") } // 현재 타이틀을 저장하는 변수

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_topbar_logo),
                                contentDescription = "logo",
                                modifier = Modifier
                                    .size(60.dp)
                                    .clickable { navController.navigate(PageRoutes.OverView.route) }
                            )
                            Spacer(modifier = Modifier.width(80.dp))
                            Text(
                                currentTitle.value,
                                color = AppColors.black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    backgroundColor = AppColors.white,
                    actions = {
                        IconButton(onClick = {
                            navController.navigate(PageRoutes.Alert.route)
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_bell),
                                contentDescription = "Alert",
                                modifier = Modifier.size(24.dp),
                                tint = AppColors.black
                            )
                        }
                        IconButton(onClick = {
                            menuOpen.value = !menuOpen.value
                        }) { // 상태를 업데이트하여 메뉴를 열고 닫습니다.
                            Icon(
                                painter = painterResource(id = R.drawable.ic_topbar_toggle),
                                contentDescription = "Menu",
                                modifier = Modifier.size(24.dp),
                                tint = AppColors.black
                            )
                        }
                    }
                )
            }
            TopBarNavigation(navController)
        }
        if (menuOpen.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .clickable { menuOpen.value = false }
            )
        }
            Column(
                modifier = Modifier
                    .offset(x = menuOffset.value) // 애니메이션 값을 적용
                    .width(200.dp)
                    .fillMaxHeight()
                    .background(AppColors.white)
                    .align(Alignment.TopEnd)
            ) {
                DrawerButton(
                    text = "박싸피",
                    onClick = {
                        navController.navigate(PageRoutes.My.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "메인",
                    icon = R.drawable.ic_home,
                    iconColor = AppColors.black,
                    onClick = {
                        currentTitle.value = "메인"
                        navController.navigate(PageRoutes.OverView.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "심박수",
                    icon = R.drawable.ic_heart,
                    iconColor = Color.Unspecified,
                    onClick = {
                        currentTitle.value = "심박수"
                        navController.navigate(PageRoutes.HeartRate.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "식단",
                    icon = R.drawable.ic_food,
                    iconColor = AppColors.green600,
                    onClick = {
                        currentTitle.value = "식단"
                        navController.navigate(PageRoutes.MealPlan.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "수면",
                    icon = R.drawable.ic_sleep,
                    iconColor = AppColors.mono900,
                    onClick = {
                        currentTitle.value = "수면"
                        navController.navigate(PageRoutes.Sleep.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "걸음수",
                    icon = R.drawable.ic_walking,
                    iconColor = AppColors.blue900,
                    onClick = {
                        currentTitle.value = "걸음수"
                        navController.navigate(PageRoutes.Walking.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "심박 수 측정",
                    icon = R.drawable.ic_heart,
                    iconColor = Color.Unspecified,
                    onClick = {
                        currentTitle.value = "심박 수 측정"
                        navController.navigate(PageRoutes.HeartRate.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "건강상태",
                    icon = R.drawable.ic_heart,
                    iconColor = Color.Unspecified,
                    onClick = {
                        currentTitle.value = "건강상태"
                        navController.navigate(PageRoutes.HealthStatus.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "챌린지",
                    icon = R.drawable.ic_fire,
                    iconColor = AppColors.red900,
                    onClick = {
                        currentTitle.value = "챌린지"
                        navController.navigate(PageRoutes.Challenge.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
                DrawerButton(
                    text = "설정",
                    icon = R.drawable.ic_setting,
                    iconColor = Color.Unspecified,
                    onClick = {
                        currentTitle.value = "설정"
                        navController.navigate(PageRoutes.Setting.route)
                    }
                )
                Divider(color = AppColors.black, thickness = 1.dp)
            }
        }
}