package com.example.buttonnavless.button_navigation

import com.example.buttonnavless.R
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.text.style.BackgroundColorSpan
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.lazy.LazyColumn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.runtime.collectAsState



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Screen1(viewModel: CurrencyViewModel) {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val dateTextForHeader = "${LocalizedStrings.get("currenciesTitle")} ${currentDate.format(formatter)}"

    val currencies = listOf(
        "PLN", "EUR", "GBP", "UAH", "AFN",
        "AED", "AUD", "CAD", "CHF", "CNY",
        "DKK", "HKD", "INR", "JPY", "MXN",
        "NOK", "NZD", "SEK", "SGD", "TRY"
    )

    val rates by viewModel.rates.collectAsState()

    val flagMap = mapOf(
        "PLN" to R.drawable.poland_flag,
        "EUR" to R.drawable.eur,
        "GBP" to R.drawable.gb,
        "UAH" to R.drawable.ua,
        "AFN" to R.drawable.af,
        "AED" to R.drawable.ae,
        "AUD" to R.drawable.au,
        "CAD" to R.drawable.canada,
        "CHF" to R.drawable.flagsw,
        "CNY" to R.drawable.cnf,
        "DKK" to R.drawable.dkk,
        "HKD" to R.drawable.hk,
        "INR" to R.drawable.india,
        "JPY" to R.drawable.japan,
        "MXN" to R.drawable.mx,
        "NOK" to R.drawable.norway,
        "NZD" to R.drawable.nz,
        "SEK" to R.drawable.sweden,
        "SGD" to R.drawable.singapore,
        "TRY" to R.drawable.turkey
    )

    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(bottom = bottomPadding)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0))
                .padding(vertical = 12.dp)
        ) {
            Text(
                text = dateTextForHeader,
                modifier = Modifier.align(Alignment.Center),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0))
                .padding(horizontal = 10.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = LocalizedStrings.get("no"),
                modifier = Modifier.width(40.dp),
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.width(40.dp))

            Text(
                text = LocalizedStrings.get("currency"),
                modifier = Modifier.weight(1f),
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.width(50.dp))

            Text(
                text = LocalizedStrings.get("priceUsd"),
                modifier = Modifier.width(80.dp),
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.End
            )

            Text(
                text = LocalizedStrings.get("per1Usd"),
                modifier = Modifier.width(80.dp),
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.width(25.dp))
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(currencies) { index, currency ->
                val priceUsd = rates[currency] ?: 0.0
                val priceInCurrency = if (priceUsd != 0.0) 1 / priceUsd else 0.0

                CurrencyCard(
                    index = index,
                    currency = currency,
                    priceUsd = priceUsd,
                    priceInCurrency = priceInCurrency,
                    flagMap = flagMap
                )
            }
        }
    }
}


