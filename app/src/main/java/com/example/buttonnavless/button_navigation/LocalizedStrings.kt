package com.example.buttonnavless.button_navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object LocalizedStrings {
    private val en = mapOf(
        // Screen1
        "currenciesTitle" to "Currencies",
        "no" to "No.",
        "currency" to "Currency",
        "priceUsd" to "Price (USD)",
        "per1Usd" to "Per 1 USD",
        // Screen2
        "currencyExchange" to "Currency Exchange",
        "amountIn" to "Amount in",
        "result" to "Result",
        "failedToLoadRates" to "Failed to load rates",
        "retry" to "Retry",
        // Screen2: Currency names
        "usDollar" to "US Dollar",
        "euro" to "Euro",
        "britishPound" to "British Pound",
        "ukrainianHryvnia" to "Ukrainian Hryvnia",
        "afghanAfghani" to "Afghan Afghani",
        "uaeDirham" to "UAE Dirham",
        "australianDollar" to "Australian Dollar",
        "canadianDollar" to "Canadian Dollar",
        "swissFranc" to "Swiss Franc",
        "chineseYuan" to "Chinese Yuan",
        "danishKrone" to "Danish Krone",
        "hongKongDollar" to "Hong Kong Dollar",
        "indianRupee" to "Indian Rupee",
        "japaneseYen" to "Japanese Yen",
        "mexicanPeso" to "Mexican Peso",
        "norwegianKrone" to "Norwegian Krone",
        "newZealandDollar" to "New Zealand Dollar",
        "swedishKrona" to "Swedish Krona",
        "singaporeDollar" to "Singapore Dollar",
        "turkishLira" to "Turkish Lira",
        // Screen3
        "screen3Placeholder" to "Screen 3 content coming soon...",
        // Screen4
        "settingsTitle" to "Settings",
        "changeLanguage" to "Change language:",
        "changeTheme" to "Change theme:",
        "notifications" to "Notifications:",
        "enabled" to "Enabled",
        "disabled" to "Disabled",
        "dark" to "Dark",
        "light" to "Light",
        "createdBy" to "Created by Нео",
        "builtWith" to "Built with Jetpack Compose.\nOpen source project.",
        "contactMe" to "You can contact me via Telegram",
        "githubUrl" to "github.com",
        "telegramHandle" to "@cobralicious"
    )

    private val pl = mapOf(
        // Screen1
        "currenciesTitle" to "Waluty",
        "no" to "Nr",
        "currency" to "Waluta",
        "priceUsd" to "Cena (USD)",
        "per1Usd" to "Za 1 USD",
        // Screen2
        "currencyExchange" to "Wymiana walut",
        "amountIn" to "Kwota w",
        "result" to "Wynik",
        "failedToLoadRates" to "Nie udało się załadować kursów",
        "retry" to "Spróbuj ponownie",
        // Screen2: Currency names
        "usDollar" to "Dolar amerykański",
        "euro" to "Euro",
        "britishPound" to "Funt brytyjski",
        "ukrainianHryvnia" to "Hrywna ukraińska",
        "afghanAfghani" to "Afgani afgańskie",
        "uaeDirham" to "Dirham ZEA",
        "australianDollar" to "Dolar australijski",
        "canadianDollar" to "Dolar kanadyjski",
        "swissFranc" to "Frank szwajcarski",
        "chineseYuan" to "Yuan chiński",
        "danishKrone" to "Korona duńska",
        "hongKongDollar" to "Dolar hongkoński",
        "indianRupee" to "Rupia indyjska",
        "japaneseYen" to "Jen japoński",
        "mexicanPeso" to "Peso meksykańskie",
        "norwegianKrone" to "Korona norweska",
        "newZealandDollar" to "Dolar nowozelandzki",
        "swedishKrona" to "Korona szwedzka",
        "singaporeDollar" to "Dolar singapurski",
        "turkishLira" to "Lira turecka",
        // Screen3
        "screen3Placeholder" to "Zawartość ekranu 3 wkrótce...",
        // Screen4
        "settingsTitle" to "Ustawienia",
        "changeLanguage" to "Zmień język:",
        "changeTheme" to "Zmień motyw:",
        "notifications" to "Powiadomienia:",
        "enabled" to "Włączone",
        "disabled" to "Wyłączone",
        "dark" to "Ciemny",
        "light" to "Jasny",
        "createdBy" to "Stworzone przez Нео",
        "builtWith" to "Zbudowane z Jetpack Compose.\nProjekt open source.",
        "contactMe" to "Możesz się ze mną skontaktować przez Telegram",
        "githubUrl" to "github.com",
        "telegramHandle" to "@cobralicious"
    )

    private val ru = mapOf(
        // Screen1
        "currenciesTitle" to "Валюты",
        "no" to "№",
        "currency" to "Валюта",
        "priceUsd" to "Цена (USD)",
        "per1Usd" to "За 1 USD",
        // Screen2
        "currencyExchange" to "Обмен валют",
        "amountIn" to "Сумма в",
        "result" to "Результат",
        "failedToLoadRates" to "Не удалось загрузить курсы",
        "retry" to "Повторить",
        // Screen2: Currency names
        "usDollar" to "Доллар США",
        "euro" to "Евро",
        "britishPound" to "Британский фунт",
        "ukrainianHryvnia" to "Украинская гривна",
        "afghanAfghani" to "Афганский афгани",
        "uaeDirham" to "Дирхам ОАЭ",
        "australianDollar" to "Австралийский доллар",
        "canadianDollar" to "Канадский доллар",
        "swissFranc" to "Швейцарский франк",
        "chineseYuan" to "Китайский юань",
        "danishKrone" to "Датская крона",
        "hongKongDollar" to "Гонконгский доллар",
        "indianRupee" to "Индийская рупия",
        "japaneseYen" to "Японская иена",
        "mexicanPeso" to "Мексиканское песо",
        "norwegianKrone" to "Норвежская крона",
        "newZealandDollar" to "Новозеландский доллар",
        "swedishKrona" to "Шведская крона",
        "singaporeDollar" to "Сингапурский доллар",
        "turkishLira" to "Турецкая лира",
        // Screen3
        "screen3Placeholder" to "Содержимое экрана 3 скоро появится...",
        // Screen4
        "settingsTitle" to "Настройки",
        "changeLanguage" to "Сменить язык:",
        "changeTheme" to "Сменить тему:",
        "notifications" to "Уведомления:",
        "enabled" to "Включены",
        "disabled" to "Выключены",
        "dark" to "Тёмная",
        "light" to "Светлая",
        "createdBy" to "Создано Нео",
        "builtWith" to "Сделано с помощью Jetpack Compose.\nОткрытый проект.",
        "contactMe" to "Связаться со мной можно через Telegram",
        "githubUrl" to "github.com",
        "telegramHandle" to "@cobralicious"
    )

    private val es = mapOf(
        // Screen1
        "currenciesTitle" to "Monedas",
        "no" to "Nº",
        "currency" to "Moneda",
        "priceUsd" to "Precio (USD)",
        "per1Usd" to "Por 1 USD",
        // Screen2
        "currencyExchange" to "Cambio de divisas",
        "amountIn" to "Cantidad en",
        "result" to "Resultado",
        "failedToLoadRates" to "No se pudieron cargar las tasas",
        "retry" to "Reintentar",
        // Screen2: Currency names
        "usDollar" to "Dólar estadounidense",
        "euro" to "Euro",
        "britishPound" to "Libra británica",
        "ukrainianHryvnia" to "Grivna ucraniana",
        "afghanAfghani" to "Afgani afgano",
        "uaeDirham" to "Dirham de los EAU",
        "australianDollar" to "Dólar australiano",
        "canadianDollar" to "Dólar canadiense",
        "swissFranc" to "Franco suizo",
        "chineseYuan" to "Yuan chino",
        "danishKrone" to "Corona danesa",
        "hongKongDollar" to "Dólar de Hong Kong",
        "indianRupee" to "Rupia india",
        "japaneseYen" to "Yen japonés",
        "mexicanPeso" to "Peso mexicano",
        "norwegianKrone" to "Corona noruega",
        "newZealandDollar" to "Dólar neozelandés",
        "swedishKrona" to "Corona sueca",
        "singaporeDollar" to "Dólar de Singapur",
        "turkishLira" to "Lira turca",
        // Screen3
        "screen3Placeholder" to "Contenido de la pantalla 3 próximamente...",
        // Screen4
        "settingsTitle" to "Configuración",
        "changeLanguage" to "Cambiar idioma:",
        "changeTheme" to "Cambiar tema:",
        "notifications" to "Notificaciones:",
        "enabled" to "Habilitadas",
        "disabled" to "Deshabilitadas",
        "dark" to "Oscuro",
        "light" to "Claro",
        "createdBy" to "Creado por Нео",
        "builtWith" to "Construido con Jetpack Compose.\nProyecto de código abierto.",
        "contactMe" to "Puedes contactarme a través de Telegram",
        "githubUrl" to "github.com",
        "telegramHandle" to "@cobralicious"
    )

    private val uk = mapOf(
        // Screen1
        "currenciesTitle" to "Валюти",
        "no" to "№",
        "currency" to "Валюта",
        "priceUsd" to "Ціна (USD)",
        "per1Usd" to "За 1 USD",
        // Screen2
        "currencyExchange" to "Обмін валют",
        "amountIn" to "Сума в",
        "result" to "Результат",
        "failedToLoadRates" to "Не вдалося завантажити курси",
        "retry" to "Повторити",
        // Screen2: Currency names
        "usDollar" to "Долар США",
        "euro" to "Євро",
        "britishPound" to "Британський фунт",
        "ukrainianHryvnia" to "Українська гривня",
        "afghanAfghani" to "Афганський афгані",
        "uaeDirham" to "Дирхам ОАЕ",
        "australianDollar" to "Австралійський долар",
        "canadianDollar" to "Канадський долар",
        "swissFranc" to "Швейцарський франк",
        "chineseYuan" to "Китайський юань",
        "danishKrone" to "Датська крона",
        "hongKongDollar" to "Гонконгський долар",
        "indianRupee" to "Індійська рупія",
        "japaneseYen" to "Японська єна",
        "mexicanPeso" to "Мексиканське песо",
        "norwegianKrone" to "Норвезька крона",
        "newZealandDollar" to "Новозеландський долар",
        "swedishKrona" to "Шведська крона",
        "singaporeDollar" to "Сінгапурський долар",
        "turkishLira" to "Турецька ліра",
        // Screen3
        "screen3Placeholder" to "Вміст екрана 3 незабаром...",
        // Screen4
        "settingsTitle" to "Налаштування",
        "changeLanguage" to "Змінити мову:",
        "changeTheme" to "Змінити тему:",
        "notifications" to "Сповіщення:",
        "enabled" to "Увімкнено",
        "disabled" to "Вимкнено",
        "dark" to "Темна",
        "light" to "Світла",
        "createdBy" to "Створено Нео",
        "builtWith" to "Створено за допомогою Jetpack Compose.\nПроект із відкритим кодом.",
        "contactMe" to "Ви можете зв’язатися зі мною через Telegram",
        "githubUrl" to "github.com",
        "telegramHandle" to "@cobralicious"
    )

    private val languages = mapOf(
        "en" to en,
        "pl" to pl,
        "ru" to ru,
        "es" to es,
        "uk" to uk
    )

    var currentLang by mutableStateOf("en")

    fun get(key: String): String {
        return languages[currentLang]?.get(key) ?: "[$key]"
    }
}