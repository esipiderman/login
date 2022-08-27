package com.example.login.ui.features

import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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

@Composable
fun RegisterScreen(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        RegisterButtons(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            onRegisterClick = { username, email, password ->

            }, onLoginClick = {
                navController.navigate(MyScreens.LoginScreen.route)
            }
        )

    }
}

@Composable
fun RegisterButtons(
    modifier: Modifier = Modifier,
    onRegisterClick: (username: String, email: String, password: String) -> Unit,
    onLoginClick: () -> Unit
) {
    var usernameString by remember {
        mutableStateOf("")
    }
    var emailString by remember {
        mutableStateOf("")
    }
    var passwordString by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Register",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            color = Color(0xFF666666),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(60.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(bottomEndPercent = 33, topEndPercent = 33)
                    )
                    .clip(RoundedCornerShape(topEndPercent = 33, bottomEndPercent = 33)),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = usernameString,
                    onValueChange = {
                        usernameString = it
                    },
                    placeholder = {
                        Text(text = "Username")
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
                    value = emailString,
                    onValueChange = {
                        emailString = it
                    },
                    placeholder = {
                        Text(text = "Email")
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color(0xFFCCCCCC),
                        backgroundColor = Color(0xFFFAFAFA),
                        unfocusedIndicatorColor = Color(0xFFDDDDDD)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDDDDDD)
                        )
                )
                TextField(
                    value = passwordString,
                    onValueChange = {
                        passwordString = it
                    },
                    placeholder = {
                        Text(text = "Password")
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
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDDDDDD),
                            shape = RoundedCornerShape(bottomEndPercent = 100)
                        )
                )
            }

            Box(
                modifier = Modifier.fillMaxWidth(0.8f),
                contentAlignment = Alignment.CenterEnd
            ) {
                IconButton(
                    onClick = { onRegisterClick(usernameString, emailString, passwordString) },
                    modifier = Modifier
                        .size(56.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                        .background(Color(0xFF44DD88))
                        .padding(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .align(Alignment.End)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(topStartPercent = 50, bottomStartPercent = 50)
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFFDDDDDD),
                    shape = RoundedCornerShape(topStartPercent = 50, bottomStartPercent = 50)
                ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFAFAFA),
                contentColor = Color(0xFFFF8F00)
            ),
            shape = RoundedCornerShape(topStartPercent = 50, bottomStartPercent = 50),
            onClick = { onLoginClick() }
        ) {
            Text(
                text = "Login",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}