@Composable
fun Screen2(viewModel: CurrencyViewModel) {
    val rates by viewModel.rates.collectAsState()
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    val currencyList = listOf(
        Triple("USD", LocalizedStrings.get("usDollar"), R.drawable.united),
        Triple("EUR", LocalizedStrings.get("euro"), R.drawable.eur),
        Triple("GBP", LocalizedStrings.get("britishPound"), R.drawable.gb),
        Triple("UAH", LocalizedStrings.get("ukrainianHryvnia"), R.drawable.ua),
        Triple("AFN", LocalizedStrings.get("afghanAfghani"), R.drawable.af),
        Triple("AED", LocalizedStrings.get("uaeDirham"), R.drawable.ae),
        Triple("AUD", LocalizedStrings.get("australianDollar"), R.drawable.au),
        Triple("CAD", LocalizedStrings.get("canadianDollar"), R.drawable.canada),
        Triple("CHF", LocalizedStrings.get("swissFranc"), R.drawable.flagsw),
        Triple("CNY", LocalizedStrings.get("chineseYuan"), R.drawable.cnf),
        Triple("DKK", LocalizedStrings.get("danishKrone"), R.drawable.dkk),
        Triple("HKD", LocalizedStrings.get("hongKongDollar"), R.drawable.hk),
        Triple("INR", LocalizedStrings.get("indianRupee"), R.drawable.india),
        Triple("JPY", LocalizedStrings.get("japaneseYen"), R.drawable.japan),
        Triple("MXN", LocalizedStrings.get("mexicanPeso"), R.drawable.mx),
        Triple("NOK", LocalizedStrings.get("norwegianKrone"), R.drawable.norway),
        Triple("NZD", LocalizedStrings.get("newZealandDollar"), R.drawable.nz),
        Triple("SEK", LocalizedStrings.get("swedishKrona"), R.drawable.sweden),
        Triple("SGD", LocalizedStrings.get("singaporeDollar"), R.drawable.singapore),
        Triple("TRY", LocalizedStrings.get("turkishLira"), R.drawable.turkey)
    )

    var fromCurrency by remember { mutableStateOf(currencyList[0]) }
    var toCurrency by remember { mutableStateOf(currencyList[1]) }
    var expandedFrom by remember { mutableStateOf(false) }
    var expandedTo by remember { mutableStateOf(false) }
    var amount by remember { mutableStateOf("") }

    LaunchedEffect(rates) {
        isLoading = rates.isEmpty()
        error = if (rates.isEmpty()) LocalizedStrings.get("failedToLoadRates") else null
    }

    val result = remember(amount, fromCurrency, toCurrency, rates) {
        val amt = amount.toDoubleOrNull() ?: 0.0
        val rateFrom = rates[fromCurrency.first] ?: 1.0
        val rateTo = rates[toCurrency.first] ?: 1.0
        if (rateFrom != 0.0) (amt / rateFrom) * rateTo else 0.0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = LocalizedStrings.get("currencyExchange"),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp, top = 10.dp)
        )

        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = error ?: LocalizedStrings.get("failedToLoadRates"),
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.loadRates() }) {
                    Text(LocalizedStrings.get("retry"))
                }
            }
        } else {
            // FROM currency selector
            Box {
                OutlinedButton(
                    onClick = { expandedFrom = true },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(48.dp)
                ) {
                    Image(
                        painter = painterResource(fromCurrency.third),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("${fromCurrency.first} (${fromCurrency.second})")
                }
                DropdownMenu(
                    expanded = expandedFrom,
                    onDismissRequest = { expandedFrom = false }
                ) {
                    currencyList.filter { it != toCurrency }.forEach { currency ->
                        DropdownMenuItem(
                            text = { Text("${currency.first} (${currency.second})") },
                            leadingIcon = {
                                Image(
                                    painter = painterResource(currency.third),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                )
                            },
                            onClick = {
                                fromCurrency = currency
                                expandedFrom = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            // TO currency selector
            Box {
                OutlinedButton(
                    onClick = { expandedTo = true },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(48.dp)
                ) {
                    Image(
                        painter = painterResource(toCurrency.third),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("${toCurrency.first} (${toCurrency.second})")
                }
                DropdownMenu(
                    expanded = expandedTo,
                    onDismissRequest = { expandedTo = false }
                ) {
                    currencyList.filter { it != fromCurrency }.forEach { currency ->
                        DropdownMenuItem(
                            text = { Text("${currency.first} (${currency.second})") },
                            leadingIcon = {
                                Image(
                                    painter = painterResource(currency.third),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                )
                            },
                            onClick = {
                                toCurrency = currency
                                expandedTo = false
                            }
                        )
                    }
                }
            }

            // Amount input
            OutlinedTextField(
                value = amount,
                onValueChange = { newValue ->
                    if (newValue.isEmpty() || newValue.matches(Regex("^\\d*\\.?\\d*\$"))) {
                        amount = newValue
                    }
                },
                label = { Text("${LocalizedStrings.get("amountIn")} ${fromCurrency.first}") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Result
            Text(
                text = "${LocalizedStrings.get("result")}: ${"%.2f".format(result)} ${toCurrency.first}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}


@Composable
fun Screen3() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = LocalizedStrings.get("screen3Placeholder"),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        )
    }
}


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen4() {
    val context = LocalContext.current
    val languages = listOf("English", "Polski", "Русский", "Español", "Українська")
    var selectedLanguage by remember { mutableStateOf(languages[0]) }
    var languageMenuExpanded by remember { mutableStateOf(false) }
    var isDarkTheme by remember { mutableStateOf(false) }
    var notificationsEnabled by remember { mutableStateOf(true) }

    val bottomPadding = WindowInsets.navigationBars
        .asPaddingValues()
        .calculateBottomPadding() + 16.dp

    // Update selectedLanguage when currentLang changes
    LaunchedEffect(LocalizedStrings.currentLang) {
        selectedLanguage = when (LocalizedStrings.currentLang) {
            "en" -> "English"
            "pl" -> "Polski"
            "ru" -> "Русский"
            "es" -> "Español"
            "uk" -> "Українська"
            else -> "English"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = LocalizedStrings.get("settingsTitle"),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(100.dp))

            // Language selection button
            Box {
                Button(
                    onClick = { languageMenuExpanded = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF9F0D0D),
                        contentColor = Color.White
                    )
                ) {
                    Text("${LocalizedStrings.get("changeLanguage")} $selectedLanguage", fontSize = 18.sp)
                }

                DropdownMenu(
                    expanded = languageMenuExpanded,
                    onDismissRequest = { languageMenuExpanded = false }
                ) {
                    languages.forEach { language ->
                        DropdownMenuItem(
                            text = { Text(language, fontSize = 16.sp) },
                            onClick = {
                                selectedLanguage = language
                                languageMenuExpanded = false
                                LocalizedStrings.currentLang = when (language) {
                                    "English" -> "en"
                                    "Polski" -> "pl"
                                    "Русский" -> "ru"
                                    "Español" -> "es"
                                    "Українська" -> "uk"
                                    else -> "en"
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFE0E0E0),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Theme toggle button
            Button(
                onClick = { isDarkTheme = !isDarkTheme },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF9F0D0D),
                    contentColor = Color.White
                )
            ) {
                Text(
                    "${LocalizedStrings.get("changeTheme")} ${if (isDarkTheme) LocalizedStrings.get("dark") else LocalizedStrings.get("light")}",
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Notifications toggle button
            Button(
                onClick = { /* No action, button is disabled */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                enabled = false // Disable the button
            ) {
                Text(
                    "${LocalizedStrings.get("notifications")} ${if (notificationsEnabled) LocalizedStrings.get("enabled") else LocalizedStrings.get("disabled")}",
                    fontSize = 18.sp
                )
            }
        }

        // Footer
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            Text(
                text = LocalizedStrings.get("createdBy"),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = LocalizedStrings.get("builtWith"),
                fontSize = 16.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            ClickableText(
                text = AnnotatedString(LocalizedStrings.get("githubUrl")),
                style = TextStyle(
                    color = Color(0xFF1A73E8),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                ),
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/cobralicious"))
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    ContextCompat.startActivity(context, intent, null)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = LocalizedStrings.get("contactMe"),
                fontSize = 16.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            ClickableText(
                text = AnnotatedString(LocalizedStrings.get("telegramHandle")),
                style = TextStyle(
                    color = Color(0xFF1A73E8),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                ),
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/cobralicious"))
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    ContextCompat.startActivity(context, intent, null)
                }
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}