package com.laila.terastv.ui.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.GetApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laila.terastv.R
import com.laila.terastv.ui.theme.TerasTVTheme
import com.laila.terastv.ui.theme.getRobotoFontFamily
import androidx.compose.material.icons.outlined.HelpOutline

// Data class untuk tabel
data class AppUsageData(
    val no: Int,
    val snTV: String,
    val tanggal: String,
    val thumbnail: String,
    val namaApp: String,
    val urlApp: String,
    val durasiApp: String,
    val durasiTV: String
)

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    onAboutClick: () -> Unit = {} // sambungkan ke halaman "About"
) {
    // Dummy data untuk tabel
    val appUsageList = listOf(
        AppUsageData(
            1, "012345", "10/08/2025", "📱",
            "Youtube", "https://youtu.be/...", "00.00.00", "00.00.00"
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header dengan tombol close
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { /* Handle close */ },
                modifier = Modifier
                    .size(32.dp)
                    .background(Color.White, RoundedCornerShape(6.dp))
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close",
                    tint = Color.Red,
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        // Timer Card dan School Info Card
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // School Info Card
            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "SMKN 1 NEGERI TANGGERANG",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = getRobotoFontFamily(),
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "0123456789",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = getRobotoFontFamily(),
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    Text(
                        text = "SN-TV",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = getRobotoFontFamily(),
                        color = Color.Gray
                    )
                }
            }

            // Timer Card
            Card(
                modifier = Modifier.wrapContentWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Box(
                    modifier = Modifier.padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "00.00.00",
                        fontSize = 72.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = getRobotoFontFamily(),
                        color = Color.Black,
                        letterSpacing = 2.sp
                    )
                }
            }
        }

        // Log History, Filter dan PDF buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Riwayat Pemakaian Smart TV",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = getRobotoFontFamily(),
                color = Color.Black
            )

            Row {
                // Filter Button
                Button(
                    onClick = { /* Handle filter */ },
                    modifier = Modifier
                        .padding(end = 8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(1.dp, Color.LightGray)
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Filter",
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Filter",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = getRobotoFontFamily(),
                        color = Color.Black
                    )
                }

                // PDF Button
                Button(
                    onClick = { /* Handle PDF export */ },
                    modifier = Modifier
                        .padding(end = 8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(1.dp, Color.LightGray)
                ) {
                    Icon(
                        imageVector = Icons.Filled.GetApp,
                        contentDescription = "PDF",
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "PDF",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = getRobotoFontFamily(),
                        color = Color.Black
                    )
                }
            }
        }

        // ===== Tabel =====
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column {
                // Table Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF474EF0))
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TableHeaderCell("No.", weight = 0.7f)
                    TableHeaderCell("SN-TV", weight = 1.2f)
                    TableHeaderCell("Tanggal", weight = 1.3f)
                    TableHeaderCell("Thumbnail", weight = 1.2f)
                    TableHeaderCell("Nama App", weight = 1.2f)
                    TableHeaderCell("URL App", weight = 1.8f)
                    TableHeaderCell("Durasi App", weight = 1.3f)
                    TableHeaderCell("Durasi TV", weight = 1.3f)
                }

                Divider(color = Color(0xFFE0E0E0), thickness = 1.dp)

                // Table Content
                LazyColumn {
                    itemsIndexed(appUsageList) { index, item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp, horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TableDataCell(item.no.toString(), weight = 0.7f)
                            TableDataCell(item.snTV, weight = 1.2f)
                            TableDataCell(item.tanggal, weight = 1.3f)

                            // Thumbnail (placeholder)
                            Box(
                                modifier = Modifier
                                    .weight(1.2f)
                                    .height(32.dp)
                                    .padding(end = 12.dp)
                                    .background(Color(0xFFF0F0F0), RoundedCornerShape(4.dp))
                                    .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(4.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.placeholder_img),
                                    contentDescription = "Thumbnail",
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            TableDataCell(item.namaApp, weight = 1.2f)
                            TableDataCell(item.urlApp, weight = 1.8f)
                            TableDataCell(item.durasiApp, weight = 1.3f)
                            TableDataCell(item.durasiTV, weight = 1.3f)
                        }

                        if (index < appUsageList.size - 1) {
                            Divider(color = Color(0xFFE0E0E0), thickness = 1.dp)
                        }
                    }

                    // Empty rows 
                    items(5) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            repeat(8) {
                                Box(modifier = Modifier.weight(1f))
                            }
                        }
                        Divider(color = Color(0xFFE0E0E0), thickness = 1.dp)
                    }
                }
            }
        }

        // button "tentang aplikasi"
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = onAboutClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Gray
                ),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                modifier = Modifier.height(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.HelpOutline,
                    contentDescription = "Tentang aplikasi",
                    modifier = Modifier.size(16.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Tentang aplikasi",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = getRobotoFontFamily()
                )
            }
        }
    }
}

@Composable
fun RowScope.TableHeaderCell(text: String, weight: Float) {
    Box(
        modifier = Modifier.weight(weight),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = getRobotoFontFamily(),
            color = Color.White,
            maxLines = 1
        )
    }
}

@Composable
fun RowScope.TableDataCell(text: String, weight: Float) {
    Box(
        modifier = Modifier.weight(weight),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = getRobotoFontFamily(),
            color = Color.Black,
            maxLines = 1
        )
    }
}

/* ================= Preview ================= */
@Preview(showBackground = true, device = "id:tv_1080p")
@Composable
fun DashboardScreenPreview() {
    TerasTVTheme {
        DashboardScreen()
    }
}