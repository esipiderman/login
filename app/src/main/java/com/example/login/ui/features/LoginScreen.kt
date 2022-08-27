package com.example.login.ui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.R
import com.example.login.util.MyScreens
import kotlin.math.sin

@Composable
fun LoginScreen(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        LoginButtons(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f),
            onLoginClick = { username, password ->

            },
            onRegisterClick = {
                navController.navigate(MyScreens.RegisterScreen.route)
            },
            onForgotClick = {

            }
        )
    }
}

@Composable
fun LoginButtons(
    modifier: Modifier = Modifier,
    onLoginClick: (username: String, password: String) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    var usernameString by remember {
        mutableStateOf("")
    }
    var passwordString by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Login",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            color = Color(0xFF666666),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(80.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(bottomEndPercent = 50, topEndPercent = 50)
                    )
                    .clip(RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50))
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    TextField(
                        value = usernameString,
                        onValueChange = {
                            usernameString = it
                        },
                        placeholder = {
                            Text(text = "username")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color(0xFFCCCCCC),
                            backgroundColor = Color(0xFFFAFAFA),
                            unfocusedIndicatorColor = Color(0xFFDDDDDD)
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(topEndPercent = 100))
                            .border(
                                width = 1.dp,
                                color = Color(0xFFDDDDDD),
                                shape = RoundedCornerShape(topEndPercent = 100)
                            )
                    )
                    TextField(
                        value = passwordString,
                        onValueChange = {
                            passwordString = it
                        },
                        placeholder = {
                            Text(text = "password")
                        },
                        shape = RoundedCornerShape(bottomEndPercent = 100),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color(0xFFCCCCCC),
                            backgroundColor = Color(0xFFFAFAFA),
                            unfocusedIndicatorColor = Color(0xFFDDDDDD)
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.NumberPassword
                        ),
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFDDDDDD),
                                shape = RoundedCornerShape(topEndPercent = 50)
                            )
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxWidth(0.8f),
                contentAlignment = Alignment.CenterEnd
            ) {
                IconButton(
                    onClick = { onLoginClick(usernameString, passwordString) },
                    modifier = Modifier
                        .size(56.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                        .background(Color(0xFF44DD88))
                        .padding(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "forget?",
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onForgotClick() }
                .padding(end = 16.dp),
            textAlign = TextAlign.End,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { onRegisterClick() },
            modifier = Modifier
                .fillMaxWidth(0.38f)
                .align(Alignment.Start)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50)
                )
                .clip(RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50))
                .border(
                    width = 1.dp,
                    color = Color(0xFFDDDDDD),
                    shape = RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50)
                ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFAFAFA),
                contentColor = Color(0xFFFF8F00)
            )
        ) {
            Text(
                text = "Register",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
