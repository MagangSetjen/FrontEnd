package com.laila.terastv.ui.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laila.terastv.ui.theme.TerasTVTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.laila.terastv.R
import com.laila.terastv.ui.theme.getRobotoFontFamily

@Composable
fun RegistrationScreen(modifier: Modifier = Modifier) {
    var npsn by remember { mutableStateOf("") }
    var namaSekolah by remember { mutableStateOf("") }
    var serialNumberTV by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 48.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_terastv),
            contentDescription = "TerasTV Logo",
            modifier = Modifier
                .widthIn(max = 120.dp)
                .heightIn(max = 80.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Fit
        )

        // Card container
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 48.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Title
                Text(
                    text = "Registrasi",
                    fontSize = 22.sp,
                    fontFamily = getRobotoFontFamily(),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                // Subtitle
                Text(
                    text = "Silahkan Registrasi TV Sekolah Anda di Sini!",
                    fontSize = 12.sp,
                    fontFamily = getRobotoFontFamily(),
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // NPSN Field
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "NPSN",
                        fontSize = 14.sp,
                        fontFamily = getRobotoFontFamily(),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )

                    OutlinedTextField(
                        value = npsn,
                        onValueChange = { npsn = it },
                        placeholder = {
                            Text(
                                text = "Masukkan NPSN Sekolah Anda",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = getRobotoFontFamily(),
                                fontWeight = FontWeight.Normal
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF777CF4),
                            unfocusedBorderColor = Color.LightGray
                        ),
                        singleLine = true
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Nama Sekolah Field
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Nama Sekolah",
                        fontSize = 14.sp,
                        fontFamily = getRobotoFontFamily(),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )

                    OutlinedTextField(
                        value = namaSekolah,
                        onValueChange = { namaSekolah = it },
                        placeholder = {
                            Text(
                                text = "Masukkan Nama Sekolah Anda",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = getRobotoFontFamily(),
                                fontWeight = FontWeight.Normal
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF777CF4),
                            unfocusedBorderColor = Color.LightGray
                        ),
                        singleLine = true
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Serial Number TV Field
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Serial Number TV",
                        fontSize = 14.sp,
                        fontFamily = getRobotoFontFamily(),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )

                    OutlinedTextField(
                        value = serialNumberTV,
                        onValueChange = { serialNumberTV = it },
                        placeholder = {
                            Text(
                                text = "Masukkan Serial Number TV Anda",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = getRobotoFontFamily(),
                                fontWeight = FontWeight.Normal
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF777CF4),
                            unfocusedBorderColor = Color.LightGray
                        ),
                        singleLine = true
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Register Button
                Button(
                    onClick = {
                        // Handle registration logic here
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF474EF0)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Daftar",
                        fontSize = 16.sp,
                        fontFamily = getRobotoFontFamily(),
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Preview(
    showBackground = true,
    device = "id:tv_1080p",
    fontScale = 1.0f
)
@Composable
fun RegistrationPreview() {
    TerasTVTheme {
        RegistrationScreen()
    }
